package com.example.recordofficeDB.Services;
import com.example.recordofficeDB.Model.DailyReport;
import com.example.recordofficeDB.Repository.DailyReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class DailyReportService {

    @Autowired
    private DailyReportRepository reportRepository;

    public DailyReport addReport(DailyReport report) {
        return reportRepository.save(report);
    }

    public List<DailyReport> getAllReports() {
        return reportRepository.findAll();
    }

    public DailyReport getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));
    }

    public List<DailyReport> getReportsByUserId(String userId) {
        return reportRepository.findByUser_UserId(userId);
    }

//    public DailyReport getReportByStaffId(Long staffId) {
//        return reportRepository.findByStaff_StaffId(staffId);
//    }

    public DailyReport updateReport(Long id, DailyReport updatedReport) {
        DailyReport report = reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));

        report.setDate(updatedReport.getDate());
        report.setActivity(updatedReport.getActivity());
        report.setProgress(updatedReport.getProgress());
        report.setRecommendation(updatedReport.getRecommendation());
//        report.setStaff(updatedReport.getStaff());
        report.setUser(updatedReport.getUser());

        return reportRepository.save(report);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}



