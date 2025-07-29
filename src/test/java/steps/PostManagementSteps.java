package steps;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.PostPage;
import utils.WaitHelper;
import utils.WebDriverHelper;

public class PostManagementSteps {
    static WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(Hooks.driver);
     PostPage postPage = new PostPage(Hooks.driver);
    WaitHelper waitHelper =  waitHelper = new WaitHelper(Hooks.driver);
/*
    @Before
    public void initPages() {
        if (Hooks.driver == null) {
            throw new IllegalStateException("WebDriver not initialized");
        }
        postPage = new PostPage(Hooks.driver);
        loginPage = new LoginPage(Hooks.driver);
        waitHelper = new WaitHelper(Hooks.driver);
    }*/

    @Given("I enter reference details from example section: {string}, {string}")
    public void enterReferenceAndImage(String reference, String image) {
        postPage.clickCreate();
        postPage.enterReference(reference,image);
        WebDriverHelper.takeScreenshot("RefrencePage");

    }

    @And("I provide additional inputs: height {string}, width {string}, price {string}, stock {string}, sales {string}, category {string}, reference {string}")
    public void enterMoreDetails(String height, String width, String price, String stock, String sales, String category, String reference) {
        postPage.enterReferences(reference);
        postPage.enterHeight(height);
        postPage.enterWidth(width);
        postPage.enterPrice(price);
        postPage.enterStock(stock);
        postPage.enterSales(sales);
        postPage.selectCategory(category);
        WebDriverHelper.takeScreenshot("AdditionalInformaiton");
        //postPage.enterReferences(reference);
    }

    @When("I submit the post")
    public void submitPost() {
        postPage.submitForm();
        WebDriverHelper.takeScreenshot("Submittion");
    }

    @Then("I should see {string} in the list")
    public void i_should_see_reference_in_the_list(String reference) {

        String isPresent = postPage.VerifThumbNail();
        Assert.assertTrue(isPresent.contains(reference));
        WebDriverHelper.takeScreenshot("AssetionPassed");
    }

    @Then("I delete the poster")
    public void i_delete_the_poster() {
        postPage.deletePoster();

    }


}
