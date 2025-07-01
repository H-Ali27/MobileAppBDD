package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class IBFTeasypaisasteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public IBFTeasypaisasteps() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
}
