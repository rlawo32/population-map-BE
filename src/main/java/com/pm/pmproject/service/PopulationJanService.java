package com.pm.pmproject.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.pmproject.dto.*;
import com.pm.pmproject.jpa.domain.populationJan.PopulationJan;
import com.pm.pmproject.jpa.repository.populationJan.PopulationJanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PopulationJanService {

    private final PopulationJanRepository populationJanRepository;
    public void populationJanUpdate(CommonRequestDto commonRequestDto) {
        try {
            List<PopulationJan> repoList = commonRequestDto.getPopulationResultDto()
                    .stream().map(PopulationJan::new).collect(Collectors.toList());
            populationJanRepository.saveAll(repoList);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

