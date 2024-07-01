package com.pm.pmproject.jpa.repository.populationJan;

import com.pm.pmproject.dto.Population70sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationJan70sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationJan70sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population70sDto> list) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO population_jan_70s (admin_code, pop_age_m_70, pop_age_w_70, pop_age_m_71, " +
                        "pop_age_w_71, pop_age_m_72, pop_age_w_72, pop_age_m_73, pop_age_w_73, pop_age_m_74, " +
                        "pop_age_w_74, pop_age_m_75, pop_age_w_75, pop_age_m_76, pop_age_w_76, pop_age_m_77, " +
                        "pop_age_w_77, pop_age_m_78, pop_age_w_78, pop_age_m_79, pop_age_w_79, " +
                        "pop_age_total, pop_age_m_total, pop_age_w_total) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal70s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal70s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM70());
                        ps.setLong(3, list.get(i).getPopAgeW70());
                        ps.setLong(4, list.get(i).getPopAgeM71());
                        ps.setLong(5, list.get(i).getPopAgeW71());
                        ps.setLong(6, list.get(i).getPopAgeM72());
                        ps.setLong(7, list.get(i).getPopAgeW72());
                        ps.setLong(8, list.get(i).getPopAgeM73());
                        ps.setLong(9, list.get(i).getPopAgeW73());
                        ps.setLong(10, list.get(i).getPopAgeM74());
                        ps.setLong(11, list.get(i).getPopAgeW74());
                        ps.setLong(12, list.get(i).getPopAgeM75());
                        ps.setLong(13, list.get(i).getPopAgeW75());
                        ps.setLong(14, list.get(i).getPopAgeM76());
                        ps.setLong(15, list.get(i).getPopAgeW76());
                        ps.setLong(16, list.get(i).getPopAgeM77());
                        ps.setLong(17, list.get(i).getPopAgeW77());
                        ps.setLong(18, list.get(i).getPopAgeM78());
                        ps.setLong(19, list.get(i).getPopAgeW78());
                        ps.setLong(20, list.get(i).getPopAgeM79());
                        ps.setLong(21, list.get(i).getPopAgeW79());
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
