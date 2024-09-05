package com.pm.pmproject.jpa.repository.populationAug;

import com.pm.pmproject.dto.Population70sDto;
import com.pm.pmproject.util.PopulationTotalUtil;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PopulationAug70sRepository {

    private final JdbcTemplate jdbcTemplate;

    public PopulationAug70sRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchInsert(List<Population70sDto> list) {
        jdbcTemplate.batchUpdate(
                "insert into population_aug_70s (admin_code, age_70_m, age_70_w, " +
                        "age_71_m, age_71_w, age_72_m, age_72_w, age_73_m, age_73_w, " +
                        "age_74_m, age_74_w, age_75_m, age_75_w, age_76_m, age_76_w, " +
                        "age_77_m, age_77_w, age_78_m, age_78_w, age_79_m, age_79_w, " +
                        "age_total, age_total_m, age_total_w) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Long mTotal = PopulationTotalUtil.populationTotal70s("M", list, i);
                        Long wTotal = PopulationTotalUtil.populationTotal70s("W", list, i);
                        ps.setLong(1, list.get(i).getAdminCode());
                        ps.setLong(2, list.get(i).getPopAge70M());
                        ps.setLong(3, list.get(i).getPopAge70W());
                        ps.setLong(4, list.get(i).getPopAge71M());
                        ps.setLong(5, list.get(i).getPopAge71W());
                        ps.setLong(6, list.get(i).getPopAge72M());
                        ps.setLong(7, list.get(i).getPopAge72W());
                        ps.setLong(8, list.get(i).getPopAge73M());
                        ps.setLong(9, list.get(i).getPopAge73W());
                        ps.setLong(10, list.get(i).getPopAge74M());
                        ps.setLong(11, list.get(i).getPopAge74W());
                        ps.setLong(12, list.get(i).getPopAge75M());
                        ps.setLong(13, list.get(i).getPopAge75W());
                        ps.setLong(14, list.get(i).getPopAge76M());
                        ps.setLong(15, list.get(i).getPopAge76W());
                        ps.setLong(16, list.get(i).getPopAge77M());
                        ps.setLong(17, list.get(i).getPopAge77W());
                        ps.setLong(18, list.get(i).getPopAge78M());
                        ps.setLong(19, list.get(i).getPopAge78W());
                        ps.setLong(20, list.get(i).getPopAge79M());
                        ps.setLong(21, list.get(i).getPopAge79W());
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
