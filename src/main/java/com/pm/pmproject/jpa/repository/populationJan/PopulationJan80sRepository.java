package com.pm.pmproject.jpa.repository.populationJan;

import com.pm.pmproject.dto.Population80sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PopulationJan80sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationJan80sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population80sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_jan_80s (admin_code, age_80_m, age_80_w, " +
                        "age_81_m, age_81_w, age_82_m, age_82_w, age_83_m, age_83_w, " +
                        "age_84_m, age_84_w, age_85_m, age_85_w, age_86_m, age_86_w, " +
                        "age_87_m, age_87_w, age_88_m, age_88_w, age_89_m, age_89_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal80s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal80s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge80M());
                        ps.setLong(3, list.get(i).getPopAge80W());
                        ps.setLong(4, list.get(i).getPopAge81M());
                        ps.setLong(5, list.get(i).getPopAge81W());
                        ps.setLong(6, list.get(i).getPopAge82M());
                        ps.setLong(7, list.get(i).getPopAge82W());
                        ps.setLong(8, list.get(i).getPopAge83M());
                        ps.setLong(9, list.get(i).getPopAge83W());
                        ps.setLong(10, list.get(i).getPopAge84M());
                        ps.setLong(11, list.get(i).getPopAge84W());
                        ps.setLong(12, list.get(i).getPopAge85M());
                        ps.setLong(13, list.get(i).getPopAge85W());
                        ps.setLong(14, list.get(i).getPopAge86M());
                        ps.setLong(15, list.get(i).getPopAge86W());
                        ps.setLong(16, list.get(i).getPopAge87M());
                        ps.setLong(17, list.get(i).getPopAge87W());
                        ps.setLong(18, list.get(i).getPopAge88M());
                        ps.setLong(19, list.get(i).getPopAge88W());
                        ps.setLong(20, list.get(i).getPopAge89M());
                        ps.setLong(21, list.get(i).getPopAge89W());
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

    public void populationTotalInsert(List<Population80sDto> list) {

        // List<PopulationResultDto> list = jdbcTemplate.query("select pop_m_total, pop_w_total, pop_total, name_ward, name_city " +
        //                 "from population_jan", new RowMapper<PopulationResultDto>() {
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

        for (Population80sDto population80sDto : list) {
            String nameCity = population80sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population80sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population80sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population80sDto.getPopAge80M() + population80sDto.getPopAge81M() + population80sDto.getPopAge82M() + population80sDto.getPopAge83M() + population80sDto.getPopAge84M() +
                    population80sDto.getPopAge85M() + population80sDto.getPopAge86M() + population80sDto.getPopAge87M() + population80sDto.getPopAge88M() + population80sDto.getPopAge89M());
            total_w += (population80sDto.getPopAge80W() + population80sDto.getPopAge81W() + population80sDto.getPopAge82W() + population80sDto.getPopAge83W() + population80sDto.getPopAge84W() +
                    population80sDto.getPopAge85W() + population80sDto.getPopAge86W() + population80sDto.getPopAge87W() + population80sDto.getPopAge88W() + population80sDto.getPopAge89W());

            Long sumAge80 = population80sDto.getPopAge80M() + population80sDto.getPopAge80W();
            Long sumAge81 = population80sDto.getPopAge81M() + population80sDto.getPopAge81W();
            Long sumAge82 = population80sDto.getPopAge82M() + population80sDto.getPopAge82W();
            Long sumAge83 = population80sDto.getPopAge83M() + population80sDto.getPopAge83W();
            Long sumAge84 = population80sDto.getPopAge84M() + population80sDto.getPopAge84W();
            Long sumAge85 = population80sDto.getPopAge85M() + population80sDto.getPopAge85W();
            Long sumAge86 = population80sDto.getPopAge86M() + population80sDto.getPopAge86W();
            Long sumAge87 = population80sDto.getPopAge87M() + population80sDto.getPopAge87W();
            Long sumAge88 = population80sDto.getPopAge88M() + population80sDto.getPopAge88W();
            Long sumAge89 = population80sDto.getPopAge89M() + population80sDto.getPopAge89W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge80, population80sDto.getPopAge80M(), population80sDto.getPopAge80W(),
                        sumAge81, population80sDto.getPopAge81M(), population80sDto.getPopAge81W(),
                        sumAge82, population80sDto.getPopAge82M(), population80sDto.getPopAge82W(),
                        sumAge83, population80sDto.getPopAge83M(), population80sDto.getPopAge83W(),
                        sumAge84, population80sDto.getPopAge84M(), population80sDto.getPopAge84W(),
                        sumAge85, population80sDto.getPopAge85M(), population80sDto.getPopAge85W(),
                        sumAge86, population80sDto.getPopAge86M(), population80sDto.getPopAge86W(),
                        sumAge87, population80sDto.getPopAge87M(), population80sDto.getPopAge87W(),
                        sumAge88, population80sDto.getPopAge88M(), population80sDto.getPopAge88W(),
                        sumAge89, population80sDto.getPopAge89M(), population80sDto.getPopAge89W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge80, map.get(nameCity).get(1) + population80sDto.getPopAge80M(), map.get(nameCity).get(2) + population80sDto.getPopAge80W(),
                        map.get(nameCity).get(3) + sumAge81, map.get(nameCity).get(4) + population80sDto.getPopAge81M(), map.get(nameCity).get(5) + population80sDto.getPopAge81W(),
                        map.get(nameCity).get(6) + sumAge82, map.get(nameCity).get(7) + population80sDto.getPopAge82M(), map.get(nameCity).get(8) + population80sDto.getPopAge82W(),
                        map.get(nameCity).get(9) + sumAge83, map.get(nameCity).get(10) + population80sDto.getPopAge83M(), map.get(nameCity).get(11) + population80sDto.getPopAge83W(),
                        map.get(nameCity).get(12) + sumAge84, map.get(nameCity).get(13) + population80sDto.getPopAge84M(), map.get(nameCity).get(14) + population80sDto.getPopAge84W(),
                        map.get(nameCity).get(15) + sumAge85, map.get(nameCity).get(16) + population80sDto.getPopAge85M(), map.get(nameCity).get(17) + population80sDto.getPopAge85W(),
                        map.get(nameCity).get(18) + sumAge86, map.get(nameCity).get(19) + population80sDto.getPopAge86M(), map.get(nameCity).get(20) + population80sDto.getPopAge86W(),
                        map.get(nameCity).get(21) + sumAge87, map.get(nameCity).get(22) + population80sDto.getPopAge87M(), map.get(nameCity).get(23) + population80sDto.getPopAge87W(),
                        map.get(nameCity).get(24) + sumAge88, map.get(nameCity).get(25) + population80sDto.getPopAge88M(), map.get(nameCity).get(26) + population80sDto.getPopAge88W(),
                        map.get(nameCity).get(27) + sumAge89, map.get(nameCity).get(28) + population80sDto.getPopAge89M(), map.get(nameCity).get(29) + population80sDto.getPopAge89W()
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
                            sumAge80, population80sDto.getPopAge80M(), population80sDto.getPopAge80W(),
                            sumAge81, population80sDto.getPopAge81M(), population80sDto.getPopAge81W(),
                            sumAge82, population80sDto.getPopAge82M(), population80sDto.getPopAge82W(),
                            sumAge83, population80sDto.getPopAge83M(), population80sDto.getPopAge83W(),
                            sumAge84, population80sDto.getPopAge84M(), population80sDto.getPopAge84W(),
                            sumAge85, population80sDto.getPopAge85M(), population80sDto.getPopAge85W(),
                            sumAge86, population80sDto.getPopAge86M(), population80sDto.getPopAge86W(),
                            sumAge87, population80sDto.getPopAge87M(), population80sDto.getPopAge87W(),
                            sumAge88, population80sDto.getPopAge88M(), population80sDto.getPopAge88W(),
                            sumAge89, population80sDto.getPopAge89M(), population80sDto.getPopAge89W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge80, map.get(subCityWard1).get(1) + population80sDto.getPopAge80M(), map.get(subCityWard1).get(2) + population80sDto.getPopAge80W(),
                            map.get(subCityWard1).get(3) + sumAge81, map.get(subCityWard1).get(4) + population80sDto.getPopAge81M(), map.get(subCityWard1).get(5) + population80sDto.getPopAge81W(),
                            map.get(subCityWard1).get(6) + sumAge82, map.get(subCityWard1).get(7) + population80sDto.getPopAge82M(), map.get(subCityWard1).get(8) + population80sDto.getPopAge82W(),
                            map.get(subCityWard1).get(9) + sumAge83, map.get(subCityWard1).get(10) + population80sDto.getPopAge83M(), map.get(subCityWard1).get(11) + population80sDto.getPopAge83W(),
                            map.get(subCityWard1).get(12) + sumAge84, map.get(subCityWard1).get(13) + population80sDto.getPopAge84M(), map.get(subCityWard1).get(14) + population80sDto.getPopAge84W(),
                            map.get(subCityWard1).get(15) + sumAge85, map.get(subCityWard1).get(16) + population80sDto.getPopAge85M(), map.get(subCityWard1).get(17) + population80sDto.getPopAge85W(),
                            map.get(subCityWard1).get(18) + sumAge86, map.get(subCityWard1).get(19) + population80sDto.getPopAge86M(), map.get(subCityWard1).get(20) + population80sDto.getPopAge86W(),
                            map.get(subCityWard1).get(21) + sumAge87, map.get(subCityWard1).get(22) + population80sDto.getPopAge87M(), map.get(subCityWard1).get(23) + population80sDto.getPopAge87W(),
                            map.get(subCityWard1).get(24) + sumAge88, map.get(subCityWard1).get(25) + population80sDto.getPopAge88M(), map.get(subCityWard1).get(26) + population80sDto.getPopAge88W(),
                            map.get(subCityWard1).get(27) + sumAge89, map.get(subCityWard1).get(28) + population80sDto.getPopAge89M(), map.get(subCityWard1).get(29) + population80sDto.getPopAge89W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge80, population80sDto.getPopAge80M(), population80sDto.getPopAge80W(),
                            sumAge81, population80sDto.getPopAge81M(), population80sDto.getPopAge81W(),
                            sumAge82, population80sDto.getPopAge82M(), population80sDto.getPopAge82W(),
                            sumAge83, population80sDto.getPopAge83M(), population80sDto.getPopAge83W(),
                            sumAge84, population80sDto.getPopAge84M(), population80sDto.getPopAge84W(),
                            sumAge85, population80sDto.getPopAge85M(), population80sDto.getPopAge85W(),
                            sumAge86, population80sDto.getPopAge86M(), population80sDto.getPopAge86W(),
                            sumAge87, population80sDto.getPopAge87M(), population80sDto.getPopAge87W(),
                            sumAge88, population80sDto.getPopAge88M(), population80sDto.getPopAge88W(),
                            sumAge89, population80sDto.getPopAge89M(), population80sDto.getPopAge89W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge80, map.get(subCityWard2).get(1) + population80sDto.getPopAge80M(), map.get(subCityWard2).get(2) + population80sDto.getPopAge80W(),
                            map.get(subCityWard2).get(3) + sumAge81, map.get(subCityWard2).get(4) + population80sDto.getPopAge81M(), map.get(subCityWard2).get(5) + population80sDto.getPopAge81W(),
                            map.get(subCityWard2).get(6) + sumAge82, map.get(subCityWard2).get(7) + population80sDto.getPopAge82M(), map.get(subCityWard2).get(8) + population80sDto.getPopAge82W(),
                            map.get(subCityWard2).get(9) + sumAge83, map.get(subCityWard2).get(10) + population80sDto.getPopAge83M(), map.get(subCityWard2).get(11) + population80sDto.getPopAge83W(),
                            map.get(subCityWard2).get(12) + sumAge84, map.get(subCityWard2).get(13) + population80sDto.getPopAge84M(), map.get(subCityWard2).get(14) + population80sDto.getPopAge84W(),
                            map.get(subCityWard2).get(15) + sumAge85, map.get(subCityWard2).get(16) + population80sDto.getPopAge85M(), map.get(subCityWard2).get(17) + population80sDto.getPopAge85W(),
                            map.get(subCityWard2).get(18) + sumAge86, map.get(subCityWard2).get(19) + population80sDto.getPopAge86M(), map.get(subCityWard2).get(20) + population80sDto.getPopAge86W(),
                            map.get(subCityWard2).get(21) + sumAge87, map.get(subCityWard2).get(22) + population80sDto.getPopAge87M(), map.get(subCityWard2).get(23) + population80sDto.getPopAge87W(),
                            map.get(subCityWard2).get(24) + sumAge88, map.get(subCityWard2).get(25) + population80sDto.getPopAge88M(), map.get(subCityWard2).get(26) + population80sDto.getPopAge88W(),
                            map.get(subCityWard2).get(27) + sumAge89, map.get(subCityWard2).get(28) + population80sDto.getPopAge89M(), map.get(subCityWard2).get(29) + population80sDto.getPopAge89W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge80, population80sDto.getPopAge80M(), population80sDto.getPopAge80W(),
                            sumAge81, population80sDto.getPopAge81M(), population80sDto.getPopAge81W(),
                            sumAge82, population80sDto.getPopAge82M(), population80sDto.getPopAge82W(),
                            sumAge83, population80sDto.getPopAge83M(), population80sDto.getPopAge83W(),
                            sumAge84, population80sDto.getPopAge84M(), population80sDto.getPopAge84W(),
                            sumAge85, population80sDto.getPopAge85M(), population80sDto.getPopAge85W(),
                            sumAge86, population80sDto.getPopAge86M(), population80sDto.getPopAge86W(),
                            sumAge87, population80sDto.getPopAge87M(), population80sDto.getPopAge87W(),
                            sumAge88, population80sDto.getPopAge88M(), population80sDto.getPopAge88W(),
                            sumAge89, population80sDto.getPopAge89M(), population80sDto.getPopAge89W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge80, map.get(cityWard).get(1) + population80sDto.getPopAge80M(), map.get(cityWard).get(2) + population80sDto.getPopAge80W(),
                            map.get(cityWard).get(3) + sumAge81, map.get(cityWard).get(4) + population80sDto.getPopAge81M(), map.get(cityWard).get(5) + population80sDto.getPopAge81W(),
                            map.get(cityWard).get(6) + sumAge82, map.get(cityWard).get(7) + population80sDto.getPopAge82M(), map.get(cityWard).get(8) + population80sDto.getPopAge82W(),
                            map.get(cityWard).get(9) + sumAge83, map.get(cityWard).get(10) + population80sDto.getPopAge83M(), map.get(cityWard).get(11) + population80sDto.getPopAge83W(),
                            map.get(cityWard).get(12) + sumAge84, map.get(cityWard).get(13) + population80sDto.getPopAge84M(), map.get(cityWard).get(14) + population80sDto.getPopAge84W(),
                            map.get(cityWard).get(15) + sumAge85, map.get(cityWard).get(16) + population80sDto.getPopAge85M(), map.get(cityWard).get(17) + population80sDto.getPopAge85W(),
                            map.get(cityWard).get(18) + sumAge86, map.get(cityWard).get(19) + population80sDto.getPopAge86M(), map.get(cityWard).get(20) + population80sDto.getPopAge86W(),
                            map.get(cityWard).get(21) + sumAge87, map.get(cityWard).get(22) + population80sDto.getPopAge87M(), map.get(cityWard).get(23) + population80sDto.getPopAge87W(),
                            map.get(cityWard).get(24) + sumAge88, map.get(cityWard).get(25) + population80sDto.getPopAge88M(), map.get(cityWard).get(26) + population80sDto.getPopAge88W(),
                            map.get(cityWard).get(27) + sumAge89, map.get(cityWard).get(28) + population80sDto.getPopAge89M(), map.get(cityWard).get(29) + population80sDto.getPopAge89W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_jan_total_80s (pop_seq, pop_place, " +
                        "age_80_total, age_80_total_m, age_80_total_w, age_81_total, age_81_total_m, age_81_total_w, " +
                        "age_82_total, age_82_total_m, age_82_total_w, age_83_total, age_83_total_m, age_83_total_w, " +
                        "age_84_total, age_84_total_m, age_84_total_w, age_85_total, age_85_total_m, age_85_total_w, " +
                        "age_86_total, age_86_total_m, age_86_total_w, age_87_total, age_87_total_m, age_87_total_w, " +
                        "age_88_total, age_88_total_m, age_88_total_w, age_89_total, age_89_total_m, age_89_total_w) " +
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
