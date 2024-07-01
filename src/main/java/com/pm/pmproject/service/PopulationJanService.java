package com.pm.pmproject.service;

import com.pm.pmproject.dto.*;
import com.pm.pmproject.jpa.repository.populationJan.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationJanService {

    private final PopulationJanRepository populationJanRepository;
    private final PopulationJan0sRepository populationJan0sRepository;
    private final PopulationJan10sRepository populationJan10sRepository;
    private final PopulationJan20sRepository populationJan20sRepository;
    private final PopulationJan30sRepository populationJan30sRepository;
    private final PopulationJan40sRepository populationJan40sRepository;
    private final PopulationJan50sRepository populationJan50sRepository;
    private final PopulationJan60sRepository populationJan60sRepository;
    private final PopulationJan70sRepository populationJan70sRepository;
    private final PopulationJan80sRepository populationJan80sRepository;
    private final PopulationJan90sRepository populationJan90sRepository;
    private final PopulationJan100sRepository populationJan100sRepository;

    @Transactional
    public void populationJanUpdate(CommonRequestDto commonRequestDto) {
        try {
//            populationJanRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationJan0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

//            populationJan10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());
//
//            populationJan20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());
//
//            populationJan30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());
//
//            populationJan40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());
//
//            populationJan50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());
//
//            populationJan60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());
//
//            populationJan70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());
//
//            populationJan80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());
//
//            populationJan90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());
//
//            populationJan100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

