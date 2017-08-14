/*
 * DbConfig.java    August 14 2017, 23:01
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

import com.zaxxer.hikari.HikariDataSource;
import java.beans.PropertyVetoException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.support.TransactionTemplate;


/**
 *
 * @author  Brett Ryan
 */
@Configuration
public class DbConfig {

    private final Environment env;

    @Autowired
    public DbConfig(Environment env) {
        this.env = env;
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(env.getProperty("db.driver"));
        ds.setJdbcUrl(env.getProperty("db.url"));
        ds.setUsername(env.getProperty("db.user"));
        ds.setPassword(env.getProperty("db.pass"));
        return ds;
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource,
                                                       @Value("classpath:com/drunkendev/weather/db/schema-security.sql") Resource schemaSecurity,
                                                       @Value("classpath:com/drunkendev/weather/db/schema-app.sql") Resource schemaApp,
                                                       @Value("classpath:com/drunkendev/weather/db/test-data.sql") Resource dataScript
    ) {
        DataSourceInitializer init = new DataSourceInitializer();
        init.setDataSource(dataSource);
        ResourceDatabasePopulator pop = new ResourceDatabasePopulator();
        pop.setContinueOnError(true);
        pop.addScript(schemaSecurity);
        //pop.addScript(schemaApp);
        //pop.addScript(dataScript);
        init.setDatabasePopulator(pop);
        init.setEnabled(env.getProperty("db.init", Boolean.class));
        return init;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public TransactionTemplate transactionTemplate(DataSourceTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }

}
