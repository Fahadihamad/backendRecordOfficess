package com.example.recordofficeDB.Repository;

import com.example.recordofficeDB.Model.HighEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighEducationRepository extends JpaRepository<HighEducation, Long> {
    List<HighEducation> findByUser_UserId(String userId);
//    List<HighEducation> findByStaff_StaffId(Long staffId);
}
