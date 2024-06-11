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
@Table(name = "PopulationJan10s")
public class PopulationJan10s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_10")
    private Long popAge10;

    @Column(name = "pop_age_11")
    private Long popAge11;

    @Column(name = "pop_age_12")
    private Long popAge12;

    @Column(name = "pop_age_13")
    private Long popAge13;

    @Column(name = "pop_age_14")
    private Long popAge14;

    @Column(name = "pop_age_15")
    private Long popAge15;

    @Column(name = "pop_age_16")
    private Long popAge16;

    @Column(name = "pop_age_17")
    private Long popAge17;

    @Column(name = "pop_age_18")
    private Long popAge18;

    @Column(name = "pop_age_19")
    private Long popAge19;
}
