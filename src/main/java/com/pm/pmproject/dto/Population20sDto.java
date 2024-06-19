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
  
    @JsonProperty("20세남자")
    private Long popAgeM20;

    @JsonProperty("20세여자")
    private Long popAgeW20;

    @JsonProperty("21세남자")
    private Long popAgeM21;

    @JsonProperty("21세여자")
    private Long popAgeW21;
  
    @JsonProperty("22세남자")
    private Long popAgeM22;

    @JsonProperty("22세여자")
    private Long popAgeW22;
  
    @JsonProperty("23세남자")
    private Long popAgeM23;

    @JsonProperty("23세여자")
    private Long popAgeW23;

    @JsonProperty("24세남자")
    private Long popAgeM24;

    @JsonProperty("24세여자")
    private Long popAgeW24;

    @JsonProperty("25세남자")
    private Long popAgeM25;

    @JsonProperty("25세여자")
    private Long popAgeW25;

    @JsonProperty("26세남자")
    private Long popAgeM26;

    @JsonProperty("26세여자")
    private Long popAgeW26;

    @JsonProperty("27세남자")
    private Long popAgeM27;

    @JsonProperty("27세여자")
    private Long popAgeW27;

    @JsonProperty("28세남자")
    private Long popAgeM28;

    @JsonProperty("28세여자")
    private Long popAgeW28;
  
    @JsonProperty("29세남자")
    private Long popAgeM29;

    @JsonProperty("29세여자")
    private Long popAgeW29;
}
