package project.N2_LP3.DAO;

import org.springframework.stereotype.Repository;
import project.N2_LP3.MODEL.Aluno;
import project.N2_LP3.MODEL.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Repository("fakeDao")
public class FakeProfessorDataAccessService implements ProfessorDao {
    private final static List<Professor> lstGetProfessor = new ArrayList<>();
    Connection connection = (Connection) ConnectionBD.conDB();
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;

    @Override
    public int insertProfessor(UUID id, Professor professor) {
        try {

            String insert = "INSERT INTO tb_instructor( id, name, login, password, birthday, genre) VALUES (?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, id.toString());
            preparedStatement.setString(2, professor.getName());
            preparedStatement.setString(3,professor.getLogin());
            preparedStatement.setString(4,professor.getPassword());
            preparedStatement.setDate(5,new java.sql.Date(professor.getBirthday().getTime()));
            preparedStatement.setString(6, String.valueOf(professor.getGenre()));
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insertProfessor(Professor professorModel) {
        return ProfessorDao.super.insertProfessor(professorModel);
    }

    @Override
    public List<Professor> getAllProfessor() {
        try {
            String select = "SELECT * FROM `tb_instructor`";
            preparedStatement = (PreparedStatement) connection.prepareStatement(select);
            ResultSet returnQueryProfessor = preparedStatement.executeQuery(select);
            while (returnQueryProfessor.next()) {
                UUID id = UUID.fromString(returnQueryProfessor.getString("id"));
                String name = returnQueryProfessor.getString("name");
                String login = returnQueryProfessor.getString("login");
                String password = returnQueryProfessor.getString("password");
                Date birthday = returnQueryProfessor.getDate("birthday");
                Character genre = returnQueryProfessor.getString("genre").charAt(0);

                Professor professor = new Professor(id, name, login, password, birthday, genre);
                lstGetProfessor.add(professor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lstGetProfessor;
    }

    @Override
    public int deleteProfessor(UUID id){
        try{
            callableStatement = connection.prepareCall("{CALL spDeleteInstructor(?)}");
            callableStatement.setString(1, id.toString() );
            callableStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateProfessor(Professor professor) {
        try {
            String update = "UPDATE tb_instructor SET name = ?, birthday = ?, password = ?, genre = ? WHERE id = ?`";
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, professor.getName());
            preparedStatement.setDate(2, new java.sql.Date(professor.getBirthday().getTime()));
            preparedStatement.setString(3, professor.getPassword());
            preparedStatement.setString(4, String.valueOf(professor.getGenre()));
            preparedStatement.setString(5, professor.getId().toString());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
