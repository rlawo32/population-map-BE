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
@Table(name = "PopulationNov_total_50s")
public class PopulationNovTotal50s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_50_total")
    private Long age50Total;

    @Column(name = "age_50_total_m")
    private Long age50TotalM;

    @Column(name = "age_50_total_w")
    private Long age50TotalW;

    @Column(name = "age_51_total")
    private Long age51Total;

    @Column(name = "age_51_total_m")
    private Long age51TotalM;

    @Column(name = "age_51_total_w")
    private Long age51TotalW;

    @Column(name = "age_52_total")
    private Long age52Total;

    @Column(name = "age_52_total_m")
    private Long age52TotalM;

    @Column(name = "age_52_total_w")
    private Long age52TotalW;

    @Column(name = "age_53_total")
    private Long age53Total;

    @Column(name = "age_53_total_m")
    private Long age53TotalM;

    @Column(name = "age_53_total_w")
    private Long age53TotalW;

    @Column(name = "age_54_total")
    private Long age54Total;

    @Column(name = "age_54_total_m")
    private Long age54TotalM;

    @Column(name = "age_54_total_w")
    private Long age54TotalW;

    @Column(name = "age_55_total")
    private Long age55Total;

    @Column(name = "age_55_total_m")
    private Long age55TotalM;

    @Column(name = "age_55_total_w")
    private Long age55TotalW;

    @Column(name = "age_56_total")
    private Long age56Total;

    @Column(name = "age_56_total_m")
    private Long age56TotalM;

    @Column(name = "age_56_total_w")
    private Long age56TotalW;

    @Column(name = "age_57_total")
    private Long age57Total;

    @Column(name = "age_57_total_m")
    private Long age57TotalM;

    @Column(name = "age_57_total_w")
    private Long age57TotalW;

    @Column(name = "age_58_total")
    private Long age58Total;

    @Column(name = "age_58_total_m")
    private Long age58TotalM;

    @Column(name = "age_58_total_w")
    private Long age58TotalW;

    @Column(name = "age_59_total")
    private Long age59Total;

    @Column(name = "age_59_total_m")
    private Long age59TotalM;

    @Column(name = "age_59_total_w")
    private Long age59TotalW;
}