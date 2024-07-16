package com.pm.pmproject.jpa.repository.populationMar;

import com.pm.pmproject.dto.Population60sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMar60sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMar60sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population60sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_mar_60s (admin_code, pop_age_m_60, pop_age_w_60, pop_age_m_61, " +
                        "pop_age_w_61, pop_age_m_62, pop_age_w_62, pop_age_m_63, pop_age_w_63, pop_age_m_64, " +
                        "pop_age_w_64, pop_age_m_65, pop_age_w_65, pop_age_m_66, pop_age_w_66, pop_age_m_67, " +
                        "pop_age_w_67, pop_age_m_68, pop_age_w_68, pop_age_m_69, pop_age_w_69, " +
                        "pop_age_total, pop_age_m_total, pop_age_w_total) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal60s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal60s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAgeM60());
                        ps.setLong(3, list.get(i).getPopAgeW60());
                        ps.setLong(4, list.get(i).getPopAgeM61());
                        ps.setLong(5, list.get(i).getPopAgeW61());
                        ps.setLong(6, list.get(i).getPopAgeM62());
                        ps.setLong(7, list.get(i).getPopAgeW62());
                        ps.setLong(8, list.get(i).getPopAgeM63());
                        ps.setLong(9, list.get(i).getPopAgeW63());
                        ps.setLong(10, list.get(i).getPopAgeM64());
                        ps.setLong(11, list.get(i).getPopAgeW64());
                        ps.setLong(12, list.get(i).getPopAgeM65());
                        ps.setLong(13, list.get(i).getPopAgeW65());
                        ps.setLong(14, list.get(i).getPopAgeM66());
                        ps.setLong(15, list.get(i).getPopAgeW66());
                        ps.setLong(16, list.get(i).getPopAgeM67());
                        ps.setLong(17, list.get(i).getPopAgeW67());
                        ps.setLong(18, list.get(i).getPopAgeM68());
                        ps.setLong(19, list.get(i).getPopAgeW68());
                        ps.setLong(20, list.get(i).getPopAgeM69());
                        ps.setLong(21, list.get(i).getPopAgeW69());
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
