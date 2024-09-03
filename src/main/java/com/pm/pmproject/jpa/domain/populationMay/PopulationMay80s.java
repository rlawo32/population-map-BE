package com.pm.pmproject.jpa.domain.populationMay;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationMay_80s")
public class PopulationMay80s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_80_m")
    private Long age80M;

    @Column(name = "age_80_w")
    private Long age80W;

    @Column(name = "age_81_m")
    private Long age81M;

    @Column(name = "age_81_w")
    private Long age81W;

    @Column(name = "age_82_m")
    private Long age82M;

    @Column(name = "age_82_w")
    private Long age82W;

    @Column(name = "age_83_m")
    private Long age83M;

    @Column(name = "age_83_w")
    private Long age83W;

    @Column(name = "age_84_m")
    private Long age84M;

    @Column(name = "age_84_w")
    private Long age84W;

    @Column(name = "age_85_m")
    private Long age85M;

    @Column(name = "age_85_w")
    private Long age85W;

    @Column(name = "age_86_m")
    private Long age86M;

    @Column(name = "age_86_w")
    private Long age86W;

    @Column(name = "age_87_m")
    private Long age87M;

    @Column(name = "age_87_w")
    private Long age87W;

    @Column(name = "age_88_m")
    private Long age88M;

    @Column(name = "age_88_w")
    private Long age88W;

    @Column(name = "age_89_m")
    private Long age89M;

    @Column(name = "age_89_w")
    private Long age89W;
}
