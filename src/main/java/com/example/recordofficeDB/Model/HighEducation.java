package com.example.recordofficeDB.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "high_education")
public class HighEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studyYear;

    private String semester;

    // Store file as a byte array
    @Lob
    private byte[] result;

    // One high education belongs to one User
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    // One high education belongs to one Staff
//    @ManyToOne
//    @JoinColumn(name = "staff_id", referencedColumnName = "staffId")
//    private Staff staff;
}
