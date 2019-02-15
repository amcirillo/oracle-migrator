package com.valassis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aaron on 2/15/19.
 */
@Configuration
public class SpringConfiguration {

    @Bean(name="AOLRunnerBean")
    public OracleMigrationRunner aolRunner() {
        return new AOLRunner();
    }

    @Bean(name="SQLRunnerBean")
    public OracleMigrationRunner sqlRunner() {
        return new SQLRunner();
    }

    @Bean(name="CTLRunnerBean")
    public OracleMigrationRunner ctlRunner() {
        return new CTLRunner();
    }

}
