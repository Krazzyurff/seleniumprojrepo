package utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    private static ExtentReports extentReport;

    public static ExtentReports getExtentReport() {

        if (extentReport == null) {

            String reportDir = System.getProperty("user.dir")
                    + File.separator + "reports";

            new File(reportDir).mkdirs();

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String reportPath = reportDir
                    + File.separator + "ExtentReport_" + timestamp + ".html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("TutorialsNinja Automation Results");
            reporter.config().setDocumentTitle("Test Results");

            extentReport = new ExtentReports();
            extentReport.attachReporter(reporter);
            extentReport.setSystemInfo("OS", "Windows 11");
            extentReport.setSystemInfo("Tester", "Ashish Kumar Singh");
        }

        return extentReport;
    }
}
