package com.pm.pmproject.jpa.domain.populationAug;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationAug_total_90s")
public class PopulationAugTotal90s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_90_total")
    private Long age90Total;

    @Column(name = "age_90_total_m")
    private Long age90TotalM;

    @Column(name = "age_90_total_w")
    private Long age90TotalW;

    @Column(name = "age_91_total")
    private Long age91Total;

    @Column(name = "age_91_total_m")
    private Long age91TotalM;

    @Column(name = "age_91_total_w")
    private Long age91TotalW;

    @Column(name = "age_92_total")
    private Long age92Total;

    @Column(name = "age_92_total_m")
    private Long age92TotalM;

    @Column(name = "age_92_total_w")
    private Long age92TotalW;

    @Column(name = "age_93_total")
    private Long age93Total;

    @Column(name = "age_93_total_m")
    private Long age93TotalM;

    @Column(name = "age_93_total_w")
    private Long age93TotalW;

    @Column(name = "age_94_total")
    private Long age94Total;

    @Column(name = "age_94_total_m")
    private Long age94TotalM;

    @Column(name = "age_94_total_w")
    private Long age94TotalW;

    @Column(name = "age_95_total")
    private Long age95Total;

    @Column(name = "age_95_total_m")
    private Long age95TotalM;

    @Column(name = "age_95_total_w")
    private Long age95TotalW;

    @Column(name = "age_96_total")
    private Long age96Total;

    @Column(name = "age_96_total_m")
    private Long age96TotalM;

    @Column(name = "age_96_total_w")
    private Long age96TotalW;

    @Column(name = "age_97_total")
    private Long age97Total;

    @Column(name = "age_97_total_m")
    private Long age97TotalM;

    @Column(name = "age_97_total_w")
    private Long age97TotalW;

    @Column(name = "age_98_total")
    private Long age98Total;

    @Column(name = "age_98_total_m")
    private Long age98TotalM;

    @Column(name = "age_98_total_w")
    private Long age98TotalW;

    @Column(name = "age_99_total")
    private Long age99Total;

    @Column(name = "age_99_total_m")
    private Long age99TotalM;

    @Column(name = "age_99_total_w")
    private Long age99TotalW;
}