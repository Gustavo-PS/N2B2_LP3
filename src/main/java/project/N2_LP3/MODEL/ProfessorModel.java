package project.N2_LP3.MODEL;

import java .util.UUID;

public class ProfessorModel {
    private final UUID id;
    private final String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProfessorModel(UUID id, String name) {
        this.id = id;
        this.name = name;
    }


}
