package StepDefinitions;

import io.appium.java_client.screenrecording.CanRecordScreen;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.Base64;

public class Hooks {
    private WebDriver driver;

    public Hooks() {
        this.driver = DriverManager.getDriver();
    }
//   @Before
//   public void setUp() {
//        driver = DriverManager.getDriver();
////        // Start recording screen
//        ((CanRecordScreen) driver).startRecordingScreen();
//}

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Step Screenshot");

                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String filename = scenario.getName().replaceAll("[^a-zA-Z0-9]","_") + ".png";
                File destination = new File("target/screenshots/"+filename);
                destination.getParentFile().mkdirs();
                Files.copy(screenshotFile.toPath(),destination.toPath());
                System.out.println("Screenshot captured for failed scenario: " + scenario.getName());
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }
}
