package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.Aluno;
import project.N2_LP3.MODEL.Professor;

import java.util.List;
import java.util.UUID;

public interface AlunoDao {
    int insertAluno(UUID id, Aluno aluno);

    default int insertAluno(Aluno aluno) {
        UUID id = UUID.randomUUID();
        return insertAluno(id, aluno);
    }

    List<Aluno> getAllAlunos();

    int deleteAluno(UUID id);

    int updateAluno(Aluno aluno);

    Aluno getAlunoBD(UUID id);
}
