package pages;

import org.openqa.selenium.*;
import java.util.List;

public class base {
    protected WebDriver driver;

    public base(WebDriver driver) {
        this.driver = driver;
    }


    protected void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    protected void click(By locator) {
        waitForSeconds(5);
        driver.findElement(locator).click();
    }


    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }


    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }


    protected boolean isVisible(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
