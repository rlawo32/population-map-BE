package com.pm.pmproject.jpa.domain.populationJan;

import com.pm.pmproject.dto.PopulationResultDto;
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

    @Column(name = "standard_date") // 집계날짜
    private String standardDate;

    @Column(name = "name_city") // 특별시, 도
    private String nameCity; 

    @Column(name = "name_ward") // 시, 군, 구
    private String nameWard;

    @Column(name = "name_town") // 읍, 면, 동
    private String nameTown;

    @Column(name = "pop_total") // 해당 지역 전체 인구수
    private Long popTotal;

    @Column(name = "pop_m_total") // 해당 지역 남자 전체 인구수
    private Long popMTotal;

    @Column(name = "pop_w_total") // 해당 지역 여자 전체 인구수
    private Long popWTotal;

    public PopulationJan(PopulationResultDto populationResultDto) {
        this.adminCode = populationResultDto.getAdminCode();
        this.standardDate = populationResultDto.getStandardDate();
        this.nameCity = populationResultDto.getNameCity();
        this.nameWard = populationResultDto.getNameWard();
        this.nameTown = populationResultDto.getNameTown();
        this.popTotal = populationResultDto.getPopTotal();
        this.popMTotal = populationResultDto.getPopMTotal();
        this.popWTotal = populationResultDto.getPopWTotal();
    }
}
