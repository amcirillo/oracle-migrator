package com.valassis.migrator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aaron on 2/15/19.
 */
public class AOLRunner extends AbstractRunner {

    private static Logger log = LoggerFactory.getLogger(AOLRunner.class);

    public AOLRunner() {
        this.type = OracleMigrationTypes.AOL;
    }

    @Override
    public boolean runMigration() {
        log.info("Running migration for AOL object");
        log.info(this.name);
        log.info(this.type.toString());
        return true;
    }

}
