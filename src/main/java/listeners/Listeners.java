package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class Listeners implements ITestListener {

    ExtentReports extentReport = ExtentReporter.getExtentReport();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReport.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentTest.get().fail(result.getThrowable());

        WebDriver driver = null;
        Object testClass = result.getInstance();

        try {
            driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getDeclaredField("driver")
                    .get(testClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Base base = new Base();
            String screenshotPath = base.takeScreenshot(
                    result.getMethod().getMethodName(), driver);

            extentTest.get().addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
    }
}
