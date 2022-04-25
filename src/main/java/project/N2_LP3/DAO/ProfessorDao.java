package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.ProfessorModel;
import java.util.UUID;

public interface ProfessorDao {
    int insertProfessor(UUID id, ProfessorModel professor);

    int insertProfessor(UUID id, String name);

default int insertProfessor(ProfessorModel professor){
    UUID id = UUID.randomUUID();
    return insertProfessor(id, professor.getName());
}
}
