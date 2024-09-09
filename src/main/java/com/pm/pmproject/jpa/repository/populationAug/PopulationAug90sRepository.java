package com.pm.pmproject.jpa.repository.populationAug;

import com.pm.pmproject.dto.Population90sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PopulationAug90sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationAug90sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population90sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_aug_90s (admin_code, age_90_m, age_90_w, " +
                        "age_91_m, age_91_w, age_92_m, age_92_w, age_93_m, age_93_w, " +
                        "age_94_m, age_94_w, age_95_m, age_95_w, age_96_m, age_96_w, " +
                        "age_97_m, age_97_w, age_98_m, age_98_w, age_99_m, age_99_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal90s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal90s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge90M());
                        ps.setLong(3, list.get(i).getPopAge90W());
                        ps.setLong(4, list.get(i).getPopAge91M());
                        ps.setLong(5, list.get(i).getPopAge91W());
                        ps.setLong(6, list.get(i).getPopAge92M());
                        ps.setLong(7, list.get(i).getPopAge92W());
                        ps.setLong(8, list.get(i).getPopAge93M());
                        ps.setLong(9, list.get(i).getPopAge93W());
                        ps.setLong(10, list.get(i).getPopAge94M());
                        ps.setLong(11, list.get(i).getPopAge94W());
                        ps.setLong(12, list.get(i).getPopAge95M());
                        ps.setLong(13, list.get(i).getPopAge95W());
                        ps.setLong(14, list.get(i).getPopAge96M());
                        ps.setLong(15, list.get(i).getPopAge96W());
                        ps.setLong(16, list.get(i).getPopAge97M());
                        ps.setLong(17, list.get(i).getPopAge97W());
                        ps.setLong(18, list.get(i).getPopAge98M());
                        ps.setLong(19, list.get(i).getPopAge98W());
                        ps.setLong(20, list.get(i).getPopAge99M());
                        ps.setLong(21, list.get(i).getPopAge99W());
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

    public void populationTotalInsert(List<Population90sDto> list) {

        // List<PopulationResultDto> list = jdbcTemplate.query("select pop_m_total, pop_w_total, pop_total, name_ward, name_city " +
        //                 "from population_aug", new RowMapper<PopulationResultDto>() {
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

        for (Population90sDto population90sDto : list) {
            String nameCity = population90sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population90sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population90sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population90sDto.getPopAge90M() + population90sDto.getPopAge91M() + population90sDto.getPopAge92M() + population90sDto.getPopAge93M() + population90sDto.getPopAge94M() +
                    population90sDto.getPopAge95M() + population90sDto.getPopAge96M() + population90sDto.getPopAge97M() + population90sDto.getPopAge98M() + population90sDto.getPopAge99M());
            total_w += (population90sDto.getPopAge90W() + population90sDto.getPopAge91W() + population90sDto.getPopAge92W() + population90sDto.getPopAge93W() + population90sDto.getPopAge94W() +
                    population90sDto.getPopAge95W() + population90sDto.getPopAge96W() + population90sDto.getPopAge97W() + population90sDto.getPopAge98W() + population90sDto.getPopAge99W());

            Long sumAge90 = population90sDto.getPopAge90M() + population90sDto.getPopAge90W();
            Long sumAge91 = population90sDto.getPopAge91M() + population90sDto.getPopAge91W();
            Long sumAge92 = population90sDto.getPopAge92M() + population90sDto.getPopAge92W();
            Long sumAge93 = population90sDto.getPopAge93M() + population90sDto.getPopAge93W();
            Long sumAge94 = population90sDto.getPopAge94M() + population90sDto.getPopAge94W();
            Long sumAge95 = population90sDto.getPopAge95M() + population90sDto.getPopAge95W();
            Long sumAge96 = population90sDto.getPopAge96M() + population90sDto.getPopAge96W();
            Long sumAge97 = population90sDto.getPopAge97M() + population90sDto.getPopAge97W();
            Long sumAge98 = population90sDto.getPopAge98M() + population90sDto.getPopAge98W();
            Long sumAge99 = population90sDto.getPopAge99M() + population90sDto.getPopAge99W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge90, population90sDto.getPopAge90M(), population90sDto.getPopAge90W(),
                        sumAge91, population90sDto.getPopAge91M(), population90sDto.getPopAge91W(),
                        sumAge92, population90sDto.getPopAge92M(), population90sDto.getPopAge92W(),
                        sumAge93, population90sDto.getPopAge93M(), population90sDto.getPopAge93W(),
                        sumAge94, population90sDto.getPopAge94M(), population90sDto.getPopAge94W(),
                        sumAge95, population90sDto.getPopAge95M(), population90sDto.getPopAge95W(),
                        sumAge96, population90sDto.getPopAge96M(), population90sDto.getPopAge96W(),
                        sumAge97, population90sDto.getPopAge97M(), population90sDto.getPopAge97W(),
                        sumAge98, population90sDto.getPopAge98M(), population90sDto.getPopAge98W(),
                        sumAge99, population90sDto.getPopAge99M(), population90sDto.getPopAge99W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge90, map.get(nameCity).get(1) + population90sDto.getPopAge90M(), map.get(nameCity).get(2) + population90sDto.getPopAge90W(),
                        map.get(nameCity).get(3) + sumAge91, map.get(nameCity).get(4) + population90sDto.getPopAge91M(), map.get(nameCity).get(5) + population90sDto.getPopAge91W(),
                        map.get(nameCity).get(6) + sumAge92, map.get(nameCity).get(7) + population90sDto.getPopAge92M(), map.get(nameCity).get(8) + population90sDto.getPopAge92W(),
                        map.get(nameCity).get(9) + sumAge93, map.get(nameCity).get(10) + population90sDto.getPopAge93M(), map.get(nameCity).get(11) + population90sDto.getPopAge93W(),
                        map.get(nameCity).get(12) + sumAge94, map.get(nameCity).get(13) + population90sDto.getPopAge94M(), map.get(nameCity).get(14) + population90sDto.getPopAge94W(),
                        map.get(nameCity).get(15) + sumAge95, map.get(nameCity).get(16) + population90sDto.getPopAge95M(), map.get(nameCity).get(17) + population90sDto.getPopAge95W(),
                        map.get(nameCity).get(18) + sumAge96, map.get(nameCity).get(19) + population90sDto.getPopAge96M(), map.get(nameCity).get(20) + population90sDto.getPopAge96W(),
                        map.get(nameCity).get(21) + sumAge97, map.get(nameCity).get(22) + population90sDto.getPopAge97M(), map.get(nameCity).get(23) + population90sDto.getPopAge97W(),
                        map.get(nameCity).get(24) + sumAge98, map.get(nameCity).get(25) + population90sDto.getPopAge98M(), map.get(nameCity).get(26) + population90sDto.getPopAge98W(),
                        map.get(nameCity).get(27) + sumAge99, map.get(nameCity).get(28) + population90sDto.getPopAge99M(), map.get(nameCity).get(29) + population90sDto.getPopAge99W()
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
                            sumAge90, population90sDto.getPopAge90M(), population90sDto.getPopAge90W(),
                            sumAge91, population90sDto.getPopAge91M(), population90sDto.getPopAge91W(),
                            sumAge92, population90sDto.getPopAge92M(), population90sDto.getPopAge92W(),
                            sumAge93, population90sDto.getPopAge93M(), population90sDto.getPopAge93W(),
                            sumAge94, population90sDto.getPopAge94M(), population90sDto.getPopAge94W(),
                            sumAge95, population90sDto.getPopAge95M(), population90sDto.getPopAge95W(),
                            sumAge96, population90sDto.getPopAge96M(), population90sDto.getPopAge96W(),
                            sumAge97, population90sDto.getPopAge97M(), population90sDto.getPopAge97W(),
                            sumAge98, population90sDto.getPopAge98M(), population90sDto.getPopAge98W(),
                            sumAge99, population90sDto.getPopAge99M(), population90sDto.getPopAge99W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge90, map.get(subCityWard1).get(1) + population90sDto.getPopAge90M(), map.get(subCityWard1).get(2) + population90sDto.getPopAge90W(),
                            map.get(subCityWard1).get(3) + sumAge91, map.get(subCityWard1).get(4) + population90sDto.getPopAge91M(), map.get(subCityWard1).get(5) + population90sDto.getPopAge91W(),
                            map.get(subCityWard1).get(6) + sumAge92, map.get(subCityWard1).get(7) + population90sDto.getPopAge92M(), map.get(subCityWard1).get(8) + population90sDto.getPopAge92W(),
                            map.get(subCityWard1).get(9) + sumAge93, map.get(subCityWard1).get(10) + population90sDto.getPopAge93M(), map.get(subCityWard1).get(11) + population90sDto.getPopAge93W(),
                            map.get(subCityWard1).get(12) + sumAge94, map.get(subCityWard1).get(13) + population90sDto.getPopAge94M(), map.get(subCityWard1).get(14) + population90sDto.getPopAge94W(),
                            map.get(subCityWard1).get(15) + sumAge95, map.get(subCityWard1).get(16) + population90sDto.getPopAge95M(), map.get(subCityWard1).get(17) + population90sDto.getPopAge95W(),
                            map.get(subCityWard1).get(18) + sumAge96, map.get(subCityWard1).get(19) + population90sDto.getPopAge96M(), map.get(subCityWard1).get(20) + population90sDto.getPopAge96W(),
                            map.get(subCityWard1).get(21) + sumAge97, map.get(subCityWard1).get(22) + population90sDto.getPopAge97M(), map.get(subCityWard1).get(23) + population90sDto.getPopAge97W(),
                            map.get(subCityWard1).get(24) + sumAge98, map.get(subCityWard1).get(25) + population90sDto.getPopAge98M(), map.get(subCityWard1).get(26) + population90sDto.getPopAge98W(),
                            map.get(subCityWard1).get(27) + sumAge99, map.get(subCityWard1).get(28) + population90sDto.getPopAge99M(), map.get(subCityWard1).get(29) + population90sDto.getPopAge99W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge90, population90sDto.getPopAge90M(), population90sDto.getPopAge90W(),
                            sumAge91, population90sDto.getPopAge91M(), population90sDto.getPopAge91W(),
                            sumAge92, population90sDto.getPopAge92M(), population90sDto.getPopAge92W(),
                            sumAge93, population90sDto.getPopAge93M(), population90sDto.getPopAge93W(),
                            sumAge94, population90sDto.getPopAge94M(), population90sDto.getPopAge94W(),
                            sumAge95, population90sDto.getPopAge95M(), population90sDto.getPopAge95W(),
                            sumAge96, population90sDto.getPopAge96M(), population90sDto.getPopAge96W(),
                            sumAge97, population90sDto.getPopAge97M(), population90sDto.getPopAge97W(),
                            sumAge98, population90sDto.getPopAge98M(), population90sDto.getPopAge98W(),
                            sumAge99, population90sDto.getPopAge99M(), population90sDto.getPopAge99W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge90, map.get(subCityWard2).get(1) + population90sDto.getPopAge90M(), map.get(subCityWard2).get(2) + population90sDto.getPopAge90W(),
                            map.get(subCityWard2).get(3) + sumAge91, map.get(subCityWard2).get(4) + population90sDto.getPopAge91M(), map.get(subCityWard2).get(5) + population90sDto.getPopAge91W(),
                            map.get(subCityWard2).get(6) + sumAge92, map.get(subCityWard2).get(7) + population90sDto.getPopAge92M(), map.get(subCityWard2).get(8) + population90sDto.getPopAge92W(),
                            map.get(subCityWard2).get(9) + sumAge93, map.get(subCityWard2).get(10) + population90sDto.getPopAge93M(), map.get(subCityWard2).get(11) + population90sDto.getPopAge93W(),
                            map.get(subCityWard2).get(12) + sumAge94, map.get(subCityWard2).get(13) + population90sDto.getPopAge94M(), map.get(subCityWard2).get(14) + population90sDto.getPopAge94W(),
                            map.get(subCityWard2).get(15) + sumAge95, map.get(subCityWard2).get(16) + population90sDto.getPopAge95M(), map.get(subCityWard2).get(17) + population90sDto.getPopAge95W(),
                            map.get(subCityWard2).get(18) + sumAge96, map.get(subCityWard2).get(19) + population90sDto.getPopAge96M(), map.get(subCityWard2).get(20) + population90sDto.getPopAge96W(),
                            map.get(subCityWard2).get(21) + sumAge97, map.get(subCityWard2).get(22) + population90sDto.getPopAge97M(), map.get(subCityWard2).get(23) + population90sDto.getPopAge97W(),
                            map.get(subCityWard2).get(24) + sumAge98, map.get(subCityWard2).get(25) + population90sDto.getPopAge98M(), map.get(subCityWard2).get(26) + population90sDto.getPopAge98W(),
                            map.get(subCityWard2).get(27) + sumAge99, map.get(subCityWard2).get(28) + population90sDto.getPopAge99M(), map.get(subCityWard2).get(29) + population90sDto.getPopAge99W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge90, population90sDto.getPopAge90M(), population90sDto.getPopAge90W(),
                            sumAge91, population90sDto.getPopAge91M(), population90sDto.getPopAge91W(),
                            sumAge92, population90sDto.getPopAge92M(), population90sDto.getPopAge92W(),
                            sumAge93, population90sDto.getPopAge93M(), population90sDto.getPopAge93W(),
                            sumAge94, population90sDto.getPopAge94M(), population90sDto.getPopAge94W(),
                            sumAge95, population90sDto.getPopAge95M(), population90sDto.getPopAge95W(),
                            sumAge96, population90sDto.getPopAge96M(), population90sDto.getPopAge96W(),
                            sumAge97, population90sDto.getPopAge97M(), population90sDto.getPopAge97W(),
                            sumAge98, population90sDto.getPopAge98M(), population90sDto.getPopAge98W(),
                            sumAge99, population90sDto.getPopAge99M(), population90sDto.getPopAge99W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge90, map.get(cityWard).get(1) + population90sDto.getPopAge90M(), map.get(cityWard).get(2) + population90sDto.getPopAge90W(),
                            map.get(cityWard).get(3) + sumAge91, map.get(cityWard).get(4) + population90sDto.getPopAge91M(), map.get(cityWard).get(5) + population90sDto.getPopAge91W(),
                            map.get(cityWard).get(6) + sumAge92, map.get(cityWard).get(7) + population90sDto.getPopAge92M(), map.get(cityWard).get(8) + population90sDto.getPopAge92W(),
                            map.get(cityWard).get(9) + sumAge93, map.get(cityWard).get(10) + population90sDto.getPopAge93M(), map.get(cityWard).get(11) + population90sDto.getPopAge93W(),
                            map.get(cityWard).get(12) + sumAge94, map.get(cityWard).get(13) + population90sDto.getPopAge94M(), map.get(cityWard).get(14) + population90sDto.getPopAge94W(),
                            map.get(cityWard).get(15) + sumAge95, map.get(cityWard).get(16) + population90sDto.getPopAge95M(), map.get(cityWard).get(17) + population90sDto.getPopAge95W(),
                            map.get(cityWard).get(18) + sumAge96, map.get(cityWard).get(19) + population90sDto.getPopAge96M(), map.get(cityWard).get(20) + population90sDto.getPopAge96W(),
                            map.get(cityWard).get(21) + sumAge97, map.get(cityWard).get(22) + population90sDto.getPopAge97M(), map.get(cityWard).get(23) + population90sDto.getPopAge97W(),
                            map.get(cityWard).get(24) + sumAge98, map.get(cityWard).get(25) + population90sDto.getPopAge98M(), map.get(cityWard).get(26) + population90sDto.getPopAge98W(),
                            map.get(cityWard).get(27) + sumAge99, map.get(cityWard).get(28) + population90sDto.getPopAge99M(), map.get(cityWard).get(29) + population90sDto.getPopAge99W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_aug_total_90s (pop_seq, pop_place, " +
                        "age_90_total, age_90_total_m, age_90_total_w, age_91_total, age_91_total_m, age_91_total_w, " +
                        "age_92_total, age_92_total_m, age_92_total_w, age_93_total, age_93_total_m, age_93_total_w, " +
                        "age_94_total, age_94_total_m, age_94_total_w, age_95_total, age_95_total_m, age_95_total_w, " +
                        "age_96_total, age_96_total_m, age_96_total_w, age_97_total, age_97_total_m, age_97_total_w, " +
                        "age_98_total, age_98_total_m, age_98_total_w, age_99_total, age_99_total_m, age_99_total_w) " +
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
