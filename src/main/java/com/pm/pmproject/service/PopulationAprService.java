package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationApr.*;
import com.pm.pmproject.jpa.repository.populationApr.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
            List<PopulationApr> repoListApr = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationApr::new).collect(Collectors.toList());

            populationAprRepository.batchInsert(repoListApr);

            List<PopulationApr0s> repoListApr0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationApr0s::new).collect(Collectors.toList());

            populationApr0sRepository.batchInsert(repoListApr0s);

            List<PopulationApr10s> repoListApr10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationApr10s::new).collect(Collectors.toList());

            populationApr10sRepository.batchInsert(repoListApr10s);

            List<PopulationApr20s> repoListApr20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationApr20s::new).collect(Collectors.toList());

            populationApr20sRepository.batchInsert(repoListApr20s);

            List<PopulationApr30s> repoListApr30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationApr30s::new).collect(Collectors.toList());

            populationApr30sRepository.batchInsert(repoListApr30s);

            List<PopulationApr40s> repoListApr40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationApr40s::new).collect(Collectors.toList());

            populationApr40sRepository.batchInsert(repoListApr40s);

            List<PopulationApr50s> repoListApr50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationApr50s::new).collect(Collectors.toList());

            populationApr50sRepository.batchInsert(repoListApr50s);

            List<PopulationApr60s> repoListApr60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationApr60s::new).collect(Collectors.toList());

            populationApr60sRepository.batchInsert(repoListApr60s);

            List<PopulationApr70s> repoListApr70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationApr70s::new).collect(Collectors.toList());

            populationApr70sRepository.batchInsert(repoListApr70s);

            List<PopulationApr80s> repoListApr80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationApr80s::new).collect(Collectors.toList());

            populationApr80sRepository.batchInsert(repoListApr80s);

            List<PopulationApr90s> repoListApr90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationApr90s::new).collect(Collectors.toList());

            populationApr90sRepository.batchInsert(repoListApr90s);

            List<PopulationApr100s> repoListApr100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationApr100s::new).collect(Collectors.toList());

            populationApr100sRepository.batchInsert(repoListApr100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

