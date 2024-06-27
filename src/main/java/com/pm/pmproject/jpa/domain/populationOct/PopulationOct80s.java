package com.pm.pmproject.jpa.domain.populationOct;

import com.pm.pmproject.dto.Population80sDto;
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
@Table(name = "PopulationOct_80s")
public class PopulationOct80s implements Persistable<Long> {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_80")
    private Long popAgeM80;

    @Column(name = "pop_age_w_80")
    private Long popAgeW80;

    @Column(name = "pop_age_m_81")
    private Long popAgeM81;

    @Column(name = "pop_age_w_81")
    private Long popAgeW81;

    @Column(name = "pop_age_m_82")
    private Long popAgeM82;

    @Column(name = "pop_age_w_82")
    private Long popAgeW82;

    @Column(name = "pop_age_m_83")
    private Long popAgeM83;

    @Column(name = "pop_age_w_83")
    private Long popAgeW83;

    @Column(name = "pop_age_m_84")
    private Long popAgeM84;

    @Column(name = "pop_age_w_84")
    private Long popAgeW84;

    @Column(name = "pop_age_m_85")
    private Long popAgeM85;

    @Column(name = "pop_age_w_85")
    private Long popAgeW85;

    @Column(name = "pop_age_m_86")
    private Long popAgeM86;

    @Column(name = "pop_age_w_86")
    private Long popAgeW86;

    @Column(name = "pop_age_m_87")
    private Long popAgeM87;

    @Column(name = "pop_age_w_87")
    private Long popAgeW87;

    @Column(name = "pop_age_m_88")
    private Long popAgeM88;

    @Column(name = "pop_age_w_88")
    private Long popAgeW88;

    @Column(name = "pop_age_m_89")
    private Long popAgeM89;

    @Column(name = "pop_age_w_89")
    private Long popAgeW89;

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationOct80s(Population80sDto population80sDto) {
        this.adminCode = population80sDto.getAdminCode();
        this.popAgeM80 = population80sDto.getPopAgeM80();
        this.popAgeW80 = population80sDto.getPopAgeW80();
        this.popAgeM81 = population80sDto.getPopAgeM81();
        this.popAgeW81 = population80sDto.getPopAgeW81();
        this.popAgeM82 = population80sDto.getPopAgeM82();
        this.popAgeW82 = population80sDto.getPopAgeW82();
        this.popAgeM83 = population80sDto.getPopAgeM83();
        this.popAgeW83 = population80sDto.getPopAgeW83();
        this.popAgeM84 = population80sDto.getPopAgeM84();
        this.popAgeW84 = population80sDto.getPopAgeW84();
        this.popAgeM85 = population80sDto.getPopAgeM85();
        this.popAgeW85 = population80sDto.getPopAgeW85();
        this.popAgeM86 = population80sDto.getPopAgeM86();
        this.popAgeW86 = population80sDto.getPopAgeW86();
        this.popAgeM87 = population80sDto.getPopAgeM87();
        this.popAgeW87 = population80sDto.getPopAgeW87();
        this.popAgeM88 = population80sDto.getPopAgeM88();
        this.popAgeW88 = population80sDto.getPopAgeW88();
        this.popAgeM89 = population80sDto.getPopAgeM89();
        this.popAgeW89 = population80sDto.getPopAgeW89();
    }
}
