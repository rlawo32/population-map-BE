package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationApr.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationAprService {

    private final PopulationAprRepository populationAprRepository;
    private final PopulationApr0sRepository populationApr0sRepository;
    private final PopulationApr10sRepository populationApr10sRepository;
    private final PopulationApr20sRepository populationApr20sRepository;
    private final PopulationApr30sRepository populationApr30sRepository;
    private final PopulationApr40sRepository populationApr40sRepository;
    private final PopulationApr50sRepository populationApr50sRepository;
    private final PopulationApr60sRepository populationApr60sRepository;
    private final PopulationApr70sRepository populationApr70sRepository;
    private final PopulationApr80sRepository populationApr80sRepository;
    private final PopulationApr90sRepository populationApr90sRepository;
    private final PopulationApr100sRepository populationApr100sRepository;

    @Transactional
    public void populationAprUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationAprRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationApr0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationApr10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationApr20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationApr30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationApr40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationApr50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationApr60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationApr70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationApr80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationApr90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationApr100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

