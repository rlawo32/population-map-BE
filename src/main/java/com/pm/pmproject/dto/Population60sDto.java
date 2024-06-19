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
  
    @JsonProperty("60세남자")
    private Long popAgeM60;

    @JsonProperty("60세여자")
    private Long popAgeW60;

    @JsonProperty("61세남자")
    private Long popAgeM61;

    @JsonProperty("61세여자")
    private Long popAgeW61;
  
    @JsonProperty("62세남자")
    private Long popAgeM62;

    @JsonProperty("62세여자")
    private Long popAgeW62;
  
    @JsonProperty("63세남자")
    private Long popAgeM63;

    @JsonProperty("63세여자")
    private Long popAgeW63;

    @JsonProperty("64세남자")
    private Long popAgeM64;

    @JsonProperty("64세여자")
    private Long popAgeW64;

    @JsonProperty("65세남자")
    private Long popAgeM65;

    @JsonProperty("65세여자")
    private Long popAgeW65;

    @JsonProperty("66세남자")
    private Long popAgeM66;

    @JsonProperty("66세여자")
    private Long popAgeW66;

    @JsonProperty("67세남자")
    private Long popAgeM67;

    @JsonProperty("67세여자")
    private Long popAgeW67;

    @JsonProperty("68세남자")
    private Long popAgeM68;

    @JsonProperty("68세여자")
    private Long popAgeW68;
  
    @JsonProperty("69세남자")
    private Long popAgeM69;

    @JsonProperty("69세여자")
    private Long popAgeW69;
}
