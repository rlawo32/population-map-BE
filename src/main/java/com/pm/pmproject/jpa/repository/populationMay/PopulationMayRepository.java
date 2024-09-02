package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.PopulationResultDto;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PopulationMayRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMayRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<PopulationResultDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may (admin_code, standard_date, name_city, " +
                        "name_ward, name_town, pop_total, pop_m_total, pop_w_total) " +
                        "values(?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setString(2, list.get(i).getStandardDate());
                        ps.setString(3, list.get(i).getNameCity());
                        ps.setString(4, list.get(i).getNameWard());
                        ps.setString(5, list.get(i).getNameTown());
                        ps.setLong(6, list.get(i).getPopTotal());
                        ps.setLong(7, list.get(i).getPopMTotal());
                        ps.setLong(8, list.get(i).getPopWTotal());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }

    public void populationMapSelect(List<PopulationResultDto> list) {

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
        // map.put("전체", Arrays.asList(0L, 0L, 0L));

        Long total = 0L;
        Long total_m = 0L;
        Long total_w = 0L;

        for(int i=0; i<30; i++) {
            String nameCity = list.get(i).getNameCity();	  	// ex. 서울특별시
            String nameWard = list.get(i).getNameWard(); 	  	// ex. 구로구
            String cityWard = nameCity+" "+list.get(i).getNameWard(); 	// ex. 서울특별시 구로구
            total += list.get(i).getPopTotal();
            total_m += list.get(i).getPopMTotal();
            total_w += list.get(i).getPopWTotal();

            if(!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(list.get(i).getPopTotal(), list.get(i).getPopMTotal(), list.get(i).getPopWTotal()));
            } else {
                map.put(nameCity, Arrays.asList(
                    map.get(nameCity).get(0) + list.get(i).getPopTotal(),
                    map.get(nameCity).get(1) + list.get(i).getPopMTotal(),
                    map.get(nameCity).get(2) + list.get(i).getPopWTotal()
                    ));
            }

            if(nameWard.indexOf(" ") > -1) {				// ex. 성남시 분당구
                int cut = nameWard.indexOf(" ");
                String subNameWard1 = nameWard.substring(0, cut);	// ex. 성남시
                String subNameWard2 = nameWard.substring(cut+1);	// ex. 분당구
		String subCityWard1 = nameCity+" "+subNameWard1;	// ex. 경기도 성남시
		// String subCityWard2 = cityWard;    			// ex. 경기도 성남시 분당구
		    
                if(!map.containsKey(subCityWard1)) {
                    map.put(subCityWard1, Arrays.asList(list.get(i).getPopTotal(), list.get(i).getPopMTotal(), list.get(i).getPopWTotal()));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                    	map.get(subCityWard1).get(0) + list.get(i).getPopTotal(),
                    	map.get(subCityWard1).get(1) + list.get(i).getPopMTotal(),
                    	map.get(subCityWard1).get(2) + list.get(i).getPopWTotal()
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
                    map.put(cityWard, Arrays.asList(list.get(i).getPopTotal(), list.get(i).getPopMTotal(), list.get(i).getPopWTotal()));
                } else {
                    map.put(cityWard, Arrays.asList(
                    	map.get(cityWard).get(0) + list.get(i).getPopTotal(),
                    	map.get(cityWard).get(1) + list.get(i).getPopMTotal(),
                    	map.get(cityWard).get(2) + list.get(i).getPopWTotal()
                    	));
                }
            }
        }

        // map.put("전체", Arrays.asList(total, total_m, total_w));

	List<String> keyList = map.keySet().stream().collect(Collectors.toList());
	List<List<Long>> valueList = map.values().stream().collect(Collectors.toList());

	jdbcTemplate.batchUpdate(
                    "insert into population_may_total (pop_seq, pop_place, pop_total, pop_total_m, pop_total_w) " +
                            "values(?, ?, ?, ?, ?)",
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            ps.setLong(1, 1+i);
                            ps.setString(2, keyList.get(i));
                            ps.setLong(3, valueList.get(i).get(0));
                            ps.setLong(4, valueList.get(i).get(1));
                            ps.setLong(5, valueList.get(i).get(2));
                        }
    
                        @Override
                        public int getBatchSize() {
                            return keyList.size();
                        }
                    });
    }
}
