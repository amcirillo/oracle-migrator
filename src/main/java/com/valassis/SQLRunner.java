package com.valassis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by aaron on 2/15/19.
 */
@Component
public class SQLRunner extends AbstractRunner {

    private static Logger log = LoggerFactory.getLogger(SQLRunner.class);

    public SQLRunner() {
        this.type = OracleMigrationTypes.SQL;
    }

    @Override
    public boolean runMigration() {
        log.info("Running migration for SQL object");
        log.info(this.name);
        log.info(this.type.toString());
        return true;
    }
}
