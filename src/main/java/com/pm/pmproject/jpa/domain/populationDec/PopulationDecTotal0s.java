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
@Table(name = "PopulationDec_total_0s")
public class PopulationDecTotal0s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_0_total")
    private Long age0Total;

    @Column(name = "age_0_total_m")
    private Long age0TotalM;

    @Column(name = "age_0_total_w")
    private Long age0TotalW;

    @Column(name = "age_1_total")
    private Long age1Total;

    @Column(name = "age_1_total_m")
    private Long age1TotalM;

    @Column(name = "age_1_total_w")
    private Long age1TotalW;

    @Column(name = "age_2_total")
    private Long age2Total;

    @Column(name = "age_2_total_m")
    private Long age2TotalM;

    @Column(name = "age_2_total_w")
    private Long age2TotalW;

    @Column(name = "age_3_total")
    private Long age3Total;

    @Column(name = "age_3_total_m")
    private Long age3TotalM;

    @Column(name = "age_3_total_w")
    private Long age3TotalW;

    @Column(name = "age_4_total")
    private Long age4Total;

    @Column(name = "age_4_total_m")
    private Long age4TotalM;

    @Column(name = "age_4_total_w")
    private Long age4TotalW;

    @Column(name = "age_5_total")
    private Long age5Total;

    @Column(name = "age_5_total_m")
    private Long age5TotalM;

    @Column(name = "age_5_total_w")
    private Long age5TotalW;

    @Column(name = "age_6_total")
    private Long age6Total;

    @Column(name = "age_6_total_m")
    private Long age6TotalM;

    @Column(name = "age_6_total_w")
    private Long age6TotalW;

    @Column(name = "age_7_total")
    private Long age7Total;

    @Column(name = "age_7_total_m")
    private Long age7TotalM;

    @Column(name = "age_7_total_w")
    private Long age7TotalW;

    @Column(name = "age_8_total")
    private Long age8Total;

    @Column(name = "age_8_total_m")
    private Long age8TotalM;

    @Column(name = "age_8_total_w")
    private Long age8TotalW;

    @Column(name = "age_9_total")
    private Long age9Total;

    @Column(name = "age_9_total_m")
    private Long age9TotalM;

    @Column(name = "age_9_total_w")
    private Long age9TotalW;
}
