package com.pm.pmproject.jpa.repository.test;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class TestRepository {

    private final JdbcTemplate jdbcTemplate;

    public TestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(String schedulerType) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO test_table (update_desc, update_date) " +
                        "VALUES(?, ?)",

                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH:mm")));
                        ps.setString(2, schedulerType);
                    }

                    @Override
                    public int getBatchSize() {
                        return 1;
                    }
                });
    }
}
