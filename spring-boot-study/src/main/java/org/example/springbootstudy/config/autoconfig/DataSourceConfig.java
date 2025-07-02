package org.example.springbootstudy.config.autoconfig;

import com.zaxxer.hikari.HikariDataSource;
import org.example.springbootstudy.config.ConditionalMyOnClass;
import org.example.springbootstudy.config.EnableMyConfigurationProperties;
import org.example.springbootstudy.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
@EnableMyConfigurationProperties(MyDataSourceProperties.class)
public class DataSourceConfig {
    @Bean
    DataSource dataSource(MyDataSourceProperties properties) throws ClassNotFoundException{
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource;
    }

    @Bean
    DataSource hikariDataSource(MyDataSourceProperties properties) throws ClassNotFoundException {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(properties.getDriverClassName()));
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        return dataSource(properties);
    }
}
