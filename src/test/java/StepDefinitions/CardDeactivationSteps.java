package StepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class CardDeactivationSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public CardDeactivationSteps() {
        this.driver = DriverManager.getDriver();  // Shared WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @When("the user clicks on the card Deactivation button")
    public void the_user_clicks_on_the_card_deactivation_button() {
        WebElement clickDeactiveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362306")));
        clickDeactiveButton.click();
    }
}
