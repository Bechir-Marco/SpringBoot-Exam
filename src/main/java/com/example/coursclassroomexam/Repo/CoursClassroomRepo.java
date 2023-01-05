package com.example.coursclassroomexam.Repo;


import com.example.coursclassroomexam.Entities.Classe;
import com.example.coursclassroomexam.Entities.CoursClassroom;
import com.example.coursclassroomexam.Entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursClassroomRepo extends JpaRepository<CoursClassroom, Integer> {

    List <CoursClassroom> findCoursClassroomsBySpecialite (Specialite specialite);
}
