package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.Population40sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMay40sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMay40sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population40sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may_40s (admin_code, age_40_m, age_40_w, " +
                        "age_41_m, age_41_w, age_42_m, age_42_w, age_43_m, age_43_w, " +
                        "age_44_m, age_44_w, age_45_m, age_45_w, age_46_m, age_46_w, " +
                        "age_47_m, age_47_w, age_48_m, age_48_w, age_49_m, age_49_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal40s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal40s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge40M());
                        ps.setLong(3, list.get(i).getPopAge40W());
                        ps.setLong(4, list.get(i).getPopAge41M());
                        ps.setLong(5, list.get(i).getPopAge41W());
                        ps.setLong(6, list.get(i).getPopAge42M());
                        ps.setLong(7, list.get(i).getPopAge42W());
                        ps.setLong(8, list.get(i).getPopAge43M());
                        ps.setLong(9, list.get(i).getPopAge43W());
                        ps.setLong(10, list.get(i).getPopAge44M());
                        ps.setLong(11, list.get(i).getPopAge44W());
                        ps.setLong(12, list.get(i).getPopAge45M());
                        ps.setLong(13, list.get(i).getPopAge45W());
                        ps.setLong(14, list.get(i).getPopAge46M());
                        ps.setLong(15, list.get(i).getPopAge46W());
                        ps.setLong(16, list.get(i).getPopAge47M());
                        ps.setLong(17, list.get(i).getPopAge47W());
                        ps.setLong(18, list.get(i).getPopAge48M());
                        ps.setLong(19, list.get(i).getPopAge48W());
                        ps.setLong(20, list.get(i).getPopAge49M());
                        ps.setLong(21, list.get(i).getPopAge49W());
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
