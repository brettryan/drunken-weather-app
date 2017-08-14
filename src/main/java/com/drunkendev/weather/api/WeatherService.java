/*
 * WeatherService.java    Aug 15 2017, 00:07
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


/**
 * Abstracts vendor weather API's into a common API.
 *
 * @author  Brett Ryan
 */
public interface WeatherService {

    /**
     * Retrieve current weather conditions for the given City ID.
     *
     * @param   cityId
     *          City ID to retrieve conditions for.
     * @return  Currently available conditions.
     * @throws  WeatherException
     *          If the underlying implementation was unable to complete the
     *          request.
     */
    WeatherCondition getCurrentConditions(long cityId) throws WeatherException;

}
