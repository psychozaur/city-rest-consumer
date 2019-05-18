package com.rybickim.cityrestconsumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Configuration {

    private static final Logger logger = LoggerFactory.getLogger(Configuration.class);

    private String connectionAddress;

    public static Logger getLogger() {
        return logger;
    }

    public String getConnectionAddress() {
        return connectionAddress;
    }


    @Bean
    RestTemplate restTemplate(RestTemplateBuilder templateBuilder){
        return templateBuilder.build();
    }

    @Autowired
    public void setConnectionAddress(@Value("${city.rest.address}") String connectionAddress) {
        logger.debug("connection address from config [{}]",connectionAddress);
        this.connectionAddress = connectionAddress;
    }



}
