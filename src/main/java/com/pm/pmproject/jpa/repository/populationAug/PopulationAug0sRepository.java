package com.pm.pmproject.jpa.repository.populationAug;

import com.pm.pmproject.dto.Population0sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationAug0sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationAug0sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population0sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_aug_0s (admin_code, age_0_m, age_0_w, " +
                        "age_1_m, age_1_w, age_2_m, age_2_w, age_3_m, age_3_w, " +
                        "age_4_m, age_4_w, age_5_m, age_5_w, age_6_m, age_6_w, " +
                        "age_7_m, age_7_w, age_8_m, age_8_w, age_9_m, age_9_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal0s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal0s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge0M());
                        ps.setLong(3, list.get(i).getPopAge0W());
                        ps.setLong(4, list.get(i).getPopAge1M());
                        ps.setLong(5, list.get(i).getPopAge1W());
                        ps.setLong(6, list.get(i).getPopAge2M());
                        ps.setLong(7, list.get(i).getPopAge2W());
                        ps.setLong(8, list.get(i).getPopAge3M());
                        ps.setLong(9, list.get(i).getPopAge3W());
                        ps.setLong(10, list.get(i).getPopAge4M());
                        ps.setLong(11, list.get(i).getPopAge4W());
                        ps.setLong(12, list.get(i).getPopAge5M());
                        ps.setLong(13, list.get(i).getPopAge5W());
                        ps.setLong(14, list.get(i).getPopAge6M());
                        ps.setLong(15, list.get(i).getPopAge6W());
                        ps.setLong(16, list.get(i).getPopAge7M());
                        ps.setLong(17, list.get(i).getPopAge7W());
                        ps.setLong(18, list.get(i).getPopAge8M());
                        ps.setLong(19, list.get(i).getPopAge8W());
                        ps.setLong(20, list.get(i).getPopAge9M());
                        ps.setLong(21, list.get(i).getPopAge9W());
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
