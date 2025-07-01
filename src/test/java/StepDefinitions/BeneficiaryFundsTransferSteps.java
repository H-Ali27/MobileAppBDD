package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CSVReader;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BeneficiaryFundsTransferSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public BeneficiaryFundsTransferSteps() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

//    @Given("the user is on the home screen")
//    public void the_user_is_on_the_home_screen() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        try {
//            WebElement homeScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                    By.id("com.bi.digitalbanking:id/2131362794"))); // ✅ Ensure correct ID
//            org.junit.Assert.assertTrue("Home Screen not visible!", homeScreenElement.isDisplayed());
//            System.out.println(" Home Screen is visible.");
//        } catch (Exception e) {
//            System.out.println(" Home Screen not visible.");
//            e.printStackTrace();
//            Assert.fail("Failed: Home screen element not found.");
//        }
//    }
//
//
//    @And("the user navigates to the 'Beneficiary' section")
//    public void the_user_navigates_to_the_beneficiary_section() {
//        WebElement addBeneficiaryButtonMain = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362993")));
//        addBeneficiaryButtonMain.click();
//    }

    @When("the user clicks the 'Transfer' button")
    public void the_user_selects_ibft() {
        WebElement transferButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362187")));
        transferButton.click();
    }

    @When("the user enters the transfer amount")
    public void the_user_enters_the_transfer_amount() {
        try
        {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");
            String amount = testData.get(0)[2];
            WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362622")));
            amountField.sendKeys(amount);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }
    }

    @When("the user selects the Purpose")
    public void the_user_selects_the_purpose() {
        // Step 1: Open the dropdown IBFT
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363245")));
        dropdown.click();

        try
        {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");
            String purpose = testData.get(0)[5];
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
            searchField.sendKeys(purpose);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }


// Step 3: Locate the Bank element by XPath
        WebElement purposeElem = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362503")));
        purposeElem.click();
    }

//    @When("the user clicks the 'Next' button")
//    public void the_user_enters_the_transfer_amount() {
//        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362226")));
//        nextButton1.click();
//    }

    @When("the user verifies the transaction details")
    public void the_user_enters_remarks_optional() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        WebElement reviewDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363634")));
        assertTrue("Review Details", reviewDetails.isDisplayed());
    }

//    @When("the user clicks the 'Transfer Fund Now' button")
//    public void the_user_clicks_the_next_button() {
//        WebElement transferFundNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363083")));
//        transferFundNowButton.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
//    }



    @Then("the user should see a status Success")
    public void the_user_should_see_a_confirmation_message() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/androidx.cardview.widget.CardView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")));
        assert confirmationMessage.getText().equals("Success");
    }

    @And("the user clicks 'Done'")
    public void the_user_clicks_ok() {
        WebElement doneButton = driver.findElement(By.id("com.bi.digitalbanking:id/2131362554"));
        doneButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

}
