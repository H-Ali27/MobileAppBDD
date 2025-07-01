package StepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CSVReader;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public class RAASTPayTrimmedIBAN {
    private WebDriver driver;
    private WebDriverWait wait;

    public RAASTPayTrimmedIBAN() {
        this.driver = DriverManager.getDriver();  // Shared WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @And("the user clicks on Fund Transfer by trimmed IBAN")
    public void the_user_clicks_on_fund_transfer_by_trimmed_IBAN() {
        WebElement fundTransferByIBAN = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362239")));
        fundTransferByIBAN.click();
        System.out.println("Clicked on Fund Transfer by IBAN.");
    }

    @And("the user enters the Trimmed IBAN number {string}")
    public void the_user_enters_the_trimmed_IBAN_number(String iban) {
        try
        {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");
            String TrimmedIBAN = testData.get(0)[9];
            WebElement ibanField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362620")));
            ibanField.sendKeys(TrimmedIBAN);
            System.out.println("Entered IBAN: " + TrimmedIBAN);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }
    }
}
