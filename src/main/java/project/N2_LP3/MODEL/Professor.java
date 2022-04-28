package project.N2_LP3.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;

import java .util.UUID;

public class Professor {
    private final UUID id;
    private final String name;

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Professor(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
