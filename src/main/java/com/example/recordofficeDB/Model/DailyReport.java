package com.example.recordofficeDB.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "daily_reports")
public class DailyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // Primary key for the report

    @Temporal(TemporalType.DATE)
    private Date date;

    private String activity;
    private String progress;
    private String recommendation;

    // Many reports can belong to one user
    @ManyToOne

    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private User user;

    // One report belongs to one staff (1:1 relation)
//    @OneToOne
//
//    @JoinColumn(name = "staff_id", referencedColumnName = "staffId", nullable = false)
//    private Staff staff;
}
