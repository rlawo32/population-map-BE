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
@Table(name = "PopulationAug0s")
public class PopulationAug0s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_0")
    private Long popAgeM0;

    @Column(name = "pop_age_w_0")
    private Long popAgeW0;

    @Column(name = "pop_age_m_1")
    private Long popAgeM1;

    @Column(name = "pop_age_w_1")
    private Long popAgeW1;
    
    @Column(name = "pop_age_m_2")
    private Long popAgeM2;

    @Column(name = "pop_age_w_2")
    private Long popAgeW2;
 
    @Column(name = "pop_age_m_3")
    private Long popAgeM3;

    @Column(name = "pop_age_w_3")
    private Long popAgeW3;
 
    @Column(name = "pop_age_m_4")
    private Long popAgeM4;

    @Column(name = "pop_age_w_4")
    private Long popAgeW4;
 
    @Column(name = "pop_age_m_5")
    private Long popAgeM5;

    @Column(name = "pop_age_w_5")
    private Long popAgeW5;
 
    @Column(name = "pop_age_m_6")
    private Long popAgeM6;

    @Column(name = "pop_age_w_6")
    private Long popAgeW6;
 
    @Column(name = "pop_age_m_7")
    private Long popAgeM7;

    @Column(name = "pop_age_w_7")
    private Long popAgeW7;
 
    @Column(name = "pop_age_m_8")
    private Long popAgeM8;

    @Column(name = "pop_age_w_8")
    private Long popAgeW8;
 
    @Column(name = "pop_age_m_9")
    private Long popAgeM9;
    
    @Column(name = "pop_age_w_9")
    private Long popAgeW9;
 
}
