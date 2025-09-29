package com.example.recordofficeDB.Services;

import com.example.recordofficeDB.Model.HighEducation;
import com.example.recordofficeDB.Repository.HighEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HighEducationService {

    @Autowired
    private HighEducationRepository highEducationRepository;

    // Add high education
    public HighEducation addHighEducation(HighEducation highEducation) {
        return highEducationRepository.save(highEducation);
    }

    // Get all high education records
    public List<HighEducation> getAllHighEducation() {
        return highEducationRepository.findAll();
    }

    // Get by ID
    public HighEducation getHighEducationById(Long id) {
        return highEducationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HighEducation not found with id " + id));
    }

    // Get by User ID
    public List<HighEducation> getHighEducationByUserId(String userId) {
        return highEducationRepository.findByUser_UserId(userId);
    }

    // Get by Staff ID
//    public List<HighEducation> getHighEducationByStaffId(Long staffId) {
//        return highEducationRepository.findByStaff_StaffId(staffId);
//    }

    // Update
    public HighEducation updateHighEducation(Long id, HighEducation updatedHighEducation) {
        HighEducation he = highEducationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HighEducation not found with id " + id));

        he.setStudyYear(updatedHighEducation.getStudyYear());
        he.setSemester(updatedHighEducation.getSemester());
        he.setResult(updatedHighEducation.getResult());
        he.setUser(updatedHighEducation.getUser());
//        he.setStaff(updatedHighEducation.getStaff());

        return highEducationRepository.save(he);
    }

    // Delete
    public void deleteHighEducation(Long id) {
        highEducationRepository.deleteById(id);
    }
}
