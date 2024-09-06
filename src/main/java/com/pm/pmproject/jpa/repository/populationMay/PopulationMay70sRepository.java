package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.Population70sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMay70sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMay70sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population70sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may_70s (admin_code, age_70_m, age_70_w, " +
                        "age_71_m, age_71_w, age_72_m, age_72_w, age_73_m, age_73_w, " +
                        "age_74_m, age_74_w, age_75_m, age_75_w, age_76_m, age_76_w, " +
                        "age_77_m, age_77_w, age_78_m, age_78_w, age_79_m, age_79_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal70s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal70s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge70M());
                        ps.setLong(3, list.get(i).getPopAge70W());
                        ps.setLong(4, list.get(i).getPopAge71M());
                        ps.setLong(5, list.get(i).getPopAge71W());
                        ps.setLong(6, list.get(i).getPopAge72M());
                        ps.setLong(7, list.get(i).getPopAge72W());
                        ps.setLong(8, list.get(i).getPopAge73M());
                        ps.setLong(9, list.get(i).getPopAge73W());
                        ps.setLong(10, list.get(i).getPopAge74M());
                        ps.setLong(11, list.get(i).getPopAge74W());
                        ps.setLong(12, list.get(i).getPopAge75M());
                        ps.setLong(13, list.get(i).getPopAge75W());
                        ps.setLong(14, list.get(i).getPopAge76M());
                        ps.setLong(15, list.get(i).getPopAge76W());
                        ps.setLong(16, list.get(i).getPopAge77M());
                        ps.setLong(17, list.get(i).getPopAge77W());
                        ps.setLong(18, list.get(i).getPopAge78M());
                        ps.setLong(19, list.get(i).getPopAge78W());
                        ps.setLong(20, list.get(i).getPopAge79M());
                        ps.setLong(21, list.get(i).getPopAge79W());
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

    public void populationTotalInsert(List<Population70sDto> list) {

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

        for (Population70sDto population70sDto : list) {
            String nameCity = population70sDto.getNameCity();                    // ex. 서울특별시
            String nameWard = population70sDto.getNameWard();                    // ex. 구로구
            String cityWard = nameCity + " " + population70sDto.getNameWard();   // ex. 서울특별시 구로구

            total_m += (population70sDto.getPopAge70M() + population70sDto.getPopAge71M() + population70sDto.getPopAge72M() + population70sDto.getPopAge73M() + population70sDto.getPopAge74M() +
                    population70sDto.getPopAge75M() + population70sDto.getPopAge76M() + population70sDto.getPopAge77M() + population70sDto.getPopAge78M() + population70sDto.getPopAge79M());
            total_w += (population70sDto.getPopAge70W() + population70sDto.getPopAge71W() + population70sDto.getPopAge72W() + population70sDto.getPopAge73W() + population70sDto.getPopAge74W() +
                    population70sDto.getPopAge75W() + population70sDto.getPopAge76W() + population70sDto.getPopAge77W() + population70sDto.getPopAge78W() + population70sDto.getPopAge79W());

            Long sumAge70 = population70sDto.getPopAge70M() + population70sDto.getPopAge70W();
            Long sumAge71 = population70sDto.getPopAge71M() + population70sDto.getPopAge71W();
            Long sumAge72 = population70sDto.getPopAge72M() + population70sDto.getPopAge72W();
            Long sumAge73 = population70sDto.getPopAge73M() + population70sDto.getPopAge73W();
            Long sumAge74 = population70sDto.getPopAge74M() + population70sDto.getPopAge74W();
            Long sumAge75 = population70sDto.getPopAge75M() + population70sDto.getPopAge75W();
            Long sumAge76 = population70sDto.getPopAge76M() + population70sDto.getPopAge76W();
            Long sumAge77 = population70sDto.getPopAge77M() + population70sDto.getPopAge77W();
            Long sumAge78 = population70sDto.getPopAge78M() + population70sDto.getPopAge78W();
            Long sumAge79 = population70sDto.getPopAge79M() + population70sDto.getPopAge79W();

            if (!map.containsKey(nameCity)) {
                map.put(nameCity, Arrays.asList(
                        sumAge70, population70sDto.getPopAge70M(), population70sDto.getPopAge70W(),
                        sumAge71, population70sDto.getPopAge71M(), population70sDto.getPopAge71W(),
                        sumAge72, population70sDto.getPopAge72M(), population70sDto.getPopAge72W(),
                        sumAge73, population70sDto.getPopAge73M(), population70sDto.getPopAge73W(),
                        sumAge74, population70sDto.getPopAge74M(), population70sDto.getPopAge74W(),
                        sumAge75, population70sDto.getPopAge75M(), population70sDto.getPopAge75W(),
                        sumAge76, population70sDto.getPopAge76M(), population70sDto.getPopAge76W(),
                        sumAge77, population70sDto.getPopAge77M(), population70sDto.getPopAge77W(),
                        sumAge78, population70sDto.getPopAge78M(), population70sDto.getPopAge78W(),
                        sumAge79, population70sDto.getPopAge79M(), population70sDto.getPopAge79W()
                ));
            } else {
                map.put(nameCity, Arrays.asList(
                        map.get(nameCity).get(0) + sumAge70, map.get(nameCity).get(1) + population70sDto.getPopAge70M(), map.get(nameCity).get(2) + population70sDto.getPopAge70W(),
                        map.get(nameCity).get(3) + sumAge71, map.get(nameCity).get(4) + population70sDto.getPopAge71M(), map.get(nameCity).get(5) + population70sDto.getPopAge71W(),
                        map.get(nameCity).get(6) + sumAge72, map.get(nameCity).get(7) + population70sDto.getPopAge72M(), map.get(nameCity).get(8) + population70sDto.getPopAge72W(),
                        map.get(nameCity).get(9) + sumAge73, map.get(nameCity).get(10) + population70sDto.getPopAge73M(), map.get(nameCity).get(11) + population70sDto.getPopAge73W(),
                        map.get(nameCity).get(12) + sumAge74, map.get(nameCity).get(13) + population70sDto.getPopAge74M(), map.get(nameCity).get(14) + population70sDto.getPopAge74W(),
                        map.get(nameCity).get(15) + sumAge75, map.get(nameCity).get(16) + population70sDto.getPopAge75M(), map.get(nameCity).get(17) + population70sDto.getPopAge75W(),
                        map.get(nameCity).get(18) + sumAge76, map.get(nameCity).get(19) + population70sDto.getPopAge76M(), map.get(nameCity).get(20) + population70sDto.getPopAge76W(),
                        map.get(nameCity).get(21) + sumAge77, map.get(nameCity).get(22) + population70sDto.getPopAge77M(), map.get(nameCity).get(23) + population70sDto.getPopAge77W(),
                        map.get(nameCity).get(24) + sumAge78, map.get(nameCity).get(25) + population70sDto.getPopAge78M(), map.get(nameCity).get(26) + population70sDto.getPopAge78W(),
                        map.get(nameCity).get(27) + sumAge79, map.get(nameCity).get(28) + population70sDto.getPopAge79M(), map.get(nameCity).get(29) + population70sDto.getPopAge79W()
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
                            sumAge70, population70sDto.getPopAge70M(), population70sDto.getPopAge70W(),
                            sumAge71, population70sDto.getPopAge71M(), population70sDto.getPopAge71W(),
                            sumAge72, population70sDto.getPopAge72M(), population70sDto.getPopAge72W(),
                            sumAge73, population70sDto.getPopAge73M(), population70sDto.getPopAge73W(),
                            sumAge74, population70sDto.getPopAge74M(), population70sDto.getPopAge74W(),
                            sumAge75, population70sDto.getPopAge75M(), population70sDto.getPopAge75W(),
                            sumAge76, population70sDto.getPopAge76M(), population70sDto.getPopAge76W(),
                            sumAge77, population70sDto.getPopAge77M(), population70sDto.getPopAge77W(),
                            sumAge78, population70sDto.getPopAge78M(), population70sDto.getPopAge78W(),
                            sumAge79, population70sDto.getPopAge79M(), population70sDto.getPopAge79W()
                    ));
                } else {
                    map.put(subCityWard1, Arrays.asList(
                            map.get(subCityWard1).get(0) + sumAge70, map.get(subCityWard1).get(1) + population70sDto.getPopAge70M(), map.get(subCityWard1).get(2) + population70sDto.getPopAge70W(),
                            map.get(subCityWard1).get(3) + sumAge71, map.get(subCityWard1).get(4) + population70sDto.getPopAge71M(), map.get(subCityWard1).get(5) + population70sDto.getPopAge71W(),
                            map.get(subCityWard1).get(6) + sumAge72, map.get(subCityWard1).get(7) + population70sDto.getPopAge72M(), map.get(subCityWard1).get(8) + population70sDto.getPopAge72W(),
                            map.get(subCityWard1).get(9) + sumAge73, map.get(subCityWard1).get(10) + population70sDto.getPopAge73M(), map.get(subCityWard1).get(11) + population70sDto.getPopAge73W(),
                            map.get(subCityWard1).get(12) + sumAge74, map.get(subCityWard1).get(13) + population70sDto.getPopAge74M(), map.get(subCityWard1).get(14) + population70sDto.getPopAge74W(),
                            map.get(subCityWard1).get(15) + sumAge75, map.get(subCityWard1).get(16) + population70sDto.getPopAge75M(), map.get(subCityWard1).get(17) + population70sDto.getPopAge75W(),
                            map.get(subCityWard1).get(18) + sumAge76, map.get(subCityWard1).get(19) + population70sDto.getPopAge76M(), map.get(subCityWard1).get(20) + population70sDto.getPopAge76W(),
                            map.get(subCityWard1).get(21) + sumAge77, map.get(subCityWard1).get(22) + population70sDto.getPopAge77M(), map.get(subCityWard1).get(23) + population70sDto.getPopAge77W(),
                            map.get(subCityWard1).get(24) + sumAge78, map.get(subCityWard1).get(25) + population70sDto.getPopAge78M(), map.get(subCityWard1).get(26) + population70sDto.getPopAge78W(),
                            map.get(subCityWard1).get(27) + sumAge79, map.get(subCityWard1).get(28) + population70sDto.getPopAge79M(), map.get(subCityWard1).get(29) + population70sDto.getPopAge79W()
                    ));
                }

                if (!map.containsKey(subCityWard2)) {
                    map.put(subCityWard2, Arrays.asList(
                            sumAge70, population70sDto.getPopAge70M(), population70sDto.getPopAge70W(),
                            sumAge71, population70sDto.getPopAge71M(), population70sDto.getPopAge71W(),
                            sumAge72, population70sDto.getPopAge72M(), population70sDto.getPopAge72W(),
                            sumAge73, population70sDto.getPopAge73M(), population70sDto.getPopAge73W(),
                            sumAge74, population70sDto.getPopAge74M(), population70sDto.getPopAge74W(),
                            sumAge75, population70sDto.getPopAge75M(), population70sDto.getPopAge75W(),
                            sumAge76, population70sDto.getPopAge76M(), population70sDto.getPopAge76W(),
                            sumAge77, population70sDto.getPopAge77M(), population70sDto.getPopAge77W(),
                            sumAge78, population70sDto.getPopAge78M(), population70sDto.getPopAge78W(),
                            sumAge79, population70sDto.getPopAge79M(), population70sDto.getPopAge79W()
                    ));
                } else {
                    map.put(subCityWard2, Arrays.asList(
                            map.get(subCityWard2).get(0) + sumAge70, map.get(subCityWard2).get(1) + population70sDto.getPopAge70M(), map.get(subCityWard2).get(2) + population70sDto.getPopAge70W(),
                            map.get(subCityWard2).get(3) + sumAge71, map.get(subCityWard2).get(4) + population70sDto.getPopAge71M(), map.get(subCityWard2).get(5) + population70sDto.getPopAge71W(),
                            map.get(subCityWard2).get(6) + sumAge72, map.get(subCityWard2).get(7) + population70sDto.getPopAge72M(), map.get(subCityWard2).get(8) + population70sDto.getPopAge72W(),
                            map.get(subCityWard2).get(9) + sumAge73, map.get(subCityWard2).get(10) + population70sDto.getPopAge73M(), map.get(subCityWard2).get(11) + population70sDto.getPopAge73W(),
                            map.get(subCityWard2).get(12) + sumAge74, map.get(subCityWard2).get(13) + population70sDto.getPopAge74M(), map.get(subCityWard2).get(14) + population70sDto.getPopAge74W(),
                            map.get(subCityWard2).get(15) + sumAge75, map.get(subCityWard2).get(16) + population70sDto.getPopAge75M(), map.get(subCityWard2).get(17) + population70sDto.getPopAge75W(),
                            map.get(subCityWard2).get(18) + sumAge76, map.get(subCityWard2).get(19) + population70sDto.getPopAge76M(), map.get(subCityWard2).get(20) + population70sDto.getPopAge76W(),
                            map.get(subCityWard2).get(21) + sumAge77, map.get(subCityWard2).get(22) + population70sDto.getPopAge77M(), map.get(subCityWard2).get(23) + population70sDto.getPopAge77W(),
                            map.get(subCityWard2).get(24) + sumAge78, map.get(subCityWard2).get(25) + population70sDto.getPopAge78M(), map.get(subCityWard2).get(26) + population70sDto.getPopAge78W(),
                            map.get(subCityWard2).get(27) + sumAge79, map.get(subCityWard2).get(28) + population70sDto.getPopAge79M(), map.get(subCityWard2).get(29) + population70sDto.getPopAge79W()
                    ));
                }

            } else {
                if (!map.containsKey(cityWard)) {
                    map.put(cityWard, Arrays.asList(
                            sumAge70, population70sDto.getPopAge70M(), population70sDto.getPopAge70W(),
                            sumAge71, population70sDto.getPopAge71M(), population70sDto.getPopAge71W(),
                            sumAge72, population70sDto.getPopAge72M(), population70sDto.getPopAge72W(),
                            sumAge73, population70sDto.getPopAge73M(), population70sDto.getPopAge73W(),
                            sumAge74, population70sDto.getPopAge74M(), population70sDto.getPopAge74W(),
                            sumAge75, population70sDto.getPopAge75M(), population70sDto.getPopAge75W(),
                            sumAge76, population70sDto.getPopAge76M(), population70sDto.getPopAge76W(),
                            sumAge77, population70sDto.getPopAge77M(), population70sDto.getPopAge77W(),
                            sumAge78, population70sDto.getPopAge78M(), population70sDto.getPopAge78W(),
                            sumAge79, population70sDto.getPopAge79M(), population70sDto.getPopAge79W()
                    ));
                } else {
                    map.put(cityWard, Arrays.asList(
                            map.get(cityWard).get(0) + sumAge70, map.get(cityWard).get(1) + population70sDto.getPopAge70M(), map.get(cityWard).get(2) + population70sDto.getPopAge70W(),
                            map.get(cityWard).get(3) + sumAge71, map.get(cityWard).get(4) + population70sDto.getPopAge71M(), map.get(cityWard).get(5) + population70sDto.getPopAge71W(),
                            map.get(cityWard).get(6) + sumAge72, map.get(cityWard).get(7) + population70sDto.getPopAge72M(), map.get(cityWard).get(8) + population70sDto.getPopAge72W(),
                            map.get(cityWard).get(9) + sumAge73, map.get(cityWard).get(10) + population70sDto.getPopAge73M(), map.get(cityWard).get(11) + population70sDto.getPopAge73W(),
                            map.get(cityWard).get(12) + sumAge74, map.get(cityWard).get(13) + population70sDto.getPopAge74M(), map.get(cityWard).get(14) + population70sDto.getPopAge74W(),
                            map.get(cityWard).get(15) + sumAge75, map.get(cityWard).get(16) + population70sDto.getPopAge75M(), map.get(cityWard).get(17) + population70sDto.getPopAge75W(),
                            map.get(cityWard).get(18) + sumAge76, map.get(cityWard).get(19) + population70sDto.getPopAge76M(), map.get(cityWard).get(20) + population70sDto.getPopAge76W(),
                            map.get(cityWard).get(21) + sumAge77, map.get(cityWard).get(22) + population70sDto.getPopAge77M(), map.get(cityWard).get(23) + population70sDto.getPopAge77W(),
                            map.get(cityWard).get(24) + sumAge78, map.get(cityWard).get(25) + population70sDto.getPopAge78M(), map.get(cityWard).get(26) + population70sDto.getPopAge78W(),
                            map.get(cityWard).get(27) + sumAge79, map.get(cityWard).get(28) + population70sDto.getPopAge79M(), map.get(cityWard).get(29) + population70sDto.getPopAge79W()
                    ));
                }
            }
        }

        map.put("전체", Arrays.asList(map.get("전체").get(0) + (total_m + total_w), map.get("전체").get(1) + total_m, map.get("전체").get(2) + total_w,
                0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L));

        List<String> keyList = map.keySet().stream().toList();
        List<List<Long>> valueList = map.values().stream().toList();

        jdbcTemplate.batchUpdate(
                "insert into population_may_total_70s (pop_seq, pop_place, " +
                        "age_70_total, age_70_total_m, age_70_total_w, age_71_total, age_71_total_m, age_71_total_w, " +
                        "age_72_total, age_72_total_m, age_72_total_w, age_73_total, age_73_total_m, age_73_total_w, " +
                        "age_74_total, age_74_total_m, age_74_total_w, age_75_total, age_75_total_m, age_75_total_w, " +
                        "age_76_total, age_76_total_m, age_76_total_w, age_77_total, age_77_total_m, age_77_total_w, " +
                        "age_78_total, age_78_total_m, age_78_total_w, age_79_total, age_79_total_m, age_79_total_w) " +
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
