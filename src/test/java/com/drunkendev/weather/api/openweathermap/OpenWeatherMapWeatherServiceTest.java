/*
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

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Brett Ryan
 */
public class OpenWeatherMapWeatherServiceTest {

    public OpenWeatherMapWeatherServiceTest() {
    }

    /**
     * Test 0 -> 360 integral degrees for cardinal direction.
     *
     * <strong>NOTE</strong>: decimal values are not tested in this case.
     */
    @Test
    public void testMeteorologicalDegreesToCardinal() {
        double offset = 22;
        for (int i = 0; i < 360; i++) {
            String expected;

            if (i < 45 - offset) {
                expected = "North";
            } else if (i < 90 - offset) {
                expected = "North East";
            } else if (i < 135 - offset) {
                expected = "East";
            } else if (i < 180 - offset) {
                expected = "South East";
            } else if (i < 225 - offset) {
                expected = "South";
            } else if (i < 270 - offset) {
                expected = "South West";
            } else if (i < 315 - offset) {
                expected = "West";
            } else if (i < 360 - offset) {
                expected = "North West";
            } else {
                expected = "North";
            }
            assertEquals("Testing " + i + " degrees.",
                         expected,
                         OpenWeatherMapWeatherService.meteorologicalDegreesToCardinal(i));
        }
    }

}
