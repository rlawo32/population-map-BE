package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population100sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("100세남자")
    private Long popAgeM100;

    @JsonProperty("100세여자")
    private Long popAgeW100;

    @JsonProperty("101세남자")
    private Long popAgeM101;

    @JsonProperty("101세여자")
    private Long popAgeW101;
  
    @JsonProperty("102세남자")
    private Long popAgeM102;

    @JsonProperty("102세여자")
    private Long popAgeW102;
  
    @JsonProperty("103세남자")
    private Long popAgeM103;

    @JsonProperty("103세여자")
    private Long popAgeW103;

    @JsonProperty("104세남자")
    private Long popAgeM104;

    @JsonProperty("104세여자")
    private Long popAgeW104;

    @JsonProperty("105세남자")
    private Long popAgeM105;

    @JsonProperty("105세여자")
    private Long popAgeW105;

    @JsonProperty("106세남자")
    private Long popAgeM106;

    @JsonProperty("106세여자")
    private Long popAgeW106;

    @JsonProperty("107세남자")
    private Long popAgeM107;

    @JsonProperty("107세여자")
    private Long popAgeW107;

    @JsonProperty("108세남자")
    private Long popAgeM108;

    @JsonProperty("108세여자")
    private Long popAgeW108;
  
    @JsonProperty("109세남자")
    private Long popAgeM109;

    @JsonProperty("109세여자")
    private Long popAgeW109;
}
