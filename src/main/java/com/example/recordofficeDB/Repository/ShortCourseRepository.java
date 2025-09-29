package com.example.recordofficeDB.Repository;

import com.example.recordofficeDB.Model.ShortCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortCourseRepository extends JpaRepository<ShortCourse, Long> {
    List<ShortCourse> findByUser_UserId(String userId);
//    List<ShortCourse> findByStaff_StaffId(Long staffId);
    List<ShortCourse> findByStaff_StaffId(Long staffId);
}
