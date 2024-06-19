package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population90sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("90세남자")
    private Long popAgeM90;

    @JsonProperty("90세여자")
    private Long popAgeW90;

    @JsonProperty("91세남자")
    private Long popAgeM91;

    @JsonProperty("91세여자")
    private Long popAgeW91;
  
    @JsonProperty("92세남자")
    private Long popAgeM92;

    @JsonProperty("92세여자")
    private Long popAgeW92;
  
    @JsonProperty("93세남자")
    private Long popAgeM93;

    @JsonProperty("93세여자")
    private Long popAgeW93;

    @JsonProperty("94세남자")
    private Long popAgeM94;

    @JsonProperty("94세여자")
    private Long popAgeW94;

    @JsonProperty("95세남자")
    private Long popAgeM95;

    @JsonProperty("95세여자")
    private Long popAgeW95;

    @JsonProperty("96세남자")
    private Long popAgeM96;

    @JsonProperty("96세여자")
    private Long popAgeW96;

    @JsonProperty("97세남자")
    private Long popAgeM97;

    @JsonProperty("97세여자")
    private Long popAgeW97;

    @JsonProperty("98세남자")
    private Long popAgeM98;

    @JsonProperty("98세여자")
    private Long popAgeW98;
  
    @JsonProperty("99세남자")
    private Long popAgeM99;

    @JsonProperty("99세여자")
    private Long popAgeW99;
}
