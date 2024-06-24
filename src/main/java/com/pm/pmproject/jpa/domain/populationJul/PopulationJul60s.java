package com.pm.pmproject.jpa.domain.populationJul;

import com.pm.pmproject.dto.Population60sDto;
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
@Table(name = "PopulationJul_60s")
public class PopulationJul60s implements Persistable<Long> {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

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

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationJul60s(Population60sDto population60sDto) {
        this.adminCode = population60sDto.getAdminCode();
        this.popAgeM60 = population60sDto.getPopAgeM60();
        this.popAgeW60 = population60sDto.getPopAgeW60();
        this.popAgeM61 = population60sDto.getPopAgeM61();
        this.popAgeW61 = population60sDto.getPopAgeW61();
        this.popAgeM62 = population60sDto.getPopAgeM62();
        this.popAgeW62 = population60sDto.getPopAgeW62();
        this.popAgeM63 = population60sDto.getPopAgeM63();
        this.popAgeW63 = population60sDto.getPopAgeW63();
        this.popAgeM64 = population60sDto.getPopAgeM64();
        this.popAgeW64 = population60sDto.getPopAgeW64();
        this.popAgeM65 = population60sDto.getPopAgeM65();
        this.popAgeW65 = population60sDto.getPopAgeW65();
        this.popAgeM66 = population60sDto.getPopAgeM66();
        this.popAgeW66 = population60sDto.getPopAgeW66();
        this.popAgeM67 = population60sDto.getPopAgeM67();
        this.popAgeW67 = population60sDto.getPopAgeW67();
        this.popAgeM68 = population60sDto.getPopAgeM68();
        this.popAgeW68 = population60sDto.getPopAgeW68();
        this.popAgeM69 = population60sDto.getPopAgeM69();
        this.popAgeW69 = population60sDto.getPopAgeW69();
    }
}
