/*
 * AppWebConfig.java    August 14 2017, 23:01
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

import com.drunkendev.web.tiles.SpringCompleteAutoloadTilesInitializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import static org.springframework.context.annotation.FilterType.ANNOTATION;


/**
 *
 * @author  bryan
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.drunkendev.web", "com.drunkendev.weather"},
               useDefaultFilters = false,
               includeFilters = {
                   @Filter(type = ANNOTATION, value = Controller.class)
               }
)
public class WebConfig extends WebMvcConfigurerAdapter {

    private final ObjectMapper objectMapper;

    @Autowired
    public WebConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        CookieLocaleResolver bean = new CookieLocaleResolver();
        bean.setCookieName("clientlanguage");
        bean.setCookieMaxAge(100000);
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        registry.addInterceptor(lci);
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer res = new TilesConfigurer();
        res.setTilesInitializer(new SpringCompleteAutoloadTilesInitializer());
        res.setDefinitions("/WEB-INF/**/tiles*.xml");
        return res;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.tiles();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/home", "/");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/sudo").setViewName("sudo");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/aboutme").setViewName("aboutme");
        registry.addViewController("/error/403").setViewName("error/403");
        registry.addViewController("/error/404").setViewName("error/404");
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }

}
