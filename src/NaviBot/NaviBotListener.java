package NaviBot;

import Utility.SupportMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestMethodFinder;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class NaviBotListener implements ITestListener{

SupportMethod getSupport = new SupportMethod();
WebDriver driver;

    @Override
    public void onTestStart(ITestResult iTestResult) {


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        String screenShotName;
        String aTestCasename = iTestResult.getName();
        screenShotName = iTestResult.getName()+".png";
        this.driver = ((RunTestCaseWelcome)iTestResult.getInstance()).myDriver;

        try {
            getSupport.ScreenShot(driver,"D:\\temp\\chatbot-system-testing\\src\\srcBugs\\"+screenShotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The name of the testcase PASSED is :"+ iTestResult.getName());

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String screenShotName;
        String aTestCasename = iTestResult.getName();
        screenShotName = iTestResult.getName()+".png";
        this.driver = ((RunTestCaseWelcome)iTestResult.getInstance()).myDriver;
        try {
            getSupport.ScreenShot(driver,"D:\\temp\\chatbot-system-testing\\src\\srcBugs\\"+screenShotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The name of the testcase failed is :"+ iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        System.out.println("The name of the testcase Skipped is :"+ iTestResult.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("The name of the testcase Passed is :"+ iTestResult.getName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }


    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
