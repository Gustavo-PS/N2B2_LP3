package project.N2_LP3.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.N2_LP3.MODEL.Professor;
import project.N2_LP3.SERVICE.ProfessorService;

import java.util.List;

@RestController
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @PostMapping("api/professor")
    public void addProfessor(@RequestBody Professor professor){
        professorService.addProfessor(professor);
    }

    @GetMapping("api/professor")
    public List<Professor> listProfessor(){
        return professorService.listProfessor();
    }
}
