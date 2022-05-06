package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.Exercicio;
import project.N2_LP3.MODEL.Treino;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeTreinoAccessService implements TreinoDao {
    private static List<Treino> lstGetTreino = new ArrayList<>();

    Connection connection = (Connection) ConnectionBD.conDB();
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;


    @Override
    public int insertTreino(Treino treino) {
        UUID id = UUID.randomUUID();
        return insertTreino(id, treino);
    }

    @Override
    public List<Treino> getAllTreino() {
        return lstGetTreino;
    }

    @Override
    public int deleteTreino(UUID id) {
        return 0;
    }

    @Override
    public int insertTreino(UUID id, Treino treino) {
        try {
            String insert = "INSERT INTO tb_training(id, exercise_1, exercise_2,exercise_3) VALUES (?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, id.toString());
            preparedStatement.setString(2, treino.getExercise1().toString());
            preparedStatement.setString(3, treino.getExercise2().toString());
            preparedStatement.setString(4, treino.getExercise3().toString());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateTreino(Treino treino) {
        try {
            String update = "UPDATE tb_training SET name = ?, description = ? WHERE id = ?`";
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, treino.getExercise1().toString());
            preparedStatement.setString(2, treino.getExercise2().toString());
            preparedStatement.setString(3, treino.getExercise3().toString());
            preparedStatement.setString(4, treino.getId().toString());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
