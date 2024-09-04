package com.pm.pmproject.jpa.repository.populationJun;

import com.pm.pmproject.dto.Population20sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationJun20sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationJun20sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population20sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_jun_20s (admin_code, age_20_m, age_20_w, " +
                        "age_21_m, age_21_w, age_22_m, age_22_w, age_23_m, age_23_w, " +
                        "age_24_m, age_24_w, age_25_m, age_25_w, age_26_m, age_26_w, " +
                        "age_27_m, age_27_w, age_28_m, age_28_w, age_29_m, age_29_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal20s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal20s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge20M());
                        ps.setLong(3, list.get(i).getPopAge20W());
                        ps.setLong(4, list.get(i).getPopAge21M());
                        ps.setLong(5, list.get(i).getPopAge21W());
                        ps.setLong(6, list.get(i).getPopAge22M());
                        ps.setLong(7, list.get(i).getPopAge22W());
                        ps.setLong(8, list.get(i).getPopAge23M());
                        ps.setLong(9, list.get(i).getPopAge23W());
                        ps.setLong(10, list.get(i).getPopAge24M());
                        ps.setLong(11, list.get(i).getPopAge24W());
                        ps.setLong(12, list.get(i).getPopAge25M());
                        ps.setLong(13, list.get(i).getPopAge25W());
                        ps.setLong(14, list.get(i).getPopAge26M());
                        ps.setLong(15, list.get(i).getPopAge26W());
                        ps.setLong(16, list.get(i).getPopAge27M());
                        ps.setLong(17, list.get(i).getPopAge27W());
                        ps.setLong(18, list.get(i).getPopAge28M());
                        ps.setLong(19, list.get(i).getPopAge28W());
                        ps.setLong(20, list.get(i).getPopAge29M());
                        ps.setLong(21, list.get(i).getPopAge29W());
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
