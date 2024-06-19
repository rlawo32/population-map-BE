package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Population1OsDto {

    @JsonProperty("행정기관코드")
    private Long adminCode;
  
    @JsonProperty("10세남자")
    private Long popAgeM10;

    @JsonProperty("10세여자")
    private Long popAgeW10;

    @JsonProperty("11세남자")
    private Long popAgeM11;

    @JsonProperty("11세여자")
    private Long popAgeW11;
  
    @JsonProperty("12세남자")
    private Long popAgeM12;

    @JsonProperty("12세여자")
    private Long popAgeW12;
  
    @JsonProperty("13세남자")
    private Long popAgeM13;

    @JsonProperty("13세여자")
    private Long popAgeW13;

    @JsonProperty("14세남자")
    private Long popAgeM14;

    @JsonProperty("14세여자")
    private Long popAgeW14;

    @JsonProperty("15세남자")
    private Long popAgeM15;

    @JsonProperty("15세여자")
    private Long popAgeW15;

    @JsonProperty("16세남자")
    private Long popAgeM16;

    @JsonProperty("16세여자")
    private Long popAgeW16;

    @JsonProperty("17세남자")
    private Long popAgeM17;

    @JsonProperty("17세여자")
    private Long popAgeW17;

    @JsonProperty("18세남자")
    private Long popAgeM18;

    @JsonProperty("18세여자")
    private Long popAgeW18;
  
    @JsonProperty("19세남자")
    private Long popAgeM19;

    @JsonProperty("19세여자")
    private Long popAgeW19;
}
