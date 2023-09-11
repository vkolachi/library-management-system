package com.example.librarymanagementsystem.model;

import com.example.librarymanagementsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibraryCard {
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        int id;

        String cardNo;
        @Enumerated(EnumType.STRING)
        CardStatus cardStatus;

        @CreationTimestamp
        Date issueDate;

        @OneToOne
        @JoinColumn
        Student student;


}
