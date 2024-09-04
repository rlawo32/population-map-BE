package com.pm.pmproject.jpa.repository.populationApr;

import com.pm.pmproject.dto.Population90sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationApr90sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationApr90sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population90sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_apr_90s (admin_code, age_90_m, age_90_w, " +
                        "age_91_m, age_91_w, age_92_m, age_92_w, age_93_m, age_93_w, " +
                        "age_94_m, age_94_w, age_95_m, age_95_w, age_96_m, age_96_w, " +
                        "age_97_m, age_97_w, age_98_m, age_98_w, age_99_m, age_99_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal90s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal90s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge90M());
                        ps.setLong(3, list.get(i).getPopAge90W());
                        ps.setLong(4, list.get(i).getPopAge91M());
                        ps.setLong(5, list.get(i).getPopAge91W());
                        ps.setLong(6, list.get(i).getPopAge92M());
                        ps.setLong(7, list.get(i).getPopAge92W());
                        ps.setLong(8, list.get(i).getPopAge93M());
                        ps.setLong(9, list.get(i).getPopAge93W());
                        ps.setLong(10, list.get(i).getPopAge94M());
                        ps.setLong(11, list.get(i).getPopAge94W());
                        ps.setLong(12, list.get(i).getPopAge95M());
                        ps.setLong(13, list.get(i).getPopAge95W());
                        ps.setLong(14, list.get(i).getPopAge96M());
                        ps.setLong(15, list.get(i).getPopAge96W());
                        ps.setLong(16, list.get(i).getPopAge97M());
                        ps.setLong(17, list.get(i).getPopAge97W());
                        ps.setLong(18, list.get(i).getPopAge98M());
                        ps.setLong(19, list.get(i).getPopAge98W());
                        ps.setLong(20, list.get(i).getPopAge99M());
                        ps.setLong(21, list.get(i).getPopAge99W());
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
