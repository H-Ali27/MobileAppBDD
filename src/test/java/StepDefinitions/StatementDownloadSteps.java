package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public class StatementDownloadSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public StatementDownloadSteps() {
        this.driver = DriverManager.getDriver();  // Using same WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    @When("the user clicks on the Statement button")
    public void the_user_clicks_on_the_statement_button() {
        WebElement Viewstatementbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363880")));
        Viewstatementbutton.click();
        System.out.println("Clicked on view now button.");
    }
    @And("the user clicks on the See all button")
    public void the_user_clicks_on_the_see_all_button() {
        WebElement seeallbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131361820")));
        seeallbutton.click();
    }
    @And("the user clicks on the Calender button")
    public void the_user_clicks_on_the_calender_button() {
        WebElement calenderbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362479")));
        calenderbutton.click();
    }
    @And("the user selects the date range from '{word}' to '{word}'")
    public void the_user_selects_the_date_range(String fromDate, String toDate) {
        WebElement CalenderEditButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131363032")));
        CalenderEditButton.click();

        List<WebElement> datefields = driver.findElements(By.className("android.widget.EditText"));
        datefields.get(0).click();
        datefields.get(0).sendKeys(fromDate);

        datefields.get(1).click();
        datefields.get(1).sendKeys(toDate);
    }
    @And("the user clicks on the Calender okay button")
    public void the_user_clicks_on_the_calender_okay_button() {
        WebElement calenderokbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362389")));
        calenderokbutton.click();
    }
    @Then("the filtered transactions should be displayed")
    public void the_filtered_transactions_should_be_displayed() {
        List<WebElement> filteredTransactions = driver.findElements(By.className("android.view.ViewGroup"));
        if (filteredTransactions.isEmpty()) {
            Assert.fail("No transactions are displayed after filtering.");
        } else {
            System.out.println("Filtered transactions are displayed. Count: " + filteredTransactions.size());
        }
    }
    @When("the user clicks on the Download button")
    public void the_user_clicks_on_the_download_button() {
        WebElement downloadbutton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bi.digitalbanking:id/2131362557")));
        downloadbutton.click();
    }

}


