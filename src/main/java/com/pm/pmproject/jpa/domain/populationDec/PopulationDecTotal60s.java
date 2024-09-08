package com.pm.pmproject.jpa.domain.populationDec;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationDec_total_60s")
public class PopulationDecTotal60s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_60_total")
    private Long age60Total;

    @Column(name = "age_60_total_m")
    private Long age60TotalM;

    @Column(name = "age_60_total_w")
    private Long age60TotalW;

    @Column(name = "age_61_total")
    private Long age61Total;

    @Column(name = "age_61_total_m")
    private Long age61TotalM;

    @Column(name = "age_61_total_w")
    private Long age61TotalW;

    @Column(name = "age_62_total")
    private Long age62Total;

    @Column(name = "age_62_total_m")
    private Long age62TotalM;

    @Column(name = "age_62_total_w")
    private Long age62TotalW;

    @Column(name = "age_63_total")
    private Long age63Total;

    @Column(name = "age_63_total_m")
    private Long age63TotalM;

    @Column(name = "age_63_total_w")
    private Long age63TotalW;

    @Column(name = "age_64_total")
    private Long age64Total;

    @Column(name = "age_64_total_m")
    private Long age64TotalM;

    @Column(name = "age_64_total_w")
    private Long age64TotalW;

    @Column(name = "age_65_total")
    private Long age65Total;

    @Column(name = "age_65_total_m")
    private Long age65TotalM;

    @Column(name = "age_65_total_w")
    private Long age65TotalW;

    @Column(name = "age_66_total")
    private Long age66Total;

    @Column(name = "age_66_total_m")
    private Long age66TotalM;

    @Column(name = "age_66_total_w")
    private Long age66TotalW;

    @Column(name = "age_67_total")
    private Long age67Total;

    @Column(name = "age_67_total_m")
    private Long age67TotalM;

    @Column(name = "age_67_total_w")
    private Long age67TotalW;

    @Column(name = "age_68_total")
    private Long age68Total;

    @Column(name = "age_68_total_m")
    private Long age68TotalM;

    @Column(name = "age_68_total_w")
    private Long age68TotalW;

    @Column(name = "age_69_total")
    private Long age69Total;

    @Column(name = "age_69_total_m")
    private Long age69TotalM;

    @Column(name = "age_69_total_w")
    private Long age69TotalW;
}