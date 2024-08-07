package com.pm.pmproject.jpa.repository.populationFeb;

import com.pm.pmproject.dto.Population0sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationFeb0sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationFeb0sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population0sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_feb_0s (admin_code, pop_age_m_0, pop_age_w_0, pop_age_m_1, " +
                        "pop_age_w_1, pop_age_m_2, pop_age_w_2, pop_age_m_3, pop_age_w_3, pop_age_m_4, " +
                        "pop_age_w_4, pop_age_m_5, pop_age_w_5, pop_age_m_6, pop_age_w_6, pop_age_m_7, " +
                        "pop_age_w_7, pop_age_m_8, pop_age_w_8, pop_age_m_9, pop_age_w_9, " +
                        "pop_age_total, pop_age_m_total, pop_age_w_total) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal0s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal0s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM0());
                        ps.setLong(3, list.get(i).getPopAgeW0());
                        ps.setLong(4, list.get(i).getPopAgeM1());
                        ps.setLong(5, list.get(i).getPopAgeW1());
                        ps.setLong(6, list.get(i).getPopAgeM2());
                        ps.setLong(7, list.get(i).getPopAgeW2());
                        ps.setLong(8, list.get(i).getPopAgeM3());
                        ps.setLong(9, list.get(i).getPopAgeW3());
                        ps.setLong(10, list.get(i).getPopAgeM4());
                        ps.setLong(11, list.get(i).getPopAgeW4());
                        ps.setLong(12, list.get(i).getPopAgeM5());
                        ps.setLong(13, list.get(i).getPopAgeW5());
                        ps.setLong(14, list.get(i).getPopAgeM6());
                        ps.setLong(15, list.get(i).getPopAgeW6());
                        ps.setLong(16, list.get(i).getPopAgeM7());
                        ps.setLong(17, list.get(i).getPopAgeW7());
                        ps.setLong(18, list.get(i).getPopAgeM8());
                        ps.setLong(19, list.get(i).getPopAgeW8());
                        ps.setLong(20, list.get(i).getPopAgeM9());
                        ps.setLong(21, list.get(i).getPopAgeW9());
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
}
