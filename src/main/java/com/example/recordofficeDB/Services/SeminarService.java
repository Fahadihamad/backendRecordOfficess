package com.example.recordofficeDB.Services;

import com.example.recordofficeDB.Model.Seminar;
import com.example.recordofficeDB.Repository.SeminarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeminarService {

    @Autowired
    private SeminarRepository seminarRepository;

    public Seminar addSeminar(Seminar seminar) {
        return seminarRepository.save(seminar);
    }

    public List<Seminar> getAllSeminars() {
        return seminarRepository.findAll();
    }

    public Seminar getSeminarById(Long id) {
        return seminarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seminar not found with id " + id));
    }

//    public List<Seminar> getSeminarsByStaffId(Long staffId) {
//        return seminarRepository.findByStaff_StaffId(staffId);
//    }

    public List<Seminar> getSeminarsByUserId(String userId) {
        return seminarRepository.findByUser_UserId(userId);
    }

    public Seminar updateSeminar(Long id, Seminar updatedSeminar) {
        Seminar seminar = seminarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seminar not found with id " + id));

        seminar.setDate(updatedSeminar.getDate());
        seminar.setActivity(updatedSeminar.getActivity());
//        seminar.setStaff(updatedSeminar.getStaff());
        seminar.setUser(updatedSeminar.getUser());

        return seminarRepository.save(seminar);
    }

    public void deleteSeminar(Long id) {
        seminarRepository.deleteById(id);
    }
}
