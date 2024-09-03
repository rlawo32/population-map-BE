package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population10sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;

    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("10세남자")
    private Long popAge10M;

    @JsonProperty("10세여자")
    private Long popAge10W;

    @JsonProperty("11세남자")
    private Long popAge11M;

    @JsonProperty("11세여자")
    private Long popAge11W;
  
    @JsonProperty("12세남자")
    private Long popAge12M;

    @JsonProperty("12세여자")
    private Long popAge12W;
  
    @JsonProperty("13세남자")
    private Long popAge13M;

    @JsonProperty("13세여자")
    private Long popAge13W;

    @JsonProperty("14세남자")
    private Long popAge14M;

    @JsonProperty("14세여자")
    private Long popAge14W;

    @JsonProperty("15세남자")
    private Long popAge15M;

    @JsonProperty("15세여자")
    private Long popAge15W;

    @JsonProperty("16세남자")
    private Long popAge16M;

    @JsonProperty("16세여자")
    private Long popAge16W;

    @JsonProperty("17세남자")
    private Long popAge17M;

    @JsonProperty("17세여자")
    private Long popAge17W;

    @JsonProperty("18세남자")
    private Long popAge18M;

    @JsonProperty("18세여자")
    private Long popAge18W;
  
    @JsonProperty("19세남자")
    private Long popAge19M;

    @JsonProperty("19세여자")
    private Long popAge19W;
}
