package project.N2_LP3.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import project.N2_LP3.DAO.AlunoDao;
import org.springframework.stereotype.Service;
import project.N2_LP3.MODEL.Aluno;

import java.beans.BeanProperty;
import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {
    @Autowired
    private final AlunoDao alunoDao;

    @Autowired
    public AlunoService(@Qualifier("fakeDaoAluno") AlunoDao alunoDao){
        this.alunoDao =alunoDao;
    }

    public List<Aluno> listAluno(){
        return alunoDao.getAllAlunos();
    }

    public int addAluno(Aluno aluno){
        return alunoDao.insertAluno(aluno);
    }

    public int deleteAluno(UUID id) {
        return alunoDao.deleteAluno(id);
    }

    public int updateAluno(Aluno aluno) {
        return alunoDao.updateAluno(aluno);
    }
}
