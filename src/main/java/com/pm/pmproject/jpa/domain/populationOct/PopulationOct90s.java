package com.pm.pmproject.jpa.domain.populationOct;

import com.pm.pmproject.dto.Population90sDto;
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
@Table(name = "PopulationOct_90s")
public class PopulationOct90s implements Persistable<Long> {

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

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationOct90s(Population90sDto population90sDto) {
        this.adminCode = population90sDto.getAdminCode();
        this.popAgeM90 = population90sDto.getPopAgeM90();
        this.popAgeW90 = population90sDto.getPopAgeW90();
        this.popAgeM91 = population90sDto.getPopAgeM91();
        this.popAgeW91 = population90sDto.getPopAgeW91();
        this.popAgeM92 = population90sDto.getPopAgeM92();
        this.popAgeW92 = population90sDto.getPopAgeW92();
        this.popAgeM93 = population90sDto.getPopAgeM93();
        this.popAgeW93 = population90sDto.getPopAgeW93();
        this.popAgeM94 = population90sDto.getPopAgeM94();
        this.popAgeW94 = population90sDto.getPopAgeW94();
        this.popAgeM95 = population90sDto.getPopAgeM95();
        this.popAgeW95 = population90sDto.getPopAgeW95();
        this.popAgeM96 = population90sDto.getPopAgeM96();
        this.popAgeW96 = population90sDto.getPopAgeW96();
        this.popAgeM97 = population90sDto.getPopAgeM97();
        this.popAgeW97 = population90sDto.getPopAgeW97();
        this.popAgeM98 = population90sDto.getPopAgeM98();
        this.popAgeW98 = population90sDto.getPopAgeW98();
        this.popAgeM99 = population90sDto.getPopAgeM99();
        this.popAgeW99 = population90sDto.getPopAgeW99();
    }
}
