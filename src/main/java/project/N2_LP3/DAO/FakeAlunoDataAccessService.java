package project.N2_LP3.DAO;

import org.springframework.stereotype.Repository;
import project.N2_LP3.MODEL.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("fakeDaoAluno")
public class FakeAlunoDataAccessService implements AlunoDao {
    private static List<Aluno> lstGetAluno = new ArrayList<>();
    Connection connection = (Connection) ConnectionBD.conDB();
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;

    @Override
    public int insertAluno(UUID id, Aluno aluno) {
        try {
            String insert = "INSERT INTO tb_student( id, name, login, password, birthday, genre, height,width, training, instructor) VALUES (?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, id.toString());
            preparedStatement.setString(2, aluno.getName());
            preparedStatement.setString(3, aluno.getLogin());
            preparedStatement.setString(4, aluno.getPassword());
            preparedStatement.setDate(5, new java.sql.Date(aluno.getBirthday().getTime()));
            preparedStatement.setString(6, String.valueOf(aluno.getGenre()));
            preparedStatement.setDouble(7, aluno.getHeight());
            preparedStatement.setDouble(8, aluno.getWidth());
            preparedStatement.setString(9, aluno.getTraining());
            preparedStatement.setString(10, aluno.getInstructor());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int insertAluno(Aluno alunoModel) {
        return AlunoDao.super.insertAluno(alunoModel);
    }

    @Override
    public List<Aluno> getAllAlunos() {
        try {
            String select = "SELECT * FROM `tb_student`";
            preparedStatement = (PreparedStatement) connection.prepareStatement(select);
            ResultSet returnQueryAluno = preparedStatement.executeQuery(select);
            while (returnQueryAluno.next()) {
                UUID id = UUID.fromString(returnQueryAluno.getString("id"));
                String name = returnQueryAluno.getString("name");
                String login = returnQueryAluno.getString("login");
                String password = returnQueryAluno.getString("password");
                Date birthday = returnQueryAluno.getDate("birthday");
                Character genre = returnQueryAluno.getString("genre").charAt(0);
                Double width = returnQueryAluno.getDouble("width");
                Double heigth = returnQueryAluno.getDouble("height");
                String training = returnQueryAluno.getString("training");
                String instructor = returnQueryAluno.getString("instructor");

                Aluno aluno = new Aluno(id, name, login, password, birthday, genre, width, heigth, training, instructor);
                lstGetAluno.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lstGetAluno;
    }

    @Override
    public int deleteAluno(UUID id) {
        try {
            callableStatement = connection.prepareCall("{CALL spDeleteStudent(?)}");
            callableStatement.setString(1, id.toString());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateAluno(Aluno aluno) {
        try {
            String update = "UPDATE tb_student SET name = ?, birthday = ?, password = ?, genre = ?, height = ?, width = ?, training = ?, instructor = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, aluno.getName());
            preparedStatement.setDate(2, new java.sql.Date(aluno.getBirthday().getTime()));
            preparedStatement.setString(3, aluno.getPassword());
            preparedStatement.setString(4, String.valueOf(aluno.getGenre()));
            preparedStatement.setDouble(5, aluno.getHeight());
            preparedStatement.setDouble(6, aluno.getWidth());
            preparedStatement.setString(7, aluno.getTraining());
            preparedStatement.setString(8, aluno.getInstructor());
            preparedStatement.setString(9, aluno.getId().toString());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Aluno getAlunoBD(UUID idQuery) {
        try {
            String select = "SELECT * FROM `tb_student` where id = ?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(select);
            preparedStatement.setString(1, idQuery.toString());
            ResultSet returnQueryAluno = preparedStatement.executeQuery(select);
            while (returnQueryAluno.next()) {
                UUID id = UUID.fromString(returnQueryAluno.getString("id"));
                String name = returnQueryAluno.getString("name");
                String login = returnQueryAluno.getString("login");
                String password = returnQueryAluno.getString("password");
                Date birthday = returnQueryAluno.getDate("birthday");
                Character genre = returnQueryAluno.getString("genre").charAt(0);
                Double width = returnQueryAluno.getDouble("width");
                Double heigth = returnQueryAluno.getDouble("height");
                String training = returnQueryAluno.getString("training");
                String instructor = returnQueryAluno.getString("instructor");

                Aluno aluno = new Aluno(id, name, login, password, birthday, genre, width, heigth, training, instructor);
                return aluno;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Aluno alunoNull = null;
        return alunoNull;
    }
}