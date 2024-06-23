package com.pm.pmproject.service;

import com.pm.pmproject.dto.*;
import com.pm.pmproject.jpa.domain.populationJan.*;
import com.pm.pmproject.jpa.repository.populationJan.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
            List<PopulationJan> repoListJan = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationJan::new).collect(Collectors.toList());

            populationJanRepository.batchInsert(repoListJan);

            List<PopulationJan0s> repoListJan0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationJan0s::new).collect(Collectors.toList());

            populationJan0sRepository.batchInsert(repoListJan0s);

            List<PopulationJan10s> repoListJan10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationJan10s::new).collect(Collectors.toList());

            populationJan10sRepository.batchInsert(repoListJan10s);

            List<PopulationJan20s> repoListJan20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationJan20s::new).collect(Collectors.toList());

            populationJan20sRepository.batchInsert(repoListJan20s);

            List<PopulationJan30s> repoListJan30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationJan30s::new).collect(Collectors.toList());

            populationJan30sRepository.batchInsert(repoListJan30s);

            List<PopulationJan40s> repoListJan40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationJan40s::new).collect(Collectors.toList());

            populationJan40sRepository.batchInsert(repoListJan40s);

            List<PopulationJan50s> repoListJan50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationJan50s::new).collect(Collectors.toList());

            populationJan50sRepository.batchInsert(repoListJan50s);

            List<PopulationJan60s> repoListJan60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationJan60s::new).collect(Collectors.toList());

            populationJan60sRepository.batchInsert(repoListJan60s);

            List<PopulationJan70s> repoListJan70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationJan70s::new).collect(Collectors.toList());

            populationJan70sRepository.batchInsert(repoListJan70s);

            List<PopulationJan80s> repoListJan80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationJan80s::new).collect(Collectors.toList());

            populationJan80sRepository.batchInsert(repoListJan80s);

            List<PopulationJan90s> repoListJan90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationJan90s::new).collect(Collectors.toList());

            populationJan90sRepository.batchInsert(repoListJan90s);

            List<PopulationJan100s> repoListJan100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationJan100s::new).collect(Collectors.toList());

            populationJan100sRepository.batchInsert(repoListJan100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

