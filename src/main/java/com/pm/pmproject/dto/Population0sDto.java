package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population0sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;

    @JsonProperty("0세남자")
    private Long popAge0M;

    @JsonProperty("0세여자")
    private Long popAge0W;

    @JsonProperty("1세남자")
    private Long popAge1M;

    @JsonProperty("1세여자")
    private Long popAge1W;
  
    @JsonProperty("2세남자")
    private Long popAge2M;

    @JsonProperty("2세여자")
    private Long popAge2W;
  
    @JsonProperty("3세남자")
    private Long popAge3M;

    @JsonProperty("3세여자")
    private Long popAge3W;

    @JsonProperty("4세남자")
    private Long popAge4M;

    @JsonProperty("4세여자")
    private Long popAge4W;

    @JsonProperty("5세남자")
    private Long popAge5M;

    @JsonProperty("5세여자")
    private Long popAge5W;

    @JsonProperty("6세남자")
    private Long popAge6M;

    @JsonProperty("6세여자")
    private Long popAge6W;

    @JsonProperty("7세남자")
    private Long popAge7M;

    @JsonProperty("7세여자")
    private Long popAge7W;

    @JsonProperty("8세남자")
    private Long popAge8M;

    @JsonProperty("8세여자")
    private Long popAge8W;
  
    @JsonProperty("9세남자")
    private Long popAge9M;

    @JsonProperty("9세여자")
    private Long popAge9W;
}
