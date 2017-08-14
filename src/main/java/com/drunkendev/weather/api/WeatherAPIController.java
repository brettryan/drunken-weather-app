/*
 * WeatherAPIController.java    Aug 15 2017, 00:06
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

package com.drunkendev.weather.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Provides rest endpoint for obtaining weather condition information.
 *
 * @author  Brett Ryan
 */
@RestController
public class WeatherAPIController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherAPIController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    /**
     * Obtain current weather information for the given city.
     *
     * @param   cityId
     *          City ID
     * @return  Current conditions.
     */
    @RequestMapping("/api/v1/weather")
    public WeatherCondition getCurrentConditions(long cityId) {
        return weatherService.getCurrentConditions(cityId);
    }

}
