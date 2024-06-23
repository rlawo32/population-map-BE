package com.pm.pmproject.jpa.repository.populationJan;

import com.pm.pmproject.jpa.domain.populationJan.PopulationJan50s;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationJan50sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationJan50sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<PopulationJan50s> list) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO population_jan_50s (admin_code, pop_age_m_50, pop_age_w_50, pop_age_m_51, " +
                        "pop_age_w_51, pop_age_m_52, pop_age_w_52, pop_age_m_53, pop_age_w_53, pop_age_m_54, " +
                        "pop_age_w_54, pop_age_m_55, pop_age_w_55, pop_age_m_56, pop_age_w_56, pop_age_m_57, " +
                        "pop_age_w_57, pop_age_m_58, pop_age_w_58, pop_age_m_59, pop_age_w_59) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM50());
                        ps.setLong(3, list.get(i).getPopAgeW50());
                        ps.setLong(4, list.get(i).getPopAgeM51());
                        ps.setLong(5, list.get(i).getPopAgeW51());
                        ps.setLong(6, list.get(i).getPopAgeM52());
                        ps.setLong(7, list.get(i).getPopAgeW52());
                        ps.setLong(8, list.get(i).getPopAgeM53());
                        ps.setLong(9, list.get(i).getPopAgeW53());
                        ps.setLong(10, list.get(i).getPopAgeM54());
                        ps.setLong(11, list.get(i).getPopAgeW54());
                        ps.setLong(12, list.get(i).getPopAgeM55());
                        ps.setLong(13, list.get(i).getPopAgeW55());
                        ps.setLong(14, list.get(i).getPopAgeM56());
                        ps.setLong(15, list.get(i).getPopAgeW56());
                        ps.setLong(16, list.get(i).getPopAgeM57());
                        ps.setLong(17, list.get(i).getPopAgeW57());
                        ps.setLong(18, list.get(i).getPopAgeM58());
                        ps.setLong(19, list.get(i).getPopAgeW58());
                        ps.setLong(20, list.get(i).getPopAgeM59());
                        ps.setLong(21, list.get(i).getPopAgeW59());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }
}
