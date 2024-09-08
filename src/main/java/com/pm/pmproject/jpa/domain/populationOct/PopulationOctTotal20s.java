package com.pm.pmproject.jpa.domain.populationOct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationOct_total_20s")
public class PopulationOctTotal20s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_20_total")
    private Long age20Total;

    @Column(name = "age_20_total_m")
    private Long age20TotalM;

    @Column(name = "age_20_total_w")
    private Long age20TotalW;

    @Column(name = "age_21_total")
    private Long age21Total;

    @Column(name = "age_21_total_m")
    private Long age21TotalM;

    @Column(name = "age_21_total_w")
    private Long age21TotalW;

    @Column(name = "age_22_total")
    private Long age22Total;

    @Column(name = "age_22_total_m")
    private Long age22TotalM;

    @Column(name = "age_22_total_w")
    private Long age22TotalW;

    @Column(name = "age_23_total")
    private Long age23Total;

    @Column(name = "age_23_total_m")
    private Long age23TotalM;

    @Column(name = "age_23_total_w")
    private Long age23TotalW;

    @Column(name = "age_24_total")
    private Long age24Total;

    @Column(name = "age_24_total_m")
    private Long age24TotalM;

    @Column(name = "age_24_total_w")
    private Long age24TotalW;

    @Column(name = "age_25_total")
    private Long age25Total;

    @Column(name = "age_25_total_m")
    private Long age25TotalM;

    @Column(name = "age_25_total_w")
    private Long age25TotalW;

    @Column(name = "age_26_total")
    private Long age26Total;

    @Column(name = "age_26_total_m")
    private Long age26TotalM;

    @Column(name = "age_26_total_w")
    private Long age26TotalW;

    @Column(name = "age_27_total")
    private Long age27Total;

    @Column(name = "age_27_total_m")
    private Long age27TotalM;

    @Column(name = "age_27_total_w")
    private Long age27TotalW;

    @Column(name = "age_28_total")
    private Long age28Total;

    @Column(name = "age_28_total_m")
    private Long age28TotalM;

    @Column(name = "age_28_total_w")
    private Long age28TotalW;

    @Column(name = "age_29_total")
    private Long age29Total;

    @Column(name = "age_29_total_m")
    private Long age29TotalM;

    @Column(name = "age_29_total_w")
    private Long age29TotalW;
}