package com.pm.pmproject.jpa.repository.populationMay;

import com.pm.pmproject.dto.Population80sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMay80sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMay80sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population80sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_may_80s (admin_code, age_80_m, age_80_w, " +
                        "age_81_m, age_81_w, age_82_m, age_82_w, age_83_m, age_83_w, " +
                        "age_84_m, age_84_w, age_85_m, age_85_w, age_86_m, age_86_w, " +
                        "age_87_m, age_87_w, age_88_m, age_88_w, age_89_m, age_89_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal80s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal80s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge80M());
                        ps.setLong(3, list.get(i).getPopAge80W());
                        ps.setLong(4, list.get(i).getPopAge81M());
                        ps.setLong(5, list.get(i).getPopAge81W());
                        ps.setLong(6, list.get(i).getPopAge82M());
                        ps.setLong(7, list.get(i).getPopAge82W());
                        ps.setLong(8, list.get(i).getPopAge83M());
                        ps.setLong(9, list.get(i).getPopAge83W());
                        ps.setLong(10, list.get(i).getPopAge84M());
                        ps.setLong(11, list.get(i).getPopAge84W());
                        ps.setLong(12, list.get(i).getPopAge85M());
                        ps.setLong(13, list.get(i).getPopAge85W());
                        ps.setLong(14, list.get(i).getPopAge86M());
                        ps.setLong(15, list.get(i).getPopAge86W());
                        ps.setLong(16, list.get(i).getPopAge87M());
                        ps.setLong(17, list.get(i).getPopAge87W());
                        ps.setLong(18, list.get(i).getPopAge88M());
                        ps.setLong(19, list.get(i).getPopAge88W());
                        ps.setLong(20, list.get(i).getPopAge89M());
                        ps.setLong(21, list.get(i).getPopAge89W());
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
