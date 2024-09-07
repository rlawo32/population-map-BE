package com.pm.pmproject.jpa.domain.populationNov;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationNov_100s")
public class PopulationNov100s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_100_m")
    private Long age100M;

    @Column(name = "age_100_w")
    private Long age100W;

    @Column(name = "age_101_m")
    private Long age101M;

    @Column(name = "age_101_w")
    private Long age101W;

    @Column(name = "age_102_m")
    private Long age102M;

    @Column(name = "age_102_w")
    private Long age102W;

    @Column(name = "age_103_m")
    private Long age103M;

    @Column(name = "age_103_w")
    private Long age103W;

    @Column(name = "age_104_m")
    private Long age104M;

    @Column(name = "age_104_w")
    private Long age104W;

    @Column(name = "age_105_m")
    private Long age105M;

    @Column(name = "age_105_w")
    private Long age105W;

    @Column(name = "age_106_m")
    private Long age106M;

    @Column(name = "age_106_w")
    private Long age106W;

    @Column(name = "age_107_m")
    private Long age107M;

    @Column(name = "age_107_w")
    private Long age107W;

    @Column(name = "age_108_m")
    private Long age108M;

    @Column(name = "age_108_w")
    private Long age108W;

    @Column(name = "age_109_m")
    private Long age109M;

    @Column(name = "age_109_w")
    private Long age109W;
}
