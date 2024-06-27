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
@Table(name = "PopulationJan_40s")
public class PopulationJan40s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_total")
    private Long popAgeTotal;

    @Column(name = "pop_age_m_total")
    private Long popAgeMTotal;

    @Column(name = "pop_age_w_total")
    private Long popAgeWTotal;

    @Column(name = "pop_age_m_40")
    private Long popAgeM40;

    @Column(name = "pop_age_w_40")
    private Long popAgeW40;

    @Column(name = "pop_age_m_41")
    private Long popAgeM41;

    @Column(name = "pop_age_w_41")
    private Long popAgeW41;

    @Column(name = "pop_age_m_42")
    private Long popAgeM42;

    @Column(name = "pop_age_w_42")
    private Long popAgeW42;

    @Column(name = "pop_age_m_43")
    private Long popAgeM43;

    @Column(name = "pop_age_w_43")
    private Long popAgeW43;

    @Column(name = "pop_age_m_44")
    private Long popAgeM44;

    @Column(name = "pop_age_w_44")
    private Long popAgeW44;

    @Column(name = "pop_age_m_45")
    private Long popAgeM45;

    @Column(name = "pop_age_w_45")
    private Long popAgeW45;

    @Column(name = "pop_age_m_46")
    private Long popAgeM46;

    @Column(name = "pop_age_w_46")
    private Long popAgeW46;

    @Column(name = "pop_age_m_47")
    private Long popAgeM47;

    @Column(name = "pop_age_w_47")
    private Long popAgeW47;

    @Column(name = "pop_age_m_48")
    private Long popAgeM48;

    @Column(name = "pop_age_w_48")
    private Long popAgeW48;

    @Column(name = "pop_age_m_49")
    private Long popAgeM49;

    @Column(name = "pop_age_w_49")
    private Long popAgeW49;
}
