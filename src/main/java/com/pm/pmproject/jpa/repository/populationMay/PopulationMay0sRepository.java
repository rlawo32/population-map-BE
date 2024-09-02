package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.Population0sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMay0sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMay0sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population0sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may_0s (admin_code, pop_age_m_0, pop_age_w_0, pop_age_m_1, " +
                        "pop_age_w_1, pop_age_m_2, pop_age_w_2, pop_age_m_3, pop_age_w_3, pop_age_m_4, " +
                        "pop_age_w_4, pop_age_m_5, pop_age_w_5, pop_age_m_6, pop_age_w_6, pop_age_m_7, " +
                        "pop_age_w_7, pop_age_m_8, pop_age_w_8, pop_age_m_9, pop_age_w_9, " +
                        "pop_age_total, pop_age_m_total, pop_age_w_total) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal0s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal0s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM0());
                        ps.setLong(3, list.get(i).getPopAgeW0());
                        ps.setLong(4, list.get(i).getPopAgeM1());
                        ps.setLong(5, list.get(i).getPopAgeW1());
                        ps.setLong(6, list.get(i).getPopAgeM2());
                        ps.setLong(7, list.get(i).getPopAgeW2());
                        ps.setLong(8, list.get(i).getPopAgeM3());
                        ps.setLong(9, list.get(i).getPopAgeW3());
                        ps.setLong(10, list.get(i).getPopAgeM4());
                        ps.setLong(11, list.get(i).getPopAgeW4());
                        ps.setLong(12, list.get(i).getPopAgeM5());
                        ps.setLong(13, list.get(i).getPopAgeW5());
                        ps.setLong(14, list.get(i).getPopAgeM6());
                        ps.setLong(15, list.get(i).getPopAgeW6());
                        ps.setLong(16, list.get(i).getPopAgeM7());
                        ps.setLong(17, list.get(i).getPopAgeW7());
                        ps.setLong(18, list.get(i).getPopAgeM8());
                        ps.setLong(19, list.get(i).getPopAgeW8());
                        ps.setLong(20, list.get(i).getPopAgeM9());
                        ps.setLong(21, list.get(i).getPopAgeW9());
                        ps.setLong(22, mTotal + wTotal);
                        ps.setLong(23, mTotal);
                        ps.setLong(24, wTotal);
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }

    public void populationMapSelect(List<Population0sDto> list) {
        
        // List<PopulationResultDto> list = jdbcTemplate.query("select pop_m_total, pop_w_total, pop_total, name_ward, name_city " +
        //                 "from population_may", new RowMapper<PopulationResultDto>() {
        //     @Override
        //     public PopulationResultDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        //         PopulationResultDto prd = new PopulationResultDto();
        //         prd.setPopTotal(rs.getLong("pop_total"));
        //         prd.setPopMTotal(rs.getLong("pop_m_total"));
        //         prd.setPopWTotal(rs.getLong("pop_w_total"));
        //         prd.setNameWard(rs.getString("name_ward"));
        //         prd.setNameCity(rs.getString("name_city"));
        //         return prd;
        //     }
        // });

        Map<String, List<Long>> map = new HashMap<>();
        //map.put("전체", Arrays.asList(0L, 0L, 0L));

        Long total = 0L;
        Long total_m = 0L;
        Long total_w = 0L;

        for(int i=0; i<30; i++) {
            String nameCity = list.get(i).getNameCity();	  	        // ex. 서울특별시
            String nameWard = list.get(i).getNameWard(); 	  	        // ex. 구로구
            String cityWard = nameCity+" "+list.get(i).getNameWard(); 	// ex. 서울특별시 구로구

            total_m += (list.get(i).getPopAgeM0() + list.get(i).getPopAgeM1() + list.get(i).getPopAgeM2() + list.get(i).getPopAgeM3() + list.get(i).getPopAgeM4() + 
                list.get(i).getPopAgeM5() + list.get(i).getPopAgeM6() + list.get(i).getPopAgeM7() + list.get(i).getPopAgeM8() + list.get(i).getPopAgeM9());
            total_w += (list.get(i).getPopAgeW0() + list.get(i).getPopAgeW1() + list.get(i).getPopAgeW2() + list.get(i).getPopAgeW3() + list.get(i).getPopAgeW4() + 
                list.get(i).getPopAgeW5() + list.get(i).getPopAgeW6() + list.get(i).getPopAgeW7() + list.get(i).getPopAgeW8() + list.get(i).getPopAgeW9());
            total += (total_m + total_w);

            Long sumAge0 = list.get(i).getPopAgeM0() + list.get(i).getPopAgeW0();
            Long sumAge1 = list.get(i).getPopAgeM1() + list.get(i).getPopAgeW1();
            Long sumAge2 = list.get(i).getPopAgeM2() + list.get(i).getPopAgeW2();
            Long sumAge3 = list.get(i).getPopAgeM3() + list.get(i).getPopAgeW3();
            Long sumAge4 = list.get(i).getPopAgeM4() + list.get(i).getPopAgeW4();
            Long sumAge5 = list.get(i).getPopAgeM5() + list.get(i).getPopAgeW5();
            Long sumAge6 = list.get(i).getPopAgeM6() + list.get(i).getPopAgeW6();
            Long sumAge7 = list.get(i).getPopAgeM7() + list.get(i).getPopAgeW7();
            Long sumAge8 = list.get(i).getPopAgeM8() + list.get(i).getPopAgeW8();
            Long sumAge9 = list.get(i).getPopAgeM9() + list.get(i).getPopAgeW9();

            if(!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                    total, total_m, total_w,
                    sumAge0, list.get(i).getPopAgeM0(), list.get(i).getPopAgeW0(),
                    sumAge1, list.get(i).getPopAgeM1(), list.get(i).getPopAgeW1(),
                    sumAge2, list.get(i).getPopAgeM2(), list.get(i).getPopAgeW2(),
                    sumAge3, list.get(i).getPopAgeM3(), list.get(i).getPopAgeW3(),
                    sumAge4, list.get(i).getPopAgeM4(), list.get(i).getPopAgeW4(),
                    sumAge5, list.get(i).getPopAgeM5(), list.get(i).getPopAgeW5(),
                    sumAge6, list.get(i).getPopAgeM6(), list.get(i).getPopAgeW6(),
                    sumAge7, list.get(i).getPopAgeM7(), list.get(i).getPopAgeW7(),
                    sumAge8, list.get(i).getPopAgeM8(), list.get(i).getPopAgeW8(),
                    sumAge9, list.get(i).getPopAgeM9(), list.get(i).getPopAgeW9()
                    ));
            } else {
                map.put(nameCity, Arrays.asList(
                    map.get(nameCity).get(0) + total, map.get(nameCity).get(1) + total_m, map.get(nameCity).get(2) + total_w,
                    map.get(nameCity).get(3) + sumAge0, map.get(nameCity).get(4) + list.get(i).getPopAgeM0(), map.get(nameCity).get(5) + list.get(i).getPopAgeW0(),
                    map.get(nameCity).get(6) + sumAge1, map.get(nameCity).get(7) + list.get(i).getPopAgeM1(), map.get(nameCity).get(8) + list.get(i).getPopAgeW1(),
                    map.get(nameCity).get(9) + sumAge2, map.get(nameCity).get(10) + list.get(i).getPopAgeM2(), map.get(nameCity).get(11) + list.get(i).getPopAgeW2(),
                    map.get(nameCity).get(12) + sumAge3, map.get(nameCity).get(13) + list.get(i).getPopAgeM3(), map.get(nameCity).get(14) + list.get(i).getPopAgeW3(),
                    map.get(nameCity).get(15) + sumAge4, map.get(nameCity).get(16) + list.get(i).getPopAgeM4(), map.get(nameCity).get(17) + list.get(i).getPopAgeW4(),
                    map.get(nameCity).get(18) + sumAge5, map.get(nameCity).get(19) + list.get(i).getPopAgeM5(), map.get(nameCity).get(20) + list.get(i).getPopAgeW5(),
                    map.get(nameCity).get(21) + sumAge6, map.get(nameCity).get(22) + list.get(i).getPopAgeM6(), map.get(nameCity).get(23) + list.get(i).getPopAgeW6(),
                    map.get(nameCity).get(24) + sumAge7, map.get(nameCity).get(25) + list.get(i).getPopAgeM7(), map.get(nameCity).get(26) + list.get(i).getPopAgeW7(),
                    map.get(nameCity).get(27) + sumAge8, map.get(nameCity).get(28) + list.get(i).getPopAgeM8(), map.get(nameCity).get(29) + list.get(i).getPopAgeW8(),
                    map.get(nameCity).get(30) + sumAge9, map.get(nameCity).get(31) + list.get(i).getPopAgeM9(), map.get(nameCity).get(32) + list.get(i).getPopAgeW9()
                    ));
            }

            if(nameWard.indexOf(" ") > -1) {				                // ex. 성남시 분당구
                int cut = nameWard.indexOf(" ");
                String subNameWard1 = nameWard.substring(0, cut);	// ex. 성남시
                String subNameWard2 = nameWard.substring(cut+1);	            // ex. 분당구
		        String subCityWard1 = nameCity+" "+subNameWard1;	            // ex. 경기도 성남시
		        // String subCityWard2 = cityWard;    			                // ex. 경기도 성남시 분당구
		    
                if(!map.containsKey(subCityWard1)) {
                    map.put(subCityWard1, Arrays.asList(
                        total, total_m, total_w,
                        sumAge0, list.get(i).getPopAgeM0(), list.get(i).getPopAgeW0(),
                        sumAge1, list.get(i).getPopAgeM1(), list.get(i).getPopAgeW1(),
                        sumAge2, list.get(i).getPopAgeM2(), list.get(i).getPopAgeW2(),
                        sumAge3, list.get(i).getPopAgeM3(), list.get(i).getPopAgeW3(),
                        sumAge4, list.get(i).getPopAgeM4(), list.get(i).getPopAgeW4(),
                        sumAge5, list.get(i).getPopAgeM5(), list.get(i).getPopAgeW5(),
                        sumAge6, list.get(i).getPopAgeM6(), list.get(i).getPopAgeW6(),
                        sumAge7, list.get(i).getPopAgeM7(), list.get(i).getPopAgeW7(),
                        sumAge8, list.get(i).getPopAgeM8(), list.get(i).getPopAgeW8(),
                        sumAge9, list.get(i).getPopAgeM9(), list.get(i).getPopAgeW9()
                        ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                        map.get(subCityWard1).get(0) + total, map.get(subCityWard1).get(1) + total_m, map.get(subCityWard1).get(2) + total_w,
                        map.get(subCityWard1).get(3) + sumAge0, map.get(subCityWard1).get(4) + list.get(i).getPopAgeM0(), map.get(subCityWard1).get(5) + list.get(i).getPopAgeW0(),
                        map.get(subCityWard1).get(6) + sumAge1, map.get(subCityWard1).get(7) + list.get(i).getPopAgeM1(), map.get(subCityWard1).get(8) + list.get(i).getPopAgeW1(),
                        map.get(subCityWard1).get(9) + sumAge2, map.get(subCityWard1).get(10) + list.get(i).getPopAgeM2(), map.get(subCityWard1).get(11) + list.get(i).getPopAgeW2(),
                        map.get(subCityWard1).get(12) + sumAge3, map.get(subCityWard1).get(13) + list.get(i).getPopAgeM3(), map.get(subCityWard1).get(14) + list.get(i).getPopAgeW3(),
                        map.get(subCityWard1).get(15) + sumAge4, map.get(subCityWard1).get(16) + list.get(i).getPopAgeM4(), map.get(subCityWard1).get(17) + list.get(i).getPopAgeW4(),
                        map.get(subCityWard1).get(18) + sumAge5, map.get(subCityWard1).get(19) + list.get(i).getPopAgeM5(), map.get(subCityWard1).get(20) + list.get(i).getPopAgeW5(),
                        map.get(subCityWard1).get(21) + sumAge6, map.get(subCityWard1).get(22) + list.get(i).getPopAgeM6(), map.get(subCityWard1).get(23) + list.get(i).getPopAgeW6(),
                        map.get(subCityWard1).get(24) + sumAge7, map.get(subCityWard1).get(25) + list.get(i).getPopAgeM7(), map.get(subCityWard1).get(26) + list.get(i).getPopAgeW7(),
                        map.get(subCityWard1).get(27) + sumAge8, map.get(subCityWard1).get(28) + list.get(i).getPopAgeM8(), map.get(subCityWard1).get(29) + list.get(i).getPopAgeW8(),
                        map.get(subCityWard1).get(30) + sumAge9, map.get(subCityWard1).get(31) + list.get(i).getPopAgeM9(), map.get(subCityWard1).get(32) + list.get(i).getPopAgeW9()
                    	));
                }

                // if(!map.containsKey(subCityWard2)) {
                //     map.put(subCityWard2, Arrays.asList(list.get(i).getPopTotal(), list.get(i).getPopMTotal(), list.get(i).getPopWTotal()));
                // } else {
                //     map.put(subCityWard2, Arrays.asList(
                //     	map.get(subCityWard2).get(0) + list.get(i).getPopTotal(),
                //     	map.get(subCityWard2).get(1) + list.get(i).getPopMTotal(),
                //     	map.get(subCityWard2).get(2) + list.get(i).getPopWTotal()
                //     	));
                // }

            } else {
                if(!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                        total, total_m, total_w,
                        sumAge0, list.get(i).getPopAgeM0(), list.get(i).getPopAgeW0(),
                        sumAge1, list.get(i).getPopAgeM1(), list.get(i).getPopAgeW1(),
                        sumAge2, list.get(i).getPopAgeM2(), list.get(i).getPopAgeW2(),
                        sumAge3, list.get(i).getPopAgeM3(), list.get(i).getPopAgeW3(),
                        sumAge4, list.get(i).getPopAgeM4(), list.get(i).getPopAgeW4(),
                        sumAge5, list.get(i).getPopAgeM5(), list.get(i).getPopAgeW5(),
                        sumAge6, list.get(i).getPopAgeM6(), list.get(i).getPopAgeW6(),
                        sumAge7, list.get(i).getPopAgeM7(), list.get(i).getPopAgeW7(),
                        sumAge8, list.get(i).getPopAgeM8(), list.get(i).getPopAgeW8(),
                        sumAge9, list.get(i).getPopAgeM9(), list.get(i).getPopAgeW9()
                        ));
                } else {
                    map.put(cityWard, Arrays.asList(
                        map.get(cityWard).get(0) + total, map.get(cityWard).get(1) + total_m, map.get(cityWard).get(2) + total_w,
                        map.get(cityWard).get(3) + sumAge0, map.get(cityWard).get(4) + list.get(i).getPopAgeM0(), map.get(cityWard).get(5) + list.get(i).getPopAgeW0(),
                        map.get(cityWard).get(6) + sumAge1, map.get(cityWard).get(7) + list.get(i).getPopAgeM1(), map.get(cityWard).get(8) + list.get(i).getPopAgeW1(),
                        map.get(cityWard).get(9) + sumAge2, map.get(cityWard).get(10) + list.get(i).getPopAgeM2(), map.get(cityWard).get(11) + list.get(i).getPopAgeW2(),
                        map.get(cityWard).get(12) + sumAge3, map.get(cityWard).get(13) + list.get(i).getPopAgeM3(), map.get(cityWard).get(14) + list.get(i).getPopAgeW3(),
                        map.get(cityWard).get(15) + sumAge4, map.get(cityWard).get(16) + list.get(i).getPopAgeM4(), map.get(cityWard).get(17) + list.get(i).getPopAgeW4(),
                        map.get(cityWard).get(18) + sumAge5, map.get(cityWard).get(19) + list.get(i).getPopAgeM5(), map.get(cityWard).get(20) + list.get(i).getPopAgeW5(),
                        map.get(cityWard).get(21) + sumAge6, map.get(cityWard).get(22) + list.get(i).getPopAgeM6(), map.get(cityWard).get(23) + list.get(i).getPopAgeW6(),
                        map.get(cityWard).get(24) + sumAge7, map.get(cityWard).get(25) + list.get(i).getPopAgeM7(), map.get(cityWard).get(26) + list.get(i).getPopAgeW7(),
                        map.get(cityWard).get(27) + sumAge8, map.get(cityWard).get(28) + list.get(i).getPopAgeM8(), map.get(cityWard).get(29) + list.get(i).getPopAgeW8(),
                        map.get(cityWard).get(30) + sumAge9, map.get(cityWard).get(31) + list.get(i).getPopAgeM9(), map.get(cityWard).get(32) + list.get(i).getPopAgeW9()
                    	));
                }
            }
        }

        //map.put("전체", Arrays.asList(total, total_m, total_w));

	List<String> keyList = map.keySet().stream().collect(Collectors.toList());
	List<List<Long>> valueList = map.values().stream().collect(Collectors.toList());

	jdbcTemplate.batchUpdate(
                    "insert into population_may_0s_total (pop_seq, pop_place, age_0s_total, age_0s_total_m, age_0s_total_w, " +
                            "age_0_total, age_0_total_m, age_0_total_w, age_1_total, age_1_total_m, age_1_total_w, " +
                            "age_2_total, age_2_total_m, age_2_total_w, age_3_total, age_3_total_m, age_3_total_w, " +
                            "age_4_total, age_4_total_m, age_4_total_w, age_5_total, age_5_total_m, age_5_total_w, " +
                            "age_6_total, age_6_total_m, age_6_total_w, age_7_total, age_7_total_m, age_7_total_w, " +
                            "age_8_total, age_8_total_m, age_8_total_w, age_9_total, age_9_total_m, age_9_total_w) " +
                            "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?)",
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            ps.setLong(1, 1+i);
                            ps.setString(2, keyList.get(i));
                            ps.setLong(3, valueList.get(i).get(0));
                            ps.setLong(4, valueList.get(i).get(1));
                            ps.setLong(5, valueList.get(i).get(2));
                            ps.setLong(6, valueList.get(i).get(3));
                            ps.setLong(7, valueList.get(i).get(4));
                            ps.setLong(8, valueList.get(i).get(5));
                            ps.setLong(9, valueList.get(i).get(6));
                            ps.setLong(10, valueList.get(i).get(7));
                            ps.setLong(11, valueList.get(i).get(8));
                            ps.setLong(12, valueList.get(i).get(9));
                            ps.setLong(13, valueList.get(i).get(10));
                            ps.setLong(14, valueList.get(i).get(11));
                            ps.setLong(15, valueList.get(i).get(12));
                            ps.setLong(16, valueList.get(i).get(13));
                            ps.setLong(17, valueList.get(i).get(14));
                            ps.setLong(18, valueList.get(i).get(15));
                            ps.setLong(19, valueList.get(i).get(16));
                            ps.setLong(20, valueList.get(i).get(17));
                            ps.setLong(21, valueList.get(i).get(18));
                            ps.setLong(22, valueList.get(i).get(19));
                            ps.setLong(23, valueList.get(i).get(20));
                            ps.setLong(24, valueList.get(i).get(21));
                            ps.setLong(25, valueList.get(i).get(22));
                            ps.setLong(26, valueList.get(i).get(23));
                            ps.setLong(27, valueList.get(i).get(24));
                            ps.setLong(28, valueList.get(i).get(25));
                            ps.setLong(29, valueList.get(i).get(26));
                            ps.setLong(30, valueList.get(i).get(27));
                            ps.setLong(31, valueList.get(i).get(28));
                            ps.setLong(32, valueList.get(i).get(29));
                            ps.setLong(33, valueList.get(i).get(30));
                            ps.setLong(34, valueList.get(i).get(31));
                            ps.setLong(35, valueList.get(i).get(32));
                        }
    
                        @Override
                        public int getBatchSize() {
                            return keyList.size();
                        }
                    });
    }
}
