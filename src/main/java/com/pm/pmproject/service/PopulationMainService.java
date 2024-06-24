package com.pm.pmproject.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.pmproject.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PopulationMainService {

    private final PopulationJanService populationJanService;
    private final PopulationFebService populationFebService;
    private final PopulationMarService populationMarService;
    private final PopulationAprService populationAprService;
    private final PopulationMayService populationMayService;
    private final PopulationJunService populationJunService;
    private final PopulationJulService populationJulService;

    @Transactional
//    @Scheduled(cron = "0 0 0 * * ?") // 매일 24시
//    @Scheduled(cron = "0 0 0/6 * * *") // 6시간마다
    @Scheduled(cron = "0 0/5 * * * *") // 10분마다
    public void schedulerPopulationUpdate() {
        try {
            for(int i=1; i<=4; i++) {
                // 1. URL 설정
                StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15097972/v1/uddi:780a2373-bf11-4fb6-b3e4-ed4119571817");
                // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
                urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode(String.valueOf(i), "UTF-8"));
                urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8"));
                urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=1zfm3O6MusH4xNmea2J41ZdYEpwMmwp4AOgUvyRJHU1bNOcyxF6VX17CZKFpJeBeJTtw%2B%2BcKcEC7g%2BuguQI79g%3D%3D");
                // 3. URL 객체 생성.
                URL url = new URL(urlBuilder.toString());
                // 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                // 5. 통신을 위한 메소드 SET.
                conn.setRequestMethod("GET");
                // 6. 통신을 위한 Content-type SET.
                conn.setRequestProperty("Content-type", "application/json");
                // 7. 통신 응답 코드 확인.
                System.out.println("Response code: " + conn.getResponseCode());
                // 8. 전달받은 데이터를 BufferedReader 객체로 저장.
                BufferedReader rd;
                if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                } else {
                    rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                }
                // 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = rd.readLine()) != null) {
                    sb.append(line);
                }
                // 10. 객체 해제.
                rd.close();
                conn.disconnect();

                ObjectMapper objectMapper = new ObjectMapper();

                JsonNode node1 = objectMapper.readTree(sb.toString());
                JsonNode node2 = node1.findValue("data");

                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                // 아래에서 반복문, dto 세대별로 진행
                List<PopulationResultDto> list = Arrays.asList(objectMapper.treeToValue(node2, PopulationResultDto[].class));
                List<Population0sDto> list0 = Arrays.asList(objectMapper.treeToValue(node2, Population0sDto[].class));
                List<Population10sDto> list1 = Arrays.asList(objectMapper.treeToValue(node2, Population10sDto[].class));
                List<Population20sDto> list2 = Arrays.asList(objectMapper.treeToValue(node2, Population20sDto[].class));
                List<Population30sDto> list3 = Arrays.asList(objectMapper.treeToValue(node2, Population30sDto[].class));
                List<Population40sDto> list4 = Arrays.asList(objectMapper.treeToValue(node2, Population40sDto[].class));
                List<Population50sDto> list5 = Arrays.asList(objectMapper.treeToValue(node2, Population50sDto[].class));
                List<Population60sDto> list6 = Arrays.asList(objectMapper.treeToValue(node2, Population60sDto[].class));
                List<Population70sDto> list7 = Arrays.asList(objectMapper.treeToValue(node2, Population70sDto[].class));
                List<Population80sDto> list8 = Arrays.asList(objectMapper.treeToValue(node2, Population80sDto[].class));
                List<Population90sDto> list9 = Arrays.asList(objectMapper.treeToValue(node2, Population90sDto[].class));
                List<Population100sDto> list10 = Arrays.asList(objectMapper.treeToValue(node2, Population100sDto[].class));

                populationJanService.populationJanUpdate(CommonRequestDto.setApiResultList(list, list0,
                        list1, list2, list3, list4, list5, list6, list7, list8, list9, list10));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

