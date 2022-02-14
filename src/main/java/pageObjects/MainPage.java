package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainPage extends BasePage{

    private WebDriver driver;

    @FindBy(xpath = "//section[@class='module module--header']/h2/span")
    WebElement titleHome;

    @FindBy(xpath = "//span[@class='gs-u-vh' and text()='BBC News']")
    WebElement titleNews;

    @FindBy(xpath = "//a[@class='sp-c-global-header__logo']")
    WebElement titleSport;

    @FindBy(xpath = "//div[@class='fc-footer-buttons']/button/p[text()='Consent']")
    WebElement btnConsent;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    WebElement textBoxSearch;

    @FindBy(xpath = "//button[@id='orb-search-button']")
    WebElement btnSearch;

    @FindBy(xpath = "//li/div/div/div/div/p")
    List<WebElement> listSearchResults;

    @FindBy(xpath = "//section[@class='module module--header']/h2")
    WebElement daydate;

    String xpathTab = "//div[contains(@class,'orb-nav-section')]/ul/li/a[text()='#ChangeMe#']";

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void launchMainPage(String url) throws InterruptedException {
        driver.get(url);
        //permissionConsent();
    }

    public void navigateToTab(String tabName) {
        System.out.println("***Tab name: " + tabName);
        driver.findElement(By.xpath(xpathTab.replace("#ChangeMe#",tabName))).click();
    }

    public void verifyTitle(String expectedTitle, String tab) throws InterruptedException {
        System.out.println("***Verify page title!");

        if(tab.equals("Home")){
            //Thread.sleep(3000);
            waitForElement(driver, titleHome,3);
            String actualTitle = titleHome.getText();
            System.out.println("Actual: " + actualTitle + " --- Expected: " + expectedTitle);
            Assert.assertEquals(actualTitle, expectedTitle, "Error... title didn't match!");
        }
        else if(tab.equals("News")){
            String actualTitle = titleNews.getText();
            System.out.println("Actual: " + actualTitle + " --- Expected: " + expectedTitle);
            Assert.assertEquals(actualTitle, expectedTitle, "Error... title didn't match!");
        }
        else if(tab.equals("Sport")){
            String actualTitle = titleSport.getText();
            System.out.println("Actual: " + actualTitle + " --- Expected: " + expectedTitle);
            Assert.assertTrue(actualTitle.contains(expectedTitle),"Error... title didn't match!");
        }

    }

    public void permissionConsent() throws InterruptedException {
        System.out.println("***permission consent!");
        btnConsent.click();
    }

    public void verifyPageUrl(String expectedUrl) {
        System.out.println("***Verify current page url!");
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual: " + actualUrl + " --- Expected: " + expectedUrl);
        Assert.assertEquals(actualUrl, expectedUrl, "Error... pageUrl didn't match!");
    }

    public void verifySearch(String searchText) {
        System.out.println("***Enter search text: " + searchText);
        textBoxSearch.sendKeys(searchText);
        btnSearch.click();
    }

    public void verifySearchResult(String searchText) {
        System.out.println("***Verify searched Results started!");
        int count = 0;
        try {
            for (WebElement result : listSearchResults){
                count++;
                String actualText = result.getText();
                System.out.println("" + count + " - Actual: " + actualText + " --- Expected: " + searchText);
                SoftAssert softAssert = null;
                softAssert.assertTrue(actualText.contains(searchText), "No search results match!");
            }

        } catch (Exception e) {
            //e.printStackTrace();
        }

    }

    public void verifyDayDate(String tabName) {
        System.out.println("***Verify day and date!");

        if(tabName.equals("Home")){
            waitForElement(driver,daydate,3);
            String[] str = daydate.getText().split("\n");
            String actualDayDate = str[1].toString();

            String pattern = "EEEEE, dd MMMMM";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String expectedDayDate = simpleDateFormat.format(new Date());

            System.out.println("actualDayDate: " + actualDayDate + " --- expectedDayDate: " + expectedDayDate);

            Assert.assertEquals(actualDayDate, expectedDayDate, "Error... Day and date didn't match!");
        }

    }

}
