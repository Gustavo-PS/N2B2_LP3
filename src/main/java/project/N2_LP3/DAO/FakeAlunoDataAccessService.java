package project.N2_LP3.DAO;

import org.springframework.stereotype.Repository;
import project.N2_LP3.MODEL.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("fakeDaoAluno")
public class FakeAlunoDataAccessService implements AlunoDao {
    private static List<Aluno> lstGetAluno = new ArrayList<>();
    Connection connection = (Connection) ConnectionBD.conDB();
    PreparedStatement preparedStatement;

    @Override
    public int insertAluno(UUID id, Aluno aluno) {
        try {
            String insert = "INSERT INTO tb_student( id, name, login, password, birthday, genre, height,width, training, instructor) VALUES (?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, id.toString());
            preparedStatement.setString(2, aluno.getName());
            preparedStatement.setString(3,aluno.getLogin());
            preparedStatement.setString(4,aluno.getPassword());
            preparedStatement.setDate(5,new java.sql.Date(aluno.getBirthday().getTime()));
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

                Aluno aluno = new Aluno(id, name, login, password, birthday, genre,width,heigth,training,instructor);
                lstGetAluno.add(aluno);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lstGetAluno;
    }
}
