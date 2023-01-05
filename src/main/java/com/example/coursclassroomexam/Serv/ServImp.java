package com.example.coursclassroomexam.Serv;

import com.example.coursclassroomexam.Entities.*;
import com.example.coursclassroomexam.Repo.ClasseRepo;
import com.example.coursclassroomexam.Repo.CoursClassroomRepo;
import com.example.coursclassroomexam.Repo.UtilisateurRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServImp implements Serv {

    @Autowired
    ClasseRepo classeRepo;
    @Autowired
    CoursClassroomRepo coursClassroomRepo;
    @Autowired
    UtilisateurRepo utilisateurRepo;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepo.save(c);
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        Classe classe = classeRepo.findById(codeClasse).orElse(null);
        cc.setClasse(classe);
        return coursClassroomRepo.save(cc);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        Utilisateur utilisateur = utilisateurRepo.findById(idUtilisateur).orElse(null);
        Classe classe = classeRepo.findById(codeClasse).orElse(null);

        utilisateur.setClasse(classe);
        utilisateurRepo.save(utilisateur);

    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        List <Classe> classeList = classeRepo.findClassesByNiveau(nv);
        int counter=0;
        for (Classe classe: classeList
             ) {
            utilisateurRepo.countUtilisateurByClasse(classe);
                 counter++;
            System.out.println("nb "+counter);
        }

        return counter;

    }
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom coursClassroom = coursClassroomRepo.findById(idCours).orElse(null);

        coursClassroom.setClasse(null);
        coursClassroomRepo.save(coursClassroom);
    }
//    @Scheduled(fixedRate= 2000)
    @Override
    public void archiverCoursClassrooms() {
             List <CoursClassroom> ccs = coursClassroomRepo.findAll();
        for (CoursClassroom cc: ccs
             ) {
            cc.setArchive(true);
            coursClassroomRepo.save(cc);

        }

    }
    public Integer nbHeuresParSpecEtNiv(Specialite sp,Niveau nv) {
        List <CoursClassroom> ccs = coursClassroomRepo.findCoursClassroomsBySpecialite(sp);

        for (CoursClassroom cc:ccs) {
            if (cc.getClasse().getNiveau() == nv) {
                return cc.getNbHeures();
            }
        }
        return null;
    }

}

