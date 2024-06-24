package com.pm.pmproject.jpa.domain.populationJun;

import com.pm.pmproject.dto.Population20sDto;
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
@Table(name = "PopulationJun_20s")
public class PopulationJun20s implements Persistable<Long> {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_20")
    private Long popAgeM20;

    @Column(name = "pop_age_w_20")
    private Long popAgeW20;

    @Column(name = "pop_age_m_21")
    private Long popAgeM21;

    @Column(name = "pop_age_w_21")
    private Long popAgeW21;

    @Column(name = "pop_age_m_22")
    private Long popAgeM22;

    @Column(name = "pop_age_w_22")
    private Long popAgeW22;

    @Column(name = "pop_age_m_23")
    private Long popAgeM23;

    @Column(name = "pop_age_w_23")
    private Long popAgeW23;

    @Column(name = "pop_age_m_24")
    private Long popAgeM24;

    @Column(name = "pop_age_w_24")
    private Long popAgeW24;

    @Column(name = "pop_age_m_25")
    private Long popAgeM25;

    @Column(name = "pop_age_w_25")
    private Long popAgeW25;

    @Column(name = "pop_age_m_26")
    private Long popAgeM26;

    @Column(name = "pop_age_w_26")
    private Long popAgeW26;

    @Column(name = "pop_age_m_27")
    private Long popAgeM27;

    @Column(name = "pop_age_w_27")
    private Long popAgeW27;

    @Column(name = "pop_age_m_28")
    private Long popAgeM28;

    @Column(name = "pop_age_w_28")
    private Long popAgeW28;

    @Column(name = "pop_age_m_29")
    private Long popAgeM29;

    @Column(name = "pop_age_w_29")
    private Long popAgeW29;

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationJun20s(Population20sDto population20sDto) {
        this.adminCode = population20sDto.getAdminCode();
        this.popAgeM20 = population20sDto.getPopAgeM20();
        this.popAgeW20 = population20sDto.getPopAgeW20();
        this.popAgeM21 = population20sDto.getPopAgeM21();
        this.popAgeW21 = population20sDto.getPopAgeW21();
        this.popAgeM22 = population20sDto.getPopAgeM22();
        this.popAgeW22 = population20sDto.getPopAgeW22();
        this.popAgeM23 = population20sDto.getPopAgeM23();
        this.popAgeW23 = population20sDto.getPopAgeW23();
        this.popAgeM24 = population20sDto.getPopAgeM24();
        this.popAgeW24 = population20sDto.getPopAgeW24();
        this.popAgeM25 = population20sDto.getPopAgeM25();
        this.popAgeW25 = population20sDto.getPopAgeW25();
        this.popAgeM26 = population20sDto.getPopAgeM26();
        this.popAgeW26 = population20sDto.getPopAgeW26();
        this.popAgeM27 = population20sDto.getPopAgeM27();
        this.popAgeW27 = population20sDto.getPopAgeW27();
        this.popAgeM28 = population20sDto.getPopAgeM28();
        this.popAgeW28 = population20sDto.getPopAgeW28();
        this.popAgeM29 = population20sDto.getPopAgeM29();
        this.popAgeW29 = population20sDto.getPopAgeW29();
    }

}
