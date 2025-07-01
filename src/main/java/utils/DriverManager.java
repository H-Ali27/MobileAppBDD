package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static AndroidDriver driver;
    private static WebDriverWait wait;

    private DriverManager() {
        // Private constructor to prevent instantiation
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "R58W91GECLX");
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
                caps.setCapability("appium:automationName", "UiAutomator2");
                caps.setCapability("appium:noReset", true);
                caps.setCapability("appPackage", "com.bi.digitalbanking");
                caps.setCapability("appActivity", "com.bi.digitalbanking.presentation.ui.activities.StartUpAuthActivity");

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                System.out.println("✅ App launched successfully.");

            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("❌ Invalid Appium Server URL.");
            }
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null && driver != null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("🚀 Driver quit successfully.");
        }
    }
}
