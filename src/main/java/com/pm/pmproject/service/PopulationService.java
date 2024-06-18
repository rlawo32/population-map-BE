package com.pm.pmproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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
            // 11. 문자열 형태의 JSON을 파싱하기 위한 JSONParser 객체 생성.
            JSONParser parser = new JSONParser();
            // 12. 문자열을 JSON 형태로 JSONObject 객체에 저장.
            JSONObject obj = (JSONObject)parser.parse(sb.toString());
            // 13. 필요한 리스트 데이터 부분만 가져와 JSONArray로 저장.
            System.out.println(obj);
            JSONArray dataArr = (JSONArray) obj.get("data");
            JSONObject obj2 = (JSONObject)dataArr.get(0);
            System.out.println(obj2.get("15세여자"));
            // 14. 전달받은 데이터 확인.
            for(int i=0; i<dataArr.size(); i++) {
                System.out.println(dataArr.get(i));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

