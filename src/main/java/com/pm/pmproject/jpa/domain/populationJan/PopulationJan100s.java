package com.pm.pmproject.jpa.domain.populationJan;

import com.pm.pmproject.dto.Population100sDto;
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
@Table(name = "PopulationJan_100s")
public class PopulationJan100s implements Persistable<Long> {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_100")
    private Long popAgeM100;

    @Column(name = "pop_age_w_100")
    private Long popAgeW100;

    @Column(name = "pop_age_m_101")
    private Long popAgeM101;

    @Column(name = "pop_age_w_101")
    private Long popAgeW101;

    @Column(name = "pop_age_m_102")
    private Long popAgeM102;

    @Column(name = "pop_age_w_102")
    private Long popAgeW102;

    @Column(name = "pop_age_m_103")
    private Long popAgeM103;

    @Column(name = "pop_age_w_103")
    private Long popAgeW103;

    @Column(name = "pop_age_m_104")
    private Long popAgeM104;

    @Column(name = "pop_age_w_104")
    private Long popAgeW104;

    @Column(name = "pop_age_m_105")
    private Long popAgeM105;

    @Column(name = "pop_age_w_105")
    private Long popAgeW105;

    @Column(name = "pop_age_m_106")
    private Long popAgeM106;

    @Column(name = "pop_age_w_106")
    private Long popAgeW106;

    @Column(name = "pop_age_m_107")
    private Long popAgeM107;

    @Column(name = "pop_age_w_107")
    private Long popAgeW107;

    @Column(name = "pop_age_m_108")
    private Long popAgeM108;

    @Column(name = "pop_age_w_108")
    private Long popAgeW108;

    @Column(name = "pop_age_m_109")
    private Long popAgeM109;

    @Column(name = "pop_age_w_109")
    private Long popAgeW109;

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationJan100s(Population100sDto population100sDto) {
        this.adminCode = population100sDto.getAdminCode();
        this.popAgeM100 = population100sDto.getPopAgeM100();
        this.popAgeW100 = population100sDto.getPopAgeW100();
        this.popAgeM101 = population100sDto.getPopAgeM101();
        this.popAgeW101 = population100sDto.getPopAgeW101();
        this.popAgeM102 = population100sDto.getPopAgeM102();
        this.popAgeW102 = population100sDto.getPopAgeW102();
        this.popAgeM103 = population100sDto.getPopAgeM103();
        this.popAgeW103 = population100sDto.getPopAgeW103();
        this.popAgeM104 = population100sDto.getPopAgeM104();
        this.popAgeW104 = population100sDto.getPopAgeW104();
        this.popAgeM105 = population100sDto.getPopAgeM105();
        this.popAgeW105 = population100sDto.getPopAgeW105();
        this.popAgeM106 = population100sDto.getPopAgeM106();
        this.popAgeW106 = population100sDto.getPopAgeW106();
        this.popAgeM107 = population100sDto.getPopAgeM107();
        this.popAgeW107 = population100sDto.getPopAgeW107();
        this.popAgeM108 = population100sDto.getPopAgeM108();
        this.popAgeW108 = population100sDto.getPopAgeW108();
        this.popAgeM109 = population100sDto.getPopAgeM109();
        this.popAgeW109 = population100sDto.getPopAgeW109();
    }
}
