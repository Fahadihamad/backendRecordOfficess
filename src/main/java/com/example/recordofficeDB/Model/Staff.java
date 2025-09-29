package com.example.recordofficeDB.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "staffs")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    private String name;
    private String gender;
    private String department;
    private String employ_No;
    private String position;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;


//    @OneToOne(mappedBy = "staff", cascade = CascadeType.ALL)
//    private DailyReport dailyReport;
//
//    @OneToOne(mappedBy = "staff", cascade = CascadeType.ALL)
//    private Seminar seminar;
}

