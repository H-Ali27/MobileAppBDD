package StepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class CardActivationSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public CardActivationSteps() {
        this.driver = DriverManager.getDriver();  // Shared WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @When("the user clicks on the card Activation button")
    public void the_user_clicks_on_the_card_Activation_button() {
        WebElement clickctiveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362303")));
        clickctiveButton.click();
    }
}
