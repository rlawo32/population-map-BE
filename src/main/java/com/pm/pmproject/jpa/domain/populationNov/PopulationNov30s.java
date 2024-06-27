package com.pm.pmproject.jpa.domain.populationNov;

import com.pm.pmproject.dto.Population30sDto;
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
@Table(name = "PopulationNov_30s")
public class PopulationNov30s implements Persistable<Long> {

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

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationNov30s(Population30sDto population30sDto) {
        this.adminCode = population30sDto.getAdminCode();
        this.popAgeM30 = population30sDto.getPopAgeM30();
        this.popAgeW30 = population30sDto.getPopAgeW30();
        this.popAgeM31 = population30sDto.getPopAgeM31();
        this.popAgeW31 = population30sDto.getPopAgeW31();
        this.popAgeM32 = population30sDto.getPopAgeM32();
        this.popAgeW32 = population30sDto.getPopAgeW32();
        this.popAgeM33 = population30sDto.getPopAgeM33();
        this.popAgeW33 = population30sDto.getPopAgeW33();
        this.popAgeM34 = population30sDto.getPopAgeM34();
        this.popAgeW34 = population30sDto.getPopAgeW34();
        this.popAgeM35 = population30sDto.getPopAgeM35();
        this.popAgeW35 = population30sDto.getPopAgeW35();
        this.popAgeM36 = population30sDto.getPopAgeM36();
        this.popAgeW36 = population30sDto.getPopAgeW36();
        this.popAgeM37 = population30sDto.getPopAgeM37();
        this.popAgeW37 = population30sDto.getPopAgeW37();
        this.popAgeM38 = population30sDto.getPopAgeM38();
        this.popAgeW38 = population30sDto.getPopAgeW38();
        this.popAgeM39 = population30sDto.getPopAgeM39();
        this.popAgeW39 = population30sDto.getPopAgeW39();
    }
}
