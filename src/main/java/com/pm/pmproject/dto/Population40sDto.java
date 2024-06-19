package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population40sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("40세남자")
    private Long popAgeM40;

    @JsonProperty("40세여자")
    private Long popAgeW40;

    @JsonProperty("41세남자")
    private Long popAgeM41;

    @JsonProperty("41세여자")
    private Long popAgeW41;
  
    @JsonProperty("42세남자")
    private Long popAgeM42;

    @JsonProperty("42세여자")
    private Long popAgeW42;
  
    @JsonProperty("43세남자")
    private Long popAgeM43;

    @JsonProperty("43세여자")
    private Long popAgeW43;

    @JsonProperty("44세남자")
    private Long popAgeM44;

    @JsonProperty("44세여자")
    private Long popAgeW44;

    @JsonProperty("45세남자")
    private Long popAgeM45;

    @JsonProperty("45세여자")
    private Long popAgeW45;

    @JsonProperty("46세남자")
    private Long popAgeM46;

    @JsonProperty("46세여자")
    private Long popAgeW46;

    @JsonProperty("47세남자")
    private Long popAgeM47;

    @JsonProperty("47세여자")
    private Long popAgeW47;

    @JsonProperty("48세남자")
    private Long popAgeM48;

    @JsonProperty("48세여자")
    private Long popAgeW48;
  
    @JsonProperty("49세남자")
    private Long popAgeM49;

    @JsonProperty("49세여자")
    private Long popAgeW49;
}
