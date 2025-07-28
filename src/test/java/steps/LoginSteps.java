package steps;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utils.WaitHelper;
import utils.WebDriverHelper;

public class LoginSteps {
    LoginPage loginPage;
    WaitHelper waitHelper;
    @Given("user opens the application")
    public void user_opens_the_application() {
        loginPage = new LoginPage(Hooks.driver);
        this.waitHelper = new WaitHelper(Hooks.driver);
    }

    @When("I login with username {string} and password {string}")
    public void login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("page title should contain {string}")
    public void page_title_should_contain(String expectedTitle) {
        String actualTitle = Hooks.driver.getTitle();
        WebDriverHelper.log("Actual title is: " + actualTitle);
        if (!actualTitle.contains(expectedTitle)) {
            WebDriverHelper.takeScreenshot("title_mismatch");
        }
        Assert.assertTrue("Title doesn't contain expected text.", actualTitle.contains(expectedTitle));


    }
}
