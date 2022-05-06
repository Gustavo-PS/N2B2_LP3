package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.Exercicio;
import project.N2_LP3.MODEL.Treino;

import java.util.List;
import java.util.UUID;

public interface TreinoDao {
    List<Treino> getAllTreino();

    int deleteTreino(UUID id);

    int insertTreino(UUID id, Treino treino);

    default int insertTreino(Treino treino) {
        UUID id = UUID.randomUUID();
        return insertTreino(id, treino);
    }

    int updateTreino(Treino treino);
}
