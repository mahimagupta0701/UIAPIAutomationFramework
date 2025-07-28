package hooks;

import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverHelper;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Driver session: " + Hooks.driver);
        driver = WebDriverHelper.initializeDriver();
        driver.get(ConfigReader.get("url"));
        System.out.println("Driver session: " + driver);


    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();

        }
    }
}
