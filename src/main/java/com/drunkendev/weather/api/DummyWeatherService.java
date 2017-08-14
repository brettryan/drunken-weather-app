/*
 * DummyWeatherService.java    Aug 15 2017, 00:18
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

import java.time.LocalDateTime;


/**
 * Dummy placeholder service.
 *
 * @author  Brett Ryan
 */
public class DummyWeatherService implements WeatherService {

    @Override
    public WeatherCondition getCurrentConditions(long cityId) {
        return new WeatherCondition(LocalDateTime.now(), 0, "Not yet known", 0, null);
    }

}
