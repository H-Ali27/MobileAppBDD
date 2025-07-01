package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class RAASTPaybyIFTBeneficiary {
    private WebDriver driver;
    private WebDriverWait wait;

    public RAASTPaybyIFTBeneficiary() {
        this.driver = DriverManager.getDriver();  // Shared WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }}
