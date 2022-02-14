package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForElement(WebDriver driver, WebElement element, long timeout) {
        try {
            return new WebDriverWait(driver, timeout).ignoring(NoSuchElementException.class)
                    .pollingEvery(Duration.ofMillis(500)).until(ExpectedConditions.elementToBeClickable(element));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
