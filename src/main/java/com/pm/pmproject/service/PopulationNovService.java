
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationNov.*;
import com.pm.pmproject.jpa.repository.populationNov.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationNovService {

    private final PopulationNovRepository populationNovRepository;
    private final PopulationNov0sRepository populationNov0sRepository;
    private final PopulationNov10sRepository populationNov10sRepository;
    private final PopulationNov20sRepository populationNov20sRepository;
    private final PopulationNov30sRepository populationNov30sRepository;
    private final PopulationNov40sRepository populationNov40sRepository;
    private final PopulationNov50sRepository populationNov50sRepository;
    private final PopulationNov60sRepository populationNov60sRepository;
    private final PopulationNov70sRepository populationNov70sRepository;
    private final PopulationNov80sRepository populationNov80sRepository;
    private final PopulationNov90sRepository populationNov90sRepository;
    private final PopulationNov100sRepository populationNov100sRepository;

    @Transactional
    public void populationNovUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationNov> repoListNov = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationNov::new).collect(Collectors.toList());

            populationNovRepository.batchInsert(repoListNov);

            List<PopulationNov0s> repoListNov0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationNov0s::new).collect(Collectors.toList());

            populationNov0sRepository.batchInsert(repoListNov0s);

            List<PopulationNov10s> repoListNov10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationNov10s::new).collect(Collectors.toList());

            populationNov10sRepository.batchInsert(repoListNov10s);

            List<PopulationNov20s> repoListNov20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationNov20s::new).collect(Collectors.toList());

            populationNov20sRepository.batchInsert(repoListNov20s);

            List<PopulationNov30s> repoListNov30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationNov30s::new).collect(Collectors.toList());

            populationNov30sRepository.batchInsert(repoListNov30s);

            List<PopulationNov40s> repoListNov40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationNov40s::new).collect(Collectors.toList());

            populationNov40sRepository.batchInsert(repoListNov40s);

            List<PopulationNov50s> repoListNov50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationNov50s::new).collect(Collectors.toList());

            populationNov50sRepository.batchInsert(repoListNov50s);

            List<PopulationNov60s> repoListNov60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationNov60s::new).collect(Collectors.toList());

            populationNov60sRepository.batchInsert(repoListNov60s);

            List<PopulationNov70s> repoListNov70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationNov70s::new).collect(Collectors.toList());

            populationNov70sRepository.batchInsert(repoListNov70s);

            List<PopulationNov80s> repoListNov80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationNov80s::new).collect(Collectors.toList());

            populationNov80sRepository.batchInsert(repoListNov80s);

            List<PopulationNov90s> repoListNov90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationNov90s::new).collect(Collectors.toList());

            populationNov90sRepository.batchInsert(repoListNov90s);

            List<PopulationNov100s> repoListNov100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationNov100s::new).collect(Collectors.toList());

            populationNov100sRepository.batchInsert(repoListNov100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

