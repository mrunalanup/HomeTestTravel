package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static steps.TakeScreenShot.takeSnapShot;

public class MyStepdefs {
    WebDriver driver;
    WebDriverWait wait;

    @Given("Open the browser")
    public void openTheBrowser() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("Successfully opened chrome Browser");
        } else {
            System.out.println("Failed to open chrome Browser");
        }
    }

    @When("Navigate to the travel website")
    public void navigateToTheTravelWebsite() {
        driver.get("https://www.mailtravel.co.uk");
        System.out.println(" Successfully opened website ");
    }

    @And("Verify the page title as Home Page | Mail Travel is displayed on UI")
    public void verifyThePageTitleAsHomePageMailTravelIsDisplayedOnUI() {
        if (driver.findElement(By.xpath("//*[@id=\"site-logo\"]")).isDisplayed()) {
            System.out.println("Successfully verified Page Title as- Home Page | Mail Travel");

        } else {
            System.out.println("Home Page | Mail Travel is not displayed on UI");
        }
    }

    @Then("Click on Accept All Cookies")

    public void clickOnAcceptAllCookies() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement accept = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("Accept All Cookies button found");
        js.executeScript("arguments[0].click();", accept);
        System.out.println("clicked successfully");
    }

    @And("Search for India in search bar and click on the search button")
    public void searchForIndiaInSearchBarAndClickOnTheSearchButton() {
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"searchtext_freetext_search_form\"]"));
        searchBtn.click();
        searchBtn.sendKeys("India");
        searchBtn.sendKeys(Keys.ENTER);

        System.out.println("India is displayed in the search text bar");
    }

    @When("User selects holiday package")
    public void iSelectHolidayPackage() {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement package_Golden = driver.findElement(By.xpath("//div[@id='iterator_2_product_custom_product-content']"));
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        package_Golden.click();
        System.out.println("holiday package selected");
    }
    @When("User selects two passenger from the dropdown")
    public void select_passengers() {
        WebElement passengers = driver.findElement(By.id("passenger-dropdown-numpassengers"));
        passengers.click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", passengers);
        Select dropDown = new Select(passengers);
        dropDown.selectByIndex(1);
        System.out.println("Two passenger selected in the dropdown");

    }
    @And("User selects a departure date from the calendar")
    public void select_departure_date() throws InterruptedException {

        // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(2000);
        WebElement departureDate = driver.findElement(By.xpath("//*[@id=\"nbf_tpl_pms_calendar-be3497ec7b906d8893cd585c14cb548f\"]/div[2]/div/div[3]/label/div/div[2]/span"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(departureDate).click().perform();
        System.out.println("departure date selected");
    }

    @Then("User should see the tour price")
    public void tour_price() throws Exception{
        WebElement tourPrice = driver.findElement(By.xpath("//*[@id=\"tour-price\"]/span"));
        boolean isPriceDisplayed = tourPrice.isDisplayed();
        Assert.assertTrue("Tour price not displayed", isPriceDisplayed);
        System.out.println("Tour price displayed");
        takeSnapShot(driver,"C:\\Source3\\TravelTest\\abc.png");

    }



}
