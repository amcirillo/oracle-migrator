package com.valassis.model;

import com.valassis.migrator.OracleMigrationTypes;

import java.util.List;

/**
 * Created by aaron on 2/15/19.
 */
public class Artifact {

    private String name;
    private OracleMigrationTypes type;
    private List<Var> params;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OracleMigrationTypes getType() {
        return type;
    }

    public void setType(OracleMigrationTypes type) {
        this.type = type;
    }

    public List<Var> getParams() {
        return params;
    }

    public void setParams(List<Var> params) {
        this.params = params;
    }
}
