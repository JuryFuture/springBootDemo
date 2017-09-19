package com.example.springBootDemo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {
    @Bean(name = "SaasDB")
    @Primary
    @ConfigurationProperties(prefix = "test.saas.datasource")
    @Qualifier("SaasDB")
    public DataSource saasDataSource() {
        return DataSourceBuilder.create().build();
    }
}
