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
@Table(name = "PopulationNov90s")
public class PopulationNov90s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_90")
    private Long popAgeM90;

    @Column(name = "pop_age_w_90")
    private Long popAgeW90;

    @Column(name = "pop_age_m_91")
    private Long popAgeM91;

    @Column(name = "pop_age_w_91")
    private Long popAgeW91;

    @Column(name = "pop_age_m_92")
    private Long popAgeM92;

    @Column(name = "pop_age_w_92")
    private Long popAgeW92;

    @Column(name = "pop_age_m_93")
    private Long popAgeM93;

    @Column(name = "pop_age_w_93")
    private Long popAgeW93;

    @Column(name = "pop_age_m_94")
    private Long popAgeM94;

    @Column(name = "pop_age_w_94")
    private Long popAgeW94;

    @Column(name = "pop_age_m_95")
    private Long popAgeM95;

    @Column(name = "pop_age_w_95")
    private Long popAgeW95;

    @Column(name = "pop_age_m_96")
    private Long popAgeM96;

    @Column(name = "pop_age_w_96")
    private Long popAgeW96;

    @Column(name = "pop_age_m_97")
    private Long popAgeM97;

    @Column(name = "pop_age_w_97")
    private Long popAgeW97;

    @Column(name = "pop_age_m_98")
    private Long popAgeM98;

    @Column(name = "pop_age_w_98")
    private Long popAgeW98;

    @Column(name = "pop_age_m_99")
    private Long popAgeM99;

    @Column(name = "pop_age_w_99")
    private Long popAgeW99;
}
