
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationJul.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationJulService {

    private final PopulationJulRepository populationJulRepository;
    private final PopulationJul0sRepository populationJul0sRepository;
    private final PopulationJul10sRepository populationJul10sRepository;
    private final PopulationJul20sRepository populationJul20sRepository;
    private final PopulationJul30sRepository populationJul30sRepository;
    private final PopulationJul40sRepository populationJul40sRepository;
    private final PopulationJul50sRepository populationJul50sRepository;
    private final PopulationJul60sRepository populationJul60sRepository;
    private final PopulationJul70sRepository populationJul70sRepository;
    private final PopulationJul80sRepository populationJul80sRepository;
    private final PopulationJul90sRepository populationJul90sRepository;
    private final PopulationJul100sRepository populationJul100sRepository;

    @Transactional
    public void populationJulUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationJulRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationJul0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationJul10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationJul20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationJul30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationJul40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationJul50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationJul60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationJul70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationJul80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationJul90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationJul100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());

            // total
            populationJulRepository.populationTotalInsert(commonRequestDto.getPopulationResultDto());

            populationJul0sRepository.populationTotalInsert(commonRequestDto.getPopulation0sDto());

            populationJul10sRepository.populationTotalInsert(commonRequestDto.getPopulation10sDto());

            populationJul20sRepository.populationTotalInsert(commonRequestDto.getPopulation20sDto());

            populationJul30sRepository.populationTotalInsert(commonRequestDto.getPopulation30sDto());

            populationJul40sRepository.populationTotalInsert(commonRequestDto.getPopulation40sDto());

            populationJul50sRepository.populationTotalInsert(commonRequestDto.getPopulation50sDto());

            populationJul60sRepository.populationTotalInsert(commonRequestDto.getPopulation60sDto());

            populationJul70sRepository.populationTotalInsert(commonRequestDto.getPopulation70sDto());

            populationJul80sRepository.populationTotalInsert(commonRequestDto.getPopulation80sDto());

            populationJul90sRepository.populationTotalInsert(commonRequestDto.getPopulation90sDto());

            populationJul100sRepository.populationTotalInsert(commonRequestDto.getPopulation100sDto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

