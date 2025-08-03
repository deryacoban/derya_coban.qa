package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class career extends base {
    public career(WebDriver driver) {
        super(driver);
    }

    private static final By locations = By.xpath("//h3[contains(text(),'Our Locations')]");
    private static final By teams = By.xpath("//h3[contains(text(),'Find your calling')]");
    private static final By life = By.xpath("//h2[contains(text(),'Life at Insider')]");
    private static final By job_button = By.xpath("//a[contains(text(),'See all teams')]");
    private static final By qajobs = By.xpath("//h3[contains(text(),'Quality Assurance')]");

    public boolean allBlocksVisible() {
        return isVisible(locations) && isVisible(teams) && isVisible(life);
    }

    public void scrollToJobButton() {
        WebElement element = driver.findElement(job_button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        waitForSeconds(2);
    }

    public void clickJobButton() {
        WebElement element = driver.findElement(job_button);
        element.click();
    }

    public void scrollToQAJobButton() {
        WebElement element = driver.findElement(qajobs);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        waitForSeconds(2);
    }

    public void clickQaJobs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(qajobs));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        waitForSeconds(2);

        element.click();
    }



    public boolean isOnQaJobsPage()  {
        return driver.getCurrentUrl().contains("careers/quality-assurance");

    }

}
