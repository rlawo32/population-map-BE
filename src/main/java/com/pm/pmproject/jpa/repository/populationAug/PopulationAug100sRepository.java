package com.pm.pmproject.jpa.repository.populationAug;

import com.pm.pmproject.dto.Population100sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationAug100sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationAug100sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population100sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_aug_100s (admin_code, age_100_m, age_100_w, " +
                        "age_101_m, age_101_w, age_102_m, age_102_w, age_103_m, age_103_w, " +
                        "age_104_m, age_104_w, age_105_m, age_105_w, age_106_m, age_106_w, " +
                        "age_107_m, age_107_w, age_108_m, age_108_w, age_109_m, age_109_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal100s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal100s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge100M());
                        ps.setLong(3, list.get(i).getPopAge100W());
                        ps.setLong(4, list.get(i).getPopAge101M());
                        ps.setLong(5, list.get(i).getPopAge101W());
                        ps.setLong(6, list.get(i).getPopAge102M());
                        ps.setLong(7, list.get(i).getPopAge102W());
                        ps.setLong(8, list.get(i).getPopAge103M());
                        ps.setLong(9, list.get(i).getPopAge103W());
                        ps.setLong(10, list.get(i).getPopAge104M());
                        ps.setLong(11, list.get(i).getPopAge104W());
                        ps.setLong(12, list.get(i).getPopAge105M());
                        ps.setLong(13, list.get(i).getPopAge105W());
                        ps.setLong(14, list.get(i).getPopAge106M());
                        ps.setLong(15, list.get(i).getPopAge106W());
                        ps.setLong(16, list.get(i).getPopAge107M());
                        ps.setLong(17, list.get(i).getPopAge107W());
                        ps.setLong(18, list.get(i).getPopAge108M());
                        ps.setLong(19, list.get(i).getPopAge108W());
                        ps.setLong(20, list.get(i).getPopAge109M());
                        ps.setLong(21, list.get(i).getPopAge109W());
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
