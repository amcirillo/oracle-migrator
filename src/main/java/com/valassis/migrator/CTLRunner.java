package com.valassis.migrator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aaron on 2/15/19.
 */
public class CTLRunner extends AbstractRunner {

    private static Logger log = LoggerFactory.getLogger(CTLRunner.class);

    public CTLRunner() {
        this.type = OracleMigrationTypes.CTL;
    }

    @Override
    public boolean runMigration() {
        log.info("Running migration for CTL object");
        log.info(this.name);
        log.info(this.type.toString());
        return true;
    }
}
