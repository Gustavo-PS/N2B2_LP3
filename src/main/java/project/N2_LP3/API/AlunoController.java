package project.N2_LP3.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.N2_LP3.MODEL.Aluno;
import project.N2_LP3.MODEL.Professor;
import project.N2_LP3.SERVICE.AlunoService;
import project.N2_LP3.SERVICE.ProfessorService;

import java.util.List;

@RestController
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping("api/aluno")
    public void addAluno(@RequestBody Aluno aluno){
        alunoService.addAluno(aluno);
    }

    @GetMapping("api/aluno")
    public List<Aluno> listAluno(){
        return alunoService.listAluno();
    }
}
