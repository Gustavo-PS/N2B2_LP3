package project.N2_LP3.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.N2_LP3.MODEL.Aluno;
import project.N2_LP3.MODEL.Exercicio;
import project.N2_LP3.SERVICE.AlunoService;
import project.N2_LP3.SERVICE.ExercicioService;

import java.util.List;
import java.util.UUID;

@RestController
public class ExercicioController {

    private final ExercicioService exercicioService;

    @Autowired
    public ExercicioController(ExercicioService exercicioService){
        this.exercicioService = exercicioService;
    }

    @PostMapping("api/exercicio")
    @CrossOrigin
    public void addExercicio(@RequestBody Exercicio exercicio){
        exercicioService.addExercicio(exercicio);
    }

    @GetMapping("api/exercicio")
    @CrossOrigin
    public List<Exercicio> listExercicio(){
        return exercicioService.listExercicio();
    }

    @DeleteMapping("api/exercicio")
    @CrossOrigin
    public int deleteExercicio(@RequestParam("id") UUID id){
        return exercicioService.deleteExercicio(id);
    }

    @PutMapping("api/exercicio")
    @CrossOrigin
    public int updateExercicio(@RequestBody Exercicio exercicio){return exercicioService.updateExercicio(exercicio);}
}
