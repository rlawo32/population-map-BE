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
import java.util.List;

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

        List<TestDto> list = jdbcTemplate.query("select * from test_table", new RowMapper<TestDto>() {
            @Override
            public TestDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                TestDto td = new TestDto();
                td.setId(rs.getLong("id"));
                td.setTestValue1(rs.getLong("test_value_1"));
                td.setTestValue2(rs.getString("test_value_2"));
                return td;
            }
        });

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i).getId() + "번째 테스트 : ");
            System.out.print(list.get(i).getTestValue1() + " ");
            System.out.println(list.get(i).getTestValue2());
        }

//        return result;
    }
}
