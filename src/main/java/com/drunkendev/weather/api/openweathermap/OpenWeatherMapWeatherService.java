/*
 * OpenWeatherMapWeatherService.java    Aug 15 2017, 08:38
 *
 * Copyright 2017 Drunken Dev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drunkendev.weather.api.openweathermap;

import com.drunkendev.weather.api.WeatherCondition;
import com.drunkendev.weather.api.WeatherException;
import com.drunkendev.weather.api.WeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.apache.commons.lang3.StringUtils.isBlank;


/**
 * OpenWeatherMap {@link WeatherService} implementation.
 *
 * @author  Brett Ryan
 * @see     <a href="https://openweathermap.org/">OpenWeatherMap</a>
 */
public class OpenWeatherMapWeatherService implements WeatherService {

    private static final Logger LOG = LoggerFactory.getLogger(OpenWeatherMapWeatherService.class);

    private final String appId;
    private final String baseUri;
    private ObjectMapper om;

    public OpenWeatherMapWeatherService(String appId,
                                        String baseUri) {
        this.appId = appId;
        if (isBlank(appId)) {
            LOG.error("APP ID has NOT been configured for OWM, please set weather.api.owm.appid in weather.config.properties or weather.user.config.properties.");
        } else {
            LOG.debug("Using {} for OWM app id.", appId);
        }
        this.baseUri = baseUri;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper om) {
        this.om = om;
    }

    @Override
    public WeatherCondition getCurrentConditions(long cityId) throws WeatherException {
        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder query = UriComponentsBuilder
                .fromHttpUrl(baseUri)
                .path("/weather")
                .queryParam("appid", appId)
                .queryParam("idd", cityId)
                .queryParam("units", "metric");

        String queryString = query.build().encode().toString();
        LOG.debug("Querying OWM for {}", queryString);

        try {
            ResponseEntity<OWMResponse> response = restTemplate.getForEntity(
                    queryString,
                    OWMResponse.class);

            OWMResponse body = response.getBody();
            if (body.getWeather().isEmpty()) {
                throw new WeatherException("No weather information was returned.");
            }

            return new WeatherCondition(
                    LocalDateTime.now(),
                    0,
                    body.getWeather().get(0).getDescription(),
                    0.0,
                    "N"
            );
        } catch (HttpClientErrorException ex) {
            String msg;
            if (om == null) {
                msg = ex.getResponseBodyAsString();
            } else {
                try {
                    OWMError err = om.readValue(ex.getResponseBodyAsString(), OWMError.class);
                    msg = err.getMessage();
                } catch (IOException ex1) {
                    msg = ex.getResponseBodyAsString();
                }
            }
            LOG.error("Couldn't get weather information: {}", msg, ex);
            throw new WeatherException(msg);
        }
    }

}
