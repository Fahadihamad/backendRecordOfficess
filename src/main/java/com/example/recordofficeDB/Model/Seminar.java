package com.example.recordofficeDB.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "seminars")
public class Seminar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String activity;

//    @OneToOne
//    @JoinColumn(name = "staff_id", referencedColumnName = "staffId")
//    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
}

