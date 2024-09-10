
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationDec.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationDecService {

    private final PopulationDecRepository populationDecRepository;
    private final PopulationDec0sRepository populationDec0sRepository;
    private final PopulationDec10sRepository populationDec10sRepository;
    private final PopulationDec20sRepository populationDec20sRepository;
    private final PopulationDec30sRepository populationDec30sRepository;
    private final PopulationDec40sRepository populationDec40sRepository;
    private final PopulationDec50sRepository populationDec50sRepository;
    private final PopulationDec60sRepository populationDec60sRepository;
    private final PopulationDec70sRepository populationDec70sRepository;
    private final PopulationDec80sRepository populationDec80sRepository;
    private final PopulationDec90sRepository populationDec90sRepository;
    private final PopulationDec100sRepository populationDec100sRepository;

    @Transactional
    public void populationDecUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationDecRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationDec0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationDec10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationDec20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationDec30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationDec40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationDec50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationDec60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationDec70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationDec80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationDec90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationDec100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());

            // total
            populationDecRepository.populationTotalInsert(commonRequestDto.getPopulationResultDto());

            populationDec0sRepository.populationTotalInsert(commonRequestDto.getPopulation0sDto());

            populationDec10sRepository.populationTotalInsert(commonRequestDto.getPopulation10sDto());

            populationDec20sRepository.populationTotalInsert(commonRequestDto.getPopulation20sDto());

            populationDec30sRepository.populationTotalInsert(commonRequestDto.getPopulation30sDto());

            populationDec40sRepository.populationTotalInsert(commonRequestDto.getPopulation40sDto());

            populationDec50sRepository.populationTotalInsert(commonRequestDto.getPopulation50sDto());

            populationDec60sRepository.populationTotalInsert(commonRequestDto.getPopulation60sDto());

            populationDec70sRepository.populationTotalInsert(commonRequestDto.getPopulation70sDto());

            populationDec80sRepository.populationTotalInsert(commonRequestDto.getPopulation80sDto());

            populationDec90sRepository.populationTotalInsert(commonRequestDto.getPopulation90sDto());

            populationDec100sRepository.populationTotalInsert(commonRequestDto.getPopulation100sDto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

