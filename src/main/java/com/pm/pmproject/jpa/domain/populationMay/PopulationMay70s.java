package com.pm.pmproject.jpa.domain.populationMay;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationMay70s")
public class PopulationMay70s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_70")
    private Long popAgeM70;

    @Column(name = "pop_age_w_70")
    private Long popAgeW70;

    @Column(name = "pop_age_m_71")
    private Long popAgeM71;

    @Column(name = "pop_age_w_71")
    private Long popAgeW71;

    @Column(name = "pop_age_m_72")
    private Long popAgeM72;

    @Column(name = "pop_age_w_72")
    private Long popAgeW72;

    @Column(name = "pop_age_m_73")
    private Long popAgeM73;

    @Column(name = "pop_age_w_73")
    private Long popAgeW73;

    @Column(name = "pop_age_m_74")
    private Long popAgeM74;

    @Column(name = "pop_age_w_74")
    private Long popAgeW74;

    @Column(name = "pop_age_m_75")
    private Long popAgeM75;

    @Column(name = "pop_age_w_75")
    private Long popAgeW75;

    @Column(name = "pop_age_m_76")
    private Long popAgeM76;

    @Column(name = "pop_age_w_76")
    private Long popAgeW76;

    @Column(name = "pop_age_m_77")
    private Long popAgeM77;

    @Column(name = "pop_age_w_77")
    private Long popAgeW77;

    @Column(name = "pop_age_m_78")
    private Long popAgeM78;

    @Column(name = "pop_age_w_78")
    private Long popAgeW78;

    @Column(name = "pop_age_m_79")
    private Long popAgeM79;

    @Column(name = "pop_age_w_79")
    private Long popAgeW79;
}
