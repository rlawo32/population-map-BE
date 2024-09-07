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
@Table(name = "PopulationNov_0s")
public class PopulationNov0s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_0_m")
    private Long age0M;

    @Column(name = "age_0_w")
    private Long age0W;

    @Column(name = "age_1_m")
    private Long age1M;

    @Column(name = "age_1_w")
    private Long age1W;

    @Column(name = "age_2_m")
    private Long age2M;

    @Column(name = "age_2_w")
    private Long age2W;

    @Column(name = "age_3_m")
    private Long age3M;

    @Column(name = "age_3_w")
    private Long age3W;

    @Column(name = "age_4_m")
    private Long age4M;

    @Column(name = "age_4_w")
    private Long age4W;

    @Column(name = "age_5_m")
    private Long age5M;

    @Column(name = "age_5_w")
    private Long age5W;

    @Column(name = "age_6_m")
    private Long age6M;

    @Column(name = "age_6_w")
    private Long age6W;

    @Column(name = "age_7_m")
    private Long age7M;

    @Column(name = "age_7_w")
    private Long age7W;

    @Column(name = "age_8_m")
    private Long age8M;

    @Column(name = "age_8_w")
    private Long age8W;

    @Column(name = "age_9_m")
    private Long age9M;

    @Column(name = "age_9_w")
    private Long age9W;
}
