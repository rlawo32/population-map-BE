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
  
    @JsonProperty("30세남자")
    private Long popAgeM30;

    @JsonProperty("30세여자")
    private Long popAgeW30;

    @JsonProperty("31세남자")
    private Long popAgeM31;

    @JsonProperty("31세여자")
    private Long popAgeW31;
  
    @JsonProperty("32세남자")
    private Long popAgeM32;

    @JsonProperty("32세여자")
    private Long popAgeW32;
  
    @JsonProperty("33세남자")
    private Long popAgeM33;

    @JsonProperty("33세여자")
    private Long popAgeW33;

    @JsonProperty("34세남자")
    private Long popAgeM34;

    @JsonProperty("34세여자")
    private Long popAgeW34;

    @JsonProperty("35세남자")
    private Long popAgeM35;

    @JsonProperty("35세여자")
    private Long popAgeW35;

    @JsonProperty("36세남자")
    private Long popAgeM36;

    @JsonProperty("36세여자")
    private Long popAgeW36;

    @JsonProperty("37세남자")
    private Long popAgeM37;

    @JsonProperty("37세여자")
    private Long popAgeW37;

    @JsonProperty("38세남자")
    private Long popAgeM38;

    @JsonProperty("38세여자")
    private Long popAgeW38;
  
    @JsonProperty("39세남자")
    private Long popAgeM39;

    @JsonProperty("39세여자")
    private Long popAgeW39;
}
