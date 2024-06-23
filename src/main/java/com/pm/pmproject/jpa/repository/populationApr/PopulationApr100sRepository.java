package com.pm.pmproject.jpa.repository.populationApr;

import com.pm.pmproject.jpa.domain.populationApr.PopulationApr100s;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationApr100sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationApr100sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<PopulationApr100s> list) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO population_apr_100s (admin_code, pop_age_m_100, pop_age_w_100, pop_age_m_101, " +
                        "pop_age_w_101, pop_age_m_102, pop_age_w_102, pop_age_m_103, pop_age_w_103, pop_age_m_104, " +
                        "pop_age_w_104, pop_age_m_105, pop_age_w_105, pop_age_m_106, pop_age_w_106, pop_age_m_107, " +
                        "pop_age_w_107, pop_age_m_108, pop_age_w_108, pop_age_m_109, pop_age_w_109) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM100());
                        ps.setLong(3, list.get(i).getPopAgeW100());
                        ps.setLong(4, list.get(i).getPopAgeM101());
                        ps.setLong(5, list.get(i).getPopAgeW101());
                        ps.setLong(6, list.get(i).getPopAgeM102());
                        ps.setLong(7, list.get(i).getPopAgeW102());
                        ps.setLong(8, list.get(i).getPopAgeM103());
                        ps.setLong(9, list.get(i).getPopAgeW103());
                        ps.setLong(10, list.get(i).getPopAgeM104());
                        ps.setLong(11, list.get(i).getPopAgeW104());
                        ps.setLong(12, list.get(i).getPopAgeM105());
                        ps.setLong(13, list.get(i).getPopAgeW105());
                        ps.setLong(14, list.get(i).getPopAgeM106());
                        ps.setLong(15, list.get(i).getPopAgeW106());
                        ps.setLong(16, list.get(i).getPopAgeM107());
                        ps.setLong(17, list.get(i).getPopAgeW107());
                        ps.setLong(18, list.get(i).getPopAgeM108());
                        ps.setLong(19, list.get(i).getPopAgeW108());
                        ps.setLong(20, list.get(i).getPopAgeM109());
                        ps.setLong(21, list.get(i).getPopAgeW109());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }
}