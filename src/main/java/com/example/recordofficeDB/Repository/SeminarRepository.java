package com.example.recordofficeDB.Repository;

import com.example.recordofficeDB.Model.Seminar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeminarRepository extends JpaRepository<Seminar, Long> {
//    List<Seminar> findByStaff_StaffId(Long staffId);
    List<Seminar> findByUser_UserId(String userId);   // ✅ new
}

