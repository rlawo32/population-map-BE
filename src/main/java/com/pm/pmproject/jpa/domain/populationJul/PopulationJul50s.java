package com.pm.pmproject.jpa.domain.populationJul;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationJul50s")
public class PopulationJul50s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_50")
    private Long popAgeM50;

    @Column(name = "pop_age_w_50")
    private Long popAgeW50;

    @Column(name = "pop_age_m_51")
    private Long popAgeM51;

    @Column(name = "pop_age_w_51")
    private Long popAgeW51;

    @Column(name = "pop_age_m_52")
    private Long popAgeM52;

    @Column(name = "pop_age_w_52")
    private Long popAgeW52;

    @Column(name = "pop_age_m_53")
    private Long popAgeM53;

    @Column(name = "pop_age_w_53")
    private Long popAgeW53;

    @Column(name = "pop_age_m_54")
    private Long popAgeM54;

    @Column(name = "pop_age_w_54")
    private Long popAgeW54;

    @Column(name = "pop_age_m_55")
    private Long popAgeM55;

    @Column(name = "pop_age_w_55")
    private Long popAgeW55;

    @Column(name = "pop_age_m_56")
    private Long popAgeM56;

    @Column(name = "pop_age_w_56")
    private Long popAgeW56;

    @Column(name = "pop_age_m_57")
    private Long popAgeM57;

    @Column(name = "pop_age_w_57")
    private Long popAgeW57;

    @Column(name = "pop_age_m_58")
    private Long popAgeM58;

    @Column(name = "pop_age_w_58")
    private Long popAgeW58;

    @Column(name = "pop_age_m_59")
    private Long popAgeM59;

    @Column(name = "pop_age_w_59")
    private Long popAgeW59;
}
