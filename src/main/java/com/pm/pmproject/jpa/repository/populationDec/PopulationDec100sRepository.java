package com.pm.pmproject.jpa.repository.populationDec;

import com.pm.pmproject.dto.Population100sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class PopulationDec100sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationDec100sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population100sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_dec_100s (admin_code, age_100_m, age_100_w, " +
                        "age_101_m, age_101_w, age_102_m, age_102_w, age_103_m, age_103_w, " +
                        "age_104_m, age_104_w, age_105_m, age_105_w, age_106_m, age_106_w, " +
                        "age_107_m, age_107_w, age_108_m, age_108_w, age_109_m, age_109_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal100s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal100s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge100M());
                        ps.setLong(3, list.get(i).getPopAge100W());
                        ps.setLong(4, list.get(i).getPopAge101M());
                        ps.setLong(5, list.get(i).getPopAge101W());
                        ps.setLong(6, list.get(i).getPopAge102M());
                        ps.setLong(7, list.get(i).getPopAge102W());
                        ps.setLong(8, list.get(i).getPopAge103M());
                        ps.setLong(9, list.get(i).getPopAge103W());
                        ps.setLong(10, list.get(i).getPopAge104M());
                        ps.setLong(11, list.get(i).getPopAge104W());
                        ps.setLong(12, list.get(i).getPopAge105M());
                        ps.setLong(13, list.get(i).getPopAge105W());
                        ps.setLong(14, list.get(i).getPopAge106M());
                        ps.setLong(15, list.get(i).getPopAge106W());
                        ps.setLong(16, list.get(i).getPopAge107M());
                        ps.setLong(17, list.get(i).getPopAge107W());
                        ps.setLong(18, list.get(i).getPopAge108M());
                        ps.setLong(19, list.get(i).getPopAge108W());
                        ps.setLong(20, list.get(i).getPopAge109M());
                        ps.setLong(21, list.get(i).getPopAge109W());
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

    public void populationTotalInsert(List<Population100sDto> list) {

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

        for (Population100sDto population100sDto : list) {
            String nameCity = population100sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population100sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population100sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population100sDto.getPopAge100M() + population100sDto.getPopAge101M() + population100sDto.getPopAge102M() + population100sDto.getPopAge103M() + population100sDto.getPopAge104M() +
                    population100sDto.getPopAge105M() + population100sDto.getPopAge106M() + population100sDto.getPopAge107M() + population100sDto.getPopAge108M() + population100sDto.getPopAge109M());
            total_w += (population100sDto.getPopAge100W() + population100sDto.getPopAge101W() + population100sDto.getPopAge102W() + population100sDto.getPopAge103W() + population100sDto.getPopAge104W() +
                    population100sDto.getPopAge105W() + population100sDto.getPopAge106W() + population100sDto.getPopAge107W() + population100sDto.getPopAge108W() + population100sDto.getPopAge109W());

            Long sumAge100 = population100sDto.getPopAge100M() + population100sDto.getPopAge100W();
            Long sumAge101 = population100sDto.getPopAge101M() + population100sDto.getPopAge101W();
            Long sumAge102 = population100sDto.getPopAge102M() + population100sDto.getPopAge102W();
            Long sumAge103 = population100sDto.getPopAge103M() + population100sDto.getPopAge103W();
            Long sumAge104 = population100sDto.getPopAge104M() + population100sDto.getPopAge104W();
            Long sumAge105 = population100sDto.getPopAge105M() + population100sDto.getPopAge105W();
            Long sumAge106 = population100sDto.getPopAge106M() + population100sDto.getPopAge106W();
            Long sumAge107 = population100sDto.getPopAge107M() + population100sDto.getPopAge107W();
            Long sumAge108 = population100sDto.getPopAge108M() + population100sDto.getPopAge108W();
            Long sumAge109 = population100sDto.getPopAge109M() + population100sDto.getPopAge109W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge100, population100sDto.getPopAge100M(), population100sDto.getPopAge100W(),
                        sumAge101, population100sDto.getPopAge101M(), population100sDto.getPopAge101W(),
                        sumAge102, population100sDto.getPopAge102M(), population100sDto.getPopAge102W(),
                        sumAge103, population100sDto.getPopAge103M(), population100sDto.getPopAge103W(),
                        sumAge104, population100sDto.getPopAge104M(), population100sDto.getPopAge104W(),
                        sumAge105, population100sDto.getPopAge105M(), population100sDto.getPopAge105W(),
                        sumAge106, population100sDto.getPopAge106M(), population100sDto.getPopAge106W(),
                        sumAge107, population100sDto.getPopAge107M(), population100sDto.getPopAge107W(),
                        sumAge108, population100sDto.getPopAge108M(), population100sDto.getPopAge108W(),
                        sumAge109, population100sDto.getPopAge109M(), population100sDto.getPopAge109W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge100, map.get(nameCity).get(1) + population100sDto.getPopAge100M(), map.get(nameCity).get(2) + population100sDto.getPopAge100W(),
                        map.get(nameCity).get(3) + sumAge101, map.get(nameCity).get(4) + population100sDto.getPopAge101M(), map.get(nameCity).get(5) + population100sDto.getPopAge101W(),
                        map.get(nameCity).get(6) + sumAge102, map.get(nameCity).get(7) + population100sDto.getPopAge102M(), map.get(nameCity).get(8) + population100sDto.getPopAge102W(),
                        map.get(nameCity).get(9) + sumAge103, map.get(nameCity).get(10) + population100sDto.getPopAge103M(), map.get(nameCity).get(11) + population100sDto.getPopAge103W(),
                        map.get(nameCity).get(12) + sumAge104, map.get(nameCity).get(13) + population100sDto.getPopAge104M(), map.get(nameCity).get(14) + population100sDto.getPopAge104W(),
                        map.get(nameCity).get(15) + sumAge105, map.get(nameCity).get(16) + population100sDto.getPopAge105M(), map.get(nameCity).get(17) + population100sDto.getPopAge105W(),
                        map.get(nameCity).get(18) + sumAge106, map.get(nameCity).get(19) + population100sDto.getPopAge106M(), map.get(nameCity).get(20) + population100sDto.getPopAge106W(),
                        map.get(nameCity).get(21) + sumAge107, map.get(nameCity).get(22) + population100sDto.getPopAge107M(), map.get(nameCity).get(23) + population100sDto.getPopAge107W(),
                        map.get(nameCity).get(24) + sumAge108, map.get(nameCity).get(25) + population100sDto.getPopAge108M(), map.get(nameCity).get(26) + population100sDto.getPopAge108W(),
                        map.get(nameCity).get(27) + sumAge109, map.get(nameCity).get(28) + population100sDto.getPopAge109M(), map.get(nameCity).get(29) + population100sDto.getPopAge109W()
                ));
            }

            if (nameWard != null && nameWard.contains(" ")) {               // ex. 성남시 분당구
                int cut = nameWard.indexOf(" ");
                String subNameWard1 = nameWard.substring(0, cut);           // ex. 성남시
                String subNameWard2 = nameWard.substring(cut + 1);          // ex. 분당구
                String subCityWard1 = nameCity + " " + subNameWard1;        // ex. 경기도 성남시
                String subCityWard2 = cityWard;                             // ex. 경기도 성남시 분당구

                if (!map.containsKey(subCityWard1)) {
                    map.put(subCityWard1, Arrays.asList(
                            sumAge100, population100sDto.getPopAge100M(), population100sDto.getPopAge100W(),
                            sumAge101, population100sDto.getPopAge101M(), population100sDto.getPopAge101W(),
                            sumAge102, population100sDto.getPopAge102M(), population100sDto.getPopAge102W(),
                            sumAge103, population100sDto.getPopAge103M(), population100sDto.getPopAge103W(),
                            sumAge104, population100sDto.getPopAge104M(), population100sDto.getPopAge104W(),
                            sumAge105, population100sDto.getPopAge105M(), population100sDto.getPopAge105W(),
                            sumAge106, population100sDto.getPopAge106M(), population100sDto.getPopAge106W(),
                            sumAge107, population100sDto.getPopAge107M(), population100sDto.getPopAge107W(),
                            sumAge108, population100sDto.getPopAge108M(), population100sDto.getPopAge108W(),
                            sumAge109, population100sDto.getPopAge109M(), population100sDto.getPopAge109W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge100, map.get(subCityWard1).get(1) + population100sDto.getPopAge100M(), map.get(subCityWard1).get(2) + population100sDto.getPopAge100W(),
                            map.get(subCityWard1).get(3) + sumAge101, map.get(subCityWard1).get(4) + population100sDto.getPopAge101M(), map.get(subCityWard1).get(5) + population100sDto.getPopAge101W(),
                            map.get(subCityWard1).get(6) + sumAge102, map.get(subCityWard1).get(7) + population100sDto.getPopAge102M(), map.get(subCityWard1).get(8) + population100sDto.getPopAge102W(),
                            map.get(subCityWard1).get(9) + sumAge103, map.get(subCityWard1).get(10) + population100sDto.getPopAge103M(), map.get(subCityWard1).get(11) + population100sDto.getPopAge103W(),
                            map.get(subCityWard1).get(12) + sumAge104, map.get(subCityWard1).get(13) + population100sDto.getPopAge104M(), map.get(subCityWard1).get(14) + population100sDto.getPopAge104W(),
                            map.get(subCityWard1).get(15) + sumAge105, map.get(subCityWard1).get(16) + population100sDto.getPopAge105M(), map.get(subCityWard1).get(17) + population100sDto.getPopAge105W(),
                            map.get(subCityWard1).get(18) + sumAge106, map.get(subCityWard1).get(19) + population100sDto.getPopAge106M(), map.get(subCityWard1).get(20) + population100sDto.getPopAge106W(),
                            map.get(subCityWard1).get(21) + sumAge107, map.get(subCityWard1).get(22) + population100sDto.getPopAge107M(), map.get(subCityWard1).get(23) + population100sDto.getPopAge107W(),
                            map.get(subCityWard1).get(24) + sumAge108, map.get(subCityWard1).get(25) + population100sDto.getPopAge108M(), map.get(subCityWard1).get(26) + population100sDto.getPopAge108W(),
                            map.get(subCityWard1).get(27) + sumAge109, map.get(subCityWard1).get(28) + population100sDto.getPopAge109M(), map.get(subCityWard1).get(29) + population100sDto.getPopAge109W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge100, population100sDto.getPopAge100M(), population100sDto.getPopAge100W(),
                            sumAge101, population100sDto.getPopAge101M(), population100sDto.getPopAge101W(),
                            sumAge102, population100sDto.getPopAge102M(), population100sDto.getPopAge102W(),
                            sumAge103, population100sDto.getPopAge103M(), population100sDto.getPopAge103W(),
                            sumAge104, population100sDto.getPopAge104M(), population100sDto.getPopAge104W(),
                            sumAge105, population100sDto.getPopAge105M(), population100sDto.getPopAge105W(),
                            sumAge106, population100sDto.getPopAge106M(), population100sDto.getPopAge106W(),
                            sumAge107, population100sDto.getPopAge107M(), population100sDto.getPopAge107W(),
                            sumAge108, population100sDto.getPopAge108M(), population100sDto.getPopAge108W(),
                            sumAge109, population100sDto.getPopAge109M(), population100sDto.getPopAge109W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge100, map.get(subCityWard2).get(1) + population100sDto.getPopAge100M(), map.get(subCityWard2).get(2) + population100sDto.getPopAge100W(),
                            map.get(subCityWard2).get(3) + sumAge101, map.get(subCityWard2).get(4) + population100sDto.getPopAge101M(), map.get(subCityWard2).get(5) + population100sDto.getPopAge101W(),
                            map.get(subCityWard2).get(6) + sumAge102, map.get(subCityWard2).get(7) + population100sDto.getPopAge102M(), map.get(subCityWard2).get(8) + population100sDto.getPopAge102W(),
                            map.get(subCityWard2).get(9) + sumAge103, map.get(subCityWard2).get(10) + population100sDto.getPopAge103M(), map.get(subCityWard2).get(11) + population100sDto.getPopAge103W(),
                            map.get(subCityWard2).get(12) + sumAge104, map.get(subCityWard2).get(13) + population100sDto.getPopAge104M(), map.get(subCityWard2).get(14) + population100sDto.getPopAge104W(),
                            map.get(subCityWard2).get(15) + sumAge105, map.get(subCityWard2).get(16) + population100sDto.getPopAge105M(), map.get(subCityWard2).get(17) + population100sDto.getPopAge105W(),
                            map.get(subCityWard2).get(18) + sumAge106, map.get(subCityWard2).get(19) + population100sDto.getPopAge106M(), map.get(subCityWard2).get(20) + population100sDto.getPopAge106W(),
                            map.get(subCityWard2).get(21) + sumAge107, map.get(subCityWard2).get(22) + population100sDto.getPopAge107M(), map.get(subCityWard2).get(23) + population100sDto.getPopAge107W(),
                            map.get(subCityWard2).get(24) + sumAge108, map.get(subCityWard2).get(25) + population100sDto.getPopAge108M(), map.get(subCityWard2).get(26) + population100sDto.getPopAge108W(),
                            map.get(subCityWard2).get(27) + sumAge109, map.get(subCityWard2).get(28) + population100sDto.getPopAge109M(), map.get(subCityWard2).get(29) + population100sDto.getPopAge109W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge100, population100sDto.getPopAge100M(), population100sDto.getPopAge100W(),
                            sumAge101, population100sDto.getPopAge101M(), population100sDto.getPopAge101W(),
                            sumAge102, population100sDto.getPopAge102M(), population100sDto.getPopAge102W(),
                            sumAge103, population100sDto.getPopAge103M(), population100sDto.getPopAge103W(),
                            sumAge104, population100sDto.getPopAge104M(), population100sDto.getPopAge104W(),
                            sumAge105, population100sDto.getPopAge105M(), population100sDto.getPopAge105W(),
                            sumAge106, population100sDto.getPopAge106M(), population100sDto.getPopAge106W(),
                            sumAge107, population100sDto.getPopAge107M(), population100sDto.getPopAge107W(),
                            sumAge108, population100sDto.getPopAge108M(), population100sDto.getPopAge108W(),
                            sumAge109, population100sDto.getPopAge109M(), population100sDto.getPopAge109W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge100, map.get(cityWard).get(1) + population100sDto.getPopAge100M(), map.get(cityWard).get(2) + population100sDto.getPopAge100W(),
                            map.get(cityWard).get(3) + sumAge101, map.get(cityWard).get(4) + population100sDto.getPopAge101M(), map.get(cityWard).get(5) + population100sDto.getPopAge101W(),
                            map.get(cityWard).get(6) + sumAge102, map.get(cityWard).get(7) + population100sDto.getPopAge102M(), map.get(cityWard).get(8) + population100sDto.getPopAge102W(),
                            map.get(cityWard).get(9) + sumAge103, map.get(cityWard).get(10) + population100sDto.getPopAge103M(), map.get(cityWard).get(11) + population100sDto.getPopAge103W(),
                            map.get(cityWard).get(12) + sumAge104, map.get(cityWard).get(13) + population100sDto.getPopAge104M(), map.get(cityWard).get(14) + population100sDto.getPopAge104W(),
                            map.get(cityWard).get(15) + sumAge105, map.get(cityWard).get(16) + population100sDto.getPopAge105M(), map.get(cityWard).get(17) + population100sDto.getPopAge105W(),
                            map.get(cityWard).get(18) + sumAge106, map.get(cityWard).get(19) + population100sDto.getPopAge106M(), map.get(cityWard).get(20) + population100sDto.getPopAge106W(),
                            map.get(cityWard).get(21) + sumAge107, map.get(cityWard).get(22) + population100sDto.getPopAge107M(), map.get(cityWard).get(23) + population100sDto.getPopAge107W(),
                            map.get(cityWard).get(24) + sumAge108, map.get(cityWard).get(25) + population100sDto.getPopAge108M(), map.get(cityWard).get(26) + population100sDto.getPopAge108W(),
                            map.get(cityWard).get(27) + sumAge109, map.get(cityWard).get(28) + population100sDto.getPopAge109M(), map.get(cityWard).get(29) + population100sDto.getPopAge109W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_dec_total_100s (pop_seq, pop_place, " +
                        "age_100_total, age_100_total_m, age_100_total_w, age_101_total, age_101_total_m, age_101_total_w, " +
                        "age_102_total, age_102_total_m, age_102_total_w, age_103_total, age_103_total_m, age_103_total_w, " +
                        "age_104_total, age_104_total_m, age_104_total_w, age_105_total, age_105_total_m, age_105_total_w, " +
                        "age_106_total, age_106_total_m, age_106_total_w, age_107_total, age_107_total_m, age_107_total_w, " +
                        "age_108_total, age_108_total_m, age_108_total_w, age_109_total, age_109_total_m, age_109_total_w) " +
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
