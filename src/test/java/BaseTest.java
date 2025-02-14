package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public ExtentSparkReporter sparkReporter; // ExtentHtmlReporter is deprecated so using ExtentSparkReporter
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod()
    {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")
                + File.separator+ "reports" + File.separator
                + "AutomationReport"+".html");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Automation Test Results");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Automation Tester", "Kiran Elkunchwar");
    }


    @BeforeMethod
    @Parameters(value={"browserName"})// driver name we will pickup from testng file
    public void beforeMethodMethod(String browserName, Method testMethod)
    {
        logger = extent.createTest(testMethod.getName()); // picking test Methods and creating tests

        setupDriver(browserName); // setting up driver before every method
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result)
    {
        if(result.getStatus()==ITestResult.SUCCESS)
        {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: "+ methodName + " Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,markup);
        } else if (result.getStatus()==ITestResult.FAILURE)
        {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: "+ methodName + " Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,markup);
        }else if (result.getStatus()==ITestResult.SKIP)
        {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: "+ methodName + " Skipped";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
            logger.log(Status.SKIP,markup);
        }
        driver.quit(); // quit driver after every method.
    }

    @AfterTest
    public void afterTestMethod()
    {
        extent.flush();
    }

    public void setupDriver(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator+
                    "drivers" + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();

        }else {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + File.separator+
                    "drivers" + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();
        }
    }


}
