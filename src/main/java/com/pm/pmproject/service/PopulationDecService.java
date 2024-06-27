
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationDec.*;
import com.pm.pmproject.jpa.repository.populationDec.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationDecService {

    private final PopulationDecRepository populationDecRepository;
    private final PopulationDec0sRepository populationDec0sRepository;
    private final PopulationDec10sRepository populationDec10sRepository;
    private final PopulationDec20sRepository populationDec20sRepository;
    private final PopulationDec30sRepository populationDec30sRepository;
    private final PopulationDec40sRepository populationDec40sRepository;
    private final PopulationDec50sRepository populationDec50sRepository;
    private final PopulationDec60sRepository populationDec60sRepository;
    private final PopulationDec70sRepository populationDec70sRepository;
    private final PopulationDec80sRepository populationDec80sRepository;
    private final PopulationDec90sRepository populationDec90sRepository;
    private final PopulationDec100sRepository populationDec100sRepository;

    @Transactional
    public void populationDecUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationDec> repoListDec = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationDec::new).collect(Collectors.toList());

            populationDecRepository.batchInsert(repoListDec);

            List<PopulationDec0s> repoListDec0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationDec0s::new).collect(Collectors.toList());

            populationDec0sRepository.batchInsert(repoListDec0s);

            List<PopulationDec10s> repoListDec10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationDec10s::new).collect(Collectors.toList());

            populationDec10sRepository.batchInsert(repoListDec10s);

            List<PopulationDec20s> repoListDec20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationDec20s::new).collect(Collectors.toList());

            populationDec20sRepository.batchInsert(repoListDec20s);

            List<PopulationDec30s> repoListDec30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationDec30s::new).collect(Collectors.toList());

            populationDec30sRepository.batchInsert(repoListDec30s);

            List<PopulationDec40s> repoListDec40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationDec40s::new).collect(Collectors.toList());

            populationDec40sRepository.batchInsert(repoListDec40s);

            List<PopulationDec50s> repoListDec50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationDec50s::new).collect(Collectors.toList());

            populationDec50sRepository.batchInsert(repoListDec50s);

            List<PopulationDec60s> repoListDec60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationDec60s::new).collect(Collectors.toList());

            populationDec60sRepository.batchInsert(repoListDec60s);

            List<PopulationDec70s> repoListDec70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationDec70s::new).collect(Collectors.toList());

            populationDec70sRepository.batchInsert(repoListDec70s);

            List<PopulationDec80s> repoListDec80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationDec80s::new).collect(Collectors.toList());

            populationDec80sRepository.batchInsert(repoListDec80s);

            List<PopulationDec90s> repoListDec90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationDec90s::new).collect(Collectors.toList());

            populationDec90sRepository.batchInsert(repoListDec90s);

            List<PopulationDec100s> repoListDec100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationDec100s::new).collect(Collectors.toList());

            populationDec100sRepository.batchInsert(repoListDec100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

