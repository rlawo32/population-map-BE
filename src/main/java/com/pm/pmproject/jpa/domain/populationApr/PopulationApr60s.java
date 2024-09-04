package com.pm.pmproject.jpa.domain.populationApr;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationApr_60s")
public class PopulationApr60s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_60_m")
    private Long age60M;

    @Column(name = "age_60_w")
    private Long age60W;

    @Column(name = "age_61_m")
    private Long age61M;

    @Column(name = "age_61_w")
    private Long age61W;

    @Column(name = "age_62_m")
    private Long age62M;

    @Column(name = "age_62_w")
    private Long age62W;

    @Column(name = "age_63_m")
    private Long age63M;

    @Column(name = "age_63_w")
    private Long age63W;

    @Column(name = "age_64_m")
    private Long age64M;

    @Column(name = "age_64_w")
    private Long age64W;

    @Column(name = "age_65_m")
    private Long age65M;

    @Column(name = "age_65_w")
    private Long age65W;

    @Column(name = "age_66_m")
    private Long age66M;

    @Column(name = "age_66_w")
    private Long age66W;

    @Column(name = "age_67_m")
    private Long age67M;

    @Column(name = "age_67_w")
    private Long age67W;

    @Column(name = "age_68_m")
    private Long age68M;

    @Column(name = "age_68_w")
    private Long age68W;

    @Column(name = "age_69_m")
    private Long age69M;

    @Column(name = "age_69_w")
    private Long age69W;
}
