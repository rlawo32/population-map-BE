package com.pm.pmproject.jpa.repository.populationApr;

import com.pm.pmproject.dto.Population30sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationApr30sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationApr30sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population30sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_apr_30s (admin_code, pop_age_m_30, pop_age_w_30, pop_age_m_31, " +
                        "pop_age_w_31, pop_age_m_32, pop_age_w_32, pop_age_m_33, pop_age_w_33, pop_age_m_34, " +
                        "pop_age_w_34, pop_age_m_35, pop_age_w_35, pop_age_m_36, pop_age_w_36, pop_age_m_37, " +
                        "pop_age_w_37, pop_age_m_38, pop_age_w_38, pop_age_m_39, pop_age_w_39, " +
                        "pop_age_total, pop_age_m_total, pop_age_w_total) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal30s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal30s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM30());
                        ps.setLong(3, list.get(i).getPopAgeW30());
                        ps.setLong(4, list.get(i).getPopAgeM31());
                        ps.setLong(5, list.get(i).getPopAgeW31());
                        ps.setLong(6, list.get(i).getPopAgeM32());
                        ps.setLong(7, list.get(i).getPopAgeW32());
                        ps.setLong(8, list.get(i).getPopAgeM33());
                        ps.setLong(9, list.get(i).getPopAgeW33());
                        ps.setLong(10, list.get(i).getPopAgeM34());
                        ps.setLong(11, list.get(i).getPopAgeW34());
                        ps.setLong(12, list.get(i).getPopAgeM35());
                        ps.setLong(13, list.get(i).getPopAgeW35());
                        ps.setLong(14, list.get(i).getPopAgeM36());
                        ps.setLong(15, list.get(i).getPopAgeW36());
                        ps.setLong(16, list.get(i).getPopAgeM37());
                        ps.setLong(17, list.get(i).getPopAgeW37());
                        ps.setLong(18, list.get(i).getPopAgeM38());
                        ps.setLong(19, list.get(i).getPopAgeW38());
                        ps.setLong(20, list.get(i).getPopAgeM39());
                        ps.setLong(21, list.get(i).getPopAgeW39());
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
