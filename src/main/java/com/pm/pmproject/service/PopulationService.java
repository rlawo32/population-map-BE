package com.pm.pmproject.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pm.pmproject.dto.PopulationResultDto;
import com.pm.pmproject.dto.Population0sDto;
import com.pm.pmproject.dto.Population10sDto;
import com.pm.pmproject.dto.Population20sDto;
import com.pm.pmproject.dto.Population30sDto;
import com.pm.pmproject.dto.Population40sDto;
import com.pm.pmproject.dto.Population50sDto;
import com.pm.pmproject.dto.Population60sDto;
import com.pm.pmproject.dto.Population70sDto;
import com.pm.pmproject.dto.Population80sDto;
import com.pm.pmproject.dto.Population90sDto;
import com.pm.pmproject.dto.Population100sDto;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PopulationService {

    @Transactional
//    @Scheduled(cron = "0 0 0 * * ?") // 매일 24시
//    @Scheduled(cron = "0 0 0/6 * * *") // 6시간마다
    @Scheduled(cron = "0 0/2 * * * *") // 10분마다
    public void schedulerLectureStateUpdate() {
        try {
            // 1. URL 설정
            StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15097972/v1/uddi:780a2373-bf11-4fb6-b3e4-ed4119571817");
            // 2. 오픈 API의요청 규격에 맞는 파라미터 생성, 발급받은 인증키.
            urlBuilder.append("?" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=1zfm3O6MusH4xNmea2J41ZdYEpwMmwp4AOgUvyRJHU1bNOcyxF6VX17CZKFpJeBeJTtw%2B%2BcKcEC7g%2BuguQI79g%3D%3D");
            // 3. URL 객체 생성.
            System.out.println(urlBuilder.toString());
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
            System.out.println(node1);
            System.out.println(node2);


            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            List<PopulationResultDto> list = objectMapper.treeToValue(node2, new TypeReference<List<PopulationResultDto>>() {});
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
            list.forEach(populationResultDto -> System.out.println(populationResultDto.getNameTown()));
            list4.forEach(population40sDto -> System.out.println(population40sDto.getAdminCode()));
            list4.forEach(population40sDto -> System.out.println(population40sDto.getPopAgeM42()));
            list9.forEach(population90sDto -> System.out.println(population90sDto.getAdminCode()));
            list9.forEach(population90sDto -> System.out.println(population90sDto.getPopAgeW94()));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

