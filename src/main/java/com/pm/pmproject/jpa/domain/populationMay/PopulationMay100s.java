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
@Table(name = "PopulationMay100s")
public class PopulationMay100s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_100")
    private Long popAgeM100;

    @Column(name = "pop_age_w_100")
    private Long popAgeW100;

    @Column(name = "pop_age_m_101")
    private Long popAgeM101;

    @Column(name = "pop_age_w_101")
    private Long popAgeW101;

    @Column(name = "pop_age_m_102")
    private Long popAgeM102;

    @Column(name = "pop_age_w_102")
    private Long popAgeW102;

    @Column(name = "pop_age_m_103")
    private Long popAgeM103;

    @Column(name = "pop_age_w_103")
    private Long popAgeW103;

    @Column(name = "pop_age_m_104")
    private Long popAgeM104;

    @Column(name = "pop_age_w_104")
    private Long popAgeW104;

    @Column(name = "pop_age_m_105")
    private Long popAgeM105;

    @Column(name = "pop_age_w_105")
    private Long popAgeW105;

    @Column(name = "pop_age_m_106")
    private Long popAgeM106;

    @Column(name = "pop_age_w_106")
    private Long popAgeW106;

    @Column(name = "pop_age_m_107")
    private Long popAgeM107;

    @Column(name = "pop_age_w_107")
    private Long popAgeW107;

    @Column(name = "pop_age_m_108")
    private Long popAgeM108;

    @Column(name = "pop_age_w_108")
    private Long popAgeW108;

    @Column(name = "pop_age_m_109")
    private Long popAgeM109;

    @Column(name = "pop_age_w_109")
    private Long popAgeW109;
}
