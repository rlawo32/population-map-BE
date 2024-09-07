package com.pm.pmproject.jpa.repository.populationNov;

import com.pm.pmproject.dto.Population60sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationNov60sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationNov60sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population60sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_nov_60s (admin_code, age_60_m, age_60_w, " +
                        "age_61_m, age_61_w, age_62_m, age_62_w, age_63_m, age_63_w, " +
                        "age_64_m, age_64_w, age_65_m, age_65_w, age_66_m, age_66_w, " +
                        "age_67_m, age_67_w, age_68_m, age_68_w, age_69_m, age_69_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal60s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal60s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge60M());
                        ps.setLong(3, list.get(i).getPopAge60W());
                        ps.setLong(4, list.get(i).getPopAge61M());
                        ps.setLong(5, list.get(i).getPopAge61W());
                        ps.setLong(6, list.get(i).getPopAge62M());
                        ps.setLong(7, list.get(i).getPopAge62W());
                        ps.setLong(8, list.get(i).getPopAge63M());
                        ps.setLong(9, list.get(i).getPopAge63W());
                        ps.setLong(10, list.get(i).getPopAge64M());
                        ps.setLong(11, list.get(i).getPopAge64W());
                        ps.setLong(12, list.get(i).getPopAge65M());
                        ps.setLong(13, list.get(i).getPopAge65W());
                        ps.setLong(14, list.get(i).getPopAge66M());
                        ps.setLong(15, list.get(i).getPopAge66W());
                        ps.setLong(16, list.get(i).getPopAge67M());
                        ps.setLong(17, list.get(i).getPopAge67W());
                        ps.setLong(18, list.get(i).getPopAge68M());
                        ps.setLong(19, list.get(i).getPopAge68W());
                        ps.setLong(20, list.get(i).getPopAge69M());
                        ps.setLong(21, list.get(i).getPopAge69W());
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
