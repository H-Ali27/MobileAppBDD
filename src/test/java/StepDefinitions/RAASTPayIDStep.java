package StepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CSVReader;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public class RAASTPayIDStep {
    private WebDriver driver;
    private WebDriverWait wait;

    public RAASTPayIDStep() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @And("the user searches for RAAST type {string}")
    public void the_user_searches_for_RAAST_type(String typname) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363401")));
        dropdown.click();

        WebElement ClicksearchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
        ClicksearchField.click();

        try
        {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");
            String raastypename = testData.get(0)[7];
            WebElement raastType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
            raastType.sendKeys(raastypename);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement bankElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "//android.widget.TextView[@text='"+raastypename+"']")));
            bankElement.click();
//        List<WebElement> textone = driver.findElements(By.className("android.widget.TextView"));
//        textone.get(0).click();

            System.out.println("Selected bank: " + raastypename);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }
    }

    @And("the user clicks on Fund Transfer by RAAST ID")
    public void the_user_clicks_on_fund_transfer_by_raast_id() {
        WebElement fundTransferByRaastID = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362240")));
        fundTransferByRaastID.click();
        System.out.println("Clicked on Fund Transfer by RAAST ID.");
    }












//    @And("the user clicks on Review Details")
//    public void the_user_clicks_on_review_details() {
//        WebElement reviewDetailsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362226")));
//        reviewDetailsButton.click();
//        System.out.println("Clicked on Review Details.");
//    }









}
