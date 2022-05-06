package project.N2_LP3.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.N2_LP3.MODEL.Aluno;
import project.N2_LP3.MODEL.Exercicio;
import project.N2_LP3.SERVICE.AlunoService;
import project.N2_LP3.SERVICE.ExercicioService;

import java.util.List;
import java.util.UUID;

public class ExercicioController {

    private final ExercicioService exercicioService;

    @Autowired
    public ExercicioController(ExercicioService exercicioService){
        this.exercicioService = exercicioService;
    }

    @PostMapping("api/exercicio")
    public void addExercicio(@RequestBody Exercicio exercicio){
        exercicioService.addExercicio(exercicio);
    }

    @GetMapping("api/exercicio")
    public List<Exercicio> listExercicio(){
        return exercicioService.listExercicio();
    }

    @DeleteMapping("api/exercicio")
    public int deleteExercicio(@RequestParam("id") UUID id){
        return exercicioService.deleteExercicio(id);
    }

    @PutMapping("api/exercicio")
    public int updateExercicio(@RequestBody Exercicio exercicio){return exercicioService.updateExercicio(exercicio);}
}
