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
@Table(name = "PopulationJan")
public class PopulationJan20s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_20")
    private Long popAge20;

    @Column(name = "pop_age_21")
    private Long popAge21;

    @Column(name = "pop_age_22")
    private Long popAge22;

    @Column(name = "pop_age_23")
    private Long popAge23;

    @Column(name = "pop_age_24")
    private Long popAge24;

    @Column(name = "pop_age_25")
    private Long popAge25;

    @Column(name = "pop_age_26")
    private Long popAge26;

    @Column(name = "pop_age_27")
    private Long popAge27;

    @Column(name = "pop_age_28")
    private Long popAge28;

    @Column(name = "pop_age_29")
    private Long popAge29;
}
