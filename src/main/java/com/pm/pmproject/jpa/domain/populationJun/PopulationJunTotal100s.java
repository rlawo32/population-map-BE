package com.pm.pmproject.jpa.domain.populationJun;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationJun_total_100s")
public class PopulationJunTotal100s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_100_total")
    private Long age100Total;

    @Column(name = "age_100_total_m")
    private Long age100TotalM;

    @Column(name = "age_100_total_w")
    private Long age100TotalW;

    @Column(name = "age_101_total")
    private Long age101Total;

    @Column(name = "age_101_total_m")
    private Long age101TotalM;

    @Column(name = "age_101_total_w")
    private Long age101TotalW;

    @Column(name = "age_102_total")
    private Long age102Total;

    @Column(name = "age_102_total_m")
    private Long age102TotalM;

    @Column(name = "age_102_total_w")
    private Long age102TotalW;

    @Column(name = "age_103_total")
    private Long age103Total;

    @Column(name = "age_103_total_m")
    private Long age103TotalM;

    @Column(name = "age_103_total_w")
    private Long age103TotalW;

    @Column(name = "age_104_total")
    private Long age104Total;

    @Column(name = "age_104_total_m")
    private Long age104TotalM;

    @Column(name = "age_104_total_w")
    private Long age104TotalW;

    @Column(name = "age_105_total")
    private Long age105Total;

    @Column(name = "age_105_total_m")
    private Long age105TotalM;

    @Column(name = "age_105_total_w")
    private Long age105TotalW;

    @Column(name = "age_106_total")
    private Long age106Total;

    @Column(name = "age_106_total_m")
    private Long age106TotalM;

    @Column(name = "age_106_total_w")
    private Long age106TotalW;

    @Column(name = "age_107_total")
    private Long age107Total;

    @Column(name = "age_107_total_m")
    private Long age107TotalM;

    @Column(name = "age_107_total_w")
    private Long age107TotalW;

    @Column(name = "age_108_total")
    private Long age108Total;

    @Column(name = "age_108_total_m")
    private Long age108TotalM;

    @Column(name = "age_108_total_w")
    private Long age108TotalW;

    @Column(name = "age_109_total")
    private Long age109Total;

    @Column(name = "age_109_total_m")
    private Long age109TotalM;

    @Column(name = "age_109_total_w")
    private Long age109TotalW;
}