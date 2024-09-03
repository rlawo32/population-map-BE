package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population60sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
 
    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("60세남자")
    private Long popAge60M;

    @JsonProperty("60세여자")
    private Long popAge60W;

    @JsonProperty("61세남자")
    private Long popAge61M;

    @JsonProperty("61세여자")
    private Long popAge61W;
  
    @JsonProperty("62세남자")
    private Long popAge62M;

    @JsonProperty("62세여자")
    private Long popAge62W;
  
    @JsonProperty("63세남자")
    private Long popAge63M;

    @JsonProperty("63세여자")
    private Long popAge63W;

    @JsonProperty("64세남자")
    private Long popAge64M;

    @JsonProperty("64세여자")
    private Long popAge64W;

    @JsonProperty("65세남자")
    private Long popAge65M;

    @JsonProperty("65세여자")
    private Long popAge65W;

    @JsonProperty("66세남자")
    private Long popAge66M;

    @JsonProperty("66세여자")
    private Long popAge66W;

    @JsonProperty("67세남자")
    private Long popAge67M;

    @JsonProperty("67세여자")
    private Long popAge67W;

    @JsonProperty("68세남자")
    private Long popAge68M;

    @JsonProperty("68세여자")
    private Long popAge68W;
  
    @JsonProperty("69세남자")
    private Long popAge69M;

    @JsonProperty("69세여자")
    private Long popAge69W;
}
