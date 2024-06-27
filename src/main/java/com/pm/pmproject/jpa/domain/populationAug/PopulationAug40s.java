package com.pm.pmproject.jpa.domain.populationAug;

import com.pm.pmproject.dto.Population40sDto;
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
@Table(name = "PopulationAug_40s")
public class PopulationAug40s implements Persistable<Long> {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

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

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationAug40s(Population40sDto population40sDto) {
        this.adminCode = population40sDto.getAdminCode();
        this.popAgeM40 = population40sDto.getPopAgeM40();
        this.popAgeW40 = population40sDto.getPopAgeW40();
        this.popAgeM41 = population40sDto.getPopAgeM41();
        this.popAgeW41 = population40sDto.getPopAgeW41();
        this.popAgeM42 = population40sDto.getPopAgeM42();
        this.popAgeW42 = population40sDto.getPopAgeW42();
        this.popAgeM43 = population40sDto.getPopAgeM43();
        this.popAgeW43 = population40sDto.getPopAgeW43();
        this.popAgeM44 = population40sDto.getPopAgeM44();
        this.popAgeW44 = population40sDto.getPopAgeW44();
        this.popAgeM45 = population40sDto.getPopAgeM45();
        this.popAgeW45 = population40sDto.getPopAgeW45();
        this.popAgeM46 = population40sDto.getPopAgeM46();
        this.popAgeW46 = population40sDto.getPopAgeW46();
        this.popAgeM47 = population40sDto.getPopAgeM47();
        this.popAgeW47 = population40sDto.getPopAgeW47();
        this.popAgeM48 = population40sDto.getPopAgeM48();
        this.popAgeW48 = population40sDto.getPopAgeW48();
        this.popAgeM49 = population40sDto.getPopAgeM49();
        this.popAgeW49 = population40sDto.getPopAgeW49();
    }

}
