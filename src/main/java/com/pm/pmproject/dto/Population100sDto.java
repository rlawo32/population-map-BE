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
  
    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("100세남자")
    private Long popAge100M;

    @JsonProperty("100세여자")
    private Long popAge100W;

    @JsonProperty("101세남자")
    private Long popAge101M;

    @JsonProperty("101세여자")
    private Long popAge101W;
  
    @JsonProperty("102세남자")
    private Long popAge102M;

    @JsonProperty("102세여자")
    private Long popAge102W;
  
    @JsonProperty("103세남자")
    private Long popAge103M;

    @JsonProperty("103세여자")
    private Long popAge103W;

    @JsonProperty("104세남자")
    private Long popAge104M;

    @JsonProperty("104세여자")
    private Long popAge104W;

    @JsonProperty("105세남자")
    private Long popAge105M;

    @JsonProperty("105세여자")
    private Long popAge105W;

    @JsonProperty("106세남자")
    private Long popAge106M;

    @JsonProperty("106세여자")
    private Long popAge106W;

    @JsonProperty("107세남자")
    private Long popAge107M;

    @JsonProperty("107세여자")
    private Long popAge107W;

    @JsonProperty("108세남자")
    private Long popAge108M;

    @JsonProperty("108세여자")
    private Long popAge108W;
  
    @JsonProperty("109세남자")
    private Long popAge109M;

    @JsonProperty("109세여자")
    private Long popAge109W;
}
