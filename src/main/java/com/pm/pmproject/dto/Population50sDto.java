package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population50sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("50세남자")
    private Long popAgeM50;

    @JsonProperty("50세여자")
    private Long popAgeW50;

    @JsonProperty("51세남자")
    private Long popAgeM51;

    @JsonProperty("51세여자")
    private Long popAgeW51;
  
    @JsonProperty("52세남자")
    private Long popAgeM52;

    @JsonProperty("52세여자")
    private Long popAgeW52;
  
    @JsonProperty("53세남자")
    private Long popAgeM53;

    @JsonProperty("53세여자")
    private Long popAgeW53;

    @JsonProperty("54세남자")
    private Long popAgeM54;

    @JsonProperty("54세여자")
    private Long popAgeW54;

    @JsonProperty("55세남자")
    private Long popAgeM55;

    @JsonProperty("55세여자")
    private Long popAgeW55;

    @JsonProperty("56세남자")
    private Long popAgeM56;

    @JsonProperty("56세여자")
    private Long popAgeW56;

    @JsonProperty("57세남자")
    private Long popAgeM57;

    @JsonProperty("57세여자")
    private Long popAgeW57;

    @JsonProperty("58세남자")
    private Long popAgeM58;

    @JsonProperty("58세여자")
    private Long popAgeW58;
  
    @JsonProperty("59세남자")
    private Long popAgeM59;

    @JsonProperty("59세여자")
    private Long popAgeW59;
}
