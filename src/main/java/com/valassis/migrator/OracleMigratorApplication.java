package com.valassis.migrator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.valassis.model.Artifact;
import com.valassis.model.Migration;
import com.valassis.model.Var;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    public void run(String... args) throws Exception {
        log.info("Spring is executing the Oracle Migration Runner");
        for (int i = 0; i < args.length; ++i) {
            log.info("args[{}]: {}", i, args[i]);
        }
        File yamlFile = new File(args[0]);
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        Migration migration = om.readValue(yamlFile, Migration.class);
        for(Artifact artifact : migration.getArtifacts()) {
            oms.runMigration(artifact.getName(), artifact.getType());
        }
    }

    private void buildModel() throws Exception {
        Migration migration = new Migration();
        migration.setArtifacts(buildArtifacts(5));
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        log.info(om.writeValueAsString(migration));
    }

    private List<Var> buildVars(int number) {
        List<Var> vars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Var var = new Var();
            var.setKey("key " + i);
            var.setValue("value " + i);
            vars.add(var);
        }
        return vars;
    }

    private List<Artifact> buildArtifacts(int number) {
        List<Artifact> artifacts = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Artifact artifact = new Artifact();
            artifact.setParams(buildVars(3));
            artifact.setType(OracleMigrationTypes.AOL);
            artifact.setName("Name " + i);
            artifacts.add(artifact);
        }
        return artifacts;
    }
}
