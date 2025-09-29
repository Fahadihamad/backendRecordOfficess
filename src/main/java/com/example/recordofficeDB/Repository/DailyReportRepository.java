package com.example.recordofficeDB.Repository;

import com.example.recordofficeDB.Model.DailyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DailyReportRepository extends JpaRepository<DailyReport, Long> {
    List<DailyReport> findByUser_UserId(String userId);   // notice User_UserId
//    DailyReport findByStaff_StaffId(Long staffId);        // notice Staff_StaffId
    DailyReport findByStaff_StaffId(Long staffId);        // notice Staff_StaffId
}