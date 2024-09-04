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
                "insert into population_apr_30s (admin_code, age_30_m, age_30_w, " +
                        "age_31_m, age_31_w, age_32_m, age_32_w, age_33_m, age_33_w, " +
                        "age_34_m, age_34_w, age_35_m, age_35_w, age_36_m, age_36_w, " +
                        "age_37_m, age_37_w, age_38_m, age_38_w, age_39_m, age_39_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal30s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal30s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge30M());
                        ps.setLong(3, list.get(i).getPopAge30W());
                        ps.setLong(4, list.get(i).getPopAge31M());
                        ps.setLong(5, list.get(i).getPopAge31W());
                        ps.setLong(6, list.get(i).getPopAge32M());
                        ps.setLong(7, list.get(i).getPopAge32W());
                        ps.setLong(8, list.get(i).getPopAge33M());
                        ps.setLong(9, list.get(i).getPopAge33W());
                        ps.setLong(10, list.get(i).getPopAge34M());
                        ps.setLong(11, list.get(i).getPopAge34W());
                        ps.setLong(12, list.get(i).getPopAge35M());
                        ps.setLong(13, list.get(i).getPopAge35W());
                        ps.setLong(14, list.get(i).getPopAge36M());
                        ps.setLong(15, list.get(i).getPopAge36W());
                        ps.setLong(16, list.get(i).getPopAge37M());
                        ps.setLong(17, list.get(i).getPopAge37W());
                        ps.setLong(18, list.get(i).getPopAge38M());
                        ps.setLong(19, list.get(i).getPopAge38W());
                        ps.setLong(20, list.get(i).getPopAge39M());
                        ps.setLong(21, list.get(i).getPopAge39W());
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
