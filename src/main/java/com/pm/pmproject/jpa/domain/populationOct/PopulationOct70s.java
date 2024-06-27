package com.pm.pmproject.jpa.domain.populationOct;

import com.pm.pmproject.dto.Population70sDto;
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
@Table(name = "PopulationOct_70s")
public class PopulationOct70s implements Persistable<Long> {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_70")
    private Long popAgeM70;

    @Column(name = "pop_age_w_70")
    private Long popAgeW70;

    @Column(name = "pop_age_m_71")
    private Long popAgeM71;

    @Column(name = "pop_age_w_71")
    private Long popAgeW71;

    @Column(name = "pop_age_m_72")
    private Long popAgeM72;

    @Column(name = "pop_age_w_72")
    private Long popAgeW72;

    @Column(name = "pop_age_m_73")
    private Long popAgeM73;

    @Column(name = "pop_age_w_73")
    private Long popAgeW73;

    @Column(name = "pop_age_m_74")
    private Long popAgeM74;

    @Column(name = "pop_age_w_74")
    private Long popAgeW74;

    @Column(name = "pop_age_m_75")
    private Long popAgeM75;

    @Column(name = "pop_age_w_75")
    private Long popAgeW75;

    @Column(name = "pop_age_m_76")
    private Long popAgeM76;

    @Column(name = "pop_age_w_76")
    private Long popAgeW76;

    @Column(name = "pop_age_m_77")
    private Long popAgeM77;

    @Column(name = "pop_age_w_77")
    private Long popAgeW77;

    @Column(name = "pop_age_m_78")
    private Long popAgeM78;

    @Column(name = "pop_age_w_78")
    private Long popAgeW78;

    @Column(name = "pop_age_m_79")
    private Long popAgeM79;

    @Column(name = "pop_age_w_79")
    private Long popAgeW79;

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationOct70s(Population70sDto population70sDto) {
        this.adminCode = population70sDto.getAdminCode();
        this.popAgeM70 = population70sDto.getPopAgeM70();
        this.popAgeW70 = population70sDto.getPopAgeW70();
        this.popAgeM71 = population70sDto.getPopAgeM71();
        this.popAgeW71 = population70sDto.getPopAgeW71();
        this.popAgeM72 = population70sDto.getPopAgeM72();
        this.popAgeW72 = population70sDto.getPopAgeW72();
        this.popAgeM73 = population70sDto.getPopAgeM73();
        this.popAgeW73 = population70sDto.getPopAgeW73();
        this.popAgeM74 = population70sDto.getPopAgeM74();
        this.popAgeW74 = population70sDto.getPopAgeW74();
        this.popAgeM75 = population70sDto.getPopAgeM75();
        this.popAgeW75 = population70sDto.getPopAgeW75();
        this.popAgeM76 = population70sDto.getPopAgeM76();
        this.popAgeW76 = population70sDto.getPopAgeW76();
        this.popAgeM77 = population70sDto.getPopAgeM77();
        this.popAgeW77 = population70sDto.getPopAgeW77();
        this.popAgeM78 = population70sDto.getPopAgeM78();
        this.popAgeW78 = population70sDto.getPopAgeW78();
        this.popAgeM79 = population70sDto.getPopAgeM79();
        this.popAgeW79 = population70sDto.getPopAgeW79();
    }
}
