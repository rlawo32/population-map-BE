
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationSep.*;
import com.pm.pmproject.jpa.repository.populationSep.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
            List<PopulationSep> repoListSep = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationSep::new).collect(Collectors.toList());

            populationSepRepository.batchInsert(repoListSep);

            List<PopulationSep0s> repoListSep0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationSep0s::new).collect(Collectors.toList());

            populationSep0sRepository.batchInsert(repoListSep0s);

            List<PopulationSep10s> repoListSep10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationSep10s::new).collect(Collectors.toList());

            populationSep10sRepository.batchInsert(repoListSep10s);

            List<PopulationSep20s> repoListSep20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationSep20s::new).collect(Collectors.toList());

            populationSep20sRepository.batchInsert(repoListSep20s);

            List<PopulationSep30s> repoListSep30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationSep30s::new).collect(Collectors.toList());

            populationSep30sRepository.batchInsert(repoListSep30s);

            List<PopulationSep40s> repoListSep40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationSep40s::new).collect(Collectors.toList());

            populationSep40sRepository.batchInsert(repoListSep40s);

            List<PopulationSep50s> repoListSep50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationSep50s::new).collect(Collectors.toList());

            populationSep50sRepository.batchInsert(repoListSep50s);

            List<PopulationSep60s> repoListSep60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationSep60s::new).collect(Collectors.toList());

            populationSep60sRepository.batchInsert(repoListSep60s);

            List<PopulationSep70s> repoListSep70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationSep70s::new).collect(Collectors.toList());

            populationSep70sRepository.batchInsert(repoListSep70s);

            List<PopulationSep80s> repoListSep80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationSep80s::new).collect(Collectors.toList());

            populationSep80sRepository.batchInsert(repoListSep80s);

            List<PopulationSep90s> repoListSep90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationSep90s::new).collect(Collectors.toList());

            populationSep90sRepository.batchInsert(repoListSep90s);

            List<PopulationSep100s> repoListSep100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationSep100s::new).collect(Collectors.toList());

            populationSep100sRepository.batchInsert(repoListSep100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

