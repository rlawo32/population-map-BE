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
@Table(name = "PopulationDec80s")
public class PopulationDec80s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_80")
    private Long popAgeM80;

    @Column(name = "pop_age_w_80")
    private Long popAgeW80;

    @Column(name = "pop_age_m_81")
    private Long popAgeM81;

    @Column(name = "pop_age_w_81")
    private Long popAgeW81;

    @Column(name = "pop_age_m_82")
    private Long popAgeM82;

    @Column(name = "pop_age_w_82")
    private Long popAgeW82;

    @Column(name = "pop_age_m_83")
    private Long popAgeM83;

    @Column(name = "pop_age_w_83")
    private Long popAgeW83;

    @Column(name = "pop_age_m_84")
    private Long popAgeM84;

    @Column(name = "pop_age_w_84")
    private Long popAgeW84;

    @Column(name = "pop_age_m_85")
    private Long popAgeM85;

    @Column(name = "pop_age_w_85")
    private Long popAgeW85;

    @Column(name = "pop_age_m_86")
    private Long popAgeM86;

    @Column(name = "pop_age_w_86")
    private Long popAgeW86;

    @Column(name = "pop_age_m_87")
    private Long popAgeM87;

    @Column(name = "pop_age_w_87")
    private Long popAgeW87;

    @Column(name = "pop_age_m_88")
    private Long popAgeM88;

    @Column(name = "pop_age_w_88")
    private Long popAgeW88;

    @Column(name = "pop_age_m_89")
    private Long popAgeM89;

    @Column(name = "pop_age_w_89")
    private Long popAgeW89;
}
