package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.Population50sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMay50sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMay50sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population50sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may_50s (admin_code, age_50_m, age_50_w, " +
                        "age_51_m, age_51_w, age_52_m, age_52_w, age_53_m, age_53_w, " +
                        "age_54_m, age_54_w, age_55_m, age_55_w, age_56_m, age_56_w, " +
                        "age_57_m, age_57_w, age_58_m, age_58_w, age_59_m, age_59_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal50s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal50s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge50M());
                        ps.setLong(3, list.get(i).getPopAge50W());
                        ps.setLong(4, list.get(i).getPopAge51M());
                        ps.setLong(5, list.get(i).getPopAge51W());
                        ps.setLong(6, list.get(i).getPopAge52M());
                        ps.setLong(7, list.get(i).getPopAge52W());
                        ps.setLong(8, list.get(i).getPopAge53M());
                        ps.setLong(9, list.get(i).getPopAge53W());
                        ps.setLong(10, list.get(i).getPopAge54M());
                        ps.setLong(11, list.get(i).getPopAge54W());
                        ps.setLong(12, list.get(i).getPopAge55M());
                        ps.setLong(13, list.get(i).getPopAge55W());
                        ps.setLong(14, list.get(i).getPopAge56M());
                        ps.setLong(15, list.get(i).getPopAge56W());
                        ps.setLong(16, list.get(i).getPopAge57M());
                        ps.setLong(17, list.get(i).getPopAge57W());
                        ps.setLong(18, list.get(i).getPopAge58M());
                        ps.setLong(19, list.get(i).getPopAge58W());
                        ps.setLong(20, list.get(i).getPopAge59M());
                        ps.setLong(21, list.get(i).getPopAge59W());
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

    public void populationTotalInsert(List<Population50sDto> list) {

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
        map.put("전체", Arrays.asList(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        Long total_m = 0L;
        Long total_w = 0L;

        for (Population50sDto population50sDto : list) {
            String nameCity = population50sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population50sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population50sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population50sDto.getPopAge50M() + population50sDto.getPopAge51M() + population50sDto.getPopAge52M() + population50sDto.getPopAge53M() + population50sDto.getPopAge54M() +
                    population50sDto.getPopAge55M() + population50sDto.getPopAge56M() + population50sDto.getPopAge57M() + population50sDto.getPopAge58M() + population50sDto.getPopAge59M());
            total_w += (population50sDto.getPopAge50W() + population50sDto.getPopAge51W() + population50sDto.getPopAge52W() + population50sDto.getPopAge53W() + population50sDto.getPopAge54W() +
                    population50sDto.getPopAge55W() + population50sDto.getPopAge56W() + population50sDto.getPopAge57W() + population50sDto.getPopAge58W() + population50sDto.getPopAge59W());

            Long sumAge50 = population50sDto.getPopAge50M() + population50sDto.getPopAge50W();
            Long sumAge51 = population50sDto.getPopAge51M() + population50sDto.getPopAge51W();
            Long sumAge52 = population50sDto.getPopAge52M() + population50sDto.getPopAge52W();
            Long sumAge53 = population50sDto.getPopAge53M() + population50sDto.getPopAge53W();
            Long sumAge54 = population50sDto.getPopAge54M() + population50sDto.getPopAge54W();
            Long sumAge55 = population50sDto.getPopAge55M() + population50sDto.getPopAge55W();
            Long sumAge56 = population50sDto.getPopAge56M() + population50sDto.getPopAge56W();
            Long sumAge57 = population50sDto.getPopAge57M() + population50sDto.getPopAge57W();
            Long sumAge58 = population50sDto.getPopAge58M() + population50sDto.getPopAge58W();
            Long sumAge59 = population50sDto.getPopAge59M() + population50sDto.getPopAge59W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge50, population50sDto.getPopAge50M(), population50sDto.getPopAge50W(),
                        sumAge51, population50sDto.getPopAge51M(), population50sDto.getPopAge51W(),
                        sumAge52, population50sDto.getPopAge52M(), population50sDto.getPopAge52W(),
                        sumAge53, population50sDto.getPopAge53M(), population50sDto.getPopAge53W(),
                        sumAge54, population50sDto.getPopAge54M(), population50sDto.getPopAge54W(),
                        sumAge55, population50sDto.getPopAge55M(), population50sDto.getPopAge55W(),
                        sumAge56, population50sDto.getPopAge56M(), population50sDto.getPopAge56W(),
                        sumAge57, population50sDto.getPopAge57M(), population50sDto.getPopAge57W(),
                        sumAge58, population50sDto.getPopAge58M(), population50sDto.getPopAge58W(),
                        sumAge59, population50sDto.getPopAge59M(), population50sDto.getPopAge59W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge50, map.get(nameCity).get(1) + population50sDto.getPopAge50M(), map.get(nameCity).get(2) + population50sDto.getPopAge50W(),
                        map.get(nameCity).get(3) + sumAge51, map.get(nameCity).get(4) + population50sDto.getPopAge51M(), map.get(nameCity).get(5) + population50sDto.getPopAge51W(),
                        map.get(nameCity).get(6) + sumAge52, map.get(nameCity).get(7) + population50sDto.getPopAge52M(), map.get(nameCity).get(8) + population50sDto.getPopAge52W(),
                        map.get(nameCity).get(9) + sumAge53, map.get(nameCity).get(10) + population50sDto.getPopAge53M(), map.get(nameCity).get(11) + population50sDto.getPopAge53W(),
                        map.get(nameCity).get(12) + sumAge54, map.get(nameCity).get(13) + population50sDto.getPopAge54M(), map.get(nameCity).get(14) + population50sDto.getPopAge54W(),
                        map.get(nameCity).get(15) + sumAge55, map.get(nameCity).get(16) + population50sDto.getPopAge55M(), map.get(nameCity).get(17) + population50sDto.getPopAge55W(),
                        map.get(nameCity).get(18) + sumAge56, map.get(nameCity).get(19) + population50sDto.getPopAge56M(), map.get(nameCity).get(20) + population50sDto.getPopAge56W(),
                        map.get(nameCity).get(21) + sumAge57, map.get(nameCity).get(22) + population50sDto.getPopAge57M(), map.get(nameCity).get(23) + population50sDto.getPopAge57W(),
                        map.get(nameCity).get(24) + sumAge58, map.get(nameCity).get(25) + population50sDto.getPopAge58M(), map.get(nameCity).get(26) + population50sDto.getPopAge58W(),
                        map.get(nameCity).get(27) + sumAge59, map.get(nameCity).get(28) + population50sDto.getPopAge59M(), map.get(nameCity).get(29) + population50sDto.getPopAge59W()
                ));
            }

            if (nameWard != null && nameWard.contains(" ")) {               // ex. 성남시 분당구
                int cut = nameWard.indexOf(" ");
                String subNameWard1 = nameWard.substring(0, cut);           // ex. 성남시
                String subNameWard2 = nameWard.substring(cut + 1); // ex. 분당구
                String subCityWard1 = nameCity + " " + subNameWard1;        // ex. 경기도 성남시
                String subCityWard2 = cityWard;                             // ex. 경기도 성남시 분당구

                if (!map.containsKey(subCityWard1)) {
                    map.put(subCityWard1, Arrays.asList(
                            sumAge50, population50sDto.getPopAge50M(), population50sDto.getPopAge50W(),
                            sumAge51, population50sDto.getPopAge51M(), population50sDto.getPopAge51W(),
                            sumAge52, population50sDto.getPopAge52M(), population50sDto.getPopAge52W(),
                            sumAge53, population50sDto.getPopAge53M(), population50sDto.getPopAge53W(),
                            sumAge54, population50sDto.getPopAge54M(), population50sDto.getPopAge54W(),
                            sumAge55, population50sDto.getPopAge55M(), population50sDto.getPopAge55W(),
                            sumAge56, population50sDto.getPopAge56M(), population50sDto.getPopAge56W(),
                            sumAge57, population50sDto.getPopAge57M(), population50sDto.getPopAge57W(),
                            sumAge58, population50sDto.getPopAge58M(), population50sDto.getPopAge58W(),
                            sumAge59, population50sDto.getPopAge59M(), population50sDto.getPopAge59W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge50, map.get(subCityWard1).get(1) + population50sDto.getPopAge50M(), map.get(subCityWard1).get(2) + population50sDto.getPopAge50W(),
                            map.get(subCityWard1).get(3) + sumAge51, map.get(subCityWard1).get(4) + population50sDto.getPopAge51M(), map.get(subCityWard1).get(5) + population50sDto.getPopAge51W(),
                            map.get(subCityWard1).get(6) + sumAge52, map.get(subCityWard1).get(7) + population50sDto.getPopAge52M(), map.get(subCityWard1).get(8) + population50sDto.getPopAge52W(),
                            map.get(subCityWard1).get(9) + sumAge53, map.get(subCityWard1).get(10) + population50sDto.getPopAge53M(), map.get(subCityWard1).get(11) + population50sDto.getPopAge53W(),
                            map.get(subCityWard1).get(12) + sumAge54, map.get(subCityWard1).get(13) + population50sDto.getPopAge54M(), map.get(subCityWard1).get(14) + population50sDto.getPopAge54W(),
                            map.get(subCityWard1).get(15) + sumAge55, map.get(subCityWard1).get(16) + population50sDto.getPopAge55M(), map.get(subCityWard1).get(17) + population50sDto.getPopAge55W(),
                            map.get(subCityWard1).get(18) + sumAge56, map.get(subCityWard1).get(19) + population50sDto.getPopAge56M(), map.get(subCityWard1).get(20) + population50sDto.getPopAge56W(),
                            map.get(subCityWard1).get(21) + sumAge57, map.get(subCityWard1).get(22) + population50sDto.getPopAge57M(), map.get(subCityWard1).get(23) + population50sDto.getPopAge57W(),
                            map.get(subCityWard1).get(24) + sumAge58, map.get(subCityWard1).get(25) + population50sDto.getPopAge58M(), map.get(subCityWard1).get(26) + population50sDto.getPopAge58W(),
                            map.get(subCityWard1).get(27) + sumAge59, map.get(subCityWard1).get(28) + population50sDto.getPopAge59M(), map.get(subCityWard1).get(29) + population50sDto.getPopAge59W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge50, population50sDto.getPopAge50M(), population50sDto.getPopAge50W(),
                            sumAge51, population50sDto.getPopAge51M(), population50sDto.getPopAge51W(),
                            sumAge52, population50sDto.getPopAge52M(), population50sDto.getPopAge52W(),
                            sumAge53, population50sDto.getPopAge53M(), population50sDto.getPopAge53W(),
                            sumAge54, population50sDto.getPopAge54M(), population50sDto.getPopAge54W(),
                            sumAge55, population50sDto.getPopAge55M(), population50sDto.getPopAge55W(),
                            sumAge56, population50sDto.getPopAge56M(), population50sDto.getPopAge56W(),
                            sumAge57, population50sDto.getPopAge57M(), population50sDto.getPopAge57W(),
                            sumAge58, population50sDto.getPopAge58M(), population50sDto.getPopAge58W(),
                            sumAge59, population50sDto.getPopAge59M(), population50sDto.getPopAge59W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge50, map.get(subCityWard2).get(1) + population50sDto.getPopAge50M(), map.get(subCityWard2).get(2) + population50sDto.getPopAge50W(),
                            map.get(subCityWard2).get(3) + sumAge51, map.get(subCityWard2).get(4) + population50sDto.getPopAge51M(), map.get(subCityWard2).get(5) + population50sDto.getPopAge51W(),
                            map.get(subCityWard2).get(6) + sumAge52, map.get(subCityWard2).get(7) + population50sDto.getPopAge52M(), map.get(subCityWard2).get(8) + population50sDto.getPopAge52W(),
                            map.get(subCityWard2).get(9) + sumAge53, map.get(subCityWard2).get(10) + population50sDto.getPopAge53M(), map.get(subCityWard2).get(11) + population50sDto.getPopAge53W(),
                            map.get(subCityWard2).get(12) + sumAge54, map.get(subCityWard2).get(13) + population50sDto.getPopAge54M(), map.get(subCityWard2).get(14) + population50sDto.getPopAge54W(),
                            map.get(subCityWard2).get(15) + sumAge55, map.get(subCityWard2).get(16) + population50sDto.getPopAge55M(), map.get(subCityWard2).get(17) + population50sDto.getPopAge55W(),
                            map.get(subCityWard2).get(18) + sumAge56, map.get(subCityWard2).get(19) + population50sDto.getPopAge56M(), map.get(subCityWard2).get(20) + population50sDto.getPopAge56W(),
                            map.get(subCityWard2).get(21) + sumAge57, map.get(subCityWard2).get(22) + population50sDto.getPopAge57M(), map.get(subCityWard2).get(23) + population50sDto.getPopAge57W(),
                            map.get(subCityWard2).get(24) + sumAge58, map.get(subCityWard2).get(25) + population50sDto.getPopAge58M(), map.get(subCityWard2).get(26) + population50sDto.getPopAge58W(),
                            map.get(subCityWard2).get(27) + sumAge59, map.get(subCityWard2).get(28) + population50sDto.getPopAge59M(), map.get(subCityWard2).get(29) + population50sDto.getPopAge59W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge50, population50sDto.getPopAge50M(), population50sDto.getPopAge50W(),
                            sumAge51, population50sDto.getPopAge51M(), population50sDto.getPopAge51W(),
                            sumAge52, population50sDto.getPopAge52M(), population50sDto.getPopAge52W(),
                            sumAge53, population50sDto.getPopAge53M(), population50sDto.getPopAge53W(),
                            sumAge54, population50sDto.getPopAge54M(), population50sDto.getPopAge54W(),
                            sumAge55, population50sDto.getPopAge55M(), population50sDto.getPopAge55W(),
                            sumAge56, population50sDto.getPopAge56M(), population50sDto.getPopAge56W(),
                            sumAge57, population50sDto.getPopAge57M(), population50sDto.getPopAge57W(),
                            sumAge58, population50sDto.getPopAge58M(), population50sDto.getPopAge58W(),
                            sumAge59, population50sDto.getPopAge59M(), population50sDto.getPopAge59W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge50, map.get(cityWard).get(1) + population50sDto.getPopAge50M(), map.get(cityWard).get(2) + population50sDto.getPopAge50W(),
                            map.get(cityWard).get(3) + sumAge51, map.get(cityWard).get(4) + population50sDto.getPopAge51M(), map.get(cityWard).get(5) + population50sDto.getPopAge51W(),
                            map.get(cityWard).get(6) + sumAge52, map.get(cityWard).get(7) + population50sDto.getPopAge52M(), map.get(cityWard).get(8) + population50sDto.getPopAge52W(),
                            map.get(cityWard).get(9) + sumAge53, map.get(cityWard).get(10) + population50sDto.getPopAge53M(), map.get(cityWard).get(11) + population50sDto.getPopAge53W(),
                            map.get(cityWard).get(12) + sumAge54, map.get(cityWard).get(13) + population50sDto.getPopAge54M(), map.get(cityWard).get(14) + population50sDto.getPopAge54W(),
                            map.get(cityWard).get(15) + sumAge55, map.get(cityWard).get(16) + population50sDto.getPopAge55M(), map.get(cityWard).get(17) + population50sDto.getPopAge55W(),
                            map.get(cityWard).get(18) + sumAge56, map.get(cityWard).get(19) + population50sDto.getPopAge56M(), map.get(cityWard).get(20) + population50sDto.getPopAge56W(),
                            map.get(cityWard).get(21) + sumAge57, map.get(cityWard).get(22) + population50sDto.getPopAge57M(), map.get(cityWard).get(23) + population50sDto.getPopAge57W(),
                            map.get(cityWard).get(24) + sumAge58, map.get(cityWard).get(25) + population50sDto.getPopAge58M(), map.get(cityWard).get(26) + population50sDto.getPopAge58W(),
                            map.get(cityWard).get(27) + sumAge59, map.get(cityWard).get(28) + population50sDto.getPopAge59M(), map.get(cityWard).get(29) + population50sDto.getPopAge59W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_may_total_50s (pop_seq, pop_place, " +
                        "age_50_total, age_50_total_m, age_50_total_w, age_51_total, age_51_total_m, age_51_total_w, " +
                        "age_52_total, age_52_total_m, age_52_total_w, age_53_total, age_53_total_m, age_53_total_w, " +
                        "age_54_total, age_54_total_m, age_54_total_w, age_55_total, age_55_total_m, age_55_total_w, " +
                        "age_56_total, age_56_total_m, age_56_total_w, age_57_total, age_57_total_m, age_57_total_w, " +
                        "age_58_total, age_58_total_m, age_58_total_w, age_59_total, age_59_total_m, age_59_total_w) " +
                        "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        String uuid = UUID.randomUUID().toString().substring(0, 9);
                        ps.setString(1, uuid + i);
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
                    }

                    @Override
                    public int getBatchSize() {
                        return keyList.size();
                    }
                });
    }
}
