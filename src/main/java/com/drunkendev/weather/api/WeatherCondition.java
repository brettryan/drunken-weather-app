/*
 * WeatherCondition.java    Aug 15 2017, 00:07
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

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;


/**
 * Provides abstract weather condition information abstract of service provider.
 *
 * @author  Brett Ryan
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class WeatherCondition {

    private final LocalDateTime updated;
    private final double temperature;
    private final String conditions;
    private final double windSpeed;
    private final String windDirection;

    public WeatherCondition(LocalDateTime updated,
                            double temperature,
                            String conditions,
                            double windSpeed,
                            String windDirection) {
        this.updated = updated;
        this.temperature = temperature;
        this.conditions = conditions;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    /**
     * Date/time when the weather information was recorded by the vendor.
     *
     * @return  Date and time when the vendor recorded the condition.
     */
    public LocalDateTime getUpdated() {
        return updated;
    }

    /**
     * Temperature in Celsius.
     *
     * @return  Temperature as at {@link getUpdated()}.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Textual conditions as supplied by the vendor.
     *
     * @return  Conditions as at {@link getUpdated()}.
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * Wind speed in meters per second.
     *
     * @return  Wind speed as at {@link getUpdated()}.
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * General wind direction as in N/NE/E/SE/S/SW/W/NW.
     *
     * @return  Wind direction as at {@link getUpdated()}.
     */
    public String getWindDirection() {
        return windDirection;
    }

}
