
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.repository.populationSep.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PopulationSepService {

    private final PopulationSepRepository populationSepRepository;
    private final PopulationSep0sRepository populationSep0sRepository;
    private final PopulationSep10sRepository populationSep10sRepository;
    private final PopulationSep20sRepository populationSep20sRepository;
    private final PopulationSep30sRepository populationSep30sRepository;
    private final PopulationSep40sRepository populationSep40sRepository;
    private final PopulationSep50sRepository populationSep50sRepository;
    private final PopulationSep60sRepository populationSep60sRepository;
    private final PopulationSep70sRepository populationSep70sRepository;
    private final PopulationSep80sRepository populationSep80sRepository;
    private final PopulationSep90sRepository populationSep90sRepository;
    private final PopulationSep100sRepository populationSep100sRepository;

    @Transactional
    public void populationSepUpdate(CommonRequestDto commonRequestDto) {
        try {
            populationSepRepository.batchInsert(commonRequestDto.getPopulationResultDto());

            populationSep0sRepository.batchInsert(commonRequestDto.getPopulation0sDto());

            populationSep10sRepository.batchInsert(commonRequestDto.getPopulation10sDto());

            populationSep20sRepository.batchInsert(commonRequestDto.getPopulation20sDto());

            populationSep30sRepository.batchInsert(commonRequestDto.getPopulation30sDto());

            populationSep40sRepository.batchInsert(commonRequestDto.getPopulation40sDto());

            populationSep50sRepository.batchInsert(commonRequestDto.getPopulation50sDto());

            populationSep60sRepository.batchInsert(commonRequestDto.getPopulation60sDto());

            populationSep70sRepository.batchInsert(commonRequestDto.getPopulation70sDto());

            populationSep80sRepository.batchInsert(commonRequestDto.getPopulation80sDto());

            populationSep90sRepository.batchInsert(commonRequestDto.getPopulation90sDto());

            populationSep100sRepository.batchInsert(commonRequestDto.getPopulation100sDto());

            // total
            populationSepRepository.populationTotalInsert(commonRequestDto.getPopulationResultDto());

            populationSep0sRepository.populationTotalInsert(commonRequestDto.getPopulation0sDto());

            populationSep10sRepository.populationTotalInsert(commonRequestDto.getPopulation10sDto());

            populationSep20sRepository.populationTotalInsert(commonRequestDto.getPopulation20sDto());

            populationSep30sRepository.populationTotalInsert(commonRequestDto.getPopulation30sDto());

            populationSep40sRepository.populationTotalInsert(commonRequestDto.getPopulation40sDto());

            populationSep50sRepository.populationTotalInsert(commonRequestDto.getPopulation50sDto());

            populationSep60sRepository.populationTotalInsert(commonRequestDto.getPopulation60sDto());

            populationSep70sRepository.populationTotalInsert(commonRequestDto.getPopulation70sDto());

            populationSep80sRepository.populationTotalInsert(commonRequestDto.getPopulation80sDto());

            populationSep90sRepository.populationTotalInsert(commonRequestDto.getPopulation90sDto());

            populationSep100sRepository.populationTotalInsert(commonRequestDto.getPopulation100sDto());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

