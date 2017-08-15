/*
 * OWMMain.java    Aug 15 2017, 10:25
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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author  Brett Ryan
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class OWMMain {

    private final double temp;
    private final long pressure;
    private final long humidity;
    private final double tempMin;
    private final double tempMax;

    @JsonCreator
    public OWMMain(@JsonProperty("temp") double temp,
                   @JsonProperty("pressure") long pressure,
                   @JsonProperty("humidity") long humidity,
                   @JsonProperty("temp_min") double tempMin,
                   @JsonProperty("temp_max") double tempMax) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public double getTemp() {
        return temp;
    }

    public long getPressure() {
        return pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

}
