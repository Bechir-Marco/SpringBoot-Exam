package com.example.coursclassroomexam.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CoursClassroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    Integer id ;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    String nom;
    Integer nbHeures ;
    Boolean archive;
    @ManyToOne(cascade = CascadeType.ALL)
            @JsonIgnore
    Classe classe;


}
