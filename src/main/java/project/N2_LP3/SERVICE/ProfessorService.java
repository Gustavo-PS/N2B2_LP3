package project.N2_LP3.SERVICE;

import project.N2_LP3.*;
import project.N2_LP3.DAO.ProfessorDao;
import project.N2_LP3.MODEL.ProfessorModel;

public class ProfessorService {
    private final ProfessorDao professorDao;

    public ProfessorService(ProfessorDao professorDao){
        this.professorDao = professorDao;
    }

    public int addProfessor(ProfessorModel professor){
        return professorDao.insertProfessor(professor);
    }
}
