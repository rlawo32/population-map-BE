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
@Table(name = "PopulationNov_70s")
public class PopulationNov70s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_70_m")
    private Long age70M;

    @Column(name = "age_70_w")
    private Long age70W;

    @Column(name = "age_71_m")
    private Long age71M;

    @Column(name = "age_71_w")
    private Long age71W;

    @Column(name = "age_72_m")
    private Long age72M;

    @Column(name = "age_72_w")
    private Long age72W;

    @Column(name = "age_73_m")
    private Long age73M;

    @Column(name = "age_73_w")
    private Long age73W;

    @Column(name = "age_74_m")
    private Long age74M;

    @Column(name = "age_74_w")
    private Long age74W;

    @Column(name = "age_75_m")
    private Long age75M;

    @Column(name = "age_75_w")
    private Long age75W;

    @Column(name = "age_76_m")
    private Long age76M;

    @Column(name = "age_76_w")
    private Long age76W;

    @Column(name = "age_77_m")
    private Long age77M;

    @Column(name = "age_77_w")
    private Long age77W;

    @Column(name = "age_78_m")
    private Long age78M;

    @Column(name = "age_78_w")
    private Long age78W;

    @Column(name = "age_79_m")
    private Long age79M;

    @Column(name = "age_79_w")
    private Long age79W;
}
