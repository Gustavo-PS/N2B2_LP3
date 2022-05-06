package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.Professor;

import java.util.List;
import java.util.UUID;

public interface ProfessorDao {
    int insertProfessor(UUID id, Professor professor);

    default int insertProfessor(Professor professor) {
        UUID id = UUID.randomUUID();
        return insertProfessor(id, professor);
    }

    List<Professor> getAllProfessor();
    int deleteProfessor(UUID id);
}
