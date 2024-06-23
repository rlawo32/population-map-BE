package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationMar.*;
import com.pm.pmproject.jpa.repository.populationMar.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationMarService {

    private final PopulationMarRepository populationMarRepository;
    private final PopulationMar0sRepository populationMar0sRepository;
    private final PopulationMar10sRepository populationMar10sRepository;
    private final PopulationMar20sRepository populationMar20sRepository;
    private final PopulationMar30sRepository populationMar30sRepository;
    private final PopulationMar40sRepository populationMar40sRepository;
    private final PopulationMar50sRepository populationMar50sRepository;
    private final PopulationMar60sRepository populationMar60sRepository;
    private final PopulationMar70sRepository populationMar70sRepository;
    private final PopulationMar80sRepository populationMar80sRepository;
    private final PopulationMar90sRepository populationMar90sRepository;
    private final PopulationMar100sRepository populationMar100sRepository;

    @Transactional
    public void populationMarUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationMar> repoListMar = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationMar::new).collect(Collectors.toList());

            populationMarRepository.batchInsert(repoListMar);

            List<PopulationMar0s> repoListMar0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationMar0s::new).collect(Collectors.toList());

            populationMar0sRepository.batchInsert(repoListMar0s);

            List<PopulationMar10s> repoListMar10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationMar10s::new).collect(Collectors.toList());

            populationMar10sRepository.batchInsert(repoListMar10s);

            List<PopulationMar20s> repoListMar20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationMar20s::new).collect(Collectors.toList());

            populationMar20sRepository.batchInsert(repoListMar20s);

            List<PopulationMar30s> repoListMar30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationMar30s::new).collect(Collectors.toList());

            populationMar30sRepository.batchInsert(repoListMar30s);

            List<PopulationMar40s> repoListMar40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationMar40s::new).collect(Collectors.toList());

            populationMar40sRepository.batchInsert(repoListMar40s);

            List<PopulationMar50s> repoListMar50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationMar50s::new).collect(Collectors.toList());

            populationMar50sRepository.batchInsert(repoListMar50s);

            List<PopulationMar60s> repoListMar60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationMar60s::new).collect(Collectors.toList());

            populationMar60sRepository.batchInsert(repoListMar60s);

            List<PopulationMar70s> repoListMar70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationMar70s::new).collect(Collectors.toList());

            populationMar70sRepository.batchInsert(repoListMar70s);

            List<PopulationMar80s> repoListMar80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationMar80s::new).collect(Collectors.toList());

            populationMar80sRepository.batchInsert(repoListMar80s);

            List<PopulationMar90s> repoListMar90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationMar90s::new).collect(Collectors.toList());

            populationMar90sRepository.batchInsert(repoListMar90s);

            List<PopulationMar100s> repoListMar100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationMar100s::new).collect(Collectors.toList());

            populationMar100sRepository.batchInsert(repoListMar100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

