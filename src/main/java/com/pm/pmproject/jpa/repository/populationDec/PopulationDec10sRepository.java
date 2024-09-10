package com.pm.pmproject.jpa.repository.populationDec;

import com.pm.pmproject.dto.Population10sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PopulationDec10sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationDec10sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population10sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_dec_10s (admin_code, age_10_m, age_10_w, " +
                        "age_11_m, age_11_w, age_12_m, age_12_w, age_13_m, age_13_w, " +
                        "age_14_m, age_14_w, age_15_m, age_15_w, age_16_m, age_16_w, " +
                        "age_17_m, age_17_w, age_18_m, age_18_w, age_19_m, age_19_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal10s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal10s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge10M());
                        ps.setLong(3, list.get(i).getPopAge10W());
                        ps.setLong(4, list.get(i).getPopAge11M());
                        ps.setLong(5, list.get(i).getPopAge11W());
                        ps.setLong(6, list.get(i).getPopAge12M());
                        ps.setLong(7, list.get(i).getPopAge12W());
                        ps.setLong(8, list.get(i).getPopAge13M());
                        ps.setLong(9, list.get(i).getPopAge13W());
                        ps.setLong(10, list.get(i).getPopAge14M());
                        ps.setLong(11, list.get(i).getPopAge14W());
                        ps.setLong(12, list.get(i).getPopAge15M());
                        ps.setLong(13, list.get(i).getPopAge15W());
                        ps.setLong(14, list.get(i).getPopAge16M());
                        ps.setLong(15, list.get(i).getPopAge16W());
                        ps.setLong(16, list.get(i).getPopAge17M());
                        ps.setLong(17, list.get(i).getPopAge17W());
                        ps.setLong(18, list.get(i).getPopAge18M());
                        ps.setLong(19, list.get(i).getPopAge18W());
                        ps.setLong(20, list.get(i).getPopAge19M());
                        ps.setLong(21, list.get(i).getPopAge19W());
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

    public void populationTotalInsert(List<Population10sDto> list) {

        // List<PopulationResultDto> list = jdbcTemplate.query("select pop_m_total, pop_w_total, pop_total, name_ward, name_city " +
        //                 "from population_dec", new RowMapper<PopulationResultDto>() {
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

        for (Population10sDto population10sDto : list) {
            String nameCity = population10sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population10sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population10sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population10sDto.getPopAge10M() + population10sDto.getPopAge11M() + population10sDto.getPopAge12M() + population10sDto.getPopAge13M() + population10sDto.getPopAge14M() +
                    population10sDto.getPopAge15M() + population10sDto.getPopAge16M() + population10sDto.getPopAge17M() + population10sDto.getPopAge18M() + population10sDto.getPopAge19M());
            total_w += (population10sDto.getPopAge10W() + population10sDto.getPopAge11W() + population10sDto.getPopAge12W() + population10sDto.getPopAge13W() + population10sDto.getPopAge14W() +
                    population10sDto.getPopAge15W() + population10sDto.getPopAge16W() + population10sDto.getPopAge17W() + population10sDto.getPopAge18W() + population10sDto.getPopAge19W());

            Long sumAge10 = population10sDto.getPopAge10M() + population10sDto.getPopAge10W();
            Long sumAge11 = population10sDto.getPopAge11M() + population10sDto.getPopAge11W();
            Long sumAge12 = population10sDto.getPopAge12M() + population10sDto.getPopAge12W();
            Long sumAge13 = population10sDto.getPopAge13M() + population10sDto.getPopAge13W();
            Long sumAge14 = population10sDto.getPopAge14M() + population10sDto.getPopAge14W();
            Long sumAge15 = population10sDto.getPopAge15M() + population10sDto.getPopAge15W();
            Long sumAge16 = population10sDto.getPopAge16M() + population10sDto.getPopAge16W();
            Long sumAge17 = population10sDto.getPopAge17M() + population10sDto.getPopAge17W();
            Long sumAge18 = population10sDto.getPopAge18M() + population10sDto.getPopAge18W();
            Long sumAge19 = population10sDto.getPopAge19M() + population10sDto.getPopAge19W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge10, population10sDto.getPopAge10M(), population10sDto.getPopAge10W(),
                        sumAge11, population10sDto.getPopAge11M(), population10sDto.getPopAge11W(),
                        sumAge12, population10sDto.getPopAge12M(), population10sDto.getPopAge12W(),
                        sumAge13, population10sDto.getPopAge13M(), population10sDto.getPopAge13W(),
                        sumAge14, population10sDto.getPopAge14M(), population10sDto.getPopAge14W(),
                        sumAge15, population10sDto.getPopAge15M(), population10sDto.getPopAge15W(),
                        sumAge16, population10sDto.getPopAge16M(), population10sDto.getPopAge16W(),
                        sumAge17, population10sDto.getPopAge17M(), population10sDto.getPopAge17W(),
                        sumAge18, population10sDto.getPopAge18M(), population10sDto.getPopAge18W(),
                        sumAge19, population10sDto.getPopAge19M(), population10sDto.getPopAge19W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge10, map.get(nameCity).get(1) + population10sDto.getPopAge10M(), map.get(nameCity).get(2) + population10sDto.getPopAge10W(),
                        map.get(nameCity).get(3) + sumAge11, map.get(nameCity).get(4) + population10sDto.getPopAge11M(), map.get(nameCity).get(5) + population10sDto.getPopAge11W(),
                        map.get(nameCity).get(6) + sumAge12, map.get(nameCity).get(7) + population10sDto.getPopAge12M(), map.get(nameCity).get(8) + population10sDto.getPopAge12W(),
                        map.get(nameCity).get(9) + sumAge13, map.get(nameCity).get(10) + population10sDto.getPopAge13M(), map.get(nameCity).get(11) + population10sDto.getPopAge13W(),
                        map.get(nameCity).get(12) + sumAge14, map.get(nameCity).get(13) + population10sDto.getPopAge14M(), map.get(nameCity).get(14) + population10sDto.getPopAge14W(),
                        map.get(nameCity).get(15) + sumAge15, map.get(nameCity).get(16) + population10sDto.getPopAge15M(), map.get(nameCity).get(17) + population10sDto.getPopAge15W(),
                        map.get(nameCity).get(18) + sumAge16, map.get(nameCity).get(19) + population10sDto.getPopAge16M(), map.get(nameCity).get(20) + population10sDto.getPopAge16W(),
                        map.get(nameCity).get(21) + sumAge17, map.get(nameCity).get(22) + population10sDto.getPopAge17M(), map.get(nameCity).get(23) + population10sDto.getPopAge17W(),
                        map.get(nameCity).get(24) + sumAge18, map.get(nameCity).get(25) + population10sDto.getPopAge18M(), map.get(nameCity).get(26) + population10sDto.getPopAge18W(),
                        map.get(nameCity).get(27) + sumAge19, map.get(nameCity).get(28) + population10sDto.getPopAge19M(), map.get(nameCity).get(29) + population10sDto.getPopAge19W()
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
                            sumAge10, population10sDto.getPopAge10M(), population10sDto.getPopAge10W(),
                            sumAge11, population10sDto.getPopAge11M(), population10sDto.getPopAge11W(),
                            sumAge12, population10sDto.getPopAge12M(), population10sDto.getPopAge12W(),
                            sumAge13, population10sDto.getPopAge13M(), population10sDto.getPopAge13W(),
                            sumAge14, population10sDto.getPopAge14M(), population10sDto.getPopAge14W(),
                            sumAge15, population10sDto.getPopAge15M(), population10sDto.getPopAge15W(),
                            sumAge16, population10sDto.getPopAge16M(), population10sDto.getPopAge16W(),
                            sumAge17, population10sDto.getPopAge17M(), population10sDto.getPopAge17W(),
                            sumAge18, population10sDto.getPopAge18M(), population10sDto.getPopAge18W(),
                            sumAge19, population10sDto.getPopAge19M(), population10sDto.getPopAge19W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge10, map.get(subCityWard1).get(1) + population10sDto.getPopAge10M(), map.get(subCityWard1).get(2) + population10sDto.getPopAge10W(),
                            map.get(subCityWard1).get(3) + sumAge11, map.get(subCityWard1).get(4) + population10sDto.getPopAge11M(), map.get(subCityWard1).get(5) + population10sDto.getPopAge11W(),
                            map.get(subCityWard1).get(6) + sumAge12, map.get(subCityWard1).get(7) + population10sDto.getPopAge12M(), map.get(subCityWard1).get(8) + population10sDto.getPopAge12W(),
                            map.get(subCityWard1).get(9) + sumAge13, map.get(subCityWard1).get(10) + population10sDto.getPopAge13M(), map.get(subCityWard1).get(11) + population10sDto.getPopAge13W(),
                            map.get(subCityWard1).get(12) + sumAge14, map.get(subCityWard1).get(13) + population10sDto.getPopAge14M(), map.get(subCityWard1).get(14) + population10sDto.getPopAge14W(),
                            map.get(subCityWard1).get(15) + sumAge15, map.get(subCityWard1).get(16) + population10sDto.getPopAge15M(), map.get(subCityWard1).get(17) + population10sDto.getPopAge15W(),
                            map.get(subCityWard1).get(18) + sumAge16, map.get(subCityWard1).get(19) + population10sDto.getPopAge16M(), map.get(subCityWard1).get(20) + population10sDto.getPopAge16W(),
                            map.get(subCityWard1).get(21) + sumAge17, map.get(subCityWard1).get(22) + population10sDto.getPopAge17M(), map.get(subCityWard1).get(23) + population10sDto.getPopAge17W(),
                            map.get(subCityWard1).get(24) + sumAge18, map.get(subCityWard1).get(25) + population10sDto.getPopAge18M(), map.get(subCityWard1).get(26) + population10sDto.getPopAge18W(),
                            map.get(subCityWard1).get(27) + sumAge19, map.get(subCityWard1).get(28) + population10sDto.getPopAge19M(), map.get(subCityWard1).get(29) + population10sDto.getPopAge19W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge10, population10sDto.getPopAge10M(), population10sDto.getPopAge10W(),
                            sumAge11, population10sDto.getPopAge11M(), population10sDto.getPopAge11W(),
                            sumAge12, population10sDto.getPopAge12M(), population10sDto.getPopAge12W(),
                            sumAge13, population10sDto.getPopAge13M(), population10sDto.getPopAge13W(),
                            sumAge14, population10sDto.getPopAge14M(), population10sDto.getPopAge14W(),
                            sumAge15, population10sDto.getPopAge15M(), population10sDto.getPopAge15W(),
                            sumAge16, population10sDto.getPopAge16M(), population10sDto.getPopAge16W(),
                            sumAge17, population10sDto.getPopAge17M(), population10sDto.getPopAge17W(),
                            sumAge18, population10sDto.getPopAge18M(), population10sDto.getPopAge18W(),
                            sumAge19, population10sDto.getPopAge19M(), population10sDto.getPopAge19W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge10, map.get(subCityWard2).get(1) + population10sDto.getPopAge10M(), map.get(subCityWard2).get(2) + population10sDto.getPopAge10W(),
                            map.get(subCityWard2).get(3) + sumAge11, map.get(subCityWard2).get(4) + population10sDto.getPopAge11M(), map.get(subCityWard2).get(5) + population10sDto.getPopAge11W(),
                            map.get(subCityWard2).get(6) + sumAge12, map.get(subCityWard2).get(7) + population10sDto.getPopAge12M(), map.get(subCityWard2).get(8) + population10sDto.getPopAge12W(),
                            map.get(subCityWard2).get(9) + sumAge13, map.get(subCityWard2).get(10) + population10sDto.getPopAge13M(), map.get(subCityWard2).get(11) + population10sDto.getPopAge13W(),
                            map.get(subCityWard2).get(12) + sumAge14, map.get(subCityWard2).get(13) + population10sDto.getPopAge14M(), map.get(subCityWard2).get(14) + population10sDto.getPopAge14W(),
                            map.get(subCityWard2).get(15) + sumAge15, map.get(subCityWard2).get(16) + population10sDto.getPopAge15M(), map.get(subCityWard2).get(17) + population10sDto.getPopAge15W(),
                            map.get(subCityWard2).get(18) + sumAge16, map.get(subCityWard2).get(19) + population10sDto.getPopAge16M(), map.get(subCityWard2).get(20) + population10sDto.getPopAge16W(),
                            map.get(subCityWard2).get(21) + sumAge17, map.get(subCityWard2).get(22) + population10sDto.getPopAge17M(), map.get(subCityWard2).get(23) + population10sDto.getPopAge17W(),
                            map.get(subCityWard2).get(24) + sumAge18, map.get(subCityWard2).get(25) + population10sDto.getPopAge18M(), map.get(subCityWard2).get(26) + population10sDto.getPopAge18W(),
                            map.get(subCityWard2).get(27) + sumAge19, map.get(subCityWard2).get(28) + population10sDto.getPopAge19M(), map.get(subCityWard2).get(29) + population10sDto.getPopAge19W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge10, population10sDto.getPopAge10M(), population10sDto.getPopAge10W(),
                            sumAge11, population10sDto.getPopAge11M(), population10sDto.getPopAge11W(),
                            sumAge12, population10sDto.getPopAge12M(), population10sDto.getPopAge12W(),
                            sumAge13, population10sDto.getPopAge13M(), population10sDto.getPopAge13W(),
                            sumAge14, population10sDto.getPopAge14M(), population10sDto.getPopAge14W(),
                            sumAge15, population10sDto.getPopAge15M(), population10sDto.getPopAge15W(),
                            sumAge16, population10sDto.getPopAge16M(), population10sDto.getPopAge16W(),
                            sumAge17, population10sDto.getPopAge17M(), population10sDto.getPopAge17W(),
                            sumAge18, population10sDto.getPopAge18M(), population10sDto.getPopAge18W(),
                            sumAge19, population10sDto.getPopAge19M(), population10sDto.getPopAge19W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge10, map.get(cityWard).get(1) + population10sDto.getPopAge10M(), map.get(cityWard).get(2) + population10sDto.getPopAge10W(),
                            map.get(cityWard).get(3) + sumAge11, map.get(cityWard).get(4) + population10sDto.getPopAge11M(), map.get(cityWard).get(5) + population10sDto.getPopAge11W(),
                            map.get(cityWard).get(6) + sumAge12, map.get(cityWard).get(7) + population10sDto.getPopAge12M(), map.get(cityWard).get(8) + population10sDto.getPopAge12W(),
                            map.get(cityWard).get(9) + sumAge13, map.get(cityWard).get(10) + population10sDto.getPopAge13M(), map.get(cityWard).get(11) + population10sDto.getPopAge13W(),
                            map.get(cityWard).get(12) + sumAge14, map.get(cityWard).get(13) + population10sDto.getPopAge14M(), map.get(cityWard).get(14) + population10sDto.getPopAge14W(),
                            map.get(cityWard).get(15) + sumAge15, map.get(cityWard).get(16) + population10sDto.getPopAge15M(), map.get(cityWard).get(17) + population10sDto.getPopAge15W(),
                            map.get(cityWard).get(18) + sumAge16, map.get(cityWard).get(19) + population10sDto.getPopAge16M(), map.get(cityWard).get(20) + population10sDto.getPopAge16W(),
                            map.get(cityWard).get(21) + sumAge17, map.get(cityWard).get(22) + population10sDto.getPopAge17M(), map.get(cityWard).get(23) + population10sDto.getPopAge17W(),
                            map.get(cityWard).get(24) + sumAge18, map.get(cityWard).get(25) + population10sDto.getPopAge18M(), map.get(cityWard).get(26) + population10sDto.getPopAge18W(),
                            map.get(cityWard).get(27) + sumAge19, map.get(cityWard).get(28) + population10sDto.getPopAge19M(), map.get(cityWard).get(29) + population10sDto.getPopAge19W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_dec_total_10s (pop_seq, pop_place, " +
                        "age_10_total, age_10_total_m, age_10_total_w, age_11_total, age_11_total_m, age_11_total_w, " +
                        "age_12_total, age_12_total_m, age_12_total_w, age_13_total, age_13_total_m, age_13_total_w, " +
                        "age_14_total, age_14_total_m, age_14_total_w, age_15_total, age_15_total_m, age_15_total_w, " +
                        "age_16_total, age_16_total_m, age_16_total_w, age_17_total, age_17_total_m, age_17_total_w, " +
                        "age_18_total, age_18_total_m, age_18_total_w, age_19_total, age_19_total_m, age_19_total_w) " +
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
