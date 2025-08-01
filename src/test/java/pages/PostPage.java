package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

import java.time.Duration;

public class PostPage {
    WebDriver driver;
    WaitHelper wait;
    String thumbnail= "";
    //WebElement editableDiv;
    //WebElement saveButton;
    //WebElement descriptionTab;
    //WebElement deleteButton;
    public PostPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver);

    }

    // ----- Update these locators here -----
    By postsLink = By.xpath("//a[@href='#/products']");
    By createButton = By.xpath("//a[@href='#/products/create']");
    By titleField = By.id("title");
    By bodyField = By.id("body");
    By referenceField = By.xpath("//input[@name='thumbnail']");
    By imageUpload = By.xpath("//input[@name='image']");
    By heightField = By.xpath("//input[@name='height']");
    By widthField = By.xpath("//input[@name='width']");
    By priceField = By.xpath("//input[@name='price']");
    By stockField = By.xpath("//input[@name='stock']");
    By salesField = By.xpath("//input[@name='sales']");
    By categoryDropdown = By.xpath("//input[@name='category']");
    By descriptionField = By.id("description");
    By editableDiv = By.xpath("//div[@class='ProseMirror']//br[@class='ProseMirror-trailingBreak']");
    By DetailsButton = By.xpath("//a[@id='tabheader-details' and text()='Details']");
    By referenceld = By.xpath("//input[@name='reference']");
    By saveButton = By.xpath("//button[@type='submit' and @aria-label='Save']");
    By descriptionTab = By.xpath("//a[@id='tabheader-description']");
    By deleteButton = By.xpath("//button[@aria-label='Delete']");


    public void navigateToPosts() {
        wait.waitForClickability(postsLink).click();
    }

    public void clickCreate() {
        wait.waitForClickability(postsLink).click();
        wait.waitForClickability(createButton).click();
    }

    public void enterReference(String ref,String image) {
        wait.waitForVisibility(referenceField).clear();
        driver.findElement(referenceField).sendKeys(ref);
        wait.waitForVisibility(imageUpload).sendKeys(image);
        wait.waitForClickability(DetailsButton).click();
    }

    public void enterReferences(String ref) {
        //wait.waitForVisibility(referenceld).clear();
        driver.findElement(referenceld).sendKeys(ref);

    }

    public void uploadImage(String imagePath) {
        wait.waitForVisibility(imageUpload).sendKeys(imagePath);
    }

    public void enterHeight(String height) {
        wait.waitForVisibility(heightField).sendKeys(height);
    }

    public void enterWidth(String width) {
        wait.waitForVisibility(widthField).sendKeys(width);
    }

    public void enterPrice(String price) {
        wait.waitForVisibility(priceField).sendKeys(price);
    }

    public void enterStock(String stock) {
        wait.waitForVisibility(stockField).sendKeys(stock);
    }

    public void enterSales(String sales) {
        wait.waitForVisibility(salesField).sendKeys(sales);
    }

    public void selectCategory(String category) {
        WebElement categoryDropdown = driver.findElement(By.xpath("//div[@role='combobox' and contains(@class, 'MuiSelect-select')]"));
        categoryDropdown.click();

       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));
*/
        // Select the category by data-value or text (e.g., "water")
        WebElement categoryOption = driver.findElement(By.xpath("//li[@role='option' and normalize-space()='water']"));
        categoryOption.click();


        wait.waitForClickability(descriptionTab).click();
    }

    public void enterDescription(String desc) {
        wait.waitForClickability(editableDiv).sendKeys(desc);


    }

    public void submitForm() {

        wait.waitForClickability(saveButton).click();
    }

    public void clickonPosterAndVerifyCreatedPoster(String refrence) {
        wait.waitForClickability(postsLink).click();

    }
    public String VerifThumbNail(){
        thumbnail = driver.findElement(referenceField).getAttribute("value");
        return  thumbnail;
    }

    public void createPost(String title, String body) {
        driver.findElement(createButton).click();
        driver.findElement(titleField).sendKeys(title);
        driver.findElement(bodyField).sendKeys(body);

    }
    public void deletePoster() {
        wait.waitForClickability(deleteButton).click();
    }



    public boolean isPostVisible(String title) {
        return driver.getPageSource().contains(title);
    }
}
