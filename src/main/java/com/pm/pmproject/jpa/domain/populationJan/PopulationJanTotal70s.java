package com.pm.pmproject.jpa.domain.populationJan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationJan_total_70s")
public class PopulationJanTotal70s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_70_total")
    private Long age70Total;

    @Column(name = "age_70_total_m")
    private Long age70TotalM;

    @Column(name = "age_70_total_w")
    private Long age70TotalW;

    @Column(name = "age_71_total")
    private Long age71Total;

    @Column(name = "age_71_total_m")
    private Long age71TotalM;

    @Column(name = "age_71_total_w")
    private Long age71TotalW;

    @Column(name = "age_72_total")
    private Long age72Total;

    @Column(name = "age_72_total_m")
    private Long age72TotalM;

    @Column(name = "age_72_total_w")
    private Long age72TotalW;

    @Column(name = "age_73_total")
    private Long age73Total;

    @Column(name = "age_73_total_m")
    private Long age73TotalM;

    @Column(name = "age_73_total_w")
    private Long age73TotalW;

    @Column(name = "age_74_total")
    private Long age74Total;

    @Column(name = "age_74_total_m")
    private Long age74TotalM;

    @Column(name = "age_74_total_w")
    private Long age74TotalW;

    @Column(name = "age_75_total")
    private Long age75Total;

    @Column(name = "age_75_total_m")
    private Long age75TotalM;

    @Column(name = "age_75_total_w")
    private Long age75TotalW;

    @Column(name = "age_76_total")
    private Long age76Total;

    @Column(name = "age_76_total_m")
    private Long age76TotalM;

    @Column(name = "age_76_total_w")
    private Long age76TotalW;

    @Column(name = "age_77_total")
    private Long age77Total;

    @Column(name = "age_77_total_m")
    private Long age77TotalM;

    @Column(name = "age_77_total_w")
    private Long age77TotalW;

    @Column(name = "age_78_total")
    private Long age78Total;

    @Column(name = "age_78_total_m")
    private Long age78TotalM;

    @Column(name = "age_78_total_w")
    private Long age78TotalW;

    @Column(name = "age_79_total")
    private Long age79Total;

    @Column(name = "age_79_total_m")
    private Long age79TotalM;

    @Column(name = "age_79_total_w")
    private Long age79TotalW;
}