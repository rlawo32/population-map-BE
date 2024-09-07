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
@Table(name = "PopulationNov_90s")
public class PopulationNov90s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_90_m")
    private Long age90M;

    @Column(name = "age_90_w")
    private Long age90W;

    @Column(name = "age_91_m")
    private Long age91M;

    @Column(name = "age_91_w")
    private Long age91W;

    @Column(name = "age_92_m")
    private Long age92M;

    @Column(name = "age_92_w")
    private Long age92W;

    @Column(name = "age_93_m")
    private Long age93M;

    @Column(name = "age_93_w")
    private Long age93W;

    @Column(name = "age_94_m")
    private Long age94M;

    @Column(name = "age_94_w")
    private Long age94W;

    @Column(name = "age_95_m")
    private Long age95M;

    @Column(name = "age_95_w")
    private Long age95W;

    @Column(name = "age_96_m")
    private Long age96M;

    @Column(name = "age_96_w")
    private Long age96W;

    @Column(name = "age_97_m")
    private Long age97M;

    @Column(name = "age_97_w")
    private Long age97W;

    @Column(name = "age_98_m")
    private Long age98M;

    @Column(name = "age_98_w")
    private Long age98W;

    @Column(name = "age_99_m")
    private Long age99M;

    @Column(name = "age_99_w")
    private Long age99W;
}
