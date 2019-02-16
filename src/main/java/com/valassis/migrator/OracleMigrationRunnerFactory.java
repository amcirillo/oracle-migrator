package com.valassis.migrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by aaron on 2/15/19.
 */
@Component
public class OracleMigrationRunnerFactory {

    @Autowired
    @Qualifier("AOLRunnerBean")
    private OracleMigrationRunner aolRunner;

    @Autowired
    @Qualifier("CTLRunnerBean")
    private OracleMigrationRunner ctlRunner;

    @Autowired
    @Qualifier("SQLRunnerBean")
    private OracleMigrationRunner sqlRunner;

    public OracleMigrationRunner getInstance(OracleMigrationTypes type) {
        OracleMigrationRunner runner = null;
        switch (type) {
            case AOL:
                runner = aolRunner;
                break;
            case CTL:
                runner = ctlRunner;
                break;
            case SQL:
                runner = sqlRunner;
                break;
        }
        return runner;
    }

}
