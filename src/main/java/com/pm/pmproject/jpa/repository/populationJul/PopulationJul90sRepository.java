package com.pm.pmproject.jpa.repository.populationJul;

import com.pm.pmproject.dto.Population90sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationJul90sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationJul90sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population90sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_jul_90s (admin_code, pop_age_m_90, pop_age_w_90, pop_age_m_91, " +
                        "pop_age_w_91, pop_age_m_92, pop_age_w_92, pop_age_m_93, pop_age_w_93, pop_age_m_94, " +
                        "pop_age_w_94, pop_age_m_95, pop_age_w_95, pop_age_m_96, pop_age_w_96, pop_age_m_97, " +
                        "pop_age_w_97, pop_age_m_98, pop_age_w_98, pop_age_m_99, pop_age_w_99, " +
                        "pop_age_total, pop_age_m_total, pop_age_w_total) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal90s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal90s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM90());
                        ps.setLong(3, list.get(i).getPopAgeW90());
                        ps.setLong(4, list.get(i).getPopAgeM91());
                        ps.setLong(5, list.get(i).getPopAgeW91());
                        ps.setLong(6, list.get(i).getPopAgeM92());
                        ps.setLong(7, list.get(i).getPopAgeW92());
                        ps.setLong(8, list.get(i).getPopAgeM93());
                        ps.setLong(9, list.get(i).getPopAgeW93());
                        ps.setLong(10, list.get(i).getPopAgeM94());
                        ps.setLong(11, list.get(i).getPopAgeW94());
                        ps.setLong(12, list.get(i).getPopAgeM95());
                        ps.setLong(13, list.get(i).getPopAgeW95());
                        ps.setLong(14, list.get(i).getPopAgeM96());
                        ps.setLong(15, list.get(i).getPopAgeW96());
                        ps.setLong(16, list.get(i).getPopAgeM97());
                        ps.setLong(17, list.get(i).getPopAgeW97());
                        ps.setLong(18, list.get(i).getPopAgeM98());
                        ps.setLong(19, list.get(i).getPopAgeW98());
                        ps.setLong(20, list.get(i).getPopAgeM99());
                        ps.setLong(21, list.get(i).getPopAgeW99());
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
