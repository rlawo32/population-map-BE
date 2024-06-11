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
@Table(name = "PopulationJan0s")
public class PopulationJan0s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_0")
    private Long popAge0;

    @Column(name = "pop_age_1")
    private Long popAge1;

    @Column(name = "pop_age_2")
    private Long popAge2;

    @Column(name = "pop_age_3")
    private Long popAge3;

    @Column(name = "pop_age_4")
    private Long popAge4;

    @Column(name = "pop_age_5")
    private Long popAge5;

    @Column(name = "pop_age_6")
    private Long popAge6;

    @Column(name = "pop_age_7")
    private Long popAge7;

    @Column(name = "pop_age_8")
    private Long popAge8;

    @Column(name = "pop_age_9")
    private Long popAge9;
}
