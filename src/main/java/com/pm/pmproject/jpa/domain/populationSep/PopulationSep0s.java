package com.pm.pmproject.jpa.domain.populationSep;

import com.pm.pmproject.dto.Population0sDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationSep_0s")
public class PopulationSep0s implements Persistable<Long> {

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

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationSep0s(Population0sDto population0sDto) {
        this.adminCode = population0sDto.getAdminCode();
        this.popAgeM0 = population0sDto.getPopAgeM0();
        this.popAgeW0 = population0sDto.getPopAgeW0();
        this.popAgeM1 = population0sDto.getPopAgeM1();
        this.popAgeW1 = population0sDto.getPopAgeW1();
        this.popAgeM2 = population0sDto.getPopAgeM2();
        this.popAgeW2 = population0sDto.getPopAgeW2();
        this.popAgeM3 = population0sDto.getPopAgeM3();
        this.popAgeW3 = population0sDto.getPopAgeW3();
        this.popAgeM4 = population0sDto.getPopAgeM4();
        this.popAgeW4 = population0sDto.getPopAgeW4();
        this.popAgeM5 = population0sDto.getPopAgeM5();
        this.popAgeW5 = population0sDto.getPopAgeW5();
        this.popAgeM6 = population0sDto.getPopAgeM6();
        this.popAgeW6 = population0sDto.getPopAgeW6();
        this.popAgeM7 = population0sDto.getPopAgeM7();
        this.popAgeW7 = population0sDto.getPopAgeW7();
        this.popAgeM8 = population0sDto.getPopAgeM8();
        this.popAgeW8 = population0sDto.getPopAgeW8();
        this.popAgeM9 = population0sDto.getPopAgeM9();
        this.popAgeW9 = population0sDto.getPopAgeW9();
    }
}
