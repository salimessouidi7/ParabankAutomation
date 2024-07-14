package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Commons;

import java.time.Duration;

public class Logout {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Logout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Adjust timeout as needed
    }

    // Locators
    private static final By LOGOUT_LINK = By.partialLinkText("Log Out");

    public void Logout(){

        Commons.clickElement(driver,LOGOUT_LINK);

    }
}
