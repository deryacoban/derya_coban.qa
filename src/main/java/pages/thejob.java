package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class thejob extends base{
    public thejob (WebDriver driver) {
        super(driver);
}
    private static final By applyforthisjob = By.xpath("//a[text()='Apply for this job'][1]");
    private static final By applicationform = By.xpath("//h4[text()='Submit your application']");

    public void clickapply () {
        waitForSeconds(5);
        waitAndClick(applicationform);
        waitForSeconds(5);
    }

    public boolean applyjob () {
        return isVisible(applicationform);
    }
    private void waitAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(thejob.applyforthisjob));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        element.click();
    }
}
