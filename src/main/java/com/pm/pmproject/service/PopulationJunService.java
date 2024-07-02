package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationJun.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationJunService {

    private final PopulationJunRepository populationJunRepository;
    private final PopulationJun0sRepository populationJun0sRepository;
    private final PopulationJun10sRepository populationJun10sRepository;
    private final PopulationJun20sRepository populationJun20sRepository;
    private final PopulationJun30sRepository populationJun30sRepository;
    private final PopulationJun40sRepository populationJun40sRepository;
    private final PopulationJun50sRepository populationJun50sRepository;
    private final PopulationJun60sRepository populationJun60sRepository;
    private final PopulationJun70sRepository populationJun70sRepository;
    private final PopulationJun80sRepository populationJun80sRepository;
    private final PopulationJun90sRepository populationJun90sRepository;
    private final PopulationJun100sRepository populationJun100sRepository;

    @Transactional
    public void populationJunUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationJunRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationJun0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationJun10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationJun20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationJun30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationJun40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationJun50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationJun60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationJun70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationJun80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationJun90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationJun100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

