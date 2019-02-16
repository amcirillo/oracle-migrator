package com.valassis.migrator;

import org.springframework.stereotype.Component;

/**
 * Created by aaron on 2/15/19.
 */
@Component
public interface OracleMigrationRunner {

    public boolean runMigration();
    public void setName(String name);

}
