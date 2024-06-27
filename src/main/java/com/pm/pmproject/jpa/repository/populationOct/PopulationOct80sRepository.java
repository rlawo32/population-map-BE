package com.pm.pmproject.jpa.repository.populationOct;

import com.pm.pmproject.jpa.domain.populationOct.PopulationOct80s;
import com.pm.pmproject.jpa.domain.populationSep.PopulationSep80s;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationOct80sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationOct80sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<PopulationOct80s> list) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO population_oct_80s (admin_code, pop_age_m_80, pop_age_w_80, pop_age_m_81, " +
                        "pop_age_w_81, pop_age_m_82, pop_age_w_82, pop_age_m_83, pop_age_w_83, pop_age_m_84, " +
                        "pop_age_w_84, pop_age_m_85, pop_age_w_85, pop_age_m_86, pop_age_w_86, pop_age_m_87, " +
                        "pop_age_w_87, pop_age_m_88, pop_age_w_88, pop_age_m_89, pop_age_w_89) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM80());
                        ps.setLong(3, list.get(i).getPopAgeW80());
                        ps.setLong(4, list.get(i).getPopAgeM81());
                        ps.setLong(5, list.get(i).getPopAgeW81());
                        ps.setLong(6, list.get(i).getPopAgeM82());
                        ps.setLong(7, list.get(i).getPopAgeW82());
                        ps.setLong(8, list.get(i).getPopAgeM83());
                        ps.setLong(9, list.get(i).getPopAgeW83());
                        ps.setLong(10, list.get(i).getPopAgeM84());
                        ps.setLong(11, list.get(i).getPopAgeW84());
                        ps.setLong(12, list.get(i).getPopAgeM85());
                        ps.setLong(13, list.get(i).getPopAgeW85());
                        ps.setLong(14, list.get(i).getPopAgeM86());
                        ps.setLong(15, list.get(i).getPopAgeW86());
                        ps.setLong(16, list.get(i).getPopAgeM87());
                        ps.setLong(17, list.get(i).getPopAgeW87());
                        ps.setLong(18, list.get(i).getPopAgeM88());
                        ps.setLong(19, list.get(i).getPopAgeW88());
                        ps.setLong(20, list.get(i).getPopAgeM89());
                        ps.setLong(21, list.get(i).getPopAgeW89());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }
}
