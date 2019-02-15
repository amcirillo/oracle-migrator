package com.valassis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aaron on 2/15/19.
 */
@Service
public class OracleMigratorService {

    private static Logger log = LoggerFactory.getLogger(OracleMigratorService.class);

    @Autowired
    private OracleMigrationRunnerFactory factory;

    public boolean runMigration(String name, OracleMigrationTypes type) {
        log.info("Oracle Migrator Service is running migration");
        OracleMigrationRunner runner = factory.getInstance(type);
        runner.setName(name);
        runner.runMigration();
        return true;
    }
}
