package com.francesca.pascalau.config.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "tenants")
public class DataSourceProperties {

    private Map<Object, Object> datasources = new LinkedHashMap<>();

    public Map<Object, Object> getDatasources() {
        return datasources;
    }

    public void setDatasources(Map<String, Map<String, String>> datasources) {
        datasources.forEach((key, value) -> this.datasources.put(key, buildDataSource(value)));
    }

    private DataSource buildDataSource(Map<String, String> source) {
        return getCustomHikariDataSource(
                DataSourceBuilder.create()
                        .url(source.get("jdbcUrl"))
                        .driverClassName(source.get("driverClassName"))
                        .username(source.get("username"))
                        .password(source.get("password"))
                        .build()
        );
    }

    private HikariDataSource getCustomHikariDataSource(DataSource dataSource) {
        return new HikariDataSource(setConnectionPoolProperties(dataSource));
    }

    private HikariConfig setConnectionPoolProperties(DataSource dataSource) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDataSource(dataSource);
        hikariConfig.setConnectionTimeout(20000);
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setMaxLifetime(1800000);
        setReadOnly(dataSource, hikariConfig);

        return hikariConfig;
    }

    private void setReadOnly(DataSource dataSource, HikariConfig hikariConfig) {
        try {
            String jdbcUrl = dataSource.getConnection().getMetaData().getURL();
            String databaseName = jdbcUrl.substring(jdbcUrl.length() - 4);
            if (databaseName.equals("read")) {
                hikariConfig.setReadOnly(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}