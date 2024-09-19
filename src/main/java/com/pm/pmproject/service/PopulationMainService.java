package com.pm.pmproject.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.pmproject.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PopulationMainService {

    @Value("${POPULATION_APIKEY}")
    private String apiKey;

    private final PopulationJanService populationJanService;
    private final PopulationFebService populationFebService;
    private final PopulationMarService populationMarService;
    private final PopulationAprService populationAprService;
    private final PopulationMayService populationMayService;
    private final PopulationJunService populationJunService;
    private final PopulationJulService populationJulService;
    private final PopulationAugService populationAugService;
    private final PopulationSepService populationSepService;
    private final PopulationOctService populationOctService;
    private final PopulationNovService populationNovService;
    private final PopulationDecService populationDecService;

    @Scheduled(cron = "0 0/2 * * * *") // 10분마다
    public void SchedulerMonthCheckWithSwagger() {
        try {
            // 1. URL 설정
            StringBuilder urlBuilder = new StringBuilder("https://infuser.odcloud.kr/oas/docs?namespace=15097972/v1");

            // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
            urlBuilder.append("&" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + apiKey);

            // 3. URI 생성
            URI uri = URI.create(urlBuilder.toString());
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            // 4. HttpClient 객체 선언
            HttpClient httpClient = HttpClient.newHttpClient();

            // 5. HttpClient URI, 메서드, Header, Timeout 선언 후 request 생성
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .header("Content-Type", "application/json;charset=utf-8")
                    .timeout(Duration.ofSeconds(20000))
                    .build();

            // 6. HttpClient request 요청 후 response 값 반환
            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());

            // 7. 통신 응답 코드 확인.
            System.out.print("Swagger 통신 결과 : ");
            if (res.statusCode() == 200) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
            stopWatch.stop();
            System.out.println("통신 시간 : " + stopWatch.getTotalTimeSeconds());

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode node1 = objectMapper.readTree(res.body());
            JsonNode node2 = node1.findValue("paths");
            List<JsonNode> node3 = node2.findValues("get");

            LocalDateTime ldt = LocalDateTime.now().minusMonths(2);         // ex. 9월 - 2개월 => 7월
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMM");
            String latestMonth = ldt.format(dtf);                           // ex. 202407
            String operationId = "";

            for (int n = 0; n < node3.size(); n++) {
                String summary = node3.get(n).get("summary").asText();      // ex. 행정안전부_지역별(행정동) 성별 연령별 주민등록 인구수_20240831
                int p1 = summary.lastIndexOf("_");
                String p2 = summary.substring(p1 + 1, p1 + 7);              // ex. 202407

                if (latestMonth.equals(p2)) {
                    operationId = node3.get(n).get("operationId").asText(); // ex. getuddi:a51f43ff-da64-43ca-a910-b0d7e9badf40
                }
            }

            if (operationId.length() > 0) {
                String nameMonth = ldt.getMonth().name().substring(0, 3);   // ex. JUL
                SchedulerPopulationUpdate(operationId, latestMonth, nameMonth);
//                SchedulerPopulationUpdate("uddi:3106da79-9e89-4af2-85f4-a132a46491ac", latestMonth, "MAY"); // 5월 swagger
            }
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error Code [1]");
        } catch (IOException ex) {
            System.out.println("Error Code [2]");
        } catch (InterruptedException ex) {
            System.out.println("Error Code [3]");
        }
    }

    private void SchedulerPopulationUpdate(String apiUrl, String updateMonth, String updateName) {
        try {
            String subUrl = apiUrl.substring(3);
            System.out.println("[" + "SubURL 확인 2" + "] " + subUrl);
            System.out.println("[" + updateMonth + "] " + updateName + " - 통신 시작 ");
            StopWatch stopWatch1 = new StopWatch();
            StopWatch stopWatch2 = new StopWatch();
            stopWatch1.start();
            stopWatch2.start();

            List<PopulationResultDto> list = new ArrayList<>();
            List<Population0sDto> list0 = new ArrayList<>();
            List<Population10sDto> list1 = new ArrayList<>();
            List<Population20sDto> list2 = new ArrayList<>();
            List<Population30sDto> list3 = new ArrayList<>();
            List<Population40sDto> list4 = new ArrayList<>();
            List<Population50sDto> list5 = new ArrayList<>();
            List<Population60sDto> list6 = new ArrayList<>();
            List<Population70sDto> list7 = new ArrayList<>();
            List<Population80sDto> list8 = new ArrayList<>();
            List<Population90sDto> list9 = new ArrayList<>();
            List<Population100sDto> list10 = new ArrayList<>();

            for (int i = 1; i <= 4; i++) {
                // 1. URL 설정
                StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15097972/v1/" + subUrl);

                // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
                urlBuilder.append("?" + URLEncoder.encode("page", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(i), "UTF-8"));
                urlBuilder.append("&" + URLEncoder.encode("perPage", "UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8"));
                urlBuilder.append("&" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + apiKey);

                // 3. URL 객체 생성.
                URL url = new URL(urlBuilder.toString());
                StopWatch stopWatch3 = new StopWatch();
                stopWatch3.start();

                // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                // 5. 통신을 위한 메소드 SET.
                conn.setRequestMethod("GET");

                // 6. 통신을 위한 Content-type SET.
                conn.setRequestProperty("Content-type", "application/json");
                conn.setConnectTimeout(20000);

                // 7. 통신 응답 코드 확인.
                System.out.print(i + "번째 통신 결과 : ");
                if (conn.getResponseCode() == 200) {
                    System.out.println("성공");
                } else {
                    System.out.println("실패");
                }

                // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
                BufferedReader br;
                if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } else {
                    br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                }

                // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                // 10. 객체 해제.
                br.close();
                conn.disconnect();
                stopWatch3.stop();
                System.out.println("통신 시간 : " + stopWatch3.getTotalTimeSeconds());

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode node1 = objectMapper.readTree(sb.toString());
                JsonNode node2 = node1.findValue("data");

                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                list.addAll(Arrays.asList(objectMapper.treeToValue(node2, PopulationResultDto[].class)));
                list0.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population0sDto[].class)));
                list1.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population10sDto[].class)));
                list2.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population20sDto[].class)));
                list3.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population30sDto[].class)));
                list4.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population40sDto[].class)));
                list5.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population50sDto[].class)));
                list6.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population60sDto[].class)));
                list7.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population70sDto[].class)));
                list8.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population80sDto[].class)));
                list9.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population90sDto[].class)));
                list10.addAll(Arrays.asList(objectMapper.treeToValue(node2, Population100sDto[].class)));
            }

            stopWatch2.stop();
            System.out.println("\n총 통신 시간 : " + stopWatch2.getTotalTimeSeconds() + "\n통신 완료");

            if (updateName.equals("JAN")) {
                populationJanService.populationJanUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("FEB")) {
                populationFebService.populationFebUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("MAR")) {
                populationMarService.populationMarUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("APR")) {
                populationAprService.populationAprUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("MAY")) {
                populationMayService.populationMayUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("JUN")) {
                populationJunService.populationJunUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("JUL")) {
                populationJulService.populationJulUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("AUG")) {
                populationAugService.populationAugUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("SEP")) {
                populationSepService.populationSepUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("OCT")) {
                populationOctService.populationOctUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("NOV")) {
                populationNovService.populationNovUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            } else if (updateName.equals("DEC")) {
                populationDecService.populationDecUpdate(CommonRequestDto.setApiResultList(list,
                        list0, list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            }

            stopWatch1.stop();
            System.out.println("\n총 작업 시간 : " + stopWatch1.getTotalTimeSeconds() + "\n작업 완료");

        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error Code [1]");
        } catch (IOException ex) {
            System.out.println("Error Code [2]");
        }
    }
}

