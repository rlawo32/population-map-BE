package com.pm.pmproject.jpa.domain.populationFeb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "PopulationFeb_total")
public class PopulationFebTotal {

    @Id
    @Column(name = "pop_seq")
    private String popSeq;

    @Column(name = "pop_place") // 지명
    private String popPlace;

    @Column(name = "pop_total") // 총 인원
    private Long popTotal;

    @Column(name = "pop_total_m") // 남자 총 인원
    private Long popTotalM;

    @Column(name = "pop_total_w") // 여자 총 인원
    private Long popTotalW;
}
