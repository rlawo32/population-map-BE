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
  
    @JsonProperty("0세남자")
    private Long popAgeM0;

    @JsonProperty("0세여자")
    private Long popAgeW0;

    @JsonProperty("1세남자")
    private Long popAgeM1;

    @JsonProperty("1세여자")
    private Long popAgeW1;
  
    @JsonProperty("2세남자")
    private Long popAgeM2;

    @JsonProperty("2세여자")
    private Long popAgeW2;
  
    @JsonProperty("3세남자")
    private Long popAgeM3;

    @JsonProperty("3세여자")
    private Long popAgeW3;

    @JsonProperty("4세남자")
    private Long popAgeM4;

    @JsonProperty("4세여자")
    private Long popAgeW4;

    @JsonProperty("5세남자")
    private Long popAgeM5;

    @JsonProperty("5세여자")
    private Long popAgeW5;

    @JsonProperty("6세남자")
    private Long popAgeM6;

    @JsonProperty("6세여자")
    private Long popAgeW6;

    @JsonProperty("7세남자")
    private Long popAgeM7;

    @JsonProperty("7세여자")
    private Long popAgeW7;

    @JsonProperty("8세남자")
    private Long popAgeM8;

    @JsonProperty("8세여자")
    private Long popAgeW8;
  
    @JsonProperty("9세남자")
    private Long popAgeM9;

    @JsonProperty("9세여자")
    private Long popAgeW9;
}
