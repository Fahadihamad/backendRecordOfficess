package com.example.recordofficeDB.controllers;

import com.example.recordofficeDB.Model.ShortCourse;
import com.example.recordofficeDB.Services.ShortCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shortcourses")
@CrossOrigin(origins = "http://localhost:3000")
public class ShortCourseController {

    @Autowired
    private ShortCourseService shortCourseService;

    @PostMapping
    public ShortCourse addShortCourse(@RequestBody ShortCourse shortCourse) {
        return shortCourseService.addShortCourse(shortCourse);
    }

    @GetMapping
    public List<ShortCourse> getAllShortCourses() {
        return shortCourseService.getAllShortCourses();
    }

    @GetMapping("/{id}")
    public ShortCourse getShortCourseById(@PathVariable Long id) {
        return shortCourseService.getShortCourseById(id);
    }

    @GetMapping("/user/{userId}")
    public List<ShortCourse> getShortCoursesByUserId(@PathVariable String userId) {
        return shortCourseService.getShortCoursesByUserId(userId);
    }

//    @GetMapping("/staff/{staffId}")
//    public List<ShortCourse> getShortCoursesByStaffId(@PathVariable Long staffId) {
//        return shortCourseService.getShortCoursesByStaffId(staffId);
//    }
    @GetMapping("/staff/{staffId}")
    public List<ShortCourse> getShortCoursesByStaffId(@PathVariable Long staffId) {
        return shortCourseService.getShortCoursesByStaffId(staffId);
    }

    @PutMapping("/{id}")
    public ShortCourse updateShortCourse(@PathVariable Long id, @RequestBody ShortCourse shortCourse) {
        return shortCourseService.updateShortCourse(id, shortCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteShortCourse(@PathVariable Long id) {
        shortCourseService.deleteShortCourse(id);
    }
}
