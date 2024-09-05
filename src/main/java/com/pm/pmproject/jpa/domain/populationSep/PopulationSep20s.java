package com.pm.pmproject.jpa.domain.populationSep;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationSep_20s")
public class PopulationSep20s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_20_m")
    private Long age20M;

    @Column(name = "age_20_w")
    private Long age20W;

    @Column(name = "age_21_m")
    private Long age21M;

    @Column(name = "age_21_w")
    private Long age21W;

    @Column(name = "age_22_m")
    private Long age22M;

    @Column(name = "age_22_w")
    private Long age22W;

    @Column(name = "age_23_m")
    private Long age23M;

    @Column(name = "age_23_w")
    private Long age23W;

    @Column(name = "age_24_m")
    private Long age24M;

    @Column(name = "age_24_w")
    private Long age24W;

    @Column(name = "age_25_m")
    private Long age25M;

    @Column(name = "age_25_w")
    private Long age25W;

    @Column(name = "age_26_m")
    private Long age26M;

    @Column(name = "age_26_w")
    private Long age26W;

    @Column(name = "age_27_m")
    private Long age27M;

    @Column(name = "age_27_w")
    private Long age27W;

    @Column(name = "age_28_m")
    private Long age28M;

    @Column(name = "age_28_w")
    private Long age28W;

    @Column(name = "age_29_m")
    private Long age29M;

    @Column(name = "age_29_w")
    private Long age29W;
}
