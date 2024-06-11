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
@Table(name = "PopulationJan30s")
public class PopulationJan30s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_30")
    private Long popAge30;

    @Column(name = "pop_age_31")
    private Long popAge31;

    @Column(name = "pop_age_32")
    private Long popAge32;

    @Column(name = "pop_age_33")
    private Long popAge33;

    @Column(name = "pop_age_34")
    private Long popAge34;

    @Column(name = "pop_age_35")
    private Long popAge35;

    @Column(name = "pop_age_36")
    private Long popAge36;

    @Column(name = "pop_age_37")
    private Long popAge37;

    @Column(name = "pop_age_38")
    private Long popAge38;

    @Column(name = "pop_age_39")
    private Long popAge39;
}
