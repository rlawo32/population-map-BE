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

    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("90세남자")
    private Long popAge90M;

    @JsonProperty("90세여자")
    private Long popAge90W;

    @JsonProperty("91세남자")
    private Long popAge91M;

    @JsonProperty("91세여자")
    private Long popAge91W;
  
    @JsonProperty("92세남자")
    private Long popAge92M;

    @JsonProperty("92세여자")
    private Long popAge92W;
  
    @JsonProperty("93세남자")
    private Long popAge93M;

    @JsonProperty("93세여자")
    private Long popAge93W;

    @JsonProperty("94세남자")
    private Long popAge94M;

    @JsonProperty("94세여자")
    private Long popAge94W;

    @JsonProperty("95세남자")
    private Long popAge95M;

    @JsonProperty("95세여자")
    private Long popAge95W;

    @JsonProperty("96세남자")
    private Long popAge96M;

    @JsonProperty("96세여자")
    private Long popAge96W;

    @JsonProperty("97세남자")
    private Long popAge97M;

    @JsonProperty("97세여자")
    private Long popAge97W;

    @JsonProperty("98세남자")
    private Long popAge98M;

    @JsonProperty("98세여자")
    private Long popAge98W;
  
    @JsonProperty("99세남자")
    private Long popAge99M;

    @JsonProperty("99세여자")
    private Long popAge99W;
}
