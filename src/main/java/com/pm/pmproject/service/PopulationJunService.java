package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationJun.*;
import com.pm.pmproject.jpa.repository.populationJun.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationJunService {

    private final PopulationJunRepository populationJunRepository;
    private final PopulationJun0sRepository populationJun0sRepository;
    private final PopulationJun10sRepository populationJun10sRepository;
    private final PopulationJun20sRepository populationJun20sRepository;
    private final PopulationJun30sRepository populationJun30sRepository;
    private final PopulationJun40sRepository populationJun40sRepository;
    private final PopulationJun50sRepository populationJun50sRepository;
    private final PopulationJun60sRepository populationJun60sRepository;
    private final PopulationJun70sRepository populationJun70sRepository;
    private final PopulationJun80sRepository populationJun80sRepository;
    private final PopulationJun90sRepository populationJun90sRepository;
    private final PopulationJun100sRepository populationJun100sRepository;

    @Transactional
    public void populationJunUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationJun> repoListJun = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationJun::new).collect(Collectors.toList());

            populationJunRepository.batchInsert(repoListJun);

            List<PopulationJun0s> repoListJun0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationJun0s::new).collect(Collectors.toList());

            populationJun0sRepository.batchInsert(repoListJun0s);

            List<PopulationJun10s> repoListJun10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationJun10s::new).collect(Collectors.toList());

            populationJun10sRepository.batchInsert(repoListJun10s);

            List<PopulationJun20s> repoListJun20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationJun20s::new).collect(Collectors.toList());

            populationJun20sRepository.batchInsert(repoListJun20s);

            List<PopulationJun30s> repoListJun30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationJun30s::new).collect(Collectors.toList());

            populationJun30sRepository.batchInsert(repoListJun30s);

            List<PopulationJun40s> repoListJun40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationJun40s::new).collect(Collectors.toList());

            populationJun40sRepository.batchInsert(repoListJun40s);

            List<PopulationJun50s> repoListJun50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationJun50s::new).collect(Collectors.toList());

            populationJun50sRepository.batchInsert(repoListJun50s);

            List<PopulationJun60s> repoListJun60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationJun60s::new).collect(Collectors.toList());

            populationJun60sRepository.batchInsert(repoListJun60s);

            List<PopulationJun70s> repoListJun70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationJun70s::new).collect(Collectors.toList());

            populationJun70sRepository.batchInsert(repoListJun70s);

            List<PopulationJun80s> repoListJun80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationJun80s::new).collect(Collectors.toList());

            populationJun80sRepository.batchInsert(repoListJun80s);

            List<PopulationJun90s> repoListJun90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationJun90s::new).collect(Collectors.toList());

            populationJun90sRepository.batchInsert(repoListJun90s);

            List<PopulationJun100s> repoListJun100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationJun100s::new).collect(Collectors.toList());

            populationJun100sRepository.batchInsert(repoListJun100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

