package com.example.recordofficeDB.controllers;

import com.example.recordofficeDB.Model.ShortCourse;
import com.example.recordofficeDB.Model.Staff;
import com.example.recordofficeDB.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "http://localhost:3000")

public class staffController {

    @Autowired
    private StaffService staffService;

    @PostMapping
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    @GetMapping
    public List<Staff> getAllStaffs() {
        return staffService.getAllStaff();
    }


    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @GetMapping("/staff/{staffId}")
    public List<Staff> getStaffByUserId(@PathVariable String userId) {
        return staffService.getStaffByUserId(userId);
    }

    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        return staffService.updateStaff(id, staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }
}
