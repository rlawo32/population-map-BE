package com.pm.pmproject.jpa.repository.populationDec;

import com.pm.pmproject.dto.Population60sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PopulationDec60sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationDec60sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population60sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_dec_60s (admin_code, age_60_m, age_60_w, " +
                        "age_61_m, age_61_w, age_62_m, age_62_w, age_63_m, age_63_w, " +
                        "age_64_m, age_64_w, age_65_m, age_65_w, age_66_m, age_66_w, " +
                        "age_67_m, age_67_w, age_68_m, age_68_w, age_69_m, age_69_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal60s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal60s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge60M());
                        ps.setLong(3, list.get(i).getPopAge60W());
                        ps.setLong(4, list.get(i).getPopAge61M());
                        ps.setLong(5, list.get(i).getPopAge61W());
                        ps.setLong(6, list.get(i).getPopAge62M());
                        ps.setLong(7, list.get(i).getPopAge62W());
                        ps.setLong(8, list.get(i).getPopAge63M());
                        ps.setLong(9, list.get(i).getPopAge63W());
                        ps.setLong(10, list.get(i).getPopAge64M());
                        ps.setLong(11, list.get(i).getPopAge64W());
                        ps.setLong(12, list.get(i).getPopAge65M());
                        ps.setLong(13, list.get(i).getPopAge65W());
                        ps.setLong(14, list.get(i).getPopAge66M());
                        ps.setLong(15, list.get(i).getPopAge66W());
                        ps.setLong(16, list.get(i).getPopAge67M());
                        ps.setLong(17, list.get(i).getPopAge67W());
                        ps.setLong(18, list.get(i).getPopAge68M());
                        ps.setLong(19, list.get(i).getPopAge68W());
                        ps.setLong(20, list.get(i).getPopAge69M());
                        ps.setLong(21, list.get(i).getPopAge69W());
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

    public void populationTotalInsert(List<Population60sDto> list) {

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

        for (Population60sDto population60sDto : list) {
            String nameCity = population60sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population60sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population60sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population60sDto.getPopAge60M() + population60sDto.getPopAge61M() + population60sDto.getPopAge62M() + population60sDto.getPopAge63M() + population60sDto.getPopAge64M() +
                    population60sDto.getPopAge65M() + population60sDto.getPopAge66M() + population60sDto.getPopAge67M() + population60sDto.getPopAge68M() + population60sDto.getPopAge69M());
            total_w += (population60sDto.getPopAge60W() + population60sDto.getPopAge61W() + population60sDto.getPopAge62W() + population60sDto.getPopAge63W() + population60sDto.getPopAge64W() +
                    population60sDto.getPopAge65W() + population60sDto.getPopAge66W() + population60sDto.getPopAge67W() + population60sDto.getPopAge68W() + population60sDto.getPopAge69W());

            Long sumAge60 = population60sDto.getPopAge60M() + population60sDto.getPopAge60W();
            Long sumAge61 = population60sDto.getPopAge61M() + population60sDto.getPopAge61W();
            Long sumAge62 = population60sDto.getPopAge62M() + population60sDto.getPopAge62W();
            Long sumAge63 = population60sDto.getPopAge63M() + population60sDto.getPopAge63W();
            Long sumAge64 = population60sDto.getPopAge64M() + population60sDto.getPopAge64W();
            Long sumAge65 = population60sDto.getPopAge65M() + population60sDto.getPopAge65W();
            Long sumAge66 = population60sDto.getPopAge66M() + population60sDto.getPopAge66W();
            Long sumAge67 = population60sDto.getPopAge67M() + population60sDto.getPopAge67W();
            Long sumAge68 = population60sDto.getPopAge68M() + population60sDto.getPopAge68W();
            Long sumAge69 = population60sDto.getPopAge69M() + population60sDto.getPopAge69W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge60, population60sDto.getPopAge60M(), population60sDto.getPopAge60W(),
                        sumAge61, population60sDto.getPopAge61M(), population60sDto.getPopAge61W(),
                        sumAge62, population60sDto.getPopAge62M(), population60sDto.getPopAge62W(),
                        sumAge63, population60sDto.getPopAge63M(), population60sDto.getPopAge63W(),
                        sumAge64, population60sDto.getPopAge64M(), population60sDto.getPopAge64W(),
                        sumAge65, population60sDto.getPopAge65M(), population60sDto.getPopAge65W(),
                        sumAge66, population60sDto.getPopAge66M(), population60sDto.getPopAge66W(),
                        sumAge67, population60sDto.getPopAge67M(), population60sDto.getPopAge67W(),
                        sumAge68, population60sDto.getPopAge68M(), population60sDto.getPopAge68W(),
                        sumAge69, population60sDto.getPopAge69M(), population60sDto.getPopAge69W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge60, map.get(nameCity).get(1) + population60sDto.getPopAge60M(), map.get(nameCity).get(2) + population60sDto.getPopAge60W(),
                        map.get(nameCity).get(3) + sumAge61, map.get(nameCity).get(4) + population60sDto.getPopAge61M(), map.get(nameCity).get(5) + population60sDto.getPopAge61W(),
                        map.get(nameCity).get(6) + sumAge62, map.get(nameCity).get(7) + population60sDto.getPopAge62M(), map.get(nameCity).get(8) + population60sDto.getPopAge62W(),
                        map.get(nameCity).get(9) + sumAge63, map.get(nameCity).get(10) + population60sDto.getPopAge63M(), map.get(nameCity).get(11) + population60sDto.getPopAge63W(),
                        map.get(nameCity).get(12) + sumAge64, map.get(nameCity).get(13) + population60sDto.getPopAge64M(), map.get(nameCity).get(14) + population60sDto.getPopAge64W(),
                        map.get(nameCity).get(15) + sumAge65, map.get(nameCity).get(16) + population60sDto.getPopAge65M(), map.get(nameCity).get(17) + population60sDto.getPopAge65W(),
                        map.get(nameCity).get(18) + sumAge66, map.get(nameCity).get(19) + population60sDto.getPopAge66M(), map.get(nameCity).get(20) + population60sDto.getPopAge66W(),
                        map.get(nameCity).get(21) + sumAge67, map.get(nameCity).get(22) + population60sDto.getPopAge67M(), map.get(nameCity).get(23) + population60sDto.getPopAge67W(),
                        map.get(nameCity).get(24) + sumAge68, map.get(nameCity).get(25) + population60sDto.getPopAge68M(), map.get(nameCity).get(26) + population60sDto.getPopAge68W(),
                        map.get(nameCity).get(27) + sumAge69, map.get(nameCity).get(28) + population60sDto.getPopAge69M(), map.get(nameCity).get(29) + population60sDto.getPopAge69W()
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
                            sumAge60, population60sDto.getPopAge60M(), population60sDto.getPopAge60W(),
                            sumAge61, population60sDto.getPopAge61M(), population60sDto.getPopAge61W(),
                            sumAge62, population60sDto.getPopAge62M(), population60sDto.getPopAge62W(),
                            sumAge63, population60sDto.getPopAge63M(), population60sDto.getPopAge63W(),
                            sumAge64, population60sDto.getPopAge64M(), population60sDto.getPopAge64W(),
                            sumAge65, population60sDto.getPopAge65M(), population60sDto.getPopAge65W(),
                            sumAge66, population60sDto.getPopAge66M(), population60sDto.getPopAge66W(),
                            sumAge67, population60sDto.getPopAge67M(), population60sDto.getPopAge67W(),
                            sumAge68, population60sDto.getPopAge68M(), population60sDto.getPopAge68W(),
                            sumAge69, population60sDto.getPopAge69M(), population60sDto.getPopAge69W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge60, map.get(subCityWard1).get(1) + population60sDto.getPopAge60M(), map.get(subCityWard1).get(2) + population60sDto.getPopAge60W(),
                            map.get(subCityWard1).get(3) + sumAge61, map.get(subCityWard1).get(4) + population60sDto.getPopAge61M(), map.get(subCityWard1).get(5) + population60sDto.getPopAge61W(),
                            map.get(subCityWard1).get(6) + sumAge62, map.get(subCityWard1).get(7) + population60sDto.getPopAge62M(), map.get(subCityWard1).get(8) + population60sDto.getPopAge62W(),
                            map.get(subCityWard1).get(9) + sumAge63, map.get(subCityWard1).get(10) + population60sDto.getPopAge63M(), map.get(subCityWard1).get(11) + population60sDto.getPopAge63W(),
                            map.get(subCityWard1).get(12) + sumAge64, map.get(subCityWard1).get(13) + population60sDto.getPopAge64M(), map.get(subCityWard1).get(14) + population60sDto.getPopAge64W(),
                            map.get(subCityWard1).get(15) + sumAge65, map.get(subCityWard1).get(16) + population60sDto.getPopAge65M(), map.get(subCityWard1).get(17) + population60sDto.getPopAge65W(),
                            map.get(subCityWard1).get(18) + sumAge66, map.get(subCityWard1).get(19) + population60sDto.getPopAge66M(), map.get(subCityWard1).get(20) + population60sDto.getPopAge66W(),
                            map.get(subCityWard1).get(21) + sumAge67, map.get(subCityWard1).get(22) + population60sDto.getPopAge67M(), map.get(subCityWard1).get(23) + population60sDto.getPopAge67W(),
                            map.get(subCityWard1).get(24) + sumAge68, map.get(subCityWard1).get(25) + population60sDto.getPopAge68M(), map.get(subCityWard1).get(26) + population60sDto.getPopAge68W(),
                            map.get(subCityWard1).get(27) + sumAge69, map.get(subCityWard1).get(28) + population60sDto.getPopAge69M(), map.get(subCityWard1).get(29) + population60sDto.getPopAge69W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge60, population60sDto.getPopAge60M(), population60sDto.getPopAge60W(),
                            sumAge61, population60sDto.getPopAge61M(), population60sDto.getPopAge61W(),
                            sumAge62, population60sDto.getPopAge62M(), population60sDto.getPopAge62W(),
                            sumAge63, population60sDto.getPopAge63M(), population60sDto.getPopAge63W(),
                            sumAge64, population60sDto.getPopAge64M(), population60sDto.getPopAge64W(),
                            sumAge65, population60sDto.getPopAge65M(), population60sDto.getPopAge65W(),
                            sumAge66, population60sDto.getPopAge66M(), population60sDto.getPopAge66W(),
                            sumAge67, population60sDto.getPopAge67M(), population60sDto.getPopAge67W(),
                            sumAge68, population60sDto.getPopAge68M(), population60sDto.getPopAge68W(),
                            sumAge69, population60sDto.getPopAge69M(), population60sDto.getPopAge69W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge60, map.get(subCityWard2).get(1) + population60sDto.getPopAge60M(), map.get(subCityWard2).get(2) + population60sDto.getPopAge60W(),
                            map.get(subCityWard2).get(3) + sumAge61, map.get(subCityWard2).get(4) + population60sDto.getPopAge61M(), map.get(subCityWard2).get(5) + population60sDto.getPopAge61W(),
                            map.get(subCityWard2).get(6) + sumAge62, map.get(subCityWard2).get(7) + population60sDto.getPopAge62M(), map.get(subCityWard2).get(8) + population60sDto.getPopAge62W(),
                            map.get(subCityWard2).get(9) + sumAge63, map.get(subCityWard2).get(10) + population60sDto.getPopAge63M(), map.get(subCityWard2).get(11) + population60sDto.getPopAge63W(),
                            map.get(subCityWard2).get(12) + sumAge64, map.get(subCityWard2).get(13) + population60sDto.getPopAge64M(), map.get(subCityWard2).get(14) + population60sDto.getPopAge64W(),
                            map.get(subCityWard2).get(15) + sumAge65, map.get(subCityWard2).get(16) + population60sDto.getPopAge65M(), map.get(subCityWard2).get(17) + population60sDto.getPopAge65W(),
                            map.get(subCityWard2).get(18) + sumAge66, map.get(subCityWard2).get(19) + population60sDto.getPopAge66M(), map.get(subCityWard2).get(20) + population60sDto.getPopAge66W(),
                            map.get(subCityWard2).get(21) + sumAge67, map.get(subCityWard2).get(22) + population60sDto.getPopAge67M(), map.get(subCityWard2).get(23) + population60sDto.getPopAge67W(),
                            map.get(subCityWard2).get(24) + sumAge68, map.get(subCityWard2).get(25) + population60sDto.getPopAge68M(), map.get(subCityWard2).get(26) + population60sDto.getPopAge68W(),
                            map.get(subCityWard2).get(27) + sumAge69, map.get(subCityWard2).get(28) + population60sDto.getPopAge69M(), map.get(subCityWard2).get(29) + population60sDto.getPopAge69W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge60, population60sDto.getPopAge60M(), population60sDto.getPopAge60W(),
                            sumAge61, population60sDto.getPopAge61M(), population60sDto.getPopAge61W(),
                            sumAge62, population60sDto.getPopAge62M(), population60sDto.getPopAge62W(),
                            sumAge63, population60sDto.getPopAge63M(), population60sDto.getPopAge63W(),
                            sumAge64, population60sDto.getPopAge64M(), population60sDto.getPopAge64W(),
                            sumAge65, population60sDto.getPopAge65M(), population60sDto.getPopAge65W(),
                            sumAge66, population60sDto.getPopAge66M(), population60sDto.getPopAge66W(),
                            sumAge67, population60sDto.getPopAge67M(), population60sDto.getPopAge67W(),
                            sumAge68, population60sDto.getPopAge68M(), population60sDto.getPopAge68W(),
                            sumAge69, population60sDto.getPopAge69M(), population60sDto.getPopAge69W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge60, map.get(cityWard).get(1) + population60sDto.getPopAge60M(), map.get(cityWard).get(2) + population60sDto.getPopAge60W(),
                            map.get(cityWard).get(3) + sumAge61, map.get(cityWard).get(4) + population60sDto.getPopAge61M(), map.get(cityWard).get(5) + population60sDto.getPopAge61W(),
                            map.get(cityWard).get(6) + sumAge62, map.get(cityWard).get(7) + population60sDto.getPopAge62M(), map.get(cityWard).get(8) + population60sDto.getPopAge62W(),
                            map.get(cityWard).get(9) + sumAge63, map.get(cityWard).get(10) + population60sDto.getPopAge63M(), map.get(cityWard).get(11) + population60sDto.getPopAge63W(),
                            map.get(cityWard).get(12) + sumAge64, map.get(cityWard).get(13) + population60sDto.getPopAge64M(), map.get(cityWard).get(14) + population60sDto.getPopAge64W(),
                            map.get(cityWard).get(15) + sumAge65, map.get(cityWard).get(16) + population60sDto.getPopAge65M(), map.get(cityWard).get(17) + population60sDto.getPopAge65W(),
                            map.get(cityWard).get(18) + sumAge66, map.get(cityWard).get(19) + population60sDto.getPopAge66M(), map.get(cityWard).get(20) + population60sDto.getPopAge66W(),
                            map.get(cityWard).get(21) + sumAge67, map.get(cityWard).get(22) + population60sDto.getPopAge67M(), map.get(cityWard).get(23) + population60sDto.getPopAge67W(),
                            map.get(cityWard).get(24) + sumAge68, map.get(cityWard).get(25) + population60sDto.getPopAge68M(), map.get(cityWard).get(26) + population60sDto.getPopAge68W(),
                            map.get(cityWard).get(27) + sumAge69, map.get(cityWard).get(28) + population60sDto.getPopAge69M(), map.get(cityWard).get(29) + population60sDto.getPopAge69W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_dec_total_60s (pop_seq, pop_place, " +
                        "age_60_total, age_60_total_m, age_60_total_w, age_61_total, age_61_total_m, age_61_total_w, " +
                        "age_62_total, age_62_total_m, age_62_total_w, age_63_total, age_63_total_m, age_63_total_w, " +
                        "age_64_total, age_64_total_m, age_64_total_w, age_65_total, age_65_total_m, age_65_total_w, " +
                        "age_66_total, age_66_total_m, age_66_total_w, age_67_total, age_67_total_m, age_67_total_w, " +
                        "age_68_total, age_68_total_m, age_68_total_w, age_69_total, age_69_total_m, age_69_total_w) " +
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
