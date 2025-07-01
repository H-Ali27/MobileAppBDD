package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;



    class CarddelinkSteps {
        private WebDriver driver;
        private WebDriverWait wait;

        public CarddelinkSteps() {
            this.driver = DriverManager.getDriver();  // Using same WebDriver instance
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }
    }

