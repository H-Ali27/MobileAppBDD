
package StepDefinitions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;


import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class RecordingManager {
    private static AppiumDriver driver;
//    public RecordingManager() {
//        this.driver = (AppiumDriver) DriverManager.getDriver(); // Reusing the initialized driver
//    }
    public static void startRecording(AppiumDriver appiumDriver) {
//        driver = appiumDriver;
//        try {
//            ((CanRecordScreen) driver).startRecordingScreen();
//            System.out.println("Recording started...");
//        } catch (Exception e) {
//            System.out.println("Failed to start screen recording: " + e.getMessage());
//        }
        driver = appiumDriver;
        ((CanRecordScreen) driver).startRecordingScreen();
    }

    public static void stopAndSaveRecording(String fileName) {
        try {
            String base64Video = ((CanRecordScreen) driver).stopRecordingScreen();
            byte[] videoBytes = Base64.getDecoder().decode(base64Video);
            File videoFile = new File("target/videos/" + fileName + ".mp4");
            videoFile.getParentFile().mkdirs();
            try (FileOutputStream fos = new FileOutputStream(videoFile)) {
                fos.write(videoBytes);
                System.out.println("Recording saved at: " + videoFile.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Failed to stop/save screen recording: " + e.getMessage());
        }
    }
}
