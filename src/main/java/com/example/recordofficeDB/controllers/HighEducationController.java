package com.example.recordofficeDB.controllers;

import com.example.recordofficeDB.Model.HighEducation;
import com.example.recordofficeDB.Services.HighEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/higheducation")
@CrossOrigin(origins = "http://localhost:3000")
public class HighEducationController {

    @Autowired
    private HighEducationService highEducationService;

    // Add with file upload
    @PostMapping
    public HighEducation addHighEducation(
            @RequestParam String studyYear,
            @RequestParam String semester,
            @RequestParam(required = false) MultipartFile resultFile,
            @RequestParam String userId,
            @RequestParam Long staffId
    ) throws IOException {
        HighEducation he = new HighEducation();
        he.setStudyYear(studyYear);
        he.setSemester(semester);
        if (resultFile != null) {
            he.setResult(resultFile.getBytes());
        }

        // Set User and Staff
        com.example.recordofficeDB.Model.User user = new com.example.recordofficeDB.Model.User();
        user.setUserId(userId);
        he.setUser(user);

//        com.example.recordofficeDB.Model.Staff staff = new com.example.recordofficeDB.Model.Staff();
//        staff.setStaffId(staffId);
//        he.setStaff(staff);
        com.example.recordofficeDB.Model.Staff staff = new com.example.recordofficeDB.Model.Staff();
        staff.setStaffId(staffId);
        he.setStaff(staff);

        return highEducationService.addHighEducation(he);
    }

    @GetMapping
    public List<HighEducation> getAllHighEducation() {
        return highEducationService.getAllHighEducation();
    }

    @GetMapping("/{id}")
    public HighEducation getHighEducationById(@PathVariable Long id) {
        return highEducationService.getHighEducationById(id);
    }

    @GetMapping("/user/{userId}")
    public List<HighEducation> getHighEducationByUserId(@PathVariable String userId) {
        return highEducationService.getHighEducationByUserId(userId);
    }


//    @GetMapping("/staff/{staffId}")
//    public List<HighEducation> getHighEducationByStaffId(@PathVariable Long staffId) {
//        return highEducationService.getHighEducationByStaffId(staffId);
//    }
    @GetMapping("/staff/{staffId}")
    public List<HighEducation> getHighEducationByStaffId(@PathVariable Long staffId) {
        return highEducationService.getHighEducationByStaffId(staffId);
    }


    @PutMapping("/{id}")
    public HighEducation updateHighEducation(
            @PathVariable Long id,
            @RequestBody HighEducation highEducation
    ) {
        return highEducationService.updateHighEducation(id, highEducation);
    }

    @DeleteMapping("/{id}")
    public void deleteHighEducation(@PathVariable Long id) {
        highEducationService.deleteHighEducation(id);
    }
}
