/*
 * SecurityConfig.java    August 14 2017, 23:01
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.drunkendev.web.security.ApiErrorBasicAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author  Brett Ryan
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Order(2)
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,
                                @Qualifier("userDetailsService") UserDetailsService userDetailsService) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        private final UserDetailsService userDetailsService;

        @Autowired
        public FormLoginWebSecurityConfigurerAdapter(UserDetailsService userDetailsService) {
            this.userDetailsService = userDetailsService;
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/static/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/static").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login").permitAll().defaultSuccessUrl("/")
                    .and()
                    .logout().logoutUrl("/logout").logoutSuccessUrl("/")
                    .and()
                    .exceptionHandling().accessDeniedPage("/error/403");
        }

        @Override
        protected UserDetailsService userDetailsService() {
            return userDetailsService;
        }

    }


    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        private final ObjectMapper mapper;
        private final UserDetailsService userDetailsService;

        @Autowired
        public ApiWebSecurityConfigurationAdapter(ObjectMapper mapper,
                                                  UserDetailsService userDetailsService) {
            this.mapper = mapper;
            this.userDetailsService = userDetailsService;
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/static/**");
        }

        @Bean
        public ApiErrorBasicAuthenticationEntryPoint xBasicAuthenticationEntryPoint() {
            ApiErrorBasicAuthenticationEntryPoint res = new ApiErrorBasicAuthenticationEntryPoint(mapper);
            res.setRealmName("com.drunkendev.weather");
            return res;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    //.csrf().disable() // Disable for all API calls.
                    .antMatcher("/api/**")
                    .authorizeRequests()
                    .antMatchers("/api/v1/weather").permitAll()
                    .antMatchers("/api/v1/cities").permitAll()
                    .antMatchers("/static").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic().realmName("com.drunkendev.weather")
                    .authenticationEntryPoint(xBasicAuthenticationEntryPoint())
                    .and().sessionManagement();
        }

        @Override
        protected UserDetailsService userDetailsService() {
            return userDetailsService;
        }

    }

}
