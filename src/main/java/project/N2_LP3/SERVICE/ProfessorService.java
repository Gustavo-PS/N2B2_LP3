package project.N2_LP3.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import project.N2_LP3.DAO.ProfessorDao;
import project.N2_LP3.MODEL.Professor;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService {
    @Autowired
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

    public int deleteProfessor(UUID id) {
        return professorDao.deleteProfessor(id);
    }

    public int updateProfessor(Professor professor) {
        return professorDao.updateProfessor(professor);
    }
}
