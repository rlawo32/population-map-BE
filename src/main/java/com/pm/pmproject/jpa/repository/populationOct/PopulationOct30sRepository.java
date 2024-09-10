package com.pm.pmproject.jpa.repository.populationOct;

import com.pm.pmproject.dto.Population30sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PopulationOct30sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationOct30sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population30sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_oct_30s (admin_code, age_30_m, age_30_w, " +
                        "age_31_m, age_31_w, age_32_m, age_32_w, age_33_m, age_33_w, " +
                        "age_34_m, age_34_w, age_35_m, age_35_w, age_36_m, age_36_w, " +
                        "age_37_m, age_37_w, age_38_m, age_38_w, age_39_m, age_39_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal30s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal30s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge30M());
                        ps.setLong(3, list.get(i).getPopAge30W());
                        ps.setLong(4, list.get(i).getPopAge31M());
                        ps.setLong(5, list.get(i).getPopAge31W());
                        ps.setLong(6, list.get(i).getPopAge32M());
                        ps.setLong(7, list.get(i).getPopAge32W());
                        ps.setLong(8, list.get(i).getPopAge33M());
                        ps.setLong(9, list.get(i).getPopAge33W());
                        ps.setLong(10, list.get(i).getPopAge34M());
                        ps.setLong(11, list.get(i).getPopAge34W());
                        ps.setLong(12, list.get(i).getPopAge35M());
                        ps.setLong(13, list.get(i).getPopAge35W());
                        ps.setLong(14, list.get(i).getPopAge36M());
                        ps.setLong(15, list.get(i).getPopAge36W());
                        ps.setLong(16, list.get(i).getPopAge37M());
                        ps.setLong(17, list.get(i).getPopAge37W());
                        ps.setLong(18, list.get(i).getPopAge38M());
                        ps.setLong(19, list.get(i).getPopAge38W());
                        ps.setLong(20, list.get(i).getPopAge39M());
                        ps.setLong(21, list.get(i).getPopAge39W());
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

    public void populationTotalInsert(List<Population30sDto> list) {

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

        for (Population30sDto population30sDto : list) {
            String nameCity = population30sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population30sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population30sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population30sDto.getPopAge30M() + population30sDto.getPopAge31M() + population30sDto.getPopAge32M() + population30sDto.getPopAge33M() + population30sDto.getPopAge34M() +
                    population30sDto.getPopAge35M() + population30sDto.getPopAge36M() + population30sDto.getPopAge37M() + population30sDto.getPopAge38M() + population30sDto.getPopAge39M());
            total_w += (population30sDto.getPopAge30W() + population30sDto.getPopAge31W() + population30sDto.getPopAge32W() + population30sDto.getPopAge33W() + population30sDto.getPopAge34W() +
                    population30sDto.getPopAge35W() + population30sDto.getPopAge36W() + population30sDto.getPopAge37W() + population30sDto.getPopAge38W() + population30sDto.getPopAge39W());

            Long sumAge30 = population30sDto.getPopAge30M() + population30sDto.getPopAge30W();
            Long sumAge31 = population30sDto.getPopAge31M() + population30sDto.getPopAge31W();
            Long sumAge32 = population30sDto.getPopAge32M() + population30sDto.getPopAge32W();
            Long sumAge33 = population30sDto.getPopAge33M() + population30sDto.getPopAge33W();
            Long sumAge34 = population30sDto.getPopAge34M() + population30sDto.getPopAge34W();
            Long sumAge35 = population30sDto.getPopAge35M() + population30sDto.getPopAge35W();
            Long sumAge36 = population30sDto.getPopAge36M() + population30sDto.getPopAge36W();
            Long sumAge37 = population30sDto.getPopAge37M() + population30sDto.getPopAge37W();
            Long sumAge38 = population30sDto.getPopAge38M() + population30sDto.getPopAge38W();
            Long sumAge39 = population30sDto.getPopAge39M() + population30sDto.getPopAge39W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge30, population30sDto.getPopAge30M(), population30sDto.getPopAge30W(),
                        sumAge31, population30sDto.getPopAge31M(), population30sDto.getPopAge31W(),
                        sumAge32, population30sDto.getPopAge32M(), population30sDto.getPopAge32W(),
                        sumAge33, population30sDto.getPopAge33M(), population30sDto.getPopAge33W(),
                        sumAge34, population30sDto.getPopAge34M(), population30sDto.getPopAge34W(),
                        sumAge35, population30sDto.getPopAge35M(), population30sDto.getPopAge35W(),
                        sumAge36, population30sDto.getPopAge36M(), population30sDto.getPopAge36W(),
                        sumAge37, population30sDto.getPopAge37M(), population30sDto.getPopAge37W(),
                        sumAge38, population30sDto.getPopAge38M(), population30sDto.getPopAge38W(),
                        sumAge39, population30sDto.getPopAge39M(), population30sDto.getPopAge39W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge30, map.get(nameCity).get(1) + population30sDto.getPopAge30M(), map.get(nameCity).get(2) + population30sDto.getPopAge30W(),
                        map.get(nameCity).get(3) + sumAge31, map.get(nameCity).get(4) + population30sDto.getPopAge31M(), map.get(nameCity).get(5) + population30sDto.getPopAge31W(),
                        map.get(nameCity).get(6) + sumAge32, map.get(nameCity).get(7) + population30sDto.getPopAge32M(), map.get(nameCity).get(8) + population30sDto.getPopAge32W(),
                        map.get(nameCity).get(9) + sumAge33, map.get(nameCity).get(10) + population30sDto.getPopAge33M(), map.get(nameCity).get(11) + population30sDto.getPopAge33W(),
                        map.get(nameCity).get(12) + sumAge34, map.get(nameCity).get(13) + population30sDto.getPopAge34M(), map.get(nameCity).get(14) + population30sDto.getPopAge34W(),
                        map.get(nameCity).get(15) + sumAge35, map.get(nameCity).get(16) + population30sDto.getPopAge35M(), map.get(nameCity).get(17) + population30sDto.getPopAge35W(),
                        map.get(nameCity).get(18) + sumAge36, map.get(nameCity).get(19) + population30sDto.getPopAge36M(), map.get(nameCity).get(20) + population30sDto.getPopAge36W(),
                        map.get(nameCity).get(21) + sumAge37, map.get(nameCity).get(22) + population30sDto.getPopAge37M(), map.get(nameCity).get(23) + population30sDto.getPopAge37W(),
                        map.get(nameCity).get(24) + sumAge38, map.get(nameCity).get(25) + population30sDto.getPopAge38M(), map.get(nameCity).get(26) + population30sDto.getPopAge38W(),
                        map.get(nameCity).get(27) + sumAge39, map.get(nameCity).get(28) + population30sDto.getPopAge39M(), map.get(nameCity).get(29) + population30sDto.getPopAge39W()
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
                            sumAge30, population30sDto.getPopAge30M(), population30sDto.getPopAge30W(),
                            sumAge31, population30sDto.getPopAge31M(), population30sDto.getPopAge31W(),
                            sumAge32, population30sDto.getPopAge32M(), population30sDto.getPopAge32W(),
                            sumAge33, population30sDto.getPopAge33M(), population30sDto.getPopAge33W(),
                            sumAge34, population30sDto.getPopAge34M(), population30sDto.getPopAge34W(),
                            sumAge35, population30sDto.getPopAge35M(), population30sDto.getPopAge35W(),
                            sumAge36, population30sDto.getPopAge36M(), population30sDto.getPopAge36W(),
                            sumAge37, population30sDto.getPopAge37M(), population30sDto.getPopAge37W(),
                            sumAge38, population30sDto.getPopAge38M(), population30sDto.getPopAge38W(),
                            sumAge39, population30sDto.getPopAge39M(), population30sDto.getPopAge39W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge30, map.get(subCityWard1).get(1) + population30sDto.getPopAge30M(), map.get(subCityWard1).get(2) + population30sDto.getPopAge30W(),
                            map.get(subCityWard1).get(3) + sumAge31, map.get(subCityWard1).get(4) + population30sDto.getPopAge31M(), map.get(subCityWard1).get(5) + population30sDto.getPopAge31W(),
                            map.get(subCityWard1).get(6) + sumAge32, map.get(subCityWard1).get(7) + population30sDto.getPopAge32M(), map.get(subCityWard1).get(8) + population30sDto.getPopAge32W(),
                            map.get(subCityWard1).get(9) + sumAge33, map.get(subCityWard1).get(10) + population30sDto.getPopAge33M(), map.get(subCityWard1).get(11) + population30sDto.getPopAge33W(),
                            map.get(subCityWard1).get(12) + sumAge34, map.get(subCityWard1).get(13) + population30sDto.getPopAge34M(), map.get(subCityWard1).get(14) + population30sDto.getPopAge34W(),
                            map.get(subCityWard1).get(15) + sumAge35, map.get(subCityWard1).get(16) + population30sDto.getPopAge35M(), map.get(subCityWard1).get(17) + population30sDto.getPopAge35W(),
                            map.get(subCityWard1).get(18) + sumAge36, map.get(subCityWard1).get(19) + population30sDto.getPopAge36M(), map.get(subCityWard1).get(20) + population30sDto.getPopAge36W(),
                            map.get(subCityWard1).get(21) + sumAge37, map.get(subCityWard1).get(22) + population30sDto.getPopAge37M(), map.get(subCityWard1).get(23) + population30sDto.getPopAge37W(),
                            map.get(subCityWard1).get(24) + sumAge38, map.get(subCityWard1).get(25) + population30sDto.getPopAge38M(), map.get(subCityWard1).get(26) + population30sDto.getPopAge38W(),
                            map.get(subCityWard1).get(27) + sumAge39, map.get(subCityWard1).get(28) + population30sDto.getPopAge39M(), map.get(subCityWard1).get(29) + population30sDto.getPopAge39W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge30, population30sDto.getPopAge30M(), population30sDto.getPopAge30W(),
                            sumAge31, population30sDto.getPopAge31M(), population30sDto.getPopAge31W(),
                            sumAge32, population30sDto.getPopAge32M(), population30sDto.getPopAge32W(),
                            sumAge33, population30sDto.getPopAge33M(), population30sDto.getPopAge33W(),
                            sumAge34, population30sDto.getPopAge34M(), population30sDto.getPopAge34W(),
                            sumAge35, population30sDto.getPopAge35M(), population30sDto.getPopAge35W(),
                            sumAge36, population30sDto.getPopAge36M(), population30sDto.getPopAge36W(),
                            sumAge37, population30sDto.getPopAge37M(), population30sDto.getPopAge37W(),
                            sumAge38, population30sDto.getPopAge38M(), population30sDto.getPopAge38W(),
                            sumAge39, population30sDto.getPopAge39M(), population30sDto.getPopAge39W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge30, map.get(subCityWard2).get(1) + population30sDto.getPopAge30M(), map.get(subCityWard2).get(2) + population30sDto.getPopAge30W(),
                            map.get(subCityWard2).get(3) + sumAge31, map.get(subCityWard2).get(4) + population30sDto.getPopAge31M(), map.get(subCityWard2).get(5) + population30sDto.getPopAge31W(),
                            map.get(subCityWard2).get(6) + sumAge32, map.get(subCityWard2).get(7) + population30sDto.getPopAge32M(), map.get(subCityWard2).get(8) + population30sDto.getPopAge32W(),
                            map.get(subCityWard2).get(9) + sumAge33, map.get(subCityWard2).get(10) + population30sDto.getPopAge33M(), map.get(subCityWard2).get(11) + population30sDto.getPopAge33W(),
                            map.get(subCityWard2).get(12) + sumAge34, map.get(subCityWard2).get(13) + population30sDto.getPopAge34M(), map.get(subCityWard2).get(14) + population30sDto.getPopAge34W(),
                            map.get(subCityWard2).get(15) + sumAge35, map.get(subCityWard2).get(16) + population30sDto.getPopAge35M(), map.get(subCityWard2).get(17) + population30sDto.getPopAge35W(),
                            map.get(subCityWard2).get(18) + sumAge36, map.get(subCityWard2).get(19) + population30sDto.getPopAge36M(), map.get(subCityWard2).get(20) + population30sDto.getPopAge36W(),
                            map.get(subCityWard2).get(21) + sumAge37, map.get(subCityWard2).get(22) + population30sDto.getPopAge37M(), map.get(subCityWard2).get(23) + population30sDto.getPopAge37W(),
                            map.get(subCityWard2).get(24) + sumAge38, map.get(subCityWard2).get(25) + population30sDto.getPopAge38M(), map.get(subCityWard2).get(26) + population30sDto.getPopAge38W(),
                            map.get(subCityWard2).get(27) + sumAge39, map.get(subCityWard2).get(28) + population30sDto.getPopAge39M(), map.get(subCityWard2).get(29) + population30sDto.getPopAge39W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge30, population30sDto.getPopAge30M(), population30sDto.getPopAge30W(),
                            sumAge31, population30sDto.getPopAge31M(), population30sDto.getPopAge31W(),
                            sumAge32, population30sDto.getPopAge32M(), population30sDto.getPopAge32W(),
                            sumAge33, population30sDto.getPopAge33M(), population30sDto.getPopAge33W(),
                            sumAge34, population30sDto.getPopAge34M(), population30sDto.getPopAge34W(),
                            sumAge35, population30sDto.getPopAge35M(), population30sDto.getPopAge35W(),
                            sumAge36, population30sDto.getPopAge36M(), population30sDto.getPopAge36W(),
                            sumAge37, population30sDto.getPopAge37M(), population30sDto.getPopAge37W(),
                            sumAge38, population30sDto.getPopAge38M(), population30sDto.getPopAge38W(),
                            sumAge39, population30sDto.getPopAge39M(), population30sDto.getPopAge39W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge30, map.get(cityWard).get(1) + population30sDto.getPopAge30M(), map.get(cityWard).get(2) + population30sDto.getPopAge30W(),
                            map.get(cityWard).get(3) + sumAge31, map.get(cityWard).get(4) + population30sDto.getPopAge31M(), map.get(cityWard).get(5) + population30sDto.getPopAge31W(),
                            map.get(cityWard).get(6) + sumAge32, map.get(cityWard).get(7) + population30sDto.getPopAge32M(), map.get(cityWard).get(8) + population30sDto.getPopAge32W(),
                            map.get(cityWard).get(9) + sumAge33, map.get(cityWard).get(10) + population30sDto.getPopAge33M(), map.get(cityWard).get(11) + population30sDto.getPopAge33W(),
                            map.get(cityWard).get(12) + sumAge34, map.get(cityWard).get(13) + population30sDto.getPopAge34M(), map.get(cityWard).get(14) + population30sDto.getPopAge34W(),
                            map.get(cityWard).get(15) + sumAge35, map.get(cityWard).get(16) + population30sDto.getPopAge35M(), map.get(cityWard).get(17) + population30sDto.getPopAge35W(),
                            map.get(cityWard).get(18) + sumAge36, map.get(cityWard).get(19) + population30sDto.getPopAge36M(), map.get(cityWard).get(20) + population30sDto.getPopAge36W(),
                            map.get(cityWard).get(21) + sumAge37, map.get(cityWard).get(22) + population30sDto.getPopAge37M(), map.get(cityWard).get(23) + population30sDto.getPopAge37W(),
                            map.get(cityWard).get(24) + sumAge38, map.get(cityWard).get(25) + population30sDto.getPopAge38M(), map.get(cityWard).get(26) + population30sDto.getPopAge38W(),
                            map.get(cityWard).get(27) + sumAge39, map.get(cityWard).get(28) + population30sDto.getPopAge39M(), map.get(cityWard).get(29) + population30sDto.getPopAge39W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_oct_total_30s (pop_seq, pop_place, " +
                        "age_30_total, age_30_total_m, age_30_total_w, age_31_total, age_31_total_m, age_31_total_w, " +
                        "age_32_total, age_32_total_m, age_32_total_w, age_33_total, age_33_total_m, age_33_total_w, " +
                        "age_34_total, age_34_total_m, age_34_total_w, age_35_total, age_35_total_m, age_35_total_w, " +
                        "age_36_total, age_36_total_m, age_36_total_w, age_37_total, age_37_total_m, age_37_total_w, " +
                        "age_38_total, age_38_total_m, age_38_total_w, age_39_total, age_39_total_m, age_39_total_w) " +
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
