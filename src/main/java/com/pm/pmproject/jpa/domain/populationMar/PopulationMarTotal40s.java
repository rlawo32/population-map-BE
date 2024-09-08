package com.pm.pmproject.jpa.domain.populationMar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationMar_total_40s")
public class PopulationMarTotal40s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_40_total")
    private Long age40Total;

    @Column(name = "age_40_total_m")
    private Long age40TotalM;

    @Column(name = "age_40_total_w")
    private Long age40TotalW;

    @Column(name = "age_41_total")
    private Long age41Total;

    @Column(name = "age_41_total_m")
    private Long age41TotalM;

    @Column(name = "age_41_total_w")
    private Long age41TotalW;

    @Column(name = "age_42_total")
    private Long age42Total;

    @Column(name = "age_42_total_m")
    private Long age42TotalM;

    @Column(name = "age_42_total_w")
    private Long age42TotalW;

    @Column(name = "age_43_total")
    private Long age43Total;

    @Column(name = "age_43_total_m")
    private Long age43TotalM;

    @Column(name = "age_43_total_w")
    private Long age43TotalW;

    @Column(name = "age_44_total")
    private Long age44Total;

    @Column(name = "age_44_total_m")
    private Long age44TotalM;

    @Column(name = "age_44_total_w")
    private Long age44TotalW;

    @Column(name = "age_45_total")
    private Long age45Total;

    @Column(name = "age_45_total_m")
    private Long age45TotalM;

    @Column(name = "age_45_total_w")
    private Long age45TotalW;

    @Column(name = "age_46_total")
    private Long age46Total;

    @Column(name = "age_46_total_m")
    private Long age46TotalM;

    @Column(name = "age_46_total_w")
    private Long age46TotalW;

    @Column(name = "age_47_total")
    private Long age47Total;

    @Column(name = "age_47_total_m")
    private Long age47TotalM;

    @Column(name = "age_47_total_w")
    private Long age47TotalW;

    @Column(name = "age_48_total")
    private Long age48Total;

    @Column(name = "age_48_total_m")
    private Long age48TotalM;

    @Column(name = "age_48_total_w")
    private Long age48TotalW;

    @Column(name = "age_49_total")
    private Long age49Total;

    @Column(name = "age_49_total_m")
    private Long age49TotalM;

    @Column(name = "age_49_total_w")
    private Long age49TotalW;
}