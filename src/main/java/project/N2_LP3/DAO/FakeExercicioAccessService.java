package project.N2_LP3.DAO;

import project.N2_LP3.MODEL.Aluno;
import project.N2_LP3.MODEL.Exercicio;
import project.N2_LP3.SERVICE.ExercicioService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class FakeExercicioAccessService implements ExercicioDao {

    private static List<Exercicio> lstGetExercicio = new ArrayList<>();

    Connection connection = ConnectionBD.conDB();
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;

    @Override
    public int insertExercicio(UUID id, Exercicio exercicio){

        try {
            String insert = "INSERT INTO tb_exercise(id, name, description) VALUES (?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(insert);
            preparedStatement.setString(1, id.toString());
            preparedStatement.setString(2, exercicio.getName());
            preparedStatement.setString(3,exercicio.getDescription());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
  public List<Exercicio> getAllExercicio(){
        try {
            String select = "SELECT * FROM `tb_exercise`";
            preparedStatement = (PreparedStatement) connection.prepareStatement(select);
            ResultSet returnQueryExercicio = preparedStatement.executeQuery(select);
            while (returnQueryExercicio.next()) {
                UUID id = UUID.fromString(returnQueryExercicio.getString("id"));
                String name = returnQueryExercicio.getString("name");
                String description = returnQueryExercicio.getString("description");


                Exercicio exercicio = new Exercicio(id, name, description);
                lstGetExercicio.add(exercicio);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lstGetExercicio;
    }

    @Override
    public int deleteExercicio(UUID id){
        try{
            callableStatement = connection.prepareCall("{CALL spDeleteExercise(?)}");
            callableStatement.setString(1, id.toString() );
            callableStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateExercicio(Exercicio exercicio) {
        try {
            String update = "UPDATE tb_exercise SET name = ?, description = ? WHERE id = ?`";
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, exercicio.getName());
            preparedStatement.setString(2, exercicio.getDescription());
            preparedStatement.setString(3, exercicio.getId().toString());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
