package project.N2_LP3.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.N2_LP3.MODEL.Professor;
import project.N2_LP3.SERVICE.ProfessorService;

import java.util.List;
import java.util.UUID;

@RestController
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("api/professor")
    public void addProfessor(@RequestBody Professor professor) {
        professorService.addProfessor(professor);
    }

    @GetMapping("api/professor")
    public List<Professor> listProfessor() {
        return professorService.listProfessor();
    }

    @DeleteMapping("api/professor")
    public int deleteProfessor(@RequestParam("id") UUID id) {
        return professorService.deleteProfessor(id);
    }
}
