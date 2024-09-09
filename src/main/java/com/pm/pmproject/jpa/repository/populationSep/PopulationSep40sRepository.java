package com.pm.pmproject.jpa.repository.populationSep;

import com.pm.pmproject.dto.Population40sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PopulationSep40sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationSep40sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population40sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_sep_40s (admin_code, age_40_m, age_40_w, " +
                        "age_41_m, age_41_w, age_42_m, age_42_w, age_43_m, age_43_w, " +
                        "age_44_m, age_44_w, age_45_m, age_45_w, age_46_m, age_46_w, " +
                        "age_47_m, age_47_w, age_48_m, age_48_w, age_49_m, age_49_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal40s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal40s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge40M());
                        ps.setLong(3, list.get(i).getPopAge40W());
                        ps.setLong(4, list.get(i).getPopAge41M());
                        ps.setLong(5, list.get(i).getPopAge41W());
                        ps.setLong(6, list.get(i).getPopAge42M());
                        ps.setLong(7, list.get(i).getPopAge42W());
                        ps.setLong(8, list.get(i).getPopAge43M());
                        ps.setLong(9, list.get(i).getPopAge43W());
                        ps.setLong(10, list.get(i).getPopAge44M());
                        ps.setLong(11, list.get(i).getPopAge44W());
                        ps.setLong(12, list.get(i).getPopAge45M());
                        ps.setLong(13, list.get(i).getPopAge45W());
                        ps.setLong(14, list.get(i).getPopAge46M());
                        ps.setLong(15, list.get(i).getPopAge46W());
                        ps.setLong(16, list.get(i).getPopAge47M());
                        ps.setLong(17, list.get(i).getPopAge47W());
                        ps.setLong(18, list.get(i).getPopAge48M());
                        ps.setLong(19, list.get(i).getPopAge48W());
                        ps.setLong(20, list.get(i).getPopAge49M());
                        ps.setLong(21, list.get(i).getPopAge49W());
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

    public void populationTotalInsert(List<Population40sDto> list) {

        // List<PopulationResultDto> list = jdbcTemplate.query("select pop_m_total, pop_w_total, pop_total, name_ward, name_city " +
        //                 "from population_sep", new RowMapper<PopulationResultDto>() {
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

        for (Population40sDto population40sDto : list) {
            String nameCity = population40sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population40sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population40sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population40sDto.getPopAge40M() + population40sDto.getPopAge41M() + population40sDto.getPopAge42M() + population40sDto.getPopAge43M() + population40sDto.getPopAge44M() +
                    population40sDto.getPopAge45M() + population40sDto.getPopAge46M() + population40sDto.getPopAge47M() + population40sDto.getPopAge48M() + population40sDto.getPopAge49M());
            total_w += (population40sDto.getPopAge40W() + population40sDto.getPopAge41W() + population40sDto.getPopAge42W() + population40sDto.getPopAge43W() + population40sDto.getPopAge44W() +
                    population40sDto.getPopAge45W() + population40sDto.getPopAge46W() + population40sDto.getPopAge47W() + population40sDto.getPopAge48W() + population40sDto.getPopAge49W());

            Long sumAge40 = population40sDto.getPopAge40M() + population40sDto.getPopAge40W();
            Long sumAge41 = population40sDto.getPopAge41M() + population40sDto.getPopAge41W();
            Long sumAge42 = population40sDto.getPopAge42M() + population40sDto.getPopAge42W();
            Long sumAge43 = population40sDto.getPopAge43M() + population40sDto.getPopAge43W();
            Long sumAge44 = population40sDto.getPopAge44M() + population40sDto.getPopAge44W();
            Long sumAge45 = population40sDto.getPopAge45M() + population40sDto.getPopAge45W();
            Long sumAge46 = population40sDto.getPopAge46M() + population40sDto.getPopAge46W();
            Long sumAge47 = population40sDto.getPopAge47M() + population40sDto.getPopAge47W();
            Long sumAge48 = population40sDto.getPopAge48M() + population40sDto.getPopAge48W();
            Long sumAge49 = population40sDto.getPopAge49M() + population40sDto.getPopAge49W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge40, population40sDto.getPopAge40M(), population40sDto.getPopAge40W(),
                        sumAge41, population40sDto.getPopAge41M(), population40sDto.getPopAge41W(),
                        sumAge42, population40sDto.getPopAge42M(), population40sDto.getPopAge42W(),
                        sumAge43, population40sDto.getPopAge43M(), population40sDto.getPopAge43W(),
                        sumAge44, population40sDto.getPopAge44M(), population40sDto.getPopAge44W(),
                        sumAge45, population40sDto.getPopAge45M(), population40sDto.getPopAge45W(),
                        sumAge46, population40sDto.getPopAge46M(), population40sDto.getPopAge46W(),
                        sumAge47, population40sDto.getPopAge47M(), population40sDto.getPopAge47W(),
                        sumAge48, population40sDto.getPopAge48M(), population40sDto.getPopAge48W(),
                        sumAge49, population40sDto.getPopAge49M(), population40sDto.getPopAge49W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge40, map.get(nameCity).get(1) + population40sDto.getPopAge40M(), map.get(nameCity).get(2) + population40sDto.getPopAge40W(),
                        map.get(nameCity).get(3) + sumAge41, map.get(nameCity).get(4) + population40sDto.getPopAge41M(), map.get(nameCity).get(5) + population40sDto.getPopAge41W(),
                        map.get(nameCity).get(6) + sumAge42, map.get(nameCity).get(7) + population40sDto.getPopAge42M(), map.get(nameCity).get(8) + population40sDto.getPopAge42W(),
                        map.get(nameCity).get(9) + sumAge43, map.get(nameCity).get(10) + population40sDto.getPopAge43M(), map.get(nameCity).get(11) + population40sDto.getPopAge43W(),
                        map.get(nameCity).get(12) + sumAge44, map.get(nameCity).get(13) + population40sDto.getPopAge44M(), map.get(nameCity).get(14) + population40sDto.getPopAge44W(),
                        map.get(nameCity).get(15) + sumAge45, map.get(nameCity).get(16) + population40sDto.getPopAge45M(), map.get(nameCity).get(17) + population40sDto.getPopAge45W(),
                        map.get(nameCity).get(18) + sumAge46, map.get(nameCity).get(19) + population40sDto.getPopAge46M(), map.get(nameCity).get(20) + population40sDto.getPopAge46W(),
                        map.get(nameCity).get(21) + sumAge47, map.get(nameCity).get(22) + population40sDto.getPopAge47M(), map.get(nameCity).get(23) + population40sDto.getPopAge47W(),
                        map.get(nameCity).get(24) + sumAge48, map.get(nameCity).get(25) + population40sDto.getPopAge48M(), map.get(nameCity).get(26) + population40sDto.getPopAge48W(),
                        map.get(nameCity).get(27) + sumAge49, map.get(nameCity).get(28) + population40sDto.getPopAge49M(), map.get(nameCity).get(29) + population40sDto.getPopAge49W()
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
                            sumAge40, population40sDto.getPopAge40M(), population40sDto.getPopAge40W(),
                            sumAge41, population40sDto.getPopAge41M(), population40sDto.getPopAge41W(),
                            sumAge42, population40sDto.getPopAge42M(), population40sDto.getPopAge42W(),
                            sumAge43, population40sDto.getPopAge43M(), population40sDto.getPopAge43W(),
                            sumAge44, population40sDto.getPopAge44M(), population40sDto.getPopAge44W(),
                            sumAge45, population40sDto.getPopAge45M(), population40sDto.getPopAge45W(),
                            sumAge46, population40sDto.getPopAge46M(), population40sDto.getPopAge46W(),
                            sumAge47, population40sDto.getPopAge47M(), population40sDto.getPopAge47W(),
                            sumAge48, population40sDto.getPopAge48M(), population40sDto.getPopAge48W(),
                            sumAge49, population40sDto.getPopAge49M(), population40sDto.getPopAge49W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge40, map.get(subCityWard1).get(1) + population40sDto.getPopAge40M(), map.get(subCityWard1).get(2) + population40sDto.getPopAge40W(),
                            map.get(subCityWard1).get(3) + sumAge41, map.get(subCityWard1).get(4) + population40sDto.getPopAge41M(), map.get(subCityWard1).get(5) + population40sDto.getPopAge41W(),
                            map.get(subCityWard1).get(6) + sumAge42, map.get(subCityWard1).get(7) + population40sDto.getPopAge42M(), map.get(subCityWard1).get(8) + population40sDto.getPopAge42W(),
                            map.get(subCityWard1).get(9) + sumAge43, map.get(subCityWard1).get(10) + population40sDto.getPopAge43M(), map.get(subCityWard1).get(11) + population40sDto.getPopAge43W(),
                            map.get(subCityWard1).get(12) + sumAge44, map.get(subCityWard1).get(13) + population40sDto.getPopAge44M(), map.get(subCityWard1).get(14) + population40sDto.getPopAge44W(),
                            map.get(subCityWard1).get(15) + sumAge45, map.get(subCityWard1).get(16) + population40sDto.getPopAge45M(), map.get(subCityWard1).get(17) + population40sDto.getPopAge45W(),
                            map.get(subCityWard1).get(18) + sumAge46, map.get(subCityWard1).get(19) + population40sDto.getPopAge46M(), map.get(subCityWard1).get(20) + population40sDto.getPopAge46W(),
                            map.get(subCityWard1).get(21) + sumAge47, map.get(subCityWard1).get(22) + population40sDto.getPopAge47M(), map.get(subCityWard1).get(23) + population40sDto.getPopAge47W(),
                            map.get(subCityWard1).get(24) + sumAge48, map.get(subCityWard1).get(25) + population40sDto.getPopAge48M(), map.get(subCityWard1).get(26) + population40sDto.getPopAge48W(),
                            map.get(subCityWard1).get(27) + sumAge49, map.get(subCityWard1).get(28) + population40sDto.getPopAge49M(), map.get(subCityWard1).get(29) + population40sDto.getPopAge49W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge40, population40sDto.getPopAge40M(), population40sDto.getPopAge40W(),
                            sumAge41, population40sDto.getPopAge41M(), population40sDto.getPopAge41W(),
                            sumAge42, population40sDto.getPopAge42M(), population40sDto.getPopAge42W(),
                            sumAge43, population40sDto.getPopAge43M(), population40sDto.getPopAge43W(),
                            sumAge44, population40sDto.getPopAge44M(), population40sDto.getPopAge44W(),
                            sumAge45, population40sDto.getPopAge45M(), population40sDto.getPopAge45W(),
                            sumAge46, population40sDto.getPopAge46M(), population40sDto.getPopAge46W(),
                            sumAge47, population40sDto.getPopAge47M(), population40sDto.getPopAge47W(),
                            sumAge48, population40sDto.getPopAge48M(), population40sDto.getPopAge48W(),
                            sumAge49, population40sDto.getPopAge49M(), population40sDto.getPopAge49W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge40, map.get(subCityWard2).get(1) + population40sDto.getPopAge40M(), map.get(subCityWard2).get(2) + population40sDto.getPopAge40W(),
                            map.get(subCityWard2).get(3) + sumAge41, map.get(subCityWard2).get(4) + population40sDto.getPopAge41M(), map.get(subCityWard2).get(5) + population40sDto.getPopAge41W(),
                            map.get(subCityWard2).get(6) + sumAge42, map.get(subCityWard2).get(7) + population40sDto.getPopAge42M(), map.get(subCityWard2).get(8) + population40sDto.getPopAge42W(),
                            map.get(subCityWard2).get(9) + sumAge43, map.get(subCityWard2).get(10) + population40sDto.getPopAge43M(), map.get(subCityWard2).get(11) + population40sDto.getPopAge43W(),
                            map.get(subCityWard2).get(12) + sumAge44, map.get(subCityWard2).get(13) + population40sDto.getPopAge44M(), map.get(subCityWard2).get(14) + population40sDto.getPopAge44W(),
                            map.get(subCityWard2).get(15) + sumAge45, map.get(subCityWard2).get(16) + population40sDto.getPopAge45M(), map.get(subCityWard2).get(17) + population40sDto.getPopAge45W(),
                            map.get(subCityWard2).get(18) + sumAge46, map.get(subCityWard2).get(19) + population40sDto.getPopAge46M(), map.get(subCityWard2).get(20) + population40sDto.getPopAge46W(),
                            map.get(subCityWard2).get(21) + sumAge47, map.get(subCityWard2).get(22) + population40sDto.getPopAge47M(), map.get(subCityWard2).get(23) + population40sDto.getPopAge47W(),
                            map.get(subCityWard2).get(24) + sumAge48, map.get(subCityWard2).get(25) + population40sDto.getPopAge48M(), map.get(subCityWard2).get(26) + population40sDto.getPopAge48W(),
                            map.get(subCityWard2).get(27) + sumAge49, map.get(subCityWard2).get(28) + population40sDto.getPopAge49M(), map.get(subCityWard2).get(29) + population40sDto.getPopAge49W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge40, population40sDto.getPopAge40M(), population40sDto.getPopAge40W(),
                            sumAge41, population40sDto.getPopAge41M(), population40sDto.getPopAge41W(),
                            sumAge42, population40sDto.getPopAge42M(), population40sDto.getPopAge42W(),
                            sumAge43, population40sDto.getPopAge43M(), population40sDto.getPopAge43W(),
                            sumAge44, population40sDto.getPopAge44M(), population40sDto.getPopAge44W(),
                            sumAge45, population40sDto.getPopAge45M(), population40sDto.getPopAge45W(),
                            sumAge46, population40sDto.getPopAge46M(), population40sDto.getPopAge46W(),
                            sumAge47, population40sDto.getPopAge47M(), population40sDto.getPopAge47W(),
                            sumAge48, population40sDto.getPopAge48M(), population40sDto.getPopAge48W(),
                            sumAge49, population40sDto.getPopAge49M(), population40sDto.getPopAge49W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge40, map.get(cityWard).get(1) + population40sDto.getPopAge40M(), map.get(cityWard).get(2) + population40sDto.getPopAge40W(),
                            map.get(cityWard).get(3) + sumAge41, map.get(cityWard).get(4) + population40sDto.getPopAge41M(), map.get(cityWard).get(5) + population40sDto.getPopAge41W(),
                            map.get(cityWard).get(6) + sumAge42, map.get(cityWard).get(7) + population40sDto.getPopAge42M(), map.get(cityWard).get(8) + population40sDto.getPopAge42W(),
                            map.get(cityWard).get(9) + sumAge43, map.get(cityWard).get(10) + population40sDto.getPopAge43M(), map.get(cityWard).get(11) + population40sDto.getPopAge43W(),
                            map.get(cityWard).get(12) + sumAge44, map.get(cityWard).get(13) + population40sDto.getPopAge44M(), map.get(cityWard).get(14) + population40sDto.getPopAge44W(),
                            map.get(cityWard).get(15) + sumAge45, map.get(cityWard).get(16) + population40sDto.getPopAge45M(), map.get(cityWard).get(17) + population40sDto.getPopAge45W(),
                            map.get(cityWard).get(18) + sumAge46, map.get(cityWard).get(19) + population40sDto.getPopAge46M(), map.get(cityWard).get(20) + population40sDto.getPopAge46W(),
                            map.get(cityWard).get(21) + sumAge47, map.get(cityWard).get(22) + population40sDto.getPopAge47M(), map.get(cityWard).get(23) + population40sDto.getPopAge47W(),
                            map.get(cityWard).get(24) + sumAge48, map.get(cityWard).get(25) + population40sDto.getPopAge48M(), map.get(cityWard).get(26) + population40sDto.getPopAge48W(),
                            map.get(cityWard).get(27) + sumAge49, map.get(cityWard).get(28) + population40sDto.getPopAge49M(), map.get(cityWard).get(29) + population40sDto.getPopAge49W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_sep_total_40s (pop_seq, pop_place, " +
                        "age_40_total, age_40_total_m, age_40_total_w, age_41_total, age_41_total_m, age_41_total_w, " +
                        "age_42_total, age_42_total_m, age_42_total_w, age_43_total, age_43_total_m, age_43_total_w, " +
                        "age_44_total, age_44_total_m, age_44_total_w, age_45_total, age_45_total_m, age_45_total_w, " +
                        "age_46_total, age_46_total_m, age_46_total_w, age_47_total, age_47_total_m, age_47_total_w, " +
                        "age_48_total, age_48_total_m, age_48_total_w, age_49_total, age_49_total_m, age_49_total_w) " +
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
