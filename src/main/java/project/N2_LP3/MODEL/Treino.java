package project.N2_LP3.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Treino {
    private final UUID id;
    private final UUID exercise1;
    private final UUID exercise2;
    private final UUID exercise3;

    public UUID getId() {
        return id;
    }

    public UUID getExercise1() {
        return exercise1;
    }

    public UUID getExercise2() {
        return exercise2;
    }

    public UUID getExercise3() {
        return exercise3;
    }

    public Treino(@JsonProperty("id") UUID id, @JsonProperty("exercise1") UUID exercise1,
                  @JsonProperty("exercise2") UUID exercise2, @JsonProperty("exercise3") UUID exercise3) {
        this.id = id;
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
        this.exercise3 = exercise3;
    }
}
