package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population80sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
 
    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("80세남자")
    private Long popAge80M;

    @JsonProperty("80세여자")
    private Long popAge80W;

    @JsonProperty("81세남자")
    private Long popAge81M;

    @JsonProperty("81세여자")
    private Long popAge81W;
  
    @JsonProperty("82세남자")
    private Long popAge82M;

    @JsonProperty("82세여자")
    private Long popAge82W;
  
    @JsonProperty("83세남자")
    private Long popAge83M;

    @JsonProperty("83세여자")
    private Long popAge83W;

    @JsonProperty("84세남자")
    private Long popAge84M;

    @JsonProperty("84세여자")
    private Long popAge84W;

    @JsonProperty("85세남자")
    private Long popAge85M;

    @JsonProperty("85세여자")
    private Long popAge85W;

    @JsonProperty("86세남자")
    private Long popAge86M;

    @JsonProperty("86세여자")
    private Long popAge86W;

    @JsonProperty("87세남자")
    private Long popAge87M;

    @JsonProperty("87세여자")
    private Long popAge87W;

    @JsonProperty("88세남자")
    private Long popAge88M;

    @JsonProperty("88세여자")
    private Long popAge88W;
  
    @JsonProperty("89세남자")
    private Long popAge89M;

    @JsonProperty("89세여자")
    private Long popAge89W;
}
