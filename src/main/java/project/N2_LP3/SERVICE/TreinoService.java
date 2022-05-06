package project.N2_LP3.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import project.N2_LP3.DAO.ExercicioDao;
import project.N2_LP3.DAO.TreinoDao;
import project.N2_LP3.MODEL.Exercicio;
import project.N2_LP3.MODEL.Treino;

import java.util.List;
import java.util.UUID;

public class TreinoService {
       @Autowired
    private final TreinoDao treinoDao;

    @Autowired
    public TreinoService(@Qualifier("fakeDaoTreino") TreinoDao treinoDao){
        this.treinoDao=treinoDao;
    }
    public int addTreino(Treino treino) {
        return treinoDao.insertTreino(treino);
    }

    public List<Treino> listTreino() {
        return treinoDao.getAllTreino();
    }

    public int deleteTreino(UUID id) {
        return treinoDao.deleteTreino(id);
    }
}
