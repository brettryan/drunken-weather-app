/*
 * AppInitializer.java    August 14 2017, 23:01
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

package com.drunkendev.weather.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * Initializer for the MVC application.
 *
 * @author  Brett Ryan
 */
@Order(1)
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
            RootConfig.class,
            DbConfig.class,
            SecurityConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // NOTE: For a single context, move WebConfig.class to the root config and return null here.
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
