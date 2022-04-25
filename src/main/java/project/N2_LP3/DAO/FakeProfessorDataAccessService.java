package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.ProfessorModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeProfessorDataAccessService implements ProfessorDao{
    private static List<ProfessorModel> DB = new ArrayList<>();

    @Override
    public int insertProfessor(UUID id, ProfessorModel professor){
        DB.add(new ProfessorModel(id, professor.getName()));
        return 1;
    }

    @Override
    public int insertProfessor(UUID id, String name) {
        return 0;
    }

    @Override
    public int insertProfessor(ProfessorModel professor) {
        return ProfessorDao.super.insertProfessor(professor);
    }
}
