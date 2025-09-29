package com.example.recordofficeDB.Repository;

import com.example.recordofficeDB.Model.ShortCourse;
import com.example.recordofficeDB.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    List<Staff> findByUser_UserId(String userId);

}
