/*
 * TestingAPIController.java    Aug 15 2017, 08:15
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Used to sanity test various aspects of the running system.
 *
 * <ul>
 *   <li>Message conversion.</li>
 *   <li>Exception handling.</li>
 *   <li>Security.</li>
 * </ul>
 *
 * @author  Brett Ryan
 */
@RestController
public class TestingAPIController {

    @RequestMapping("/api/v1/test/exception")
    public void createException() throws Exception {
        throw new Exception("API Test exception");
    }

    @RequestMapping("/api/v1/test/timestamp")
    public LocalDateTime timestamp() {
        return LocalDateTime.now();
    }

    @RequestMapping("/api/v1/test/date")
    public LocalDate date() {
        return LocalDate.now();
    }

    @RequestMapping("/api/v1/test/time")
    public LocalTime time() {
        return LocalTime.now();
    }

    @RequestMapping("/api/v1/test/payload")
    public TestPayload payload() {
        return new TestPayload("Sample payload",
                               123,
                               10.123,
                               LocalDate.now(),
                               LocalTime.now(),
                               LocalDateTime.now());
    }

}
