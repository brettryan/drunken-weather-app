/*
 * OWMResponse.java    Aug 15 2017, 08:41
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
import java.util.List;


/**
 *
 * @author  Brett Ryan
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OWMResponse {

    private final long dt;
    private final OWMMain main;
    private final OWMWind wind;
    private final List<OWMWeather> weather;

    @JsonCreator
    public OWMResponse(@JsonProperty("dt") long dt,
                       @JsonProperty("main") OWMMain main,
                       @JsonProperty("wind") OWMWind wind,
                       @JsonProperty("weather") List<OWMWeather> weather) {
        this.dt = dt;
        this.main = main;
        this.wind = wind;
        this.weather = weather;
    }

    public long getDt() {
        return dt;
    }

    public OWMMain getMain() {
        return main;
    }

    public OWMWind getWind() {
        return wind;
    }

    public List<OWMWeather> getWeather() {
        return weather;
    }

}
