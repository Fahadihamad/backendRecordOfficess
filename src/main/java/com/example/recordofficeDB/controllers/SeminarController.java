package com.example.recordofficeDB.controllers;

import com.example.recordofficeDB.Model.Seminar;
import com.example.recordofficeDB.Services.SeminarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seminars")
@CrossOrigin(origins = "http://localhost:3000")
public class SeminarController {

    @Autowired
    private SeminarService seminarService;

    @PostMapping
    public Seminar addSeminar(@RequestBody Seminar seminar) {
        return seminarService.addSeminar(seminar);
    }

    @GetMapping
    public List<Seminar> getAllSeminars() {
        return seminarService.getAllSeminars();
    }

    @GetMapping("/{id}")
    public Seminar getSeminarById(@PathVariable Long id) {
        return seminarService.getSeminarById(id);
    }


//    @GetMapping("/staff/{staffId}")
//    public List<Seminar> getSeminarsByStaffId(@PathVariable Long staffId) {
//        return seminarService.getSeminarsByStaffId(staffId);
//    }
    @GetMapping("/staff/{staffId}")
    public List<Seminar> getSeminarsByStaffId(@PathVariable Long staffId) {
        return seminarService.getSeminarsByStaffId(staffId);
    }

    @GetMapping("/user/{userId}")
    public List<Seminar> getSeminarsByUserId(@PathVariable String userId) {
        return seminarService.getSeminarsByUserId(userId);
    }

    @PutMapping("/{id}")
    public Seminar updateSeminar(@PathVariable Long id, @RequestBody Seminar seminar) {
        return seminarService.updateSeminar(id, seminar);
    }

    @DeleteMapping("/{id}")
    public void deleteSeminar(@PathVariable Long id) {
        seminarService.deleteSeminar(id);
    }
}
