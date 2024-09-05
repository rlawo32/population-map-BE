package com.pm.pmproject.jpa.domain.populationJul;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationJul_30s")
public class PopulationJul30s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_30_m")
    private Long age30M;

    @Column(name = "age_30_w")
    private Long age30W;

    @Column(name = "age_31_m")
    private Long age31M;

    @Column(name = "age_31_w")
    private Long age31W;

    @Column(name = "age_32_m")
    private Long age32M;

    @Column(name = "age_32_w")
    private Long age32W;

    @Column(name = "age_33_m")
    private Long age33M;

    @Column(name = "age_33_w")
    private Long age33W;

    @Column(name = "age_34_m")
    private Long age34M;

    @Column(name = "age_34_w")
    private Long age34W;

    @Column(name = "age_35_m")
    private Long age35M;

    @Column(name = "age_35_w")
    private Long age35W;

    @Column(name = "age_36_m")
    private Long age36M;

    @Column(name = "age_36_w")
    private Long age36W;

    @Column(name = "age_37_m")
    private Long age37M;

    @Column(name = "age_37_w")
    private Long age37W;

    @Column(name = "age_38_m")
    private Long age38M;

    @Column(name = "age_38_w")
    private Long age38W;

    @Column(name = "age_39_m")
    private Long age39M;

    @Column(name = "age_39_w")
    private Long age39W;
}
