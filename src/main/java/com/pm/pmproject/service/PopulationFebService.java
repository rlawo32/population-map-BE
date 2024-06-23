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
            List<PopulationFeb> repoListFeb = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationFeb::new).collect(Collectors.toList());

            populationFebRepository.batchInsert(repoListFeb);

            List<PopulationFeb0s> repoListFeb0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationFeb0s::new).collect(Collectors.toList());

            populationFeb0sRepository.batchInsert(repoListFeb0s);

            List<PopulationFeb10s> repoListFeb10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationFeb10s::new).collect(Collectors.toList());

            populationFeb10sRepository.batchInsert(repoListFeb10s);

            List<PopulationFeb20s> repoListFeb20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationFeb20s::new).collect(Collectors.toList());

            populationFeb20sRepository.batchInsert(repoListFeb20s);

            List<PopulationFeb30s> repoListFeb30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationFeb30s::new).collect(Collectors.toList());

            populationFeb30sRepository.batchInsert(repoListFeb30s);

            List<PopulationFeb40s> repoListFeb40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationFeb40s::new).collect(Collectors.toList());

            populationFeb40sRepository.batchInsert(repoListFeb40s);

            List<PopulationFeb50s> repoListFeb50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationFeb50s::new).collect(Collectors.toList());

            populationFeb50sRepository.batchInsert(repoListFeb50s);

            List<PopulationFeb60s> repoListFeb60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationFeb60s::new).collect(Collectors.toList());

            populationFeb60sRepository.batchInsert(repoListFeb60s);

            List<PopulationFeb70s> repoListFeb70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationFeb70s::new).collect(Collectors.toList());

            populationFeb70sRepository.batchInsert(repoListFeb70s);

            List<PopulationFeb80s> repoListFeb80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationFeb80s::new).collect(Collectors.toList());

            populationFeb80sRepository.batchInsert(repoListFeb80s);

            List<PopulationFeb90s> repoListFeb90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationFeb90s::new).collect(Collectors.toList());

            populationFeb90sRepository.batchInsert(repoListFeb90s);

            List<PopulationFeb100s> repoListFeb100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationFeb100s::new).collect(Collectors.toList());

            populationFeb100sRepository.batchInsert(repoListFeb100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

