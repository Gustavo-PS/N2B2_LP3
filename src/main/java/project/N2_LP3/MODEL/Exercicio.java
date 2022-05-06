package project.N2_LP3.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Exercicio {

    private final UUID id;
    private final String name;
    private final String description;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Exercicio(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
