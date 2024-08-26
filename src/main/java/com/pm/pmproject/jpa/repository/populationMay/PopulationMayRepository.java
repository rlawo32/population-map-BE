package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.PopulationResultDto;
import com.pm.pmproject.dto.TestDto;
import com.pm.pmproject.jpa.domain.populationMay.PopulationMay;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PopulationMayRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMayRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<PopulationResultDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may (admin_code, standard_date, name_city, " +
                        "name_ward, name_town, pop_total, pop_m_total, pop_w_total) " +
                        "values(?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setString(2, list.get(i).getStandardDate());
                        ps.setString(3, list.get(i).getNameCity());
                        ps.setString(4, list.get(i).getNameWard());
                        ps.setString(5, list.get(i).getNameTown());
                        ps.setLong(6, list.get(i).getPopTotal());
                        ps.setLong(7, list.get(i).getPopMTotal());
                        ps.setLong(8, list.get(i).getPopWTotal());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }

    public void batchSelect() {
        Long result = 0L;

        List<PopulationResultDto> list = jdbcTemplate.query("select pop_m_total, pop_w_total, pop_total, name_ward, name_city " +
                        "from population_may", new RowMapper<PopulationResultDto>() {
            @Override
            public PopulationResultDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                PopulationResultDto prd = new PopulationResultDto();
                prd.setPopTotal(rs.getLong("pop_total"));
                prd.setPopMTotal(rs.getLong("pop_m_total"));
                prd.setPopWTotal(rs.getLong("pop_w_total"));
                prd.setNameWard(rs.getString("name_ward"));
                prd.setNameCity(rs.getString("name_city"));
                return prd;
            }
        });

        Map<String, Long> map = new HashMap<>();
        map.put("total", 0L);
        map.put("total_m", 0L);
        map.put("total_w", 0L);

        Long total = 0L;
        Long total_m = 0L;
        Long total_w = 0L;

        for(int i=0; i< list.size(); i++) {
            String nameCity = list.get(i).getNameCity();
            String nameWard = list.get(i).getNameWard();
            total += list.get(i).getPopTotal();
            total_m += list.get(i).getPopMTotal();
            total_w += list.get(i).getPopWTotal();

            if(!map.containsKey(nameCity)) {
                map.put(nameCity, list.get(i).getPopTotal());
            }

            if(!map.containsKey(nameWard)) {
                map.put(nameWard, list.get(i).getPopTotal());
            }
        }

//        return result;
    }
}
