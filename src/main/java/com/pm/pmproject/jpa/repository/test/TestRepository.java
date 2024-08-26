package com.pm.pmproject.jpa.repository.test;

import com.pm.pmproject.dto.PopulationResultDto;
import com.pm.pmproject.dto.TestDto;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TestRepository {

    private final JdbcTemplate jdbcTemplate;

    public TestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<TestDto> list) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO test_table (test_value_1, test_value_2) " +
                        "VALUES(?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, list.get(i).getCost());
                        ps.setString(2, list.get(i).getSubName());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }
}
