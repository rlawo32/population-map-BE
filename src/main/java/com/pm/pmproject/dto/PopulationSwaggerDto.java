package com.pm.pmproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PopulationSwaggerDto {

    @JsonProperty("summary")
    private String description;

    @JsonProperty("operationId")
    private String operationId;
}
