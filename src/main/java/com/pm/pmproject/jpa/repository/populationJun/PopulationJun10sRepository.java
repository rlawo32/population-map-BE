package com.pm.pmproject.jpa.repository.populationJun;

import com.pm.pmproject.dto.Population10sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationJun10sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationJun10sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population10sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_jun_10s (admin_code, age_10_m, age_10_w, " +
                        "age_11_m, age_11_w, age_12_m, age_12_w, age_13_m, age_13_w, " +
                        "age_14_m, age_14_w, age_15_m, age_15_w, age_16_m, age_16_w, " +
                        "age_17_m, age_17_w, age_18_m, age_18_w, age_19_m, age_19_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal10s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal10s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge10M());
                        ps.setLong(3, list.get(i).getPopAge10W());
                        ps.setLong(4, list.get(i).getPopAge11M());
                        ps.setLong(5, list.get(i).getPopAge11W());
                        ps.setLong(6, list.get(i).getPopAge12M());
                        ps.setLong(7, list.get(i).getPopAge12W());
                        ps.setLong(8, list.get(i).getPopAge13M());
                        ps.setLong(9, list.get(i).getPopAge13W());
                        ps.setLong(10, list.get(i).getPopAge14M());
                        ps.setLong(11, list.get(i).getPopAge14W());
                        ps.setLong(12, list.get(i).getPopAge15M());
                        ps.setLong(13, list.get(i).getPopAge15W());
                        ps.setLong(14, list.get(i).getPopAge16M());
                        ps.setLong(15, list.get(i).getPopAge16W());
                        ps.setLong(16, list.get(i).getPopAge17M());
                        ps.setLong(17, list.get(i).getPopAge17W());
                        ps.setLong(18, list.get(i).getPopAge18M());
                        ps.setLong(19, list.get(i).getPopAge18W());
                        ps.setLong(20, list.get(i).getPopAge19M());
                        ps.setLong(21, list.get(i).getPopAge19W());
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
