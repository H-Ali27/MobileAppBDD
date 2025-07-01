package StepDefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class IFTSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public IFTSteps() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


//    @Given("the user is on the home screen")
//    public void the_user_is_on_the_home_screen() {
//        try {
//            WebElement homeScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362794")));
//            Assert.assertTrue("Home screen is not visible", homeScreenElement.isDisplayed());
//            System.out.println("User is on the home screen.");
//        } catch (Exception e) {
//            System.out.println("Home screen not visible.");
//            e.printStackTrace();
//            Assert.fail("Home screen element not found.");
//        }
//    }

//    @When("the user clicks on the Transfer button")
//    public void the_user_clicks_on_the_transfer_button() {
//        WebElement transferButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.cardview.widget.CardView[1]/android.widget.TextView"
//        )));
//        transferButton.click();
//        System.out.println("Clicked on Transfer button.");
//    }
//
//    @And("the user selects Instant Fund Transfer")
//    public void the_user_selects_instant_fund_transfer() {
//        WebElement instantFundTransferButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363002")));
//        instantFundTransferButton.click();
//        System.out.println("Selected Instant Fund Transfer.");
//    }

//    @And("the user searches for {string} in the bank list")
//    public void the_user_searches_for_in_the_bank_list(String bankName) {
//        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363400")));
//        dropdown.click();
//
//        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
//        searchField.sendKeys(bankName);
//
//        WebElement bankElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup"
//        )));
//        bankElement.click();
//        System.out.println("Selected bank: " + bankName);
//    }

//    @And("the user enters the account number {string}")
//    public void the_user_enters_the_account_number(String accountNumber) {
//        WebElement accountNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362620")));
//        accountNumberField.sendKeys(accountNumber);
//        System.out.println("Entered Account Number: " + accountNumber);
//    }

//    @And("the user enters the amount {string}")
//    public void the_user_enters_the_amount(String amount) {
//        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362622")));
//        amountField.sendKeys(amount);
//        System.out.println("Entered Amount: " + amount);
//    }

//    @And("the user selects the purpose of transfer as {string}")
//    public void the_user_selects_the_purpose_of_transfer_as(String purpose) {
//        WebElement purposeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363245")));
//        purposeDropdown.click();
//
//        WebElement purposeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView"
//        )));
//        purposeOption.click();
//        System.out.println("Selected Purpose: " + purpose);
//    }



//    @And("the user clicks the 'Transfer Fund Now' button")
//    public void the_user_clicks_the_transfer_fund_now_button() {
//        WebElement transferNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363083")));
//        transferNowButton.click();
//        System.out.println("Clicked on 'Transfer Fund Now' button.");
//    }

//    @Then("the user should see the OTP screen")
//    public void the_user_should_see_the_otp_screen() {
//        WebElement otpScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363634")));
//        Assert.assertTrue("OTP screen is not visible", otpScreen.isDisplayed());
//        System.out.println("OTP screen is visible.");
//    }

//    @And("the user clicks on Done to complete the transfer")
//    public void the_user_clicks_on_done_to_complete_the_transfer() {
//        WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362554")));
//        doneButton.click();
//        System.out.println("Clicked on Done to complete the transfer.");
//    }

//    @And("the user is redirected to the home screen")
//    public void the_user_is_redirected_to_the_home_screen() {
//        WebElement homeScreenButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362794")));
//        Assert.assertTrue("Home screen is not visible after transfer", homeScreenButton.isDisplayed());
//        System.out.println("User redirected to the home screen.");
//    }
}

