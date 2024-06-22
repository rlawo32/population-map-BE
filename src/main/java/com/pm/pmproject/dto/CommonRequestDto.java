package com.pm.pmproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "set")
public class CommonRequestDto {

    private boolean result;
    private List<PopulationResultDto> populationResultDto;
    private List<Population0sDto> population0sDto;
    private List<Population10sDto> population10sDto;
    private List<Population20sDto> population20sDto;
    private List<Population30sDto> population30sDto;
    private List<Population40sDto> population40sDto;
    private List<Population50sDto> population50sDto;
    private List<Population60sDto> population60sDto;
    private List<Population70sDto> population70sDto;
    private List<Population80sDto> population80sDto;
    private List<Population90sDto> population90sDto;
    private List<Population100sDto> population100sDto;

    public static CommonRequestDto setApiResultList(List<PopulationResultDto> dto1, List<Population0sDto> dto2, List<Population10sDto> dto3,
                                                    List<Population20sDto> dto4, List<Population30sDto> dto5, List<Population40sDto> dto6,
                                                    List<Population50sDto> dto7, List<Population60sDto> dto8, List<Population70sDto> dto9,
                                                    List<Population80sDto> dto10, List<Population90sDto> dto11, List<Population100sDto> dto12) {
        return CommonRequestDto.set(true, dto1, dto2, dto3, dto4, dto5, dto6, dto7, dto8, dto9, dto10, dto11, dto12);
    }
}

