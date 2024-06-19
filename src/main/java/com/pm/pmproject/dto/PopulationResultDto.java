package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopulationResultDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;

    @JsonProperty("기준연월")
    private String standardDate;

    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;

    @JsonProperty("읍면동명")
    private String nameTown;

    @JsonProperty("계")
    private Long popTotal;

    @JsonProperty("남자")
    private Long popMTotal;

    @JsonProperty("여자")
    private Long popWTotal;
}
