package com.rybickim.cityrestconsumer.service;

import com.rybickim.cityrestconsumer.domain.City;
import com.rybickim.cityrestconsumer.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private static final Logger logger = LoggerFactory.getLogger(CityService.class);

    private DataRepository dataRepository;

    public CityService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
        logger.debug("CityService(): " + dataRepository);
    }

    public String getConnectionAddress(){
        logger.debug("getConnectionAddress(): " + dataRepository.getConnectionAddress());

        return dataRepository.getConnectionAddress();
    }

    public List<City> getCities(){
        logger.debug("getCities(): " + dataRepository.readCities());

        return dataRepository.readCities();
    }
}
