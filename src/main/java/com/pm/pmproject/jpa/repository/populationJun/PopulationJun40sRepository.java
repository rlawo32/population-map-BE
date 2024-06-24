package com.pm.pmproject.jpa.repository.populationJun;

import com.pm.pmproject.jpa.domain.populationJun.PopulationJun40s;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationJun40sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationJun40sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<PopulationJun40s> list) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO population_jun_40s (admin_code, pop_age_m_40, pop_age_w_40, pop_age_m_41, " +
                        "pop_age_w_41, pop_age_m_42, pop_age_w_42, pop_age_m_43, pop_age_w_43, pop_age_m_44, " +
                        "pop_age_w_44, pop_age_m_45, pop_age_w_45, pop_age_m_46, pop_age_w_46, pop_age_m_47, " +
                        "pop_age_w_47, pop_age_m_48, pop_age_w_48, pop_age_m_49, pop_age_w_49) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM40());
                        ps.setLong(3, list.get(i).getPopAgeW40());
                        ps.setLong(4, list.get(i).getPopAgeM41());
                        ps.setLong(5, list.get(i).getPopAgeW41());
                        ps.setLong(6, list.get(i).getPopAgeM42());
                        ps.setLong(7, list.get(i).getPopAgeW42());
                        ps.setLong(8, list.get(i).getPopAgeM43());
                        ps.setLong(9, list.get(i).getPopAgeW43());
                        ps.setLong(10, list.get(i).getPopAgeM44());
                        ps.setLong(11, list.get(i).getPopAgeW44());
                        ps.setLong(12, list.get(i).getPopAgeM45());
                        ps.setLong(13, list.get(i).getPopAgeW45());
                        ps.setLong(14, list.get(i).getPopAgeM46());
                        ps.setLong(15, list.get(i).getPopAgeW46());
                        ps.setLong(16, list.get(i).getPopAgeM47());
                        ps.setLong(17, list.get(i).getPopAgeW47());
                        ps.setLong(18, list.get(i).getPopAgeM48());
                        ps.setLong(19, list.get(i).getPopAgeW48());
                        ps.setLong(20, list.get(i).getPopAgeM49());
                        ps.setLong(21, list.get(i).getPopAgeW49());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }
}
