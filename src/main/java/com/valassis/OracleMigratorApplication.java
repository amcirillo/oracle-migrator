package com.valassis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by aaron on 2/15/19.
 */
@SpringBootApplication
public class OracleMigratorApplication implements CommandLineRunner{

    private static Logger log = LoggerFactory.getLogger(OracleMigratorApplication.class);

    @Autowired
    private OracleMigratorService oms;

    public static void main(String[] args) {
        log.info("Starting Oracle Migration");
        SpringApplication.run(OracleMigratorApplication.class, args);
        log.info("Oracle Migrator Finished");
    }

    @Override
    public void run(String... args) {
        log.info("Spring is executing the Oracle Migration Runner");
        for (int i = 0; i < args.length; ++i) {
            log.info("args[{}]: {}", i, args[i]);
        }
        oms.runMigration("AOL Object Example", OracleMigrationTypes.AOL);
        oms.runMigration("CTL Object Example", OracleMigrationTypes.CTL);
        oms.runMigration("SQL Object Example", OracleMigrationTypes.SQL);
    }
}
