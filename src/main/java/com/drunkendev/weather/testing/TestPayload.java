/*
 * TestPayload.java    Aug 15 2017, 08:19
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

package com.drunkendev.weather.testing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 *
 * @author  Brett Ryan
 */
public class TestPayload {

    private final String text;
    private final int number;
    private final double decimal;
    private final LocalDate date;
    private final LocalTime time;
    private final LocalDateTime timestamp;

    public TestPayload(String text,
                       int number,
                       double decimal,
                       LocalDate date,
                       LocalTime time,
                       LocalDateTime timestamp) {
        this.text = text;
        this.number = number;
        this.decimal = decimal;
        this.date = date;
        this.time = time;
        this.timestamp = timestamp;
    }


    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }

    public double getDecimal() {
        return decimal;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }


}
