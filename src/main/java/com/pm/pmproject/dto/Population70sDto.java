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
  
    @JsonProperty("70세남자")
    private Long popAgeM70;

    @JsonProperty("70세여자")
    private Long popAgeW70;

    @JsonProperty("71세남자")
    private Long popAgeM71;

    @JsonProperty("71세여자")
    private Long popAgeW71;
  
    @JsonProperty("72세남자")
    private Long popAgeM72;

    @JsonProperty("72세여자")
    private Long popAgeW72;
  
    @JsonProperty("73세남자")
    private Long popAgeM73;

    @JsonProperty("73세여자")
    private Long popAgeW73;

    @JsonProperty("74세남자")
    private Long popAgeM74;

    @JsonProperty("74세여자")
    private Long popAgeW74;

    @JsonProperty("75세남자")
    private Long popAgeM75;

    @JsonProperty("75세여자")
    private Long popAgeW75;

    @JsonProperty("76세남자")
    private Long popAgeM76;

    @JsonProperty("76세여자")
    private Long popAgeW76;

    @JsonProperty("77세남자")
    private Long popAgeM77;

    @JsonProperty("77세여자")
    private Long popAgeW77;

    @JsonProperty("78세남자")
    private Long popAgeM78;

    @JsonProperty("78세여자")
    private Long popAgeW78;
  
    @JsonProperty("79세남자")
    private Long popAgeM79;

    @JsonProperty("79세여자")
    private Long popAgeW79;
}
