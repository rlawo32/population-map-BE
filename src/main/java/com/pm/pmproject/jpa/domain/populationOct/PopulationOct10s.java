package com.pm.pmproject.jpa.domain.populationOct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationOct_10s")
public class PopulationOct10s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_10_m")
    private Long age10M;

    @Column(name = "age_10_w")
    private Long age10W;

    @Column(name = "age_11_m")
    private Long age11M;

    @Column(name = "age_11_w")
    private Long age11W;

    @Column(name = "age_12_m")
    private Long age12M;

    @Column(name = "age_12_w")
    private Long age12W;

    @Column(name = "age_13_m")
    private Long age13M;

    @Column(name = "age_13_w")
    private Long age13W;

    @Column(name = "age_14_m")
    private Long age14M;

    @Column(name = "age_14_w")
    private Long age14W;

    @Column(name = "age_15_m")
    private Long age15M;

    @Column(name = "age_15_w")
    private Long age15W;

    @Column(name = "age_16_m")
    private Long age16M;

    @Column(name = "age_16_w")
    private Long age16W;

    @Column(name = "age_17_m")
    private Long age17M;

    @Column(name = "age_17_w")
    private Long age17W;

    @Column(name = "age_18_m")
    private Long age18M;

    @Column(name = "age_18_w")
    private Long age18W;

    @Column(name = "age_19_m")
    private Long age19M;

    @Column(name = "age_19_w")
    private Long age19W;
}
