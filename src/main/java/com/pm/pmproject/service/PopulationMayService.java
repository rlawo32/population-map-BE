package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationMay.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationMayService {

    private final PopulationMayRepository populationMayRepository;
    private final PopulationMay0sRepository populationMay0sRepository;
    private final PopulationMay10sRepository populationMay10sRepository;
    private final PopulationMay20sRepository populationMay20sRepository;
    private final PopulationMay30sRepository populationMay30sRepository;
    private final PopulationMay40sRepository populationMay40sRepository;
    private final PopulationMay50sRepository populationMay50sRepository;
    private final PopulationMay60sRepository populationMay60sRepository;
    private final PopulationMay70sRepository populationMay70sRepository;
    private final PopulationMay80sRepository populationMay80sRepository;
    private final PopulationMay90sRepository populationMay90sRepository;
    private final PopulationMay100sRepository populationMay100sRepository;

    @Transactional
    public void testSelect() {
        populationMayRepository.batchSelect();
    }

    @Transactional
    public void populationMayUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationMayRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationMay0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationMay10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationMay20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationMay30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationMay40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationMay50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationMay60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationMay70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationMay80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationMay90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationMay100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

