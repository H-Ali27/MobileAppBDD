package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.CSVReader;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public class LoginSteps {
    AndroidDriver driver = DriverManager.getDriver();
    WebDriverWait wait = DriverManager.getWait();
    @Given("User is on the login screen")
    public void userIsOnLoginScreen() {
        try {
            WebElement LoginScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362283")));
            Assert.assertTrue(LoginScreenElement.isDisplayed(), "Login Screen is visible.");

        } catch (Exception e) {
            System.out.println("Login screen is not visible.");
            e.printStackTrace();
            Assert.fail("Login screen element not found.");
        } finally {
            //
        }
    }

    @When("the user enters username {string}")
    public void userEntersUsername(String username) {
        try {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");

                String userName = testData.get(0)[0];
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362651")));
                userNameField.sendKeys(userName);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }

    }

    @When("the user enters password {string}")
    public void userEntersPassword(String password) {
        try
        {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");

                String Pass = testData.get(0)[1];
                WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362644")));
                passwordField.sendKeys(Pass);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }

    }

    @When("User taps on login button")
    public void userTapsOnLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362283")));
        loginButton.click();
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement homeScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362794")));
            Assert.assertTrue(homeScreenElement.isDisplayed(), "Login successful.");
            System.out.println("Login was successful.");

        } catch (Exception e) {
            System.out.println("Login failed.");
            e.printStackTrace();
            Assert.fail("Login failed: Home screen element not found.");
        } finally {
            //
        }
    }
}
