package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverManager;

import java.time.Duration;

public class LogoutSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public LogoutSteps() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @Given("the user clicks on the 'Logout' button")
    public void the_user_clicks_on_the_logout_button(){
        WebElement logoutbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363697")));
        logoutbutton.click();
    }
    @And("the user confirms the logout action")
    public void the_user_confirms_the_logout_action() {
        WebElement logoutbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362267")));
        logoutbutton.click();
    }
    @Then("the user should be redirected to the login screen")
    public void the_user_should_be_redirected_to_the_login_screen() {
        try {
            WebElement loginScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362283")));
            Assert.assertTrue(loginScreenElement.isDisplayed(), "Login successful.");
            System.out.println("Login was successful.");

        } catch (Exception e) {
            System.out.println("Logout failed.");
            e.printStackTrace();
            Assert.fail("Logout failed: Home screen element not found.");
        } finally {
            //
        }
    }

}
