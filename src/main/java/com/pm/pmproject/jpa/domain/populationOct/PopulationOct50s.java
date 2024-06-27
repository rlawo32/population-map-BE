package com.pm.pmproject.jpa.domain.populationOct;

import com.pm.pmproject.dto.Population50sDto;
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
@Table(name = "PopulationOct_50s")
public class PopulationOct50s implements Persistable<Long> {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "pop_age_m_50")
    private Long popAgeM50;

    @Column(name = "pop_age_w_50")
    private Long popAgeW50;

    @Column(name = "pop_age_m_51")
    private Long popAgeM51;

    @Column(name = "pop_age_w_51")
    private Long popAgeW51;

    @Column(name = "pop_age_m_52")
    private Long popAgeM52;

    @Column(name = "pop_age_w_52")
    private Long popAgeW52;

    @Column(name = "pop_age_m_53")
    private Long popAgeM53;

    @Column(name = "pop_age_w_53")
    private Long popAgeW53;

    @Column(name = "pop_age_m_54")
    private Long popAgeM54;

    @Column(name = "pop_age_w_54")
    private Long popAgeW54;

    @Column(name = "pop_age_m_55")
    private Long popAgeM55;

    @Column(name = "pop_age_w_55")
    private Long popAgeW55;

    @Column(name = "pop_age_m_56")
    private Long popAgeM56;

    @Column(name = "pop_age_w_56")
    private Long popAgeW56;

    @Column(name = "pop_age_m_57")
    private Long popAgeM57;

    @Column(name = "pop_age_w_57")
    private Long popAgeW57;

    @Column(name = "pop_age_m_58")
    private Long popAgeM58;

    @Column(name = "pop_age_w_58")
    private Long popAgeW58;

    @Column(name = "pop_age_m_59")
    private Long popAgeM59;

    @Column(name = "pop_age_w_59")
    private Long popAgeW59;

    @Override
    public boolean isNew() {
        return true;
    }

    @Override
    public Long getId() {
        return this.adminCode;
    }

    public PopulationOct50s(Population50sDto population50sDto) {
        this.adminCode = population50sDto.getAdminCode();
        this.popAgeM50 = population50sDto.getPopAgeM50();
        this.popAgeW50 = population50sDto.getPopAgeW50();
        this.popAgeM51 = population50sDto.getPopAgeM51();
        this.popAgeW51 = population50sDto.getPopAgeW51();
        this.popAgeM52 = population50sDto.getPopAgeM52();
        this.popAgeW52 = population50sDto.getPopAgeW52();
        this.popAgeM53 = population50sDto.getPopAgeM53();
        this.popAgeW53 = population50sDto.getPopAgeW53();
        this.popAgeM54 = population50sDto.getPopAgeM54();
        this.popAgeW54 = population50sDto.getPopAgeW54();
        this.popAgeM55 = population50sDto.getPopAgeM55();
        this.popAgeW55 = population50sDto.getPopAgeW55();
        this.popAgeM56 = population50sDto.getPopAgeM56();
        this.popAgeW56 = population50sDto.getPopAgeW56();
        this.popAgeM57 = population50sDto.getPopAgeM57();
        this.popAgeW57 = population50sDto.getPopAgeW57();
        this.popAgeM58 = population50sDto.getPopAgeM58();
        this.popAgeW58 = population50sDto.getPopAgeW58();
        this.popAgeM59 = population50sDto.getPopAgeM59();
        this.popAgeW59 = population50sDto.getPopAgeW59();
    }
}
