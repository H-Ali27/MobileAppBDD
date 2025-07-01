package StepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CSVReader;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CommonSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public CommonSteps() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Given("the user is on the home screen")
    public void the_user_is_on_the_home_screen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement homeScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.bi.digitalbanking:id/2131362794"))); // ✅ Ensure correct ID
            org.junit.Assert.assertTrue("Home Screen not visible!", homeScreenElement.isDisplayed());
            System.out.println(" Home Screen is visible.");
        } catch (Exception e) {
            System.out.println(" Home Screen not visible.");
            e.printStackTrace();
            Assert.fail("Failed: Home screen element not found.");
        }
    }

    @When("the user clicks on the RAAST button")
    public void the_user_clicks_on_the_raast_button() {
        WebElement raastButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363464")));
        raastButton.click();
        System.out.println("Clicked on RAAST button.");
    }
    @And("the user navigates to the 'Beneficiary' section")
    public void the_user_navigates_to_the_beneficiary_section() {
        WebElement addBeneficiaryButtonMain = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362993")));
        addBeneficiaryButtonMain.click();
    }

    @And("the user clicks on the RAAST Payment button")
    public void the_user_clicks_on_the_raast_payment_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
        if (!buttons.isEmpty() && "Raast Payment".equals(buttons.get(0).getText())) {
            try {
                buttons.get(0).click();
                System.out.println("Clicked on the RAAST PAYMENT button.");
            } catch (Exception e1) {
                System.out.println("First click failed, trying again...");
                try {
                    Thread.sleep(1000); // Optional: small delay before retry
                    buttons.get(0).click();
                    System.out.println("Clicked on the RAAST PAYMENT button on retry.");
                } catch (Exception e2) {
                    System.out.println("Retry also failed. Exception: " + e2.getMessage());
                }
            }
        } else {
            System.out.println("RAAST PAYMENT button not found or not matching.");
        }

    }
    @When("the user clicks the 'Transfer Fund Now' button")
    public void the_user_clicks_the_transfer_fund_now_button() {
        WebElement transferFundNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363083")));
        transferFundNowButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("the user clicks the 'Next' button")
    public void the_user_clicks_the_Next_button() {
        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362226")));
        nextButton1.click();
    }
    @And("the user searches for {string} in the bank list")
    public void the_user_searches_for_in_the_bank_list(String bankName) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363400")));
        dropdown.click();

        WebElement ClicksearchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
        ClicksearchField.click();

        WebElement enterbankname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
        enterbankname.sendKeys(bankName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement bankElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text='"+bankName+"']")));
        bankElement.click();

//        List<WebElement> textone = driver.findElements(By.className("android.widget.TextView"));
//        textone.get(0).click();

        System.out.println("Selected bank: " + bankName);
    }
    @And("the user enters the account number {string}")
    public void the_user_enters_the_account_number(String accountNumber) {
        WebElement accountNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362620")));
        accountNumberField.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362620"))).sendKeys(accountNumber);
        System.out.println("Entered Account Number: " + accountNumber);
    }
    @And("the user enters the amount")
    public void the_user_enters_the_amount() {
        try
        {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");
            String amount = testData.get(0)[2];
            WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362622")));
            amountField.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            amountField.sendKeys(amount);
            System.out.println("Entered Amount: " + amount);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }

    }

    @And("the user selects the purpose of transfer as {string}")
    public void the_user_selects_the_purpose_of_transfer_as(String Purpose) {
        WebElement purposeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363247")));
        purposeDropdown.click();
        try
        {
            List<String[]> testData = CSVReader.getData("src/test/resources/TestData.csv");
            String purpose = testData.get(0)[5];
            WebElement searchPurpose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
            searchPurpose.sendKeys(purpose);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from CSV.");
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement purposeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"
        )));
        purposeOption.click();
        System.out.println("Selected Purpose: " + Purpose);
    }

    @And("the user clicks on Review Details")
    public void the_user_clicks_on_review_details() {
        WebElement reviewDetailsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362194")));
        reviewDetailsButton.click();
        System.out.println("Clicked on Review Details.");
    }
    @And("the user is redirected to the home screen")
    public void the_user_is_redirected_to_the_home_screen() {
        WebElement homeScreenButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362794")));
        Assert.assertTrue("Home screen is not visible after transfer", homeScreenButton.isDisplayed());
        System.out.println("User redirected to the home screen.");
    }
    @And("the user clicks on Done to complete the transfer")
    public void the_user_clicks_on_done_to_complete_the_transfer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(18));
        WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362554")));
        doneButton.click();
        System.out.println("Clicked on Done to complete the transfer.");
    }
    @Then("the user should see the OTP screen")
    public void the_user_should_see_the_otp_screen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement otpScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363634")));
        Assert.assertTrue("OTP screen is not visible", otpScreen.isDisplayed());
        System.out.println("OTP screen is visible.");
    }
    @And("the user Review Details and click on the 'Transfer Fund Now' button")
    public void the_user_Review_Details_and_click_on_the_transfer_fund_now_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement transferFundNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363083")));
        transferFundNowButton.click();
    }
    @And("the user adds the beneficiary")
    public void the_user_adds_the_beneficiary() {
        // Click on the 'Add Beneficiary' button on the 'My Beneficiary' screen
        WebElement addBeneficiaryButtonOnBeneficiaryScreen = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362226")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addBeneficiaryButtonOnBeneficiaryScreen.click();
    }
    @And("the user clicks on the RAAST Beneficiary button")
    public void the_user_clicks_on_the_RAAST_Beneficiary_button() {
        WebElement raastbeneficiaryButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.Button[2]")));
        raastbeneficiaryButton.click();
        System.out.println("Clicked on RAAST beneficiary button.");
    }
    @And("the user selects the RAAST type 'RAAST IBAN'")
    public void the_user_selects_the_RAAST_type() {
        WebElement raastype = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363430")));
        raastype.click();

        WebElement raastIBAN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView")));
        raastIBAN.click();
    }
    @And("the user enters the RAAST IBAN number {string}")
    public void the_user_enters_the_RAAST_iban_number(String iban) {
        WebElement RaastibanField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362620")));
        RaastibanField.sendKeys(iban);
        System.out.println("Entered IBAN: " + iban);
    }
    @And("the user enters the nickname {string} and clicks the add beneficiary button")
    public void the_user_enters_the_nickname_and_clicks_the_add_beneficiary_button(String nickname) {
        WebElement nicknamefield = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362596")));
        nicknamefield.sendKeys(nickname);

        WebElement addbeneficiarybutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362226")));
        addbeneficiarybutton.click();
    }
    @And("the user clicks on the okay button")
    public void the_user_clicks_on_the_okay_button() {
        WebElement Okaybutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362191")));
        Okaybutton.click();
    }
    @And("the user clicks on the okay button on confirmation")
    public void the_user_clicks_the_okay_button_on_confirmation() {
        WebElement okaybutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363225")));
        okaybutton.click();
    }

    @And("the user clicks on Fund Transfer by beneficiary")
    public void the_user_clicks_on_Fund_Transfer_by_beneficiary() {
        WebElement beneficiaryButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button[3]")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        beneficiaryButton.click();
    }
//    @And("the user selects the beneficiary")
//    public void the_user_selects_the_beneficiary() {
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement raastbeneficiaryfield = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363402")));
//        raastbeneficiaryfield.click();
//
//        WebElement beneficiary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363197")));
//        beneficiary.click();
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
    @And("the user navigates to the RAAST Screen")
    public void the_user_navigates_to_the_RAAST_Screen() {
        WebElement backbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362831")));
        backbutton.click();
    }
    @And("the user searches for the beneficiary {string} and selects it")
    public void the_user_searches_for_the_beneficiary_and_selects_it(String beneficiaryName) {
        WebElement beneficiaryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363402")));
        beneficiaryDropdown.click();

        WebElement ClicksearchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
        ClicksearchField.click();

        WebElement enterbeneficiaryname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
        enterbeneficiaryname.sendKeys(beneficiaryName);

        WebElement beneficiaryResult = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.TextView[1]")));
        beneficiaryResult.click();
    }


    @When("the user clicks on the Transfer button")
    public void the_user_clicks_on_the_transfer_button() {
        WebElement transferButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.cardview.widget.CardView[1]/android.widget.TextView"
        )));
        transferButton.click();
        System.out.println("Clicked on Transfer button.");
    }

    @And("the user selects Instant Fund Transfer")
    public void the_user_selects_instant_fund_transfer() {
        WebElement instantFundTransferButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363002")));
        instantFundTransferButton.click();
        System.out.println("Selected Instant Fund Transfer.");
    }
    @And("the user selects the purpose of the transfer as {string}")
    public void the_user_selects_the_purpose_of_the_transfer_as(String purpose) {
        WebElement purposeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363245")));
        purposeDropdown.click();

        WebElement searchPurpose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
        searchPurpose.sendKeys(purpose);

        WebElement purposeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"
        )));
        purposeOption.click();
        System.out.println("Selected Purpose: " + purpose);
    }



    @When("the user clicks on the Bread button")
    public void the_user_clicks_on_the_Bread_button() {
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363695")));
        menuButton.click();
        System.out.println("Clicked on Bread button.");
    }

    @And("the user clicks on the card management tab")
    public void the_user_clicks_on_the_card_management_tab() {
        WebElement addBeneficiaryButtonMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[7]/android.widget.TextView")));
        addBeneficiaryButtonMain.click();
    }

    @And("the user clicks on the card link delink button")
    public void the_user_clicks_on_the_card_link_delink_button() {
        WebElement addBeneficiaryButtonMain = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362312")));
        addBeneficiaryButtonMain.click();
    }

    @And("the user clicks on the Account selection dropdown")
    public void the_user_clicks_on_the_Account_selection_dropdown() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363711")));
        dropdown.click();

    }

    @And("the user clicks on the link delink button")
    public void the_user_clicks_on_the_Link_delink_button() {
        WebElement ClicklinkdelinkButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362191")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ClicklinkdelinkButton.click();

    }
    @And("the user Back to Card screen")
    public void the_user_Back_to_card_screen() {

        WebElement Clickbacktwobutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362831")));
        Clickbacktwobutton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("the user Back to home screen")
    public void the_user_Back_to_home_screen() {
        WebElement Clickbackonebutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362831")));
        Clickbackonebutton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("the user clicks on the Yes button")
    public void the_user_clicks_on_the_Yes_button() {

        WebElement Yesbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363225")));
        Yesbutton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @And("the user Review Details and click on the 'Next' button")
    public void the_user_Review_Details_and_click_on_the_next_button() {
        WebElement transferFundNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363083")));
        transferFundNowButton.click();
    }
    @And("the user clicks the 'Next or Add' button")
    public void the_user_clicks_the_Next_or_Add_button() {
        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362187")));
        nextButton1.click();

    }
    @When("the user clicks on the 'Pay' button")
    public void the_user_clicks_on_the_pay_button() {
        WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text='Pay']")));
        payButton.click();
        System.out.println("Clicked on pay button.");
    }
    @And("the user clicks on 'Add Payee'")
    public void the_user_clicks_on_add_Payee() {
        WebElement addpayeebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Add Payee']")));
        addpayeebutton.click();
        System.out.println("click on add payee button.");
    }
    @And("the user selects {string} as the payment type")
    public void the_user_selects_Mobile_as_the_payment_type(String subcat) {
        WebElement Subcatselect = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363432")));
        Subcatselect.click();

        WebElement searchsubcat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
        searchsubcat.sendKeys(subcat);

        WebElement mobileprepaid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362503")));
        mobileprepaid.click();

    }
    @And("the user selects the mobile network category {string}")
    public void the_user_selects_Mobile_network_category(String Netcat) {
        WebElement Netcatselect = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363431")));
        Netcatselect.click();

        WebElement searchNetcat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
        searchNetcat.sendKeys(Netcat);

        WebElement Netcatpaid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362503")));
        Netcatpaid.click();

    }
    @And("the user enters the payee nickname {string}")
    public void the_user_enters_the_payee_nickname(String nicknamepayee) {
        WebElement nicknamepayeefield = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362652")));
        nicknamepayeefield.sendKeys(nicknamepayee);

    }
    @And("the user enters the payee mobile number {string}")
    public void the_user_enters_the_payee_mobile_number(String numpayee) {
        WebElement numpayeefield = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362630")));
        numpayeefield.sendKeys(numpayee);

    }

}
