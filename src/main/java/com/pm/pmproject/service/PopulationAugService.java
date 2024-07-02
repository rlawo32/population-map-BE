
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationAug.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationAugService {

    private final PopulationAugRepository populationAugRepository;
    private final PopulationAug0sRepository populationAug0sRepository;
    private final PopulationAug10sRepository populationAug10sRepository;
    private final PopulationAug20sRepository populationAug20sRepository;
    private final PopulationAug30sRepository populationAug30sRepository;
    private final PopulationAug40sRepository populationAug40sRepository;
    private final PopulationAug50sRepository populationAug50sRepository;
    private final PopulationAug60sRepository populationAug60sRepository;
    private final PopulationAug70sRepository populationAug70sRepository;
    private final PopulationAug80sRepository populationAug80sRepository;
    private final PopulationAug90sRepository populationAug90sRepository;
    private final PopulationAug100sRepository populationAug100sRepository;

    @Transactional
    public void populationAugUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationAugRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationAug0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationAug10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationAug20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationAug30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationAug40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationAug50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationAug60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationAug70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationAug80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationAug90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationAug100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

