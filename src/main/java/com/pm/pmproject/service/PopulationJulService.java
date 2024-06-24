
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationJul.*;
import com.pm.pmproject.jpa.repository.populationJul.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationJulService {

    private final PopulationJulRepository populationJulRepository;
    private final PopulationJul0sRepository populationJul0sRepository;
    private final PopulationJul10sRepository populationJul10sRepository;
    private final PopulationJul20sRepository populationJul20sRepository;
    private final PopulationJul30sRepository populationJul30sRepository;
    private final PopulationJul40sRepository populationJul40sRepository;
    private final PopulationJul50sRepository populationJul50sRepository;
    private final PopulationJul60sRepository populationJul60sRepository;
    private final PopulationJul70sRepository populationJul70sRepository;
    private final PopulationJul80sRepository populationJul80sRepository;
    private final PopulationJul90sRepository populationJul90sRepository;
    private final PopulationJul100sRepository populationJul100sRepository;

    @Transactional
    public void populationJulUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationJul> repoListJul = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationJul::new).collect(Collectors.toList());

            populationJulRepository.batchInsert(repoListJul);

            List<PopulationJul0s> repoListJul0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationJul0s::new).collect(Collectors.toList());

            populationJul0sRepository.batchInsert(repoListJul0s);

            List<PopulationJul10s> repoListJul10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationJul10s::new).collect(Collectors.toList());

            populationJul10sRepository.batchInsert(repoListJul10s);

            List<PopulationJul20s> repoListJul20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationJul20s::new).collect(Collectors.toList());

            populationJul20sRepository.batchInsert(repoListJul20s);

            List<PopulationJul30s> repoListJul30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationJul30s::new).collect(Collectors.toList());

            populationJul30sRepository.batchInsert(repoListJul30s);

            List<PopulationJul40s> repoListJul40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationJul40s::new).collect(Collectors.toList());

            populationJul40sRepository.batchInsert(repoListJul40s);

            List<PopulationJul50s> repoListJul50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationJul50s::new).collect(Collectors.toList());

            populationJul50sRepository.batchInsert(repoListJul50s);

            List<PopulationJul60s> repoListJul60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationJul60s::new).collect(Collectors.toList());

            populationJul60sRepository.batchInsert(repoListJul60s);

            List<PopulationJul70s> repoListJul70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationJul70s::new).collect(Collectors.toList());

            populationJul70sRepository.batchInsert(repoListJul70s);

            List<PopulationJul80s> repoListJul80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationJul80s::new).collect(Collectors.toList());

            populationJul80sRepository.batchInsert(repoListJul80s);

            List<PopulationJul90s> repoListJul90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationJul90s::new).collect(Collectors.toList());

            populationJul90sRepository.batchInsert(repoListJul90s);

            List<PopulationJul100s> repoListJul100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationJul100s::new).collect(Collectors.toList());

            populationJul100sRepository.batchInsert(repoListJul100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

