package com.example.coursclassroomexam.Serv;


import com.example.coursclassroomexam.Entities.*;

public interface Serv {

    public Utilisateur ajouterUtilisateur (Utilisateur utilisateur);
    public Classe ajouterClasse (Classe c);
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer codeClasse);
    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse);
    public Integer nbUtilisateursParNiveau(Niveau nv);
    public void desaffecterCoursClassroomClasse(Integer idCours);
    public void archiverCoursClassrooms();
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);


}
