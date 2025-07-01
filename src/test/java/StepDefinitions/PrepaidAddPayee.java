package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class PrepaidAddPayee {

    private WebDriver driver;
    private WebDriverWait wait;

    public PrepaidAddPayee() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

//    @When("the user clicks on the 'Pay' button")
//    public void the_user_clicks_on_the_pay_button() {
//        WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//                "//android.widget.TextView[@text='Pay']")));
//        payButton.click();
//        System.out.println("Clicked on pay button.");
//    }
//    @And("the user clicks on 'Add Payee'")
//    public void the_user_clicks_on_add_Payee() {
//        WebElement addpayeebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Add Payee']")));
//        addpayeebutton.click();
//        System.out.println("click on add payee button.");
//    }
//    @And("the user selects {string} as the payment type")
//    public void the_user_selects_Mobile_as_the_payment_type(String subcat) {
//        WebElement Subcatselect = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363432")));
//        Subcatselect.click();
//
//        WebElement searchsubcat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
//        searchsubcat.sendKeys(subcat);
//
//        WebElement mobileprepaid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362503")));
//        mobileprepaid.click();
//
//    }
//    @And("the user selects the mobile network category {string}")
//    public void the_user_selects_Mobile_network_category(String Netcat) {
//        WebElement Netcatselect = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363431")));
//        Netcatselect.click();
//
//        WebElement searchNetcat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131363383")));
//        searchNetcat.sendKeys(Netcat);
//
//        WebElement Netcatpaid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.bi.digitalbanking:id/2131362503")));
//        Netcatpaid.click();
//
//    }
//    @And("the user enters the payee nickname {string}")
//    public void the_user_enters_the_payee_nickname(String nicknamepayee) {
//        WebElement nicknamepayeefield = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362652")));
//        nicknamepayeefield.sendKeys(nicknamepayee);
//
//    }
//    @And("the user enters the payee mobile number {string}")
//    public void the_user_enters_the_payee_mobile_number(String numpayee) {
//        WebElement numpayeefield = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362630")));
//        numpayeefield.sendKeys(numpayee);
//
//    }



}
