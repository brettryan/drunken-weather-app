/*
 * OWMError.java    Aug 15 2017, 10:14
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
public class OWMError {

    private final int cod;
    private final String message;

    @JsonCreator
    public OWMError(@JsonProperty("cod") int cod,
                    @JsonProperty("message") String message) {
        this.cod = cod;
        this.message = message;
    }

    public int getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

}
