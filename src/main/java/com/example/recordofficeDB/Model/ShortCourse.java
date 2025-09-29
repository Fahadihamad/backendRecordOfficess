package com.example.recordofficeDB.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "short_courses")
public class ShortCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String activity;

    // One short course belongs to one User
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    // One short course belongs to one Staff

//    @ManyToOne
//    @JoinColumn(name = "staff_id", referencedColumnName = "staffId")
//    private Staff staff;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staffId")
    private Staff staff;

}
