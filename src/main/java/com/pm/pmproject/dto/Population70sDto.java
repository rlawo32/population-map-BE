package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population70sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("70세남자")
    private Long popAge70M;

    @JsonProperty("70세여자")
    private Long popAge70W;

    @JsonProperty("71세남자")
    private Long popAge71M;

    @JsonProperty("71세여자")
    private Long popAge71W;
  
    @JsonProperty("72세남자")
    private Long popAge72M;

    @JsonProperty("72세여자")
    private Long popAge72W;
  
    @JsonProperty("73세남자")
    private Long popAge73M;

    @JsonProperty("73세여자")
    private Long popAge73W;

    @JsonProperty("74세남자")
    private Long popAge74M;

    @JsonProperty("74세여자")
    private Long popAge74W;

    @JsonProperty("75세남자")
    private Long popAge75M;

    @JsonProperty("75세여자")
    private Long popAge75W;

    @JsonProperty("76세남자")
    private Long popAge76M;

    @JsonProperty("76세여자")
    private Long popAge76W;

    @JsonProperty("77세남자")
    private Long popAge77M;

    @JsonProperty("77세여자")
    private Long popAge77W;

    @JsonProperty("78세남자")
    private Long popAge78M;

    @JsonProperty("78세여자")
    private Long popAge78W;
  
    @JsonProperty("79세남자")
    private Long popAge79M;

    @JsonProperty("79세여자")
    private Long popAge79W;
}
