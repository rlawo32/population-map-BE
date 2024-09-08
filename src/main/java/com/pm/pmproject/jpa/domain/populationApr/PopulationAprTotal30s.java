package com.pm.pmproject.jpa.domain.populationApr;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationApr_total_30s")
public class PopulationAprTotal30s {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place")
    private String popPlace;

    @Column(name = "age_30_total")
    private Long age30Total;

    @Column(name = "age_30_total_m")
    private Long age30TotalM;

    @Column(name = "age_30_total_w")
    private Long age30TotalW;

    @Column(name = "age_31_total")
    private Long age31Total;

    @Column(name = "age_31_total_m")
    private Long age31TotalM;

    @Column(name = "age_31_total_w")
    private Long age31TotalW;

    @Column(name = "age_32_total")
    private Long age32Total;

    @Column(name = "age_32_total_m")
    private Long age32TotalM;

    @Column(name = "age_32_total_w")
    private Long age32TotalW;

    @Column(name = "age_33_total")
    private Long age33Total;

    @Column(name = "age_33_total_m")
    private Long age33TotalM;

    @Column(name = "age_33_total_w")
    private Long age33TotalW;

    @Column(name = "age_34_total")
    private Long age34Total;

    @Column(name = "age_34_total_m")
    private Long age34TotalM;

    @Column(name = "age_34_total_w")
    private Long age34TotalW;

    @Column(name = "age_35_total")
    private Long age35Total;

    @Column(name = "age_35_total_m")
    private Long age35TotalM;

    @Column(name = "age_35_total_w")
    private Long age35TotalW;

    @Column(name = "age_36_total")
    private Long age36Total;

    @Column(name = "age_36_total_m")
    private Long age36TotalM;

    @Column(name = "age_36_total_w")
    private Long age36TotalW;

    @Column(name = "age_37_total")
    private Long age37Total;

    @Column(name = "age_37_total_m")
    private Long age37TotalM;

    @Column(name = "age_37_total_w")
    private Long age37TotalW;

    @Column(name = "age_38_total")
    private Long age38Total;

    @Column(name = "age_38_total_m")
    private Long age38TotalM;

    @Column(name = "age_38_total_w")
    private Long age38TotalW;

    @Column(name = "age_39_total")
    private Long age39Total;

    @Column(name = "age_39_total_m")
    private Long age39TotalM;

    @Column(name = "age_39_total_w")
    private Long age39TotalW;
}