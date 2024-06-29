package com.ascii274.login.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties("environments.development.datasource")
public class MySQLConfig {

    private String mysqlDatabase;
    private String MYSQL_USER;
    private String MYSQL_PASSWORD;
    private String MYSQL_ROOT_PASSWORD;
    private String MYSQL_PORT;
    private String ENTITY_TO_SCAN;
    private String URL;


}
