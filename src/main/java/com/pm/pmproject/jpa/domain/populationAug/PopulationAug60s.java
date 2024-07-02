package com.pm.pmproject.jpa.domain.populationAug;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationAug_60s")
public class PopulationAug60s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_total")
    private Long popAgeTotal;

    @Column(name = "pop_age_m_total")
    private Long popAgeMTotal;

    @Column(name = "pop_age_w_total")
    private Long popAgeWTotal;

    @Column(name = "pop_age_m_60")
    private Long popAgeM60;

    @Column(name = "pop_age_w_60")
    private Long popAgeW60;

    @Column(name = "pop_age_m_61")
    private Long popAgeM61;

    @Column(name = "pop_age_w_61")
    private Long popAgeW61;

    @Column(name = "pop_age_m_62")
    private Long popAgeM62;

    @Column(name = "pop_age_w_62")
    private Long popAgeW62;

    @Column(name = "pop_age_m_63")
    private Long popAgeM63;

    @Column(name = "pop_age_w_63")
    private Long popAgeW63;

    @Column(name = "pop_age_m_64")
    private Long popAgeM64;

    @Column(name = "pop_age_w_64")
    private Long popAgeW64;

    @Column(name = "pop_age_m_65")
    private Long popAgeM65;

    @Column(name = "pop_age_w_65")
    private Long popAgeW65;

    @Column(name = "pop_age_m_66")
    private Long popAgeM66;

    @Column(name = "pop_age_w_66")
    private Long popAgeW66;

    @Column(name = "pop_age_m_67")
    private Long popAgeM67;

    @Column(name = "pop_age_w_67")
    private Long popAgeW67;

    @Column(name = "pop_age_m_68")
    private Long popAgeM68;

    @Column(name = "pop_age_w_68")
    private Long popAgeW68;

    @Column(name = "pop_age_m_69")
    private Long popAgeM69;

    @Column(name = "pop_age_w_69")
    private Long popAgeW69;
}
