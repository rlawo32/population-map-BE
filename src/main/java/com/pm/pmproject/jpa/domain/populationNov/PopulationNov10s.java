package com.pm.pmproject.jpa.domain.populationNov;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationNov10s")
public class PopulationNov10s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_10")
    private Long popAgeM10;

    @Column(name = "pop_age_w_10")
    private Long popAgeW10;

    @Column(name = "pop_age_m_11")
    private Long popAgeM11;

    @Column(name = "pop_age_w_11")
    private Long popAgeW11;

    @Column(name = "pop_age_m_12")
    private Long popAgeM12;

    @Column(name = "pop_age_w_12")
    private Long popAgeW12;

    @Column(name = "pop_age_m_13")
    private Long popAgeM13;

    @Column(name = "pop_age_w_13")
    private Long popAgeW13;

    @Column(name = "pop_age_m_14")
    private Long popAgeM14;

    @Column(name = "pop_age_w_14")
    private Long popAgeW14;

    @Column(name = "pop_age_m_15")
    private Long popAgeM15;

    @Column(name = "pop_age_w_15")
    private Long popAgeW15;

    @Column(name = "pop_age_m_16")
    private Long popAgeM16;

    @Column(name = "pop_age_w_16")
    private Long popAgeW16;

    @Column(name = "pop_age_m_17")
    private Long popAgeM17;

    @Column(name = "pop_age_w_17")
    private Long popAgeW17;

    @Column(name = "pop_age_m_18")
    private Long popAgeM18;

    @Column(name = "pop_age_w_18")
    private Long popAgeW18;

    @Column(name = "pop_age_m_19")
    private Long popAgeM19;

    @Column(name = "pop_age_w_19")
    private Long popAgeW19;
}
