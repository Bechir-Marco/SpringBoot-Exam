package com.example.coursclassroomexam.Repo;


import com.example.coursclassroomexam.Entities.Classe;
import com.example.coursclassroomexam.Entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {
    Integer countUtilisateurByClasse (Classe u);
}
