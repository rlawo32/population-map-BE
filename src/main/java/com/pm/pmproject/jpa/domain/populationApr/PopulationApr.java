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
@Table(name = "PopulationApr")
public class PopulationApr {

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
}
