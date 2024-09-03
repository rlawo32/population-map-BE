package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population40sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
   
    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("40세남자")
    private Long popAge40M;

    @JsonProperty("40세여자")
    private Long popAge40W;

    @JsonProperty("41세남자")
    private Long popAge41M;

    @JsonProperty("41세여자")
    private Long popAge41W;
  
    @JsonProperty("42세남자")
    private Long popAge42M;

    @JsonProperty("42세여자")
    private Long popAge42W;
  
    @JsonProperty("43세남자")
    private Long popAge43M;

    @JsonProperty("43세여자")
    private Long popAge43W;

    @JsonProperty("44세남자")
    private Long popAge44M;

    @JsonProperty("44세여자")
    private Long popAge44W;

    @JsonProperty("45세남자")
    private Long popAge45M;

    @JsonProperty("45세여자")
    private Long popAge45W;

    @JsonProperty("46세남자")
    private Long popAge46M;

    @JsonProperty("46세여자")
    private Long popAge46W;

    @JsonProperty("47세남자")
    private Long popAge47M;

    @JsonProperty("47세여자")
    private Long popAge47W;

    @JsonProperty("48세남자")
    private Long popAge48M;

    @JsonProperty("48세여자")
    private Long popAge48W;
  
    @JsonProperty("49세남자")
    private Long popAge49M;

    @JsonProperty("49세여자")
    private Long popAge49W;
}
