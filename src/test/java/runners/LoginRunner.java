package runners;

import StepDefinitions.RecordingManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.DriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/01_Login.feature"
                },

        glue = "StepDefinitions",
        //tags = "@Login", // ✅ Pehle Login run hoga phir BalanceView
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class LoginRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void beforeAllTests() {
//        RecordingManager.startRecording(DriverManager.getDriver());
        RecordingManager.startRecording((io.appium.java_client.AppiumDriver) DriverManager.getDriver());
    }

    @AfterClass
    public void afterAllTests() {
        RecordingManager.stopAndSaveRecording("Full_Test_Session");
    }
}
/*
"src/test/resources/features/07_RaastPayIBAN.feature",
                "src/test/resources/features/08_RaastPayTrimmedIBAN.feature" ,
                "src/test/resources/features/09_RaastPaybyIBFTBeneficiary.feature" ,
                "src/test/resources/features/10_RaastPaybyIFTBenificiary.feature" ,
                "src/test/resources/features/11_IBFTeasypaisa.feature" ,
                "src/test/resources/features/12_CardLink.feature" ,
* "src/test/resources/features/01_Login.feature",
                "src/test/resources/features/02_BalanceView.feature" ,
                "src/test/resources/features/03_AddBeneficiary.feature" ,
                "src/test/resources/features/04_BeneficiaryFundsTransfer.feature" ,
                "src/test/resources/features/05_IFT.feature" ,
                "src/test/resources/features/06_RAASTPayId.feature" ,*/