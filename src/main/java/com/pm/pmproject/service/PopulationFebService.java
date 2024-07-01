package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationFeb.*;
import com.pm.pmproject.jpa.repository.populationFeb.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationFebService {

    private final PopulationFebRepository populationFebRepository;
    private final PopulationFeb0sRepository populationFeb0sRepository;
    private final PopulationFeb10sRepository populationFeb10sRepository;
    private final PopulationFeb20sRepository populationFeb20sRepository;
    private final PopulationFeb30sRepository populationFeb30sRepository;
    private final PopulationFeb40sRepository populationFeb40sRepository;
    private final PopulationFeb50sRepository populationFeb50sRepository;
    private final PopulationFeb60sRepository populationFeb60sRepository;
    private final PopulationFeb70sRepository populationFeb70sRepository;
    private final PopulationFeb80sRepository populationFeb80sRepository;
    private final PopulationFeb90sRepository populationFeb90sRepository;
    private final PopulationFeb100sRepository populationFeb100sRepository;

    @Transactional
    public void populationFebUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationFebRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationFeb0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationFeb10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationFeb20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationFeb30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationFeb40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationFeb50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationFeb60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationFeb70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationFeb80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationFeb90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationFeb100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

