package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationMay.*;
import com.pm.pmproject.jpa.repository.populationMay.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationMayService {

    private final PopulationMayRepository populationMayRepository;
    private final PopulationMay0sRepository populationMay0sRepository;
    private final PopulationMay10sRepository populationMay10sRepository;
    private final PopulationMay20sRepository populationMay20sRepository;
    private final PopulationMay30sRepository populationMay30sRepository;
    private final PopulationMay40sRepository populationMay40sRepository;
    private final PopulationMay50sRepository populationMay50sRepository;
    private final PopulationMay60sRepository populationMay60sRepository;
    private final PopulationMay70sRepository populationMay70sRepository;
    private final PopulationMay80sRepository populationMay80sRepository;
    private final PopulationMay90sRepository populationMay90sRepository;
    private final PopulationMay100sRepository populationMay100sRepository;

    @Transactional
    public void populationMayUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationMay> repoListMay = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationMay::new).collect(Collectors.toList());

            populationMayRepository.batchInsert(repoListMay);

            List<PopulationMay0s> repoListMay0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationMay0s::new).collect(Collectors.toList());

            populationMay0sRepository.batchInsert(repoListMay0s);

            List<PopulationMay10s> repoListMay10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationMay10s::new).collect(Collectors.toList());

            populationMay10sRepository.batchInsert(repoListMay10s);

            List<PopulationMay20s> repoListMay20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationMay20s::new).collect(Collectors.toList());

            populationMay20sRepository.batchInsert(repoListMay20s);

            List<PopulationMay30s> repoListMay30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationMay30s::new).collect(Collectors.toList());

            populationMay30sRepository.batchInsert(repoListMay30s);

            List<PopulationMay40s> repoListMay40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationMay40s::new).collect(Collectors.toList());

            populationMay40sRepository.batchInsert(repoListMay40s);

            List<PopulationMay50s> repoListMay50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationMay50s::new).collect(Collectors.toList());

            populationMay50sRepository.batchInsert(repoListMay50s);

            List<PopulationMay60s> repoListMay60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationMay60s::new).collect(Collectors.toList());

            populationMay60sRepository.batchInsert(repoListMay60s);

            List<PopulationMay70s> repoListMay70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationMay70s::new).collect(Collectors.toList());

            populationMay70sRepository.batchInsert(repoListMay70s);

            List<PopulationMay80s> repoListMay80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationMay80s::new).collect(Collectors.toList());

            populationMay80sRepository.batchInsert(repoListMay80s);

            List<PopulationMay90s> repoListMay90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationMay90s::new).collect(Collectors.toList());

            populationMay90sRepository.batchInsert(repoListMay90s);

            List<PopulationMay100s> repoListMay100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationMay100s::new).collect(Collectors.toList());

            populationMay100sRepository.batchInsert(repoListMay100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

