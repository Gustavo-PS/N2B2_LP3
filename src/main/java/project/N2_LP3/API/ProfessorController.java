package project.N2_LP3.API;

import project.N2_LP3.*;
import project.N2_LP3.MODEL.ProfessorModel;
import project.N2_LP3.SERVICE.ProfessorService;

public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    public void addPRofessor(ProfessorModel professor){
        professorService.addProfessor(professor);
    }
}
