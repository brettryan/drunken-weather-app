/*
 * WeatherConfig.java    Aug 15 2017, 00:20
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

package com.drunkendev.weather.config;

import com.drunkendev.weather.api.WeatherService;
import com.drunkendev.weather.api.openweathermap.OpenWeatherMapWeatherService;
import com.drunkendev.web.settings.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;


/**
 * Configuration for weather module provided by application.
 *
 * @author  Brett Ryan
 */
@Configuration
public class WeatherConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RootConfig.class);

    @Bean()
    public WeatherService weatherService(AppConfig conf) throws ClassNotFoundException,
                                                                InstantiationException,
                                                                IllegalAccessException {
        return new OpenWeatherMapWeatherService(conf.getString("weather.api.owm.appid"),
                                                conf.getString("weather.api.owm.base"));
    }

}
