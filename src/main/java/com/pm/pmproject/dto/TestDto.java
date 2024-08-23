package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {

    //private Long id;
    //private Long testValue1;
    //private String testValue2;
    private String Name;
    private String SubName;
    private Long Cost;
}
