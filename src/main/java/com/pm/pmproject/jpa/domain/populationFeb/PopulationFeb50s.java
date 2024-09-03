package com.pm.pmproject.jpa.domain.populationFeb;

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
@Table(name = "PopulationFeb_50s")
public class PopulationFeb50s {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "age_total")
    private Long ageTotal;

    @Column(name = "age_total_m")
    private Long ageTotalM;

    @Column(name = "age_total_w")
    private Long ageTotalW;

    @Column(name = "age_50_m")
    private Long age50M;

    @Column(name = "age_50_w")
    private Long age50W;

    @Column(name = "age_51_m")
    private Long age51M;

    @Column(name = "age_51_w")
    private Long age51W;

    @Column(name = "age_52_m")
    private Long age52M;

    @Column(name = "age_52_w")
    private Long age52W;

    @Column(name = "age_53_m")
    private Long age53M;

    @Column(name = "age_53_w")
    private Long age53W;

    @Column(name = "age_54_m")
    private Long age54M;

    @Column(name = "age_54_w")
    private Long age54W;

    @Column(name = "age_55_m")
    private Long age55M;

    @Column(name = "age_55_w")
    private Long age55W;

    @Column(name = "age_56_m")
    private Long age56M;

    @Column(name = "age_56_w")
    private Long age56W;

    @Column(name = "age_57_m")
    private Long age57M;

    @Column(name = "age_57_w")
    private Long age57W;

    @Column(name = "age_58_m")
    private Long age58M;

    @Column(name = "age_58_w")
    private Long age58W;

    @Column(name = "age_59_m")
    private Long age59M;

    @Column(name = "age_59_w")
    private Long age59W;
}
