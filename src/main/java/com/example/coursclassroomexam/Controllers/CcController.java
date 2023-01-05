package com.example.coursclassroomexam.Controllers;


import com.example.coursclassroomexam.Entities.*;
import com.example.coursclassroomexam.Serv.Serv;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam")
public class CcController {
    private final Serv serv;

    @PostMapping ("/ajouterUser")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
       return serv.ajouterUtilisateur(utilisateur);
    }
    @PostMapping ("/ajouterClasse")
    public Classe ajouterClasse(Classe c) {
        return serv.ajouterClasse(c);
    }
    @PostMapping("/ajouterCoursClassroom/{codeClasse}")
    public CoursClassroom ajouterCoursClassroom(@RequestBody CoursClassroom cc,@PathVariable("codeClasse") Integer codeClasse) {
        return serv.ajouterCoursClassroom(cc,codeClasse);
    }
    @PostMapping("/affecterUtilisateurClasse/{idUtilisateur}/{codeClasse}")
    public void affecterUtilisateurClasse(@PathVariable("idUtilisateur") Integer idUtilisateur, @PathVariable("codeClasse") Integer codeClasse){
        serv.affecterUtilisateurClasse(idUtilisateur, codeClasse);
    }
    @GetMapping("/nbUtilisateursParNiveau/{nv}")
    public Integer nbUtilisateursParNiveau(@PathVariable Niveau nv) {
        return serv.nbUtilisateursParNiveau(nv);
    }
    @PostMapping("/desaffecterCoursClassroomClasse/{idCours}")
    public void desaffecterCoursClassroomClasse(@PathVariable Integer idCours){
        serv.desaffecterCoursClassroomClasse(idCours);
    }
    @GetMapping("/nbHeuresParSpecEtNiv/{sp}/{nv}")
    public Integer nbHeuresParSpecEtNiv(@PathVariable Specialite sp,Niveau nv) {
        return serv.nbHeuresParSpecEtNiv(sp,nv);
    }
}
