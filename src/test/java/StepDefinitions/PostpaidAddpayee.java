package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.
support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;
public class PostpaidAddpayee {

    private WebDriver driver;
    private WebDriverWait wait;

    public PostpaidAddpayee() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
}