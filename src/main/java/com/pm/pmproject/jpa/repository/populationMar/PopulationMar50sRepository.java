package com.pm.pmproject.jpa.repository.populationMar;

import com.pm.pmproject.dto.Population50sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationMar50sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationMar50sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population50sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_mar_50s (admin_code, age_50_m, age_50_w, " +
                        "age_51_m, age_51_w, age_52_m, age_52_w, age_53_m, age_53_w, " +
                        "age_54_m, age_54_w, age_55_m, age_55_w, age_56_m, age_56_w, " +
                        "age_57_m, age_57_w, age_58_m, age_58_w, age_59_m, age_59_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal50s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal50s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge50M());
                        ps.setLong(3, list.get(i).getPopAge50W());
                        ps.setLong(4, list.get(i).getPopAge51M());
                        ps.setLong(5, list.get(i).getPopAge51W());
                        ps.setLong(6, list.get(i).getPopAge52M());
                        ps.setLong(7, list.get(i).getPopAge52W());
                        ps.setLong(8, list.get(i).getPopAge53M());
                        ps.setLong(9, list.get(i).getPopAge53W());
                        ps.setLong(10, list.get(i).getPopAge54M());
                        ps.setLong(11, list.get(i).getPopAge54W());
                        ps.setLong(12, list.get(i).getPopAge55M());
                        ps.setLong(13, list.get(i).getPopAge55W());
                        ps.setLong(14, list.get(i).getPopAge56M());
                        ps.setLong(15, list.get(i).getPopAge56W());
                        ps.setLong(16, list.get(i).getPopAge57M());
                        ps.setLong(17, list.get(i).getPopAge57W());
                        ps.setLong(18, list.get(i).getPopAge58M());
                        ps.setLong(19, list.get(i).getPopAge58W());
                        ps.setLong(20, list.get(i).getPopAge59M());
                        ps.setLong(21, list.get(i).getPopAge59W());
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
