package com.ad3bay0.covid19tracker.services;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * ApiService
 */
@Component
public class ApiService {

    private static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/03-23-2020.csv";
    private static Logger log = LoggerFactory.getLogger(ApiService.class);

    @PostConstruct
    public void fetchData(){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(DATA_URL, String.class);
        log.info(response.getBody());



    }

    
}