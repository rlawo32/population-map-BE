package com.pm.pmproject.jpa.domain.populationJan;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationJan")
public class PopulationJan {

    @Id
    @Column(name = "admin_code")
    private Long adminCode;

    @Column(name = "standard_date")
    private String standardDate;

    @Column(name = "name_city")
    private String nameCity;

    @Column(name = "name_ward")
    private String nameWard;

    @Column(name = "name_town")
    private String nameTown;

    @Column(name = "pop_total")
    private Long popTotal;

    @Column(name = "pop_man_total")
    private Long popManTotal;

    @Column(name = "pop_woman_total")
    private Long popWomanTotal;
}
