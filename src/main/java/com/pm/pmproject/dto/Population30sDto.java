package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population30sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;

    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("30세남자")
    private Long popAge30M;

    @JsonProperty("30세여자")
    private Long popAge30W;

    @JsonProperty("31세남자")
    private Long popAge31M;

    @JsonProperty("31세여자")
    private Long popAge31W;
  
    @JsonProperty("32세남자")
    private Long popAge32M;

    @JsonProperty("32세여자")
    private Long popAge32W;
  
    @JsonProperty("33세남자")
    private Long popAge33M;

    @JsonProperty("33세여자")
    private Long popAge33W;

    @JsonProperty("34세남자")
    private Long popAge34M;

    @JsonProperty("34세여자")
    private Long popAge34W;

    @JsonProperty("35세남자")
    private Long popAge35M;

    @JsonProperty("35세여자")
    private Long popAge35W;

    @JsonProperty("36세남자")
    private Long popAge36M;

    @JsonProperty("36세여자")
    private Long popAge36W;

    @JsonProperty("37세남자")
    private Long popAge37M;

    @JsonProperty("37세여자")
    private Long popAge37W;

    @JsonProperty("38세남자")
    private Long popAge38M;

    @JsonProperty("38세여자")
    private Long popAge38W;
  
    @JsonProperty("39세남자")
    private Long popAge39M;

    @JsonProperty("39세여자")
    private Long popAge39W;
}
