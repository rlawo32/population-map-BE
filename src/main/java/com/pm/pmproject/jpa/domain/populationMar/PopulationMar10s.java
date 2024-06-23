package com.pm.pmproject.jpa.domain.populationMar;

import com.pm.pmproject.dto.Population10sDto;
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
@Table(name = "PopulationMar_10s")
public class PopulationMar10s implements Persistable<Long> {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_10")
    private Long popAgeM10;

    @Column(name = "pop_age_w_10")
    private Long popAgeW10;

    @Column(name = "pop_age_m_11")
    private Long popAgeM11;

    @Column(name = "pop_age_w_11")
    private Long popAgeW11;

    @Column(name = "pop_age_m_12")
    private Long popAgeM12;

    @Column(name = "pop_age_w_12")
    private Long popAgeW12;

    @Column(name = "pop_age_m_13")
    private Long popAgeM13;

    @Column(name = "pop_age_w_13")
    private Long popAgeW13;

    @Column(name = "pop_age_m_14")
    private Long popAgeM14;

    @Column(name = "pop_age_w_14")
    private Long popAgeW14;

    @Column(name = "pop_age_m_15")
    private Long popAgeM15;

    @Column(name = "pop_age_w_15")
    private Long popAgeW15;

    @Column(name = "pop_age_m_16")
    private Long popAgeM16;

    @Column(name = "pop_age_w_16")
    private Long popAgeW16;

    @Column(name = "pop_age_m_17")
    private Long popAgeM17;

    @Column(name = "pop_age_w_17")
    private Long popAgeW17;

    @Column(name = "pop_age_m_18")
    private Long popAgeM18;

    @Column(name = "pop_age_w_18")
    private Long popAgeW18;

    @Column(name = "pop_age_m_19")
    private Long popAgeM19;

    @Column(name = "pop_age_w_19")
    private Long popAgeW19;

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationMar10s (Population10sDto population10sDto) {
        this.adminCode = population10sDto.getAdminCode();
        this.popAgeM10 = population10sDto.getPopAgeM10();
        this.popAgeW10 = population10sDto.getPopAgeW10();
        this.popAgeM11 = population10sDto.getPopAgeM11();
        this.popAgeW11 = population10sDto.getPopAgeW11();
        this.popAgeM12 = population10sDto.getPopAgeM12();
        this.popAgeW12 = population10sDto.getPopAgeW12();
        this.popAgeM13 = population10sDto.getPopAgeM13();
        this.popAgeW13 = population10sDto.getPopAgeW13();
        this.popAgeM14 = population10sDto.getPopAgeM14();
        this.popAgeW14 = population10sDto.getPopAgeW14();
        this.popAgeM15 = population10sDto.getPopAgeM15();
        this.popAgeW15 = population10sDto.getPopAgeW15();
        this.popAgeM16 = population10sDto.getPopAgeM16();
        this.popAgeW16 = population10sDto.getPopAgeW16();
        this.popAgeM17 = population10sDto.getPopAgeM17();
        this.popAgeW17 = population10sDto.getPopAgeW17();
        this.popAgeM18 = population10sDto.getPopAgeM18();
        this.popAgeW18 = population10sDto.getPopAgeW18();
        this.popAgeM19 = population10sDto.getPopAgeM19();
        this.popAgeW19 = population10sDto.getPopAgeW19();
    }
}
