
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationAug.*;
import com.pm.pmproject.jpa.repository.populationAug.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationAugService {

    private final PopulationAugRepository populationAugRepository;
    private final PopulationAug0sRepository populationAug0sRepository;
    private final PopulationAug10sRepository populationAug10sRepository;
    private final PopulationAug20sRepository populationAug20sRepository;
    private final PopulationAug30sRepository populationAug30sRepository;
    private final PopulationAug40sRepository populationAug40sRepository;
    private final PopulationAug50sRepository populationAug50sRepository;
    private final PopulationAug60sRepository populationAug60sRepository;
    private final PopulationAug70sRepository populationAug70sRepository;
    private final PopulationAug80sRepository populationAug80sRepository;
    private final PopulationAug90sRepository populationAug90sRepository;
    private final PopulationAug100sRepository populationAug100sRepository;

    @Transactional
    public void populationAugUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationAug> repoListAug = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationAug::new).collect(Collectors.toList());

            populationAugRepository.batchInsert(repoListAug);

            List<PopulationAug0s> repoListAug0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationAug0s::new).collect(Collectors.toList());

            populationAug0sRepository.batchInsert(repoListAug0s);

            List<PopulationAug10s> repoListAug10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationAug10s::new).collect(Collectors.toList());

            populationAug10sRepository.batchInsert(repoListAug10s);

            List<PopulationAug20s> repoListAug20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationAug20s::new).collect(Collectors.toList());

            populationAug20sRepository.batchInsert(repoListAug20s);

            List<PopulationAug30s> repoListAug30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationAug30s::new).collect(Collectors.toList());

            populationAug30sRepository.batchInsert(repoListAug30s);

            List<PopulationAug40s> repoListAug40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationAug40s::new).collect(Collectors.toList());

            populationAug40sRepository.batchInsert(repoListAug40s);

            List<PopulationAug50s> repoListAug50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationAug50s::new).collect(Collectors.toList());

            populationAug50sRepository.batchInsert(repoListAug50s);

            List<PopulationAug60s> repoListAug60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationAug60s::new).collect(Collectors.toList());

            populationAug60sRepository.batchInsert(repoListAug60s);

            List<PopulationAug70s> repoListAug70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationAug70s::new).collect(Collectors.toList());

            populationAug70sRepository.batchInsert(repoListAug70s);

            List<PopulationAug80s> repoListAug80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationAug80s::new).collect(Collectors.toList());

            populationAug80sRepository.batchInsert(repoListAug80s);

            List<PopulationAug90s> repoListAug90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationAug90s::new).collect(Collectors.toList());

            populationAug90sRepository.batchInsert(repoListAug90s);

            List<PopulationAug100s> repoListAug100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationAug100s::new).collect(Collectors.toList());

            populationAug100sRepository.batchInsert(repoListAug100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

