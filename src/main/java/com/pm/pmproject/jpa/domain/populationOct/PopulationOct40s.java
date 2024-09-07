package com.pm.pmproject.jpa.domain.populationOct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationOct_40s")
public class PopulationOct40s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_40_m")
    private Long age40M;

    @Column(name = "age_40_w")
    private Long age40W;

    @Column(name = "age_41_m")
    private Long age41M;

    @Column(name = "age_41_w")
    private Long age41W;

    @Column(name = "age_42_m")
    private Long age42M;

    @Column(name = "age_42_w")
    private Long age42W;

    @Column(name = "age_43_m")
    private Long age43M;

    @Column(name = "age_43_w")
    private Long age43W;

    @Column(name = "age_44_m")
    private Long age44M;

    @Column(name = "age_44_w")
    private Long age44W;

    @Column(name = "age_45_m")
    private Long age45M;

    @Column(name = "age_45_w")
    private Long age45W;

    @Column(name = "age_46_m")
    private Long age46M;

    @Column(name = "age_46_w")
    private Long age46W;

    @Column(name = "age_47_m")
    private Long age47M;

    @Column(name = "age_47_w")
    private Long age47W;

    @Column(name = "age_48_m")
    private Long age48M;

    @Column(name = "age_48_w")
    private Long age48W;

    @Column(name = "age_49_m")
    private Long age49M;

    @Column(name = "age_49_w")
    private Long age49W;
}
