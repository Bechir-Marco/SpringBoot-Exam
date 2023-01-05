package com.example.coursclassroomexam.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    Integer codeClasse;
    String titre;
    @Enumerated(EnumType.STRING)
    Niveau niveau;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "classe")
     @JsonIgnore
    List<CoursClassroom> coursClassroomList;

}
