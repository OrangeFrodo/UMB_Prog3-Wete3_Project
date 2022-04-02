package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Employee {
    private final UUID id;
    private final String name;
    private final String workOurs;
    private final String project;

    public Employee(@JsonProperty("id") UUID id,
                    @JsonProperty("name") String name,
                    @JsonProperty("hours") String workOurs,
                    @JsonProperty("project") String project) {
        this.id = id;
        this.name = name;
        this.workOurs = workOurs;
        this.project = project;
    }

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWorkOurs() {
        return workOurs;
    }

    public String getProject() {
        return project;
    }
}
