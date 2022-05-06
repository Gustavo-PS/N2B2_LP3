package project.N2_LP3.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.N2_LP3.MODEL.Exercicio;
import project.N2_LP3.MODEL.Treino;
import project.N2_LP3.SERVICE.ExercicioService;
import project.N2_LP3.SERVICE.TreinoService;

import java.util.List;
import java.util.UUID;

public class TreinoController {
    private final TreinoService treinoService;

    @Autowired
    public TreinoController(TreinoService treinoService){
        this.treinoService = treinoService;
    }

    @PostMapping("api/treino")
    public void addTreino(@RequestBody Treino treino){
        treinoService.addTreino(treino);
    }

    @GetMapping("api/treino")
    public List<Treino> listTreino(){
        return treinoService.listTreino();
    }

    @DeleteMapping("api/exercicio")
    public int deleteTreino(@RequestParam("id") UUID id){
        return treinoService.deleteTreino(id);
    }
}
