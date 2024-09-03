package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population20sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("20세남자")
    private Long popAge20M;

    @JsonProperty("20세여자")
    private Long popAge20W;

    @JsonProperty("21세남자")
    private Long popAge21M;

    @JsonProperty("21세여자")
    private Long popAge21W;
  
    @JsonProperty("22세남자")
    private Long popAge22M;

    @JsonProperty("22세여자")
    private Long popAge22W;
  
    @JsonProperty("23세남자")
    private Long popAge23M;

    @JsonProperty("23세여자")
    private Long popAge23W;

    @JsonProperty("24세남자")
    private Long popAge24M;

    @JsonProperty("24세여자")
    private Long popAge24W;

    @JsonProperty("25세남자")
    private Long popAge25M;

    @JsonProperty("25세여자")
    private Long popAge25W;

    @JsonProperty("26세남자")
    private Long popAge26M;

    @JsonProperty("26세여자")
    private Long popAge26W;

    @JsonProperty("27세남자")
    private Long popAge27M;

    @JsonProperty("27세여자")
    private Long popAge27W;

    @JsonProperty("28세남자")
    private Long popAge28M;

    @JsonProperty("28세여자")
    private Long popAge28W;
  
    @JsonProperty("29세남자")
    private Long popAge29M;

    @JsonProperty("29세여자")
    private Long popAge29W;
}
