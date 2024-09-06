package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.Population20sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMay20sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMay20sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population20sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may_20s (admin_code, age_20_m, age_20_w, " +
                        "age_21_m, age_21_w, age_22_m, age_22_w, age_23_m, age_23_w, " +
                        "age_24_m, age_24_w, age_25_m, age_25_w, age_26_m, age_26_w, " +
                        "age_27_m, age_27_w, age_28_m, age_28_w, age_29_m, age_29_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal20s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal20s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge20M());
                        ps.setLong(3, list.get(i).getPopAge20W());
                        ps.setLong(4, list.get(i).getPopAge21M());
                        ps.setLong(5, list.get(i).getPopAge21W());
                        ps.setLong(6, list.get(i).getPopAge22M());
                        ps.setLong(7, list.get(i).getPopAge22W());
                        ps.setLong(8, list.get(i).getPopAge23M());
                        ps.setLong(9, list.get(i).getPopAge23W());
                        ps.setLong(10, list.get(i).getPopAge24M());
                        ps.setLong(11, list.get(i).getPopAge24W());
                        ps.setLong(12, list.get(i).getPopAge25M());
                        ps.setLong(13, list.get(i).getPopAge25W());
                        ps.setLong(14, list.get(i).getPopAge26M());
                        ps.setLong(15, list.get(i).getPopAge26W());
                        ps.setLong(16, list.get(i).getPopAge27M());
                        ps.setLong(17, list.get(i).getPopAge27W());
                        ps.setLong(18, list.get(i).getPopAge28M());
                        ps.setLong(19, list.get(i).getPopAge28W());
                        ps.setLong(20, list.get(i).getPopAge29M());
                        ps.setLong(21, list.get(i).getPopAge29W());
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

    public void populationTotalInsert(List<Population20sDto> list) {

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

        for (Population20sDto population20sDto : list) {
            String nameCity = population20sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population20sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population20sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population20sDto.getPopAge20M() + population20sDto.getPopAge21M() + population20sDto.getPopAge22M() + population20sDto.getPopAge23M() + population20sDto.getPopAge24M() +
                    population20sDto.getPopAge25M() + population20sDto.getPopAge26M() + population20sDto.getPopAge27M() + population20sDto.getPopAge28M() + population20sDto.getPopAge29M());
            total_w += (population20sDto.getPopAge20W() + population20sDto.getPopAge21W() + population20sDto.getPopAge22W() + population20sDto.getPopAge23W() + population20sDto.getPopAge24W() +
                    population20sDto.getPopAge25W() + population20sDto.getPopAge26W() + population20sDto.getPopAge27W() + population20sDto.getPopAge28W() + population20sDto.getPopAge29W());

            Long sumAge20 = population20sDto.getPopAge20M() + population20sDto.getPopAge20W();
            Long sumAge21 = population20sDto.getPopAge21M() + population20sDto.getPopAge21W();
            Long sumAge22 = population20sDto.getPopAge22M() + population20sDto.getPopAge22W();
            Long sumAge23 = population20sDto.getPopAge23M() + population20sDto.getPopAge23W();
            Long sumAge24 = population20sDto.getPopAge24M() + population20sDto.getPopAge24W();
            Long sumAge25 = population20sDto.getPopAge25M() + population20sDto.getPopAge25W();
            Long sumAge26 = population20sDto.getPopAge26M() + population20sDto.getPopAge26W();
            Long sumAge27 = population20sDto.getPopAge27M() + population20sDto.getPopAge27W();
            Long sumAge28 = population20sDto.getPopAge28M() + population20sDto.getPopAge28W();
            Long sumAge29 = population20sDto.getPopAge29M() + population20sDto.getPopAge29W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge20, population20sDto.getPopAge20M(), population20sDto.getPopAge20W(),
                        sumAge21, population20sDto.getPopAge21M(), population20sDto.getPopAge21W(),
                        sumAge22, population20sDto.getPopAge22M(), population20sDto.getPopAge22W(),
                        sumAge23, population20sDto.getPopAge23M(), population20sDto.getPopAge23W(),
                        sumAge24, population20sDto.getPopAge24M(), population20sDto.getPopAge24W(),
                        sumAge25, population20sDto.getPopAge25M(), population20sDto.getPopAge25W(),
                        sumAge26, population20sDto.getPopAge26M(), population20sDto.getPopAge26W(),
                        sumAge27, population20sDto.getPopAge27M(), population20sDto.getPopAge27W(),
                        sumAge28, population20sDto.getPopAge28M(), population20sDto.getPopAge28W(),
                        sumAge29, population20sDto.getPopAge29M(), population20sDto.getPopAge29W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge20, map.get(nameCity).get(1) + population20sDto.getPopAge20M(), map.get(nameCity).get(2) + population20sDto.getPopAge20W(),
                        map.get(nameCity).get(3) + sumAge21, map.get(nameCity).get(4) + population20sDto.getPopAge21M(), map.get(nameCity).get(5) + population20sDto.getPopAge21W(),
                        map.get(nameCity).get(6) + sumAge22, map.get(nameCity).get(7) + population20sDto.getPopAge22M(), map.get(nameCity).get(8) + population20sDto.getPopAge22W(),
                        map.get(nameCity).get(9) + sumAge23, map.get(nameCity).get(10) + population20sDto.getPopAge23M(), map.get(nameCity).get(11) + population20sDto.getPopAge23W(),
                        map.get(nameCity).get(12) + sumAge24, map.get(nameCity).get(13) + population20sDto.getPopAge24M(), map.get(nameCity).get(14) + population20sDto.getPopAge24W(),
                        map.get(nameCity).get(15) + sumAge25, map.get(nameCity).get(16) + population20sDto.getPopAge25M(), map.get(nameCity).get(17) + population20sDto.getPopAge25W(),
                        map.get(nameCity).get(18) + sumAge26, map.get(nameCity).get(19) + population20sDto.getPopAge26M(), map.get(nameCity).get(20) + population20sDto.getPopAge26W(),
                        map.get(nameCity).get(21) + sumAge27, map.get(nameCity).get(22) + population20sDto.getPopAge27M(), map.get(nameCity).get(23) + population20sDto.getPopAge27W(),
                        map.get(nameCity).get(24) + sumAge28, map.get(nameCity).get(25) + population20sDto.getPopAge28M(), map.get(nameCity).get(26) + population20sDto.getPopAge28W(),
                        map.get(nameCity).get(27) + sumAge29, map.get(nameCity).get(28) + population20sDto.getPopAge29M(), map.get(nameCity).get(29) + population20sDto.getPopAge29W()
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
                            sumAge20, population20sDto.getPopAge20M(), population20sDto.getPopAge20W(),
                            sumAge21, population20sDto.getPopAge21M(), population20sDto.getPopAge21W(),
                            sumAge22, population20sDto.getPopAge22M(), population20sDto.getPopAge22W(),
                            sumAge23, population20sDto.getPopAge23M(), population20sDto.getPopAge23W(),
                            sumAge24, population20sDto.getPopAge24M(), population20sDto.getPopAge24W(),
                            sumAge25, population20sDto.getPopAge25M(), population20sDto.getPopAge25W(),
                            sumAge26, population20sDto.getPopAge26M(), population20sDto.getPopAge26W(),
                            sumAge27, population20sDto.getPopAge27M(), population20sDto.getPopAge27W(),
                            sumAge28, population20sDto.getPopAge28M(), population20sDto.getPopAge28W(),
                            sumAge29, population20sDto.getPopAge29M(), population20sDto.getPopAge29W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge20, map.get(subCityWard1).get(1) + population20sDto.getPopAge20M(), map.get(subCityWard1).get(2) + population20sDto.getPopAge20W(),
                            map.get(subCityWard1).get(3) + sumAge21, map.get(subCityWard1).get(4) + population20sDto.getPopAge21M(), map.get(subCityWard1).get(5) + population20sDto.getPopAge21W(),
                            map.get(subCityWard1).get(6) + sumAge22, map.get(subCityWard1).get(7) + population20sDto.getPopAge22M(), map.get(subCityWard1).get(8) + population20sDto.getPopAge22W(),
                            map.get(subCityWard1).get(9) + sumAge23, map.get(subCityWard1).get(10) + population20sDto.getPopAge23M(), map.get(subCityWard1).get(11) + population20sDto.getPopAge23W(),
                            map.get(subCityWard1).get(12) + sumAge24, map.get(subCityWard1).get(13) + population20sDto.getPopAge24M(), map.get(subCityWard1).get(14) + population20sDto.getPopAge24W(),
                            map.get(subCityWard1).get(15) + sumAge25, map.get(subCityWard1).get(16) + population20sDto.getPopAge25M(), map.get(subCityWard1).get(17) + population20sDto.getPopAge25W(),
                            map.get(subCityWard1).get(18) + sumAge26, map.get(subCityWard1).get(19) + population20sDto.getPopAge26M(), map.get(subCityWard1).get(20) + population20sDto.getPopAge26W(),
                            map.get(subCityWard1).get(21) + sumAge27, map.get(subCityWard1).get(22) + population20sDto.getPopAge27M(), map.get(subCityWard1).get(23) + population20sDto.getPopAge27W(),
                            map.get(subCityWard1).get(24) + sumAge28, map.get(subCityWard1).get(25) + population20sDto.getPopAge28M(), map.get(subCityWard1).get(26) + population20sDto.getPopAge28W(),
                            map.get(subCityWard1).get(27) + sumAge29, map.get(subCityWard1).get(28) + population20sDto.getPopAge29M(), map.get(subCityWard1).get(29) + population20sDto.getPopAge29W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge20, population20sDto.getPopAge20M(), population20sDto.getPopAge20W(),
                            sumAge21, population20sDto.getPopAge21M(), population20sDto.getPopAge21W(),
                            sumAge22, population20sDto.getPopAge22M(), population20sDto.getPopAge22W(),
                            sumAge23, population20sDto.getPopAge23M(), population20sDto.getPopAge23W(),
                            sumAge24, population20sDto.getPopAge24M(), population20sDto.getPopAge24W(),
                            sumAge25, population20sDto.getPopAge25M(), population20sDto.getPopAge25W(),
                            sumAge26, population20sDto.getPopAge26M(), population20sDto.getPopAge26W(),
                            sumAge27, population20sDto.getPopAge27M(), population20sDto.getPopAge27W(),
                            sumAge28, population20sDto.getPopAge28M(), population20sDto.getPopAge28W(),
                            sumAge29, population20sDto.getPopAge29M(), population20sDto.getPopAge29W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge20, map.get(subCityWard2).get(1) + population20sDto.getPopAge20M(), map.get(subCityWard2).get(2) + population20sDto.getPopAge20W(),
                            map.get(subCityWard2).get(3) + sumAge21, map.get(subCityWard2).get(4) + population20sDto.getPopAge21M(), map.get(subCityWard2).get(5) + population20sDto.getPopAge21W(),
                            map.get(subCityWard2).get(6) + sumAge22, map.get(subCityWard2).get(7) + population20sDto.getPopAge22M(), map.get(subCityWard2).get(8) + population20sDto.getPopAge22W(),
                            map.get(subCityWard2).get(9) + sumAge23, map.get(subCityWard2).get(10) + population20sDto.getPopAge23M(), map.get(subCityWard2).get(11) + population20sDto.getPopAge23W(),
                            map.get(subCityWard2).get(12) + sumAge24, map.get(subCityWard2).get(13) + population20sDto.getPopAge24M(), map.get(subCityWard2).get(14) + population20sDto.getPopAge24W(),
                            map.get(subCityWard2).get(15) + sumAge25, map.get(subCityWard2).get(16) + population20sDto.getPopAge25M(), map.get(subCityWard2).get(17) + population20sDto.getPopAge25W(),
                            map.get(subCityWard2).get(18) + sumAge26, map.get(subCityWard2).get(19) + population20sDto.getPopAge26M(), map.get(subCityWard2).get(20) + population20sDto.getPopAge26W(),
                            map.get(subCityWard2).get(21) + sumAge27, map.get(subCityWard2).get(22) + population20sDto.getPopAge27M(), map.get(subCityWard2).get(23) + population20sDto.getPopAge27W(),
                            map.get(subCityWard2).get(24) + sumAge28, map.get(subCityWard2).get(25) + population20sDto.getPopAge28M(), map.get(subCityWard2).get(26) + population20sDto.getPopAge28W(),
                            map.get(subCityWard2).get(27) + sumAge29, map.get(subCityWard2).get(28) + population20sDto.getPopAge29M(), map.get(subCityWard2).get(29) + population20sDto.getPopAge29W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge20, population20sDto.getPopAge20M(), population20sDto.getPopAge20W(),
                            sumAge21, population20sDto.getPopAge21M(), population20sDto.getPopAge21W(),
                            sumAge22, population20sDto.getPopAge22M(), population20sDto.getPopAge22W(),
                            sumAge23, population20sDto.getPopAge23M(), population20sDto.getPopAge23W(),
                            sumAge24, population20sDto.getPopAge24M(), population20sDto.getPopAge24W(),
                            sumAge25, population20sDto.getPopAge25M(), population20sDto.getPopAge25W(),
                            sumAge26, population20sDto.getPopAge26M(), population20sDto.getPopAge26W(),
                            sumAge27, population20sDto.getPopAge27M(), population20sDto.getPopAge27W(),
                            sumAge28, population20sDto.getPopAge28M(), population20sDto.getPopAge28W(),
                            sumAge29, population20sDto.getPopAge29M(), population20sDto.getPopAge29W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge20, map.get(cityWard).get(1) + population20sDto.getPopAge20M(), map.get(cityWard).get(2) + population20sDto.getPopAge20W(),
                            map.get(cityWard).get(3) + sumAge21, map.get(cityWard).get(4) + population20sDto.getPopAge21M(), map.get(cityWard).get(5) + population20sDto.getPopAge21W(),
                            map.get(cityWard).get(6) + sumAge22, map.get(cityWard).get(7) + population20sDto.getPopAge22M(), map.get(cityWard).get(8) + population20sDto.getPopAge22W(),
                            map.get(cityWard).get(9) + sumAge23, map.get(cityWard).get(10) + population20sDto.getPopAge23M(), map.get(cityWard).get(11) + population20sDto.getPopAge23W(),
                            map.get(cityWard).get(12) + sumAge24, map.get(cityWard).get(13) + population20sDto.getPopAge24M(), map.get(cityWard).get(14) + population20sDto.getPopAge24W(),
                            map.get(cityWard).get(15) + sumAge25, map.get(cityWard).get(16) + population20sDto.getPopAge25M(), map.get(cityWard).get(17) + population20sDto.getPopAge25W(),
                            map.get(cityWard).get(18) + sumAge26, map.get(cityWard).get(19) + population20sDto.getPopAge26M(), map.get(cityWard).get(20) + population20sDto.getPopAge26W(),
                            map.get(cityWard).get(21) + sumAge27, map.get(cityWard).get(22) + population20sDto.getPopAge27M(), map.get(cityWard).get(23) + population20sDto.getPopAge27W(),
                            map.get(cityWard).get(24) + sumAge28, map.get(cityWard).get(25) + population20sDto.getPopAge28M(), map.get(cityWard).get(26) + population20sDto.getPopAge28W(),
                            map.get(cityWard).get(27) + sumAge29, map.get(cityWard).get(28) + population20sDto.getPopAge29M(), map.get(cityWard).get(29) + population20sDto.getPopAge29W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_may_total_20s (pop_seq, pop_place, " +
                        "age_20_total, age_20_total_m, age_20_total_w, age_21_total, age_21_total_m, age_21_total_w, " +
                        "age_22_total, age_22_total_m, age_22_total_w, age_23_total, age_23_total_m, age_23_total_w, " +
                        "age_24_total, age_24_total_m, age_24_total_w, age_25_total, age_25_total_m, age_25_total_w, " +
                        "age_26_total, age_26_total_m, age_26_total_w, age_27_total, age_27_total_m, age_27_total_w, " +
                        "age_28_total, age_28_total_m, age_28_total_w, age_29_total, age_29_total_m, age_29_total_w) " +
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
