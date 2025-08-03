package part_1;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.*;

import java.time.Duration;


public class tc_1 {
    WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod


    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://useinsider.com");

    }




    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void insider_home_page_is_opened() throws InterruptedException {
        insider_home home = new insider_home(driver);
        home.open();
        Assert.assertTrue(home.isHomePageLoaded(), "Home page is not loaded!");

        home.goToCareers();

        career careers = new career(driver);
        Assert.assertTrue(careers.allBlocksVisible(), "All blocks are not visible!");

        careers.scrollToJobButton();
        careers.clickJobButton();
        careers.clickQaJobs();

        Assert.assertTrue(careers.isOnQaJobsPage(), "Did not navigate to QA Jobs page!");


        jobs qajob = new jobs(driver);
        qajob.clickqajobs();
        qajob.isqapageloaded();
        Assert.assertTrue(qajob.isJobsPageLoaded(), "Jobs page did not load!");
        qajob.applyFilters();
        String originalWindowHandle = driver.getWindowHandle();
        qajob.clickFirstViewRole();
        switchToNewTab(driver, originalWindowHandle);


        thejob thejob = new thejob(driver);
        thejob.clickapply();
        thejob.applyjob();

//        Assert.assertTrue(qajob.areJobsVisible(), "No jobs found!");
//
//        Assert.assertTrue(qajob.allJobCardsAreCorrect(), "Job card info mismatch!");



    }

    private void switchToNewTab(WebDriver driver, String originalWindowHandle) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindowHandle.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}