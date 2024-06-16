package com.pm.pmproject.jpa.domain.populationFeb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationFeb20s")
public class PopulationFeb20s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_20")
    private Long popAgeM20;

    @Column(name = "pop_age_w_20")
    private Long popAgeW20;

    @Column(name = "pop_age_m_21")
    private Long popAgeM21;

    @Column(name = "pop_age_w_21")
    private Long popAgeW21;

    @Column(name = "pop_age_m_22")
    private Long popAgeM22;

    @Column(name = "pop_age_w_22")
    private Long popAgeW22;

    @Column(name = "pop_age_m_23")
    private Long popAgeM23;

    @Column(name = "pop_age_w_23")
    private Long popAgeW23;

    @Column(name = "pop_age_m_24")
    private Long popAgeM24;

    @Column(name = "pop_age_w_24")
    private Long popAgeW24;

    @Column(name = "pop_age_m_25")
    private Long popAgeM25;

    @Column(name = "pop_age_w_25")
    private Long popAgeW25;

    @Column(name = "pop_age_m_26")
    private Long popAgeM26;

    @Column(name = "pop_age_w_26")
    private Long popAgeW26;

    @Column(name = "pop_age_m_27")
    private Long popAgeM27;

    @Column(name = "pop_age_w_27")
    private Long popAgeW27;

    @Column(name = "pop_age_m_28")
    private Long popAgeM28;

    @Column(name = "pop_age_w_28")
    private Long popAgeW28;

    @Column(name = "pop_age_m_29")
    private Long popAgeM29;

    @Column(name = "pop_age_w_29")
    private Long popAgeW29;
}
