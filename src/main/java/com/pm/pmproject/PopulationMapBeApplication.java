package com.pm.pmproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PopulationMapBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopulationMapBeApplication.class, args);

		List<TestDto> list = new ArrayList<>();
		for(int i=0; i<7; i++) {
			TestDto testDto = new TestDto();
			testDto.setName("이마트");
			if(i<4) {
				testDto.setSubName("과자");
			} else {
				testDto.setSubName("음료");
			}
			testDto.setCost(10000L);
			list.add(testDto);
		}

		for(int i=0; i<10; i++) {
			TestDto testDto = new TestDto();
			testDto.setName("롯데마트");
			if(i<3) {
				testDto.setSubName("상의");
			} else if(i>2 && i<7) {
				testDto.setSubName("하의");
			} else {
				testDto.setSubName("신발");
			}
			testDto.setCost(10000L);
			list.add(testDto);
		}

		for(int i=0; i<13; i++) {
			TestDto testDto = new TestDto();
			testDto.setName("하이마트");
			if(i<5) {
				testDto.setSubName("청소기");
			} else if(i>4 && i<9) {
				testDto.setSubName("냉장고");
			} else {
				testDto.setSubName("세탁기");
			}
			testDto.setCost(10000L);
			list.add(testDto);
		}

		Map<String, Long> map = new HashMap<>();
		map.put("총액", 0L);

		for(int i=0; i<list.size(); i++) {
			map.put("총액", map.get("총액")+list.get(i).getCost());
			
			if(!map.containsKey(list.get(i).getName())) {
				map.put(list.get(i).getName(), list.get(i).getCost());
			} else {
				map.put(list.get(i).getName(), map.get(list.get(i).getName())+list.get(i).getCost());
			}

			if(!map.containsKey(list.get(i).getSubName())) {
				map.put(list.get(i).getSubName(), list.get(i).getCost());
			} else {
				map.put(list.get(i).getSubName(), map.get(list.get(i).getSubName())+list.get(i).getCost());
			}
		}

		// System.out.println(list.size());
		// for(int i=0; i<list.size(); i++) {
		// 	System.out.println(list.get(i).getName());
		// 	System.out.println(list.get(i).getSubName());
		// 	System.out.println(list.get(i).getCost());
		// }

		for( String key : map.keySet() ){
			Long value = map.get(key);
			System.out.println( String.format("키 : "+key+", 값 : "+value));
		}
	}

}
