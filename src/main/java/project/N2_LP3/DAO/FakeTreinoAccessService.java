package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.Exercicio;
import project.N2_LP3.MODEL.Professor;
import project.N2_LP3.MODEL.Treino;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
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
        try {
            String select = "SELECT * FROM `tb_training`";
            preparedStatement = (PreparedStatement) connection.prepareStatement(select);
            ResultSet returnQueryExercicio = preparedStatement.executeQuery(select);
            while (returnQueryExercicio.next()) {
                UUID id = UUID.fromString(returnQueryExercicio.getString("id"));
                String exercicio1 = returnQueryExercicio.getString("exercise_1");
                String exercicio2= returnQueryExercicio.getString("exercise_2");
                String exercicio3 = returnQueryExercicio.getString("exercise_3");


                Treino treino = new Treino(id, UUID.fromString(exercicio1),UUID.fromString(exercicio2),UUID.fromString(exercicio3));
                lstGetTreino.add(treino);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lstGetTreino;
    }

    @Override
    public int deleteTreino(UUID id) {
        try{
            callableStatement = connection.prepareCall("{CALL spDeleteTraining(?)}");
            callableStatement.setString(1, id.toString() );
            callableStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public Treino getTreinoBD(UUID idQuery) {
        try {
            String select = "SELECT * FROM `tb_training` where id = ?";
            preparedStatement = (PreparedStatement) connection.prepareStatement(select);
            preparedStatement.setString(1, idQuery.toString());
            ResultSet returnQueryAluno = preparedStatement.executeQuery(select);
            while (returnQueryAluno.next()) {
                UUID id = UUID.fromString(returnQueryAluno.getString("id"));
                String exercicio1 = returnQueryAluno.getString("exercise_1");
                String exercicio2 = returnQueryAluno.getString("exercise_2");
                String exercicio3= returnQueryAluno.getString("exercise_3");

                Treino treino = new Treino(id,UUID.fromString(exercicio1),UUID.fromString(exercicio2),UUID.fromString(exercicio3));
                return treino;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Treino treinoNull = null;
        return treinoNull;
    }
}
