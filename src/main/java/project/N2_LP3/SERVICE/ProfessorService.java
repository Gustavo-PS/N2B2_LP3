package project.N2_LP3.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import project.N2_LP3.DAO.ProfessorDao;
import project.N2_LP3.MODEL.Professor;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorDao professorDao;

    @Autowired
    public ProfessorService(@Qualifier("fakeDao")ProfessorDao professorDao){
        this.professorDao = professorDao;
    }

    public List<Professor> listProfessor(){
        return professorDao.getAllProfessor();
    }

    public int addProfessor(Professor professor){
        return professorDao.insertProfessor(professor);
    }
}
