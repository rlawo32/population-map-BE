package com.pm.pmproject.jpa.repository.populationOct;

import com.pm.pmproject.dto.Population0sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PopulationOct0sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationOct0sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population0sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_oct_0s (admin_code, age_0_m, age_0_w, " +
                        "age_1_m, age_1_w, age_2_m, age_2_w, age_3_m, age_3_w, " +
                        "age_4_m, age_4_w, age_5_m, age_5_w, age_6_m, age_6_w, " +
                        "age_7_m, age_7_w, age_8_m, age_8_w, age_9_m, age_9_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal0s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal0s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge0M());
                        ps.setLong(3, list.get(i).getPopAge0W());
                        ps.setLong(4, list.get(i).getPopAge1M());
                        ps.setLong(5, list.get(i).getPopAge1W());
                        ps.setLong(6, list.get(i).getPopAge2M());
                        ps.setLong(7, list.get(i).getPopAge2W());
                        ps.setLong(8, list.get(i).getPopAge3M());
                        ps.setLong(9, list.get(i).getPopAge3W());
                        ps.setLong(10, list.get(i).getPopAge4M());
                        ps.setLong(11, list.get(i).getPopAge4W());
                        ps.setLong(12, list.get(i).getPopAge5M());
                        ps.setLong(13, list.get(i).getPopAge5W());
                        ps.setLong(14, list.get(i).getPopAge6M());
                        ps.setLong(15, list.get(i).getPopAge6W());
                        ps.setLong(16, list.get(i).getPopAge7M());
                        ps.setLong(17, list.get(i).getPopAge7W());
                        ps.setLong(18, list.get(i).getPopAge8M());
                        ps.setLong(19, list.get(i).getPopAge8W());
                        ps.setLong(20, list.get(i).getPopAge9M());
                        ps.setLong(21, list.get(i).getPopAge9W());
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

    public void populationTotalInsert(List<Population0sDto> list) {

        // List<PopulationResultDto> list = jdbcTemplate.query("select pop_m_total, pop_w_total, pop_total, name_ward, name_city " +
        //                 "from population_oct", new RowMapper<PopulationResultDto>() {
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

        for (Population0sDto population0sDto : list) {
            String nameCity = population0sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population0sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population0sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population0sDto.getPopAge0M() + population0sDto.getPopAge1M() + population0sDto.getPopAge2M() + population0sDto.getPopAge3M() + population0sDto.getPopAge4M() +
                    population0sDto.getPopAge5M() + population0sDto.getPopAge6M() + population0sDto.getPopAge7M() + population0sDto.getPopAge8M() + population0sDto.getPopAge9M());
            total_w += (population0sDto.getPopAge0W() + population0sDto.getPopAge1W() + population0sDto.getPopAge2W() + population0sDto.getPopAge3W() + population0sDto.getPopAge4W() +
                    population0sDto.getPopAge5W() + population0sDto.getPopAge6W() + population0sDto.getPopAge7W() + population0sDto.getPopAge8W() + population0sDto.getPopAge9W());

            Long sumAge0 = population0sDto.getPopAge0M() + population0sDto.getPopAge0W();
            Long sumAge1 = population0sDto.getPopAge1M() + population0sDto.getPopAge1W();
            Long sumAge2 = population0sDto.getPopAge2M() + population0sDto.getPopAge2W();
            Long sumAge3 = population0sDto.getPopAge3M() + population0sDto.getPopAge3W();
            Long sumAge4 = population0sDto.getPopAge4M() + population0sDto.getPopAge4W();
            Long sumAge5 = population0sDto.getPopAge5M() + population0sDto.getPopAge5W();
            Long sumAge6 = population0sDto.getPopAge6M() + population0sDto.getPopAge6W();
            Long sumAge7 = population0sDto.getPopAge7M() + population0sDto.getPopAge7W();
            Long sumAge8 = population0sDto.getPopAge8M() + population0sDto.getPopAge8W();
            Long sumAge9 = population0sDto.getPopAge9M() + population0sDto.getPopAge9W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge0, population0sDto.getPopAge0M(), population0sDto.getPopAge0W(),
                        sumAge1, population0sDto.getPopAge1M(), population0sDto.getPopAge1W(),
                        sumAge2, population0sDto.getPopAge2M(), population0sDto.getPopAge2W(),
                        sumAge3, population0sDto.getPopAge3M(), population0sDto.getPopAge3W(),
                        sumAge4, population0sDto.getPopAge4M(), population0sDto.getPopAge4W(),
                        sumAge5, population0sDto.getPopAge5M(), population0sDto.getPopAge5W(),
                        sumAge6, population0sDto.getPopAge6M(), population0sDto.getPopAge6W(),
                        sumAge7, population0sDto.getPopAge7M(), population0sDto.getPopAge7W(),
                        sumAge8, population0sDto.getPopAge8M(), population0sDto.getPopAge8W(),
                        sumAge9, population0sDto.getPopAge9M(), population0sDto.getPopAge9W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge0, map.get(nameCity).get(1) + population0sDto.getPopAge0M(), map.get(nameCity).get(2) + population0sDto.getPopAge0W(),
                        map.get(nameCity).get(3) + sumAge1, map.get(nameCity).get(4) + population0sDto.getPopAge1M(), map.get(nameCity).get(5) + population0sDto.getPopAge1W(),
                        map.get(nameCity).get(6) + sumAge2, map.get(nameCity).get(7) + population0sDto.getPopAge2M(), map.get(nameCity).get(8) + population0sDto.getPopAge2W(),
                        map.get(nameCity).get(9) + sumAge3, map.get(nameCity).get(10) + population0sDto.getPopAge3M(), map.get(nameCity).get(11) + population0sDto.getPopAge3W(),
                        map.get(nameCity).get(12) + sumAge4, map.get(nameCity).get(13) + population0sDto.getPopAge4M(), map.get(nameCity).get(14) + population0sDto.getPopAge4W(),
                        map.get(nameCity).get(15) + sumAge5, map.get(nameCity).get(16) + population0sDto.getPopAge5M(), map.get(nameCity).get(17) + population0sDto.getPopAge5W(),
                        map.get(nameCity).get(18) + sumAge6, map.get(nameCity).get(19) + population0sDto.getPopAge6M(), map.get(nameCity).get(20) + population0sDto.getPopAge6W(),
                        map.get(nameCity).get(21) + sumAge7, map.get(nameCity).get(22) + population0sDto.getPopAge7M(), map.get(nameCity).get(23) + population0sDto.getPopAge7W(),
                        map.get(nameCity).get(24) + sumAge8, map.get(nameCity).get(25) + population0sDto.getPopAge8M(), map.get(nameCity).get(26) + population0sDto.getPopAge8W(),
                        map.get(nameCity).get(27) + sumAge9, map.get(nameCity).get(28) + population0sDto.getPopAge9M(), map.get(nameCity).get(29) + population0sDto.getPopAge9W()
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
                            sumAge0, population0sDto.getPopAge0M(), population0sDto.getPopAge0W(),
                            sumAge1, population0sDto.getPopAge1M(), population0sDto.getPopAge1W(),
                            sumAge2, population0sDto.getPopAge2M(), population0sDto.getPopAge2W(),
                            sumAge3, population0sDto.getPopAge3M(), population0sDto.getPopAge3W(),
                            sumAge4, population0sDto.getPopAge4M(), population0sDto.getPopAge4W(),
                            sumAge5, population0sDto.getPopAge5M(), population0sDto.getPopAge5W(),
                            sumAge6, population0sDto.getPopAge6M(), population0sDto.getPopAge6W(),
                            sumAge7, population0sDto.getPopAge7M(), population0sDto.getPopAge7W(),
                            sumAge8, population0sDto.getPopAge8M(), population0sDto.getPopAge8W(),
                            sumAge9, population0sDto.getPopAge9M(), population0sDto.getPopAge9W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge0, map.get(subCityWard1).get(1) + population0sDto.getPopAge0M(), map.get(subCityWard1).get(2) + population0sDto.getPopAge0W(),
                            map.get(subCityWard1).get(3) + sumAge1, map.get(subCityWard1).get(4) + population0sDto.getPopAge1M(), map.get(subCityWard1).get(5) + population0sDto.getPopAge1W(),
                            map.get(subCityWard1).get(6) + sumAge2, map.get(subCityWard1).get(7) + population0sDto.getPopAge2M(), map.get(subCityWard1).get(8) + population0sDto.getPopAge2W(),
                            map.get(subCityWard1).get(9) + sumAge3, map.get(subCityWard1).get(10) + population0sDto.getPopAge3M(), map.get(subCityWard1).get(11) + population0sDto.getPopAge3W(),
                            map.get(subCityWard1).get(12) + sumAge4, map.get(subCityWard1).get(13) + population0sDto.getPopAge4M(), map.get(subCityWard1).get(14) + population0sDto.getPopAge4W(),
                            map.get(subCityWard1).get(15) + sumAge5, map.get(subCityWard1).get(16) + population0sDto.getPopAge5M(), map.get(subCityWard1).get(17) + population0sDto.getPopAge5W(),
                            map.get(subCityWard1).get(18) + sumAge6, map.get(subCityWard1).get(19) + population0sDto.getPopAge6M(), map.get(subCityWard1).get(20) + population0sDto.getPopAge6W(),
                            map.get(subCityWard1).get(21) + sumAge7, map.get(subCityWard1).get(22) + population0sDto.getPopAge7M(), map.get(subCityWard1).get(23) + population0sDto.getPopAge7W(),
                            map.get(subCityWard1).get(24) + sumAge8, map.get(subCityWard1).get(25) + population0sDto.getPopAge8M(), map.get(subCityWard1).get(26) + population0sDto.getPopAge8W(),
                            map.get(subCityWard1).get(27) + sumAge9, map.get(subCityWard1).get(28) + population0sDto.getPopAge9M(), map.get(subCityWard1).get(29) + population0sDto.getPopAge9W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge0, population0sDto.getPopAge0M(), population0sDto.getPopAge0W(),
                            sumAge1, population0sDto.getPopAge1M(), population0sDto.getPopAge1W(),
                            sumAge2, population0sDto.getPopAge2M(), population0sDto.getPopAge2W(),
                            sumAge3, population0sDto.getPopAge3M(), population0sDto.getPopAge3W(),
                            sumAge4, population0sDto.getPopAge4M(), population0sDto.getPopAge4W(),
                            sumAge5, population0sDto.getPopAge5M(), population0sDto.getPopAge5W(),
                            sumAge6, population0sDto.getPopAge6M(), population0sDto.getPopAge6W(),
                            sumAge7, population0sDto.getPopAge7M(), population0sDto.getPopAge7W(),
                            sumAge8, population0sDto.getPopAge8M(), population0sDto.getPopAge8W(),
                            sumAge9, population0sDto.getPopAge9M(), population0sDto.getPopAge9W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge0, map.get(subCityWard2).get(1) + population0sDto.getPopAge0M(), map.get(subCityWard2).get(2) + population0sDto.getPopAge0W(),
                            map.get(subCityWard2).get(3) + sumAge1, map.get(subCityWard2).get(4) + population0sDto.getPopAge1M(), map.get(subCityWard2).get(5) + population0sDto.getPopAge1W(),
                            map.get(subCityWard2).get(6) + sumAge2, map.get(subCityWard2).get(7) + population0sDto.getPopAge2M(), map.get(subCityWard2).get(8) + population0sDto.getPopAge2W(),
                            map.get(subCityWard2).get(9) + sumAge3, map.get(subCityWard2).get(10) + population0sDto.getPopAge3M(), map.get(subCityWard2).get(11) + population0sDto.getPopAge3W(),
                            map.get(subCityWard2).get(12) + sumAge4, map.get(subCityWard2).get(13) + population0sDto.getPopAge4M(), map.get(subCityWard2).get(14) + population0sDto.getPopAge4W(),
                            map.get(subCityWard2).get(15) + sumAge5, map.get(subCityWard2).get(16) + population0sDto.getPopAge5M(), map.get(subCityWard2).get(17) + population0sDto.getPopAge5W(),
                            map.get(subCityWard2).get(18) + sumAge6, map.get(subCityWard2).get(19) + population0sDto.getPopAge6M(), map.get(subCityWard2).get(20) + population0sDto.getPopAge6W(),
                            map.get(subCityWard2).get(21) + sumAge7, map.get(subCityWard2).get(22) + population0sDto.getPopAge7M(), map.get(subCityWard2).get(23) + population0sDto.getPopAge7W(),
                            map.get(subCityWard2).get(24) + sumAge8, map.get(subCityWard2).get(25) + population0sDto.getPopAge8M(), map.get(subCityWard2).get(26) + population0sDto.getPopAge8W(),
                            map.get(subCityWard2).get(27) + sumAge9, map.get(subCityWard2).get(28) + population0sDto.getPopAge9M(), map.get(subCityWard2).get(29) + population0sDto.getPopAge9W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge0, population0sDto.getPopAge0M(), population0sDto.getPopAge0W(),
                            sumAge1, population0sDto.getPopAge1M(), population0sDto.getPopAge1W(),
                            sumAge2, population0sDto.getPopAge2M(), population0sDto.getPopAge2W(),
                            sumAge3, population0sDto.getPopAge3M(), population0sDto.getPopAge3W(),
                            sumAge4, population0sDto.getPopAge4M(), population0sDto.getPopAge4W(),
                            sumAge5, population0sDto.getPopAge5M(), population0sDto.getPopAge5W(),
                            sumAge6, population0sDto.getPopAge6M(), population0sDto.getPopAge6W(),
                            sumAge7, population0sDto.getPopAge7M(), population0sDto.getPopAge7W(),
                            sumAge8, population0sDto.getPopAge8M(), population0sDto.getPopAge8W(),
                            sumAge9, population0sDto.getPopAge9M(), population0sDto.getPopAge9W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge0, map.get(cityWard).get(1) + population0sDto.getPopAge0M(), map.get(cityWard).get(2) + population0sDto.getPopAge0W(),
                            map.get(cityWard).get(3) + sumAge1, map.get(cityWard).get(4) + population0sDto.getPopAge1M(), map.get(cityWard).get(5) + population0sDto.getPopAge1W(),
                            map.get(cityWard).get(6) + sumAge2, map.get(cityWard).get(7) + population0sDto.getPopAge2M(), map.get(cityWard).get(8) + population0sDto.getPopAge2W(),
                            map.get(cityWard).get(9) + sumAge3, map.get(cityWard).get(10) + population0sDto.getPopAge3M(), map.get(cityWard).get(11) + population0sDto.getPopAge3W(),
                            map.get(cityWard).get(12) + sumAge4, map.get(cityWard).get(13) + population0sDto.getPopAge4M(), map.get(cityWard).get(14) + population0sDto.getPopAge4W(),
                            map.get(cityWard).get(15) + sumAge5, map.get(cityWard).get(16) + population0sDto.getPopAge5M(), map.get(cityWard).get(17) + population0sDto.getPopAge5W(),
                            map.get(cityWard).get(18) + sumAge6, map.get(cityWard).get(19) + population0sDto.getPopAge6M(), map.get(cityWard).get(20) + population0sDto.getPopAge6W(),
                            map.get(cityWard).get(21) + sumAge7, map.get(cityWard).get(22) + population0sDto.getPopAge7M(), map.get(cityWard).get(23) + population0sDto.getPopAge7W(),
                            map.get(cityWard).get(24) + sumAge8, map.get(cityWard).get(25) + population0sDto.getPopAge8M(), map.get(cityWard).get(26) + population0sDto.getPopAge8W(),
                            map.get(cityWard).get(27) + sumAge9, map.get(cityWard).get(28) + population0sDto.getPopAge9M(), map.get(cityWard).get(29) + population0sDto.getPopAge9W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_oct_total_0s (pop_seq, pop_place, " +
                        "age_0_total, age_0_total_m, age_0_total_w, age_1_total, age_1_total_m, age_1_total_w, " +
                        "age_2_total, age_2_total_m, age_2_total_w, age_3_total, age_3_total_m, age_3_total_w, " +
                        "age_4_total, age_4_total_m, age_4_total_w, age_5_total, age_5_total_m, age_5_total_w, " +
                        "age_6_total, age_6_total_m, age_6_total_w, age_7_total, age_7_total_m, age_7_total_w, " +
                        "age_8_total, age_8_total_m, age_8_total_w, age_9_total, age_9_total_m, age_9_total_w) " +
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
