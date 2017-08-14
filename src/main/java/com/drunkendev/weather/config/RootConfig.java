/*
 * RootConfig.java    August 14 2017, 23:01
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

import com.fasterxml.jackson.databind.SerializationFeature;
import com.drunkendev.web.settings.AppConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.BooleanUtils;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.trimToNull;
import static org.springframework.context.annotation.FilterType.ANNOTATION;


/**
 *
 * @author  Brett Ryan
 */
@Configuration
@ComponentScan(basePackages = {"com.drunkendev.web", "com.drunkendev.weather"},
               excludeFilters = {
                   @Filter(type = ANNOTATION, value = Configuration.class),
                   @Filter(type = ANNOTATION, value = Controller.class)
               })
@PropertySources({
    @PropertySource(ignoreResourceNotFound = true, value = "classpath:weather.config.properties"),
    @PropertySource(ignoreResourceNotFound = true, value = "classpath:weather.user.config.properties"),
    @PropertySource(ignoreResourceNotFound = true, value = "file:///${weather.config}")
})
public class RootConfig {

    private static final Logger LOG = LoggerFactory.getLogger(RootConfig.class);

    private final Environment env;

    @Autowired
    public RootConfig(Environment env) {
        this.env = env;
    }

    @Bean(initMethod = "start",
          destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        String val = trimToNull(env.getProperty("db.h2.server.tcp.enabled"));
        if (BooleanUtils.toBoolean(val) || "1".equals(val)) {
            LOG.debug("Starting h2 TCP server");

            List<String> args = new ArrayList<>();
            args.add("-tcp");
            args.add("-tcpPort");
            args.add(env.getProperty("db.h2.server.tcp.port"));

            val = trimToNull(env.getProperty("db.h2.server.ssl"));
            if (BooleanUtils.toBoolean(val) || "1".equals(val)) {
                args.add("-tcpSSL");
            }
            val = trimToNull(env.getProperty("db.h2.server.tcp.daemon"));
            if (BooleanUtils.toBoolean(val) || "1".equals(val)) {
                args.add("tcpDaemon");
            }

            val = trimToNull(env.getProperty("db.h2.server.trace"));
            if (BooleanUtils.toBoolean(val) || "1".equals(val)) {
                args.add("-trace");
            }

            val = trimToNull(env.getProperty("db.h2.server.basedir"));
            if (isNotBlank(val)) {
                args.add("-baseDir");
                args.add(val.trim());
            }
            return Server.createTcpServer(args.toArray(new String[args.size()]));
        }
        return null;
    }

    @Bean
    public AppConfig appConfig() {
        return new AppConfig(RootConfig.class.getClassLoader(), "weather");
    }

    @Bean
    public UserDetailsService userDetailsService(JdbcTemplate jdbcTemplate) {
        JdbcUserDetailsManager res = new JdbcUserDetailsManager();
        res.setJdbcTemplate(jdbcTemplate);
        return res;
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper res = new ObjectMapper();
        res.registerModule(new JavaTimeModule());
        res.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return res;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource res = new ResourceBundleMessageSource();
        res.setBasenames("i18n/i18n");
        res.setDefaultEncoding("UTF-8");
        res.setUseCodeAsDefaultMessage(true);
        return res;
    }

}
