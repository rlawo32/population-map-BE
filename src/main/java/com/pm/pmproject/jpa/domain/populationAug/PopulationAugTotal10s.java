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
@Table(name = "PopulationAug_total_10s")
public class PopulationAugTotal10s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_10_total")
    private Long age10Total;

    @Column(name = "age_10_total_m")
    private Long age10TotalM;

    @Column(name = "age_10_total_w")
    private Long age10TotalW;

    @Column(name = "age_11_total")
    private Long age11Total;

    @Column(name = "age_11_total_m")
    private Long age11TotalM;

    @Column(name = "age_11_total_w")
    private Long age11TotalW;

    @Column(name = "age_12_total")
    private Long age12Total;

    @Column(name = "age_12_total_m")
    private Long age12TotalM;

    @Column(name = "age_12_total_w")
    private Long age12TotalW;

    @Column(name = "age_13_total")
    private Long age13Total;

    @Column(name = "age_13_total_m")
    private Long age13TotalM;

    @Column(name = "age_13_total_w")
    private Long age13TotalW;

    @Column(name = "age_14_total")
    private Long age14Total;

    @Column(name = "age_14_total_m")
    private Long age14TotalM;

    @Column(name = "age_14_total_w")
    private Long age14TotalW;

    @Column(name = "age_15_total")
    private Long age15Total;

    @Column(name = "age_15_total_m")
    private Long age15TotalM;

    @Column(name = "age_15_total_w")
    private Long age15TotalW;

    @Column(name = "age_16_total")
    private Long age16Total;

    @Column(name = "age_16_total_m")
    private Long age16TotalM;

    @Column(name = "age_16_total_w")
    private Long age16TotalW;

    @Column(name = "age_17_total")
    private Long age17Total;

    @Column(name = "age_17_total_m")
    private Long age17TotalM;

    @Column(name = "age_17_total_w")
    private Long age17TotalW;

    @Column(name = "age_18_total")
    private Long age18Total;

    @Column(name = "age_18_total_m")
    private Long age18TotalM;

    @Column(name = "age_18_total_w")
    private Long age18TotalW;

    @Column(name = "age_19_total")
    private Long age19Total;

    @Column(name = "age_19_total_m")
    private Long age19TotalM;

    @Column(name = "age_19_total_w")
    private Long age19TotalW;
}