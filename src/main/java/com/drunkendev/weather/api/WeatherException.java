/*
 * WeatherException.java    Aug 15 2017, 09:12
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
 * Exception to handle weather API errors.
 *
 * @author  Brett Ryan
 */
public class WeatherException extends Exception {

    /**
     * Creates a new instance of <code>WeatherException</code> without detail message.
     */
    public WeatherException() {
    }

    /**
     * Constructs an instance of <code>WeatherException</code> with the specified detail message.
     *
     * @param   msg
     *          the detail message.
     */
    public WeatherException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>WeatherException</code> with the specified detail message.
     *
     * @param   msg
     *          the detail message.
     * @param   cause
     *          Underlying cause of the exception.
     */
    public WeatherException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
