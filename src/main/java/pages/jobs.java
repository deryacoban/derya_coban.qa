package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;
public class jobs extends base{
    public jobs(WebDriver driver) {
        super(driver);
    }
    private static final By location = By.xpath("//label[contains(text(),'Filter by Location')]");
    private static final By dropdownmenu1 = By.xpath("//span[@id='select2-filter-by-location-container']");
    private static final By dropdownmenu2 = By.xpath("//span[@id='select2-filter-by-department-container']");

    private static final By department = By.xpath("//span[contains(text(),'Quality Assurance')]");
    private final By jobinfo = By.cssSelector("div.position-list-item");
    private final By viewRole = By.xpath("(//a[text()='View Role'])[1]");
    private final By istanbul_turkey = By.xpath("//li[contains(text(),'Istanbul, Turkiye')]");
    private final By quality_assurance = By.xpath("//li[contains(text(),'Quality Assurance')]");
    private static final By qajobs = By.xpath("//h1[contains(text(),'Quality Assurance')]");
    private static final By seeqajobs = By.xpath("//a[contains(text(),'See all QA jobs')]");
    private static final By browse = By.xpath("//section[@id='career-position-filter']");
    private final By parentContainer = By.cssSelector(".position-list-item-wrapper");
    //h3[@class='mb-0']
    public boolean isqapageloaded(){

         return isVisible(qajobs);
    }
    public void clickqajobs(){
        WebElement element = driver.findElement(seeqajobs);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        waitForSeconds(2);
        element.click();
    }
    public boolean isJobsPageLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,300)", "");
        return waitForElementVisible(location, 10);
    }

    public void applyFilters() {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,300)");
        waitForSeconds(10);


        waitAndClick(dropdownmenu1);
        waitAndClick(istanbul_turkey);

        waitForSeconds(2);


        waitAndClick(dropdownmenu2);
        waitAndClickAndScrollTo(quality_assurance);

        waitForSeconds(5);

        js.executeScript("window.scroll(0,700)");
        waitForSeconds(10);
    }
//
//    public boolean areJobsVisible() {
//        return driver.findElements(jobinfo).size() > 0;
//    }
//
//    public boolean allJobCardsAreCorrect() {
//        List<WebElement> cards = driver.findElements(jobinfo);
//        for (WebElement card : cards) {
//            String cardText = card.getText();
//            if (!cardText.contains("Quality Assurance") || !cardText.contains("Istanbul, Turkey")) {
//                return false;
//            }
//        }
//        return true;
//    }
//
    public void clickFirstViewRole() {
        List<WebElement> containers = driver.findElements(parentContainer);

        if (!containers.isEmpty()) {

            WebElement firstContainer = containers.get(0);


            Actions actions = new Actions(driver);
            actions.moveToElement(firstContainer).perform();





            WebElement firstViewRole = firstContainer.findElement(viewRole);
            firstViewRole.click();

            waitForSeconds(5);
        } else {
            System.out.println("No job containers found on the page.");
        }
    }

//
//    public boolean isOnLeverApplicationPage() {
//        return driver.getCurrentUrl().contains("lever.co");
//    }
//
//
    private void waitAndClick(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        element.click();
    }

    private void waitAndClick(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }
    private void waitAndClickAndScrollTo(By locator) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        waitAndClick(element);
    }
//
    private boolean waitForElementVisible(By locator, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
