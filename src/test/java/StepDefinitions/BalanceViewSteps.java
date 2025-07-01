package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class BalanceViewSteps {
    AndroidDriver driver = DriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    @Given("User is logged in")
    public void the_user_is_logged_in() {
        try {
            WebElement homeScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.bi.digitalbanking:id/2131362794"))); // ✅ Ensure correct ID
            Assert.assertTrue("Home Screen visible!", homeScreenElement.isDisplayed());
            System.out.println(" Home Screen is visible.");
        } catch (Exception e) {
            System.out.println(" Home Screen not visible.");
            e.printStackTrace();
            Assert.fail("Failed: Home screen element not found.");
        }
    }

    @When("User taps on the balance view button")
    public void user_taps_on_the_balance_view_button() {
        try {
            WebElement balanceButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.bi.digitalbanking:id/2131363230"))); // ✅ Ensure correct ID
            balanceButton.click();
            System.out.println("Balance button clicked.");
        } catch (Exception e) {
            System.out.println("Unable to click balance button.");
            e.printStackTrace();
            Assert.fail("Failed: Balance button not clickable.");
        }
    }

    @Then("Balance should be visible")
    public void balance_should_be_visible() {
        try {
            WebElement balanceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.bi.digitalbanking:id/2131363230"))); // ✅ Ensure correct ID
            Assert.assertTrue(" Balance is not displayed!", balanceElement.isDisplayed());
            System.out.println("Balance is displayed.");
        } catch (TimeoutException e) {
            System.out.println("Balance not displayed.");
            Assert.fail("Failed: Balance element not found.");
        }
    }

    @When("User taps on the balance hide button")
    public void user_taps_on_the_balance_hide_button() {
        try {
            WebElement hideBalanceButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.bi.digitalbanking:id/2131363230"))); // ✅ Ensure correct ID
            hideBalanceButton.click();
            System.out.println("Hide Balance button clicked.");
        } catch (Exception e) {
            System.out.println("Unable to click hide balance button.");
            e.printStackTrace();
            Assert.fail("Failed: Hide balance button not clickable.");
        }
    }

    @Then("Balance should be hidden")
    public void balance_should_be_hidden() {
        try {
            WebElement balanceElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.id("com.bi.digitalbanking:id/2131363829"))); // ✅ Ensure correct ID

            String balanceText = balanceElement.getText();
            Assert.assertEquals("Balance is still visible!", "------", balanceText);
            System.out.println("Balance is hidden correctly as '-----'.");
        } catch (TimeoutException e) {
            System.out.println(" Balance element not found, test failed.");
            Assert.fail("Failed: Balance element did not load in time.");
        }
    }
}
