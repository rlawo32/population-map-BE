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
@Table(name = "PopulationMar30s")
public class PopulationMar30s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_30")
    private Long popAgeM30;

    @Column(name = "pop_age_w_30")
    private Long popAgeW30;

    @Column(name = "pop_age_m_31")
    private Long popAgeM31;

    @Column(name = "pop_age_w_31")
    private Long popAgeW31;

    @Column(name = "pop_age_m_32")
    private Long popAgeM32;

    @Column(name = "pop_age_w_32")
    private Long popAgeW32;

    @Column(name = "pop_age_m_33")
    private Long popAgeM33;

    @Column(name = "pop_age_w_33")
    private Long popAgeW33;

    @Column(name = "pop_age_m_34")
    private Long popAgeM34;

    @Column(name = "pop_age_w_34")
    private Long popAgeW34;

    @Column(name = "pop_age_m_35")
    private Long popAgeM35;

    @Column(name = "pop_age_w_35")
    private Long popAgeW35;

    @Column(name = "pop_age_m_36")
    private Long popAgeM36;

    @Column(name = "pop_age_w_36")
    private Long popAgeW36;

    @Column(name = "pop_age_m_37")
    private Long popAgeM37;

    @Column(name = "pop_age_w_37")
    private Long popAgeW37;

    @Column(name = "pop_age_m_38")
    private Long popAgeM38;

    @Column(name = "pop_age_w_38")
    private Long popAgeW38;

    @Column(name = "pop_age_m_39")
    private Long popAgeM39;

    @Column(name = "pop_age_w_39")
    private Long popAgeW39;
}
