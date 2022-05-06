package project.N2_LP3.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import project.N2_LP3.DAO.AlunoDao;
import project.N2_LP3.DAO.ExercicioDao;
import project.N2_LP3.MODEL.Exercicio;

import java.util.List;
import java.util.UUID;

public class ExercicioService {

    @Autowired
    private final ExercicioDao exercicioDao;

    @Autowired
    public ExercicioService(@Qualifier("fakeDaoExercicio") ExercicioDao exercicioDaoDao){
        this.exercicioDao =exercicioDaoDao;
    }
    public int addExercicio(Exercicio exercicio) {
        return exercicioDao.insertExercicio(exercicio);
    }

    public List<Exercicio> listExercicio() {
        return exercicioDao.getAllExercicio();
    }

    public int deleteExercicio(UUID id) {
        return exercicioDao.deleteExercicio(id);
    }

    public int updateExercicio(Exercicio exercicio) {
        return exercicioDao.updateExercicio(exercicio);
    }
}
