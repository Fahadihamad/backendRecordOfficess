package com.example.recordofficeDB.controllers;
import com.example.recordofficeDB.Model.DailyReport;
import com.example.recordofficeDB.Services.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:3000")
public class DailyReportController {

    @Autowired
    private DailyReportService reportService;

    @PostMapping
    public DailyReport addReport(@RequestBody DailyReport report) {
        return reportService.addReport(report);
    }

    @GetMapping
    public List<DailyReport> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public DailyReport getReportById(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    @GetMapping("/user/{userId}")
    public List<DailyReport> getReportsByUserId(@PathVariable String userId) {
        return reportService.getReportsByUserId(userId);
    }

//    @GetMapping("/staff/{staffId}")
//    public DailyReport getReportByStaffId(@PathVariable Long staffId) {
//        return reportService.getReportByStaffId(staffId);
//    }

    @PutMapping("/{id}")
    public DailyReport updateReport(@PathVariable Long id, @RequestBody DailyReport report) {
        return reportService.updateReport(id, report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
    }
}
