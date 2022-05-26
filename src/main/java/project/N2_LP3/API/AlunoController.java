package project.N2_LP3.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import project.N2_LP3.MODEL.Aluno;
import project.N2_LP3.MODEL.Professor;
import project.N2_LP3.SERVICE.AlunoService;
import project.N2_LP3.SERVICE.ProfessorService;

import java.util.List;
import java.util.UUID;

@RestController
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping("api/aluno")
    @CrossOrigin
    public void addAluno(@RequestBody Aluno aluno){
        alunoService.addAluno(aluno);
    }

    @GetMapping("api/aluno")
    @CrossOrigin
    public List<Aluno> listAluno(){
        return alunoService.listAluno();
    }

    @DeleteMapping("api/aluno")
    @CrossOrigin
    public int deleteAluno(@RequestParam("id") UUID id){
        return alunoService.deleteAluno(id);
    }

    @PutMapping("api/aluno")
    @CrossOrigin
    public void updateAluno(@RequestBody Aluno aluno){ alunoService.updateAluno(aluno);}

}
