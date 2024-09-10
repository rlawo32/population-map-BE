
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationNov.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationNovService {

    private final PopulationNovRepository populationNovRepository;
    private final PopulationNov0sRepository populationNov0sRepository;
    private final PopulationNov10sRepository populationNov10sRepository;
    private final PopulationNov20sRepository populationNov20sRepository;
    private final PopulationNov30sRepository populationNov30sRepository;
    private final PopulationNov40sRepository populationNov40sRepository;
    private final PopulationNov50sRepository populationNov50sRepository;
    private final PopulationNov60sRepository populationNov60sRepository;
    private final PopulationNov70sRepository populationNov70sRepository;
    private final PopulationNov80sRepository populationNov80sRepository;
    private final PopulationNov90sRepository populationNov90sRepository;
    private final PopulationNov100sRepository populationNov100sRepository;

    @Transactional
    public void populationNovUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationNovRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationNov0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationNov10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationNov20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationNov30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationNov40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationNov50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationNov60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationNov70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationNov80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationNov90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationNov100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());

            // total
            populationNovRepository.populationTotalInsert(commonRequestDto.getPopulationResultDto());

            populationNov0sRepository.populationTotalInsert(commonRequestDto.getPopulation0sDto());

            populationNov10sRepository.populationTotalInsert(commonRequestDto.getPopulation10sDto());

            populationNov20sRepository.populationTotalInsert(commonRequestDto.getPopulation20sDto());

            populationNov30sRepository.populationTotalInsert(commonRequestDto.getPopulation30sDto());

            populationNov40sRepository.populationTotalInsert(commonRequestDto.getPopulation40sDto());

            populationNov50sRepository.populationTotalInsert(commonRequestDto.getPopulation50sDto());

            populationNov60sRepository.populationTotalInsert(commonRequestDto.getPopulation60sDto());

            populationNov70sRepository.populationTotalInsert(commonRequestDto.getPopulation70sDto());

            populationNov80sRepository.populationTotalInsert(commonRequestDto.getPopulation80sDto());

            populationNov90sRepository.populationTotalInsert(commonRequestDto.getPopulation90sDto());

            populationNov100sRepository.populationTotalInsert(commonRequestDto.getPopulation100sDto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

