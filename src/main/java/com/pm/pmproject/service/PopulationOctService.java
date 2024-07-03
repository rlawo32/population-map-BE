
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationOct.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationOctService {

    private final PopulationOctRepository populationOctRepository;
    private final PopulationOct0sRepository populationOct0sRepository;
    private final PopulationOct10sRepository populationOct10sRepository;
    private final PopulationOct20sRepository populationOct20sRepository;
    private final PopulationOct30sRepository populationOct30sRepository;
    private final PopulationOct40sRepository populationOct40sRepository;
    private final PopulationOct50sRepository populationOct50sRepository;
    private final PopulationOct60sRepository populationOct60sRepository;
    private final PopulationOct70sRepository populationOct70sRepository;
    private final PopulationOct80sRepository populationOct80sRepository;
    private final PopulationOct90sRepository populationOct90sRepository;
    private final PopulationOct100sRepository populationOct100sRepository;

    @Transactional
    public void populationOctUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationOctRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationOct0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationOct10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationOct20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationOct30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationOct40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationOct50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationOct60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationOct70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationOct80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationOct90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationOct100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

