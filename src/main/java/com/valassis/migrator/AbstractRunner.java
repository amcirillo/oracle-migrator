package com.valassis.migrator;

/**
 * Created by aaron on 2/15/19.
 */
public class AbstractRunner implements OracleMigrationRunner {

    OracleMigrationTypes type = null;
    String name = null;

    public boolean runMigration() {
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

}
