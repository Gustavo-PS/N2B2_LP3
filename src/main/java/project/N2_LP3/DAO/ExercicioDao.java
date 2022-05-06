package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.Aluno;
import project.N2_LP3.MODEL.Exercicio;

import java.util.List;
import java.util.UUID;

public interface ExercicioDao {
    int insertExercicio(UUID id, Exercicio exercicio);

    default int insertExercicio(Exercicio exercicio) {
        UUID id = UUID.randomUUID();
        return insertExercicio(id, exercicio);
    }

     List<Exercicio> getAllExercicio() ;

     int deleteExercicio(UUID id) ;
}
