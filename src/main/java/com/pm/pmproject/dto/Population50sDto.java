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
 
    @JsonProperty("시도명")
    private String nameCity;

    @JsonProperty("시군구명")
    private String nameWard;
  
    @JsonProperty("50세남자")
    private Long popAge50M;

    @JsonProperty("50세여자")
    private Long popAge50W;

    @JsonProperty("51세남자")
    private Long popAge51M;

    @JsonProperty("51세여자")
    private Long popAge51W;
  
    @JsonProperty("52세남자")
    private Long popAge52M;

    @JsonProperty("52세여자")
    private Long popAge52W;
  
    @JsonProperty("53세남자")
    private Long popAge53M;

    @JsonProperty("53세여자")
    private Long popAge53W;

    @JsonProperty("54세남자")
    private Long popAge54M;

    @JsonProperty("54세여자")
    private Long popAge54W;

    @JsonProperty("55세남자")
    private Long popAge55M;

    @JsonProperty("55세여자")
    private Long popAge55W;

    @JsonProperty("56세남자")
    private Long popAge56M;

    @JsonProperty("56세여자")
    private Long popAge56W;

    @JsonProperty("57세남자")
    private Long popAge57M;

    @JsonProperty("57세여자")
    private Long popAge57W;

    @JsonProperty("58세남자")
    private Long popAge58M;

    @JsonProperty("58세여자")
    private Long popAge58W;
  
    @JsonProperty("59세남자")
    private Long popAge59M;

    @JsonProperty("59세여자")
    private Long popAge59W;
}
