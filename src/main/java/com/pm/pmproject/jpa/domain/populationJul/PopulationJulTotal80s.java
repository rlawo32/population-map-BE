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
@Table(name = "PopulationJul_total_80s")
public class PopulationJulTotal80s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_80_total")
    private Long age80Total;

    @Column(name = "age_80_total_m")
    private Long age80TotalM;

    @Column(name = "age_80_total_w")
    private Long age80TotalW;

    @Column(name = "age_81_total")
    private Long age81Total;

    @Column(name = "age_81_total_m")
    private Long age81TotalM;

    @Column(name = "age_81_total_w")
    private Long age81TotalW;

    @Column(name = "age_82_total")
    private Long age82Total;

    @Column(name = "age_82_total_m")
    private Long age82TotalM;

    @Column(name = "age_82_total_w")
    private Long age82TotalW;

    @Column(name = "age_83_total")
    private Long age83Total;

    @Column(name = "age_83_total_m")
    private Long age83TotalM;

    @Column(name = "age_83_total_w")
    private Long age83TotalW;

    @Column(name = "age_84_total")
    private Long age84Total;

    @Column(name = "age_84_total_m")
    private Long age84TotalM;

    @Column(name = "age_84_total_w")
    private Long age84TotalW;

    @Column(name = "age_85_total")
    private Long age85Total;

    @Column(name = "age_85_total_m")
    private Long age85TotalM;

    @Column(name = "age_85_total_w")
    private Long age85TotalW;

    @Column(name = "age_86_total")
    private Long age86Total;

    @Column(name = "age_86_total_m")
    private Long age86TotalM;

    @Column(name = "age_86_total_w")
    private Long age86TotalW;

    @Column(name = "age_87_total")
    private Long age87Total;

    @Column(name = "age_87_total_m")
    private Long age87TotalM;

    @Column(name = "age_87_total_w")
    private Long age87TotalW;

    @Column(name = "age_88_total")
    private Long age88Total;

    @Column(name = "age_88_total_m")
    private Long age88TotalM;

    @Column(name = "age_88_total_w")
    private Long age88TotalW;

    @Column(name = "age_89_total")
    private Long age89Total;

    @Column(name = "age_89_total_m")
    private Long age89TotalM;

    @Column(name = "age_89_total_w")
    private Long age89TotalW;
}