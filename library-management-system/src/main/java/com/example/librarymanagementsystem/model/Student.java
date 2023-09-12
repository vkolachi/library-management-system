package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int regNo;

    @Column(name = "student_name")
    String name;

    int age;
    @Column(unique = true,nullable =false)
    String email;
    
    @Enumerated(EnumType.STRING)
    Gender gender;


    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LibraryCard libraryCard;


}