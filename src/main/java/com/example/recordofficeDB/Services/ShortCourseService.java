package com.example.recordofficeDB.Services;

import com.example.recordofficeDB.Model.ShortCourse;
import com.example.recordofficeDB.Repository.ShortCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortCourseService {

    @Autowired
    private ShortCourseRepository shortCourseRepository;

    // Add new short course
    public ShortCourse addShortCourse(ShortCourse shortCourse) {
        return shortCourseRepository.save(shortCourse);
    }

    // Get all short courses
    public List<ShortCourse> getAllShortCourses() {
        return shortCourseRepository.findAll();
    }

    // Get short course by ID
    public ShortCourse getShortCourseById(Long id) {
        return shortCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Short course not found with id " + id));
    }

    // Get short courses by User ID
    public List<ShortCourse> getShortCoursesByUserId(String userId) {
        return shortCourseRepository.findByUser_UserId(userId);
    }

    // Get short courses by Staff ID

//    public List<ShortCourse> getShortCoursesByStaffId(Long staffId) {
//        return shortCourseRepository.findByStaff_StaffId(staffId);
//    }

    public List<ShortCourse> getShortCoursesByStaffId(Long staffId) {
        return shortCourseRepository.findByStaff_StaffId(staffId);
    }

    // Update short course
    public ShortCourse updateShortCourse(Long id, ShortCourse updatedShortCourse) {
        ShortCourse sc = shortCourseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Short course not found with id " + id));

        sc.setDate(updatedShortCourse.getDate());
        sc.setActivity(updatedShortCourse.getActivity());
        sc.setUser(updatedShortCourse.getUser());
        sc.setStaff(updatedShortCourse.getStaff());

        return shortCourseRepository.save(sc);
    }

    // Delete short course
    public void deleteShortCourse(Long id) {
        shortCourseRepository.deleteById(id);
    }
}
