package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Commons;

public class UserLogin{
	private final WebDriver driver;
    private final WebDriverWait wait;

    public UserLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Adjust timeout as needed
    }

    // Locators
    private static final By USERNAME_FIELD = By.name("username");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.xpath("//input[@value='Log In']");
    private static final By LOGIN_SUCCESS_MSG = By.xpath("//h1[normalize-space()='Accounts Overview']");
    
    /**
     * Enters the username.
     * @param username The username to enter.
     * @return UserLogin instance for method chaining.
     */
    private UserLogin enterUsername(String username) {
        Commons.enterText(driver,USERNAME_FIELD, username);
        return this;
    }

    /**
     * Enters the password.
     * @param password The password to enter.
     * @return UserLogin instance for method chaining.
     */
    private UserLogin enterPassword(String password) {
    	Commons.enterText(driver,PASSWORD_FIELD, password);
        return this;
    }
    
    /**
     * Clicks the Log In button.
     * @return UserLogin instance for method chaining.
     */
    private UserLogin clickLoginButton() {
    	Commons.clickElement(driver,LOGIN_BUTTON);
        return this;
    }
    
    /**
     * Checks if the user logs in successfully.
     * @return true if login successfully message is displayed, false otherwise.
     */
    private boolean check_login_successfully(){
    	return driver.findElement(LOGIN_SUCCESS_MSG).isDisplayed();
    }
    
    
    public void loginUser(String username, String password) {
    	this.enterUsername(username)
    		.enterPassword(password)
    		.clickLoginButton();
    	check_login_successfully();
    }
    

}
