package project.N2_LP3.DAO;

import org.springframework.stereotype.Repository;
import project.N2_LP3.MODEL.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Repository("fakeDao")
public class FakeProfessorDataAccessService implements ProfessorDao{
    private static List<Professor> lstGetProfessor = new ArrayList<>();
    Connection connection = (Connection) ConnectionBD.conDB();
    PreparedStatement preparedStatement;

    @Override
    public int insertProfessor(UUID id, Professor professor) {
        try{

            String insert = "INSERT INTO testetabela( id, nome) VALUES (?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, id.toString());
            preparedStatement.setString(2, professor.getName());
            preparedStatement.executeUpdate();
            return 1;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int insertProfessor(Professor professorModel) {
        return ProfessorDao.super.insertProfessor(professorModel);
    }

    @Override
    public List<Professor> getAllProfessor(){
        try{
            String select = "SELECT * FROM `testetabela`";
            preparedStatement = (PreparedStatement) connection.prepareStatement(select);
            ResultSet returnQueryProfessor = preparedStatement.executeQuery(select);
        while (returnQueryProfessor.next()){
            UUID id = UUID.fromString(returnQueryProfessor.getString("id"));
            String name = returnQueryProfessor.getString("nome");

            Professor professor = new Professor(id,name);
            lstGetProfessor.add(professor);
        }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lstGetProfessor;
    }
}
