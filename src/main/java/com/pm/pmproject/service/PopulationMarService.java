package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationMar.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationMarService {

    private final PopulationMarRepository populationMarRepository;
    private final PopulationMar0sRepository populationMar0sRepository;
    private final PopulationMar10sRepository populationMar10sRepository;
    private final PopulationMar20sRepository populationMar20sRepository;
    private final PopulationMar30sRepository populationMar30sRepository;
    private final PopulationMar40sRepository populationMar40sRepository;
    private final PopulationMar50sRepository populationMar50sRepository;
    private final PopulationMar60sRepository populationMar60sRepository;
    private final PopulationMar70sRepository populationMar70sRepository;
    private final PopulationMar80sRepository populationMar80sRepository;
    private final PopulationMar90sRepository populationMar90sRepository;
    private final PopulationMar100sRepository populationMar100sRepository;

    @Transactional
    public void populationMarUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationMarRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationMar0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationMar10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationMar20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationMar30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationMar40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationMar50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationMar60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationMar70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationMar80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationMar90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationMar100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

