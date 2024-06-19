package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population80sDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("80세남자")
    private Long popAgeM80;

    @JsonProperty("80세여자")
    private Long popAgeW80;

    @JsonProperty("81세남자")
    private Long popAgeM81;

    @JsonProperty("81세여자")
    private Long popAgeW81;
  
    @JsonProperty("82세남자")
    private Long popAgeM82;

    @JsonProperty("82세여자")
    private Long popAgeW82;
  
    @JsonProperty("83세남자")
    private Long popAgeM83;

    @JsonProperty("83세여자")
    private Long popAgeW83;

    @JsonProperty("84세남자")
    private Long popAgeM84;

    @JsonProperty("84세여자")
    private Long popAgeW84;

    @JsonProperty("85세남자")
    private Long popAgeM85;

    @JsonProperty("85세여자")
    private Long popAgeW85;

    @JsonProperty("86세남자")
    private Long popAgeM86;

    @JsonProperty("86세여자")
    private Long popAgeW86;

    @JsonProperty("87세남자")
    private Long popAgeM87;

    @JsonProperty("87세여자")
    private Long popAgeW87;

    @JsonProperty("88세남자")
    private Long popAgeM88;

    @JsonProperty("88세여자")
    private Long popAgeW88;
  
    @JsonProperty("89세남자")
    private Long popAgeM89;

    @JsonProperty("89세여자")
    private Long popAgeW89;
}
