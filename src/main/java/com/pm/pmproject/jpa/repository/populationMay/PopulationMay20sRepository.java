package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.Population20sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMay20sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMay20sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population20sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may_20s (admin_code, pop_age_m_20, pop_age_w_20, pop_age_m_21, " +
                        "pop_age_w_21, pop_age_m_22, pop_age_w_22, pop_age_m_23, pop_age_w_23, pop_age_m_24, " +
                        "pop_age_w_24, pop_age_m_25, pop_age_w_25, pop_age_m_26, pop_age_w_26, pop_age_m_27, " +
                        "pop_age_w_27, pop_age_m_28, pop_age_w_28, pop_age_m_29, pop_age_w_29, " +
                        "pop_age_total, pop_age_m_total, pop_age_w_total) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal20s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal20s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM20());
                        ps.setLong(3, list.get(i).getPopAgeW20());
                        ps.setLong(4, list.get(i).getPopAgeM21());
                        ps.setLong(5, list.get(i).getPopAgeW21());
                        ps.setLong(6, list.get(i).getPopAgeM22());
                        ps.setLong(7, list.get(i).getPopAgeW22());
                        ps.setLong(8, list.get(i).getPopAgeM23());
                        ps.setLong(9, list.get(i).getPopAgeW23());
                        ps.setLong(10, list.get(i).getPopAgeM24());
                        ps.setLong(11, list.get(i).getPopAgeW24());
                        ps.setLong(12, list.get(i).getPopAgeM25());
                        ps.setLong(13, list.get(i).getPopAgeW25());
                        ps.setLong(14, list.get(i).getPopAgeM26());
                        ps.setLong(15, list.get(i).getPopAgeW26());
                        ps.setLong(16, list.get(i).getPopAgeM27());
                        ps.setLong(17, list.get(i).getPopAgeW27());
                        ps.setLong(18, list.get(i).getPopAgeM28());
                        ps.setLong(19, list.get(i).getPopAgeW28());
                        ps.setLong(20, list.get(i).getPopAgeM29());
                        ps.setLong(21, list.get(i).getPopAgeW29());
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
