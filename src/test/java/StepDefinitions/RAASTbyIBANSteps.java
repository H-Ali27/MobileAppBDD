package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CSVReader;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public class RAASTbyIBANSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public RAASTbyIBANSteps() {
        this.driver = DriverManager.getDriver();  // Shared WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @And("the user clicks on Fund Transfer by IBAN")
    public void the_user_clicks_on_fund_transfer_by_iban() {
        WebElement fundTransferByIBAN = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362239")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fundTransferByIBAN.click();
        System.out.println("Clicked on Fund Transfer by IBAN.");
    }

    @And("the user enters the IBAN number {string}")
    public void the_user_enters_the_iban_number(String iban) {
        try
        {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");
            String IBANno = testData.get(0)[8];
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement ibanField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362620")));
            ibanField.sendKeys(IBANno);
            System.out.println("Entered IBAN: " + IBANno);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }

    }

}
