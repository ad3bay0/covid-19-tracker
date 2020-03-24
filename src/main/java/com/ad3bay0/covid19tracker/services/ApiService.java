package com.ad3bay0.covid19tracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.ad3bay0.covid19tracker.models.LocationStats;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ApiService
 */
@Service
public class ApiService {

    private static String DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/03-23-2020.csv";
    private static Logger log = LoggerFactory.getLogger(ApiService.class);
    private List<LocationStats> allStats =  new ArrayList<>();

    @PostConstruct
    public void fetchData() throws IOException {
         List<LocationStats> newStats =  new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(DATA_URL, String.class);

        StringReader in = new StringReader(response.getBody());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {

            LocationStats locationStat = new LocationStats(
                record.get("Province_State"), 
                record.get("Country_Region"), 
                Integer.parseInt(record.get("Confirmed")));

                log.info(locationStat.toString());
                newStats.add(locationStat);
        }

        this.allStats = newStats;
        

    }

}