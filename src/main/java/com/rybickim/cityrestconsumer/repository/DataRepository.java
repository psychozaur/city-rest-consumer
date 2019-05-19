package com.rybickim.cityrestconsumer.repository;

import com.rybickim.cityrestconsumer.config.Configuration;
import com.rybickim.cityrestconsumer.domain.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataRepository {

    private static final Logger logger = LoggerFactory.getLogger(DataRepository.class);

    private RestTemplate restTemplate;
    private final String connectionAddress;

    public DataRepository(RestTemplate restTemplate, Configuration configuration) {
        this.restTemplate = restTemplate;
        connectionAddress = configuration.getConnectionAddress();
        logger.debug("DataRepository(): " + restTemplate + ", " + configuration);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public String getConnectionAddress() {
        return connectionAddress;
    }

    public List<City> readCities() {
        City[] response = restTemplate.getForObject(connectionAddress, City[].class);
        logger.debug("received response [{}]", response);

        return Arrays.asList(response);
    }
}
