package com.pm.pmproject.jpa.repository.populationJun;

import com.pm.pmproject.jpa.domain.populationJun.PopulationJun10s;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationJun10sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationJun10sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<PopulationJun10s> list) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO population_jun_10s (admin_code, pop_age_m_10, pop_age_w_10, pop_age_m_11, " +
                        "pop_age_w_11, pop_age_m_12, pop_age_w_12, pop_age_m_13, pop_age_w_13, pop_age_m_14, " +
                        "pop_age_w_14, pop_age_m_15, pop_age_w_15, pop_age_m_16, pop_age_w_16, pop_age_m_17, " +
                        "pop_age_w_17, pop_age_m_18, pop_age_w_18, pop_age_m_19, pop_age_w_19) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM10());
                        ps.setLong(3, list.get(i).getPopAgeW10());
                        ps.setLong(4, list.get(i).getPopAgeM11());
                        ps.setLong(5, list.get(i).getPopAgeW11());
                        ps.setLong(6, list.get(i).getPopAgeM12());
                        ps.setLong(7, list.get(i).getPopAgeW12());
                        ps.setLong(8, list.get(i).getPopAgeM13());
                        ps.setLong(9, list.get(i).getPopAgeW13());
                        ps.setLong(10, list.get(i).getPopAgeM14());
                        ps.setLong(11, list.get(i).getPopAgeW14());
                        ps.setLong(12, list.get(i).getPopAgeM15());
                        ps.setLong(13, list.get(i).getPopAgeW15());
                        ps.setLong(14, list.get(i).getPopAgeM16());
                        ps.setLong(15, list.get(i).getPopAgeW16());
                        ps.setLong(16, list.get(i).getPopAgeM17());
                        ps.setLong(17, list.get(i).getPopAgeW17());
                        ps.setLong(18, list.get(i).getPopAgeM18());
                        ps.setLong(19, list.get(i).getPopAgeW18());
                        ps.setLong(20, list.get(i).getPopAgeM19());
                        ps.setLong(21, list.get(i).getPopAgeW19());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }
}
