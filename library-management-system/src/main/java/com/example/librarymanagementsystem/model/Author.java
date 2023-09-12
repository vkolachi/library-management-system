package com.example.librarymanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;

    String Name;

    int age;

    @Column(nullable = false,unique = true)
    String emailId;

    @UpdateTimestamp
    Date lastActivity;

    @JoinColumn
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> books=new ArrayList<>();
}
