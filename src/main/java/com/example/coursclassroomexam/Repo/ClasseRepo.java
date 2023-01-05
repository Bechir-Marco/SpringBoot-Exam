package com.example.coursclassroomexam.Repo;

import com.example.coursclassroomexam.Entities.Classe;
import com.example.coursclassroomexam.Entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepo extends JpaRepository <Classe, Integer> {
        List <Classe>findClassesByNiveau(Niveau nv);
}
