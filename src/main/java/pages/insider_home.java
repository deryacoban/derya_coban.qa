package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class insider_home extends base {
    public insider_home(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://useinsider.com/");
    }

    public boolean isHomePageLoaded() {
        return isVisible(By.xpath("//img[@alt='insider_logo']"));
    }

    public void goToCareers() {
        click(By.xpath("//a[contains(text(),'Company')]"));
        click(By.xpath("//a[text()='Careers']"));
    }
}
