
package com.pm.pmproject.service;

import com.pm.pmproject.dto.CommonRequestDto;
import com.pm.pmproject.jpa.domain.populationOct.*;
import com.pm.pmproject.jpa.repository.populationOct.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationOctService {

    private final PopulationOctRepository populationOctRepository;
    private final PopulationOct0sRepository populationOct0sRepository;
    private final PopulationOct10sRepository populationOct10sRepository;
    private final PopulationOct20sRepository populationOct20sRepository;
    private final PopulationOct30sRepository populationOct30sRepository;
    private final PopulationOct40sRepository populationOct40sRepository;
    private final PopulationOct50sRepository populationOct50sRepository;
    private final PopulationOct60sRepository populationOct60sRepository;
    private final PopulationOct70sRepository populationOct70sRepository;
    private final PopulationOct80sRepository populationOct80sRepository;
    private final PopulationOct90sRepository populationOct90sRepository;
    private final PopulationOct100sRepository populationOct100sRepository;

    @Transactional
    public void populationOctUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationOct> repoListOct = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationOct::new).collect(Collectors.toList());

            populationOctRepository.batchInsert(repoListOct);

            List<PopulationOct0s> repoListOct0s  = commonRequestDto.getPopulation0sDto()
                    .stream().map(PopulationOct0s::new).collect(Collectors.toList());

            populationOct0sRepository.batchInsert(repoListOct0s);

            List<PopulationOct10s> repoListOct10s  = commonRequestDto.getPopulation10sDto()
                    .stream().map(PopulationOct10s::new).collect(Collectors.toList());

            populationOct10sRepository.batchInsert(repoListOct10s);

            List<PopulationOct20s> repoListOct20s  = commonRequestDto.getPopulation20sDto()
                    .stream().map(PopulationOct20s::new).collect(Collectors.toList());

            populationOct20sRepository.batchInsert(repoListOct20s);

            List<PopulationOct30s> repoListOct30s  = commonRequestDto.getPopulation30sDto()
                    .stream().map(PopulationOct30s::new).collect(Collectors.toList());

            populationOct30sRepository.batchInsert(repoListOct30s);

            List<PopulationOct40s> repoListOct40s  = commonRequestDto.getPopulation40sDto()
                    .stream().map(PopulationOct40s::new).collect(Collectors.toList());

            populationOct40sRepository.batchInsert(repoListOct40s);

            List<PopulationOct50s> repoListOct50s  = commonRequestDto.getPopulation50sDto()
                    .stream().map(PopulationOct50s::new).collect(Collectors.toList());

            populationOct50sRepository.batchInsert(repoListOct50s);

            List<PopulationOct60s> repoListOct60s  = commonRequestDto.getPopulation60sDto()
                    .stream().map(PopulationOct60s::new).collect(Collectors.toList());

            populationOct60sRepository.batchInsert(repoListOct60s);

            List<PopulationOct70s> repoListOct70s  = commonRequestDto.getPopulation70sDto()
                    .stream().map(PopulationOct70s::new).collect(Collectors.toList());

            populationOct70sRepository.batchInsert(repoListOct70s);

            List<PopulationOct80s> repoListOct80s  = commonRequestDto.getPopulation80sDto()
                    .stream().map(PopulationOct80s::new).collect(Collectors.toList());

            populationOct80sRepository.batchInsert(repoListOct80s);

            List<PopulationOct90s> repoListOct90s  = commonRequestDto.getPopulation90sDto()
                    .stream().map(PopulationOct90s::new).collect(Collectors.toList());

            populationOct90sRepository.batchInsert(repoListOct90s);

            List<PopulationOct100s> repoListOct100s  = commonRequestDto.getPopulation100sDto()
                    .stream().map(PopulationOct100s::new).collect(Collectors.toList());

            populationOct100sRepository.batchInsert(repoListOct100s);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

