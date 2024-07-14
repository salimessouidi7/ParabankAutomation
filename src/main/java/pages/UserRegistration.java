package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Commons;

import java.time.Duration;

public class UserRegistration{

    private final WebDriver driver;
    private final WebDriverWait wait;

    public UserRegistration(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Adjust timeout as needed
    }

    // Locators
    private static final By REGISTER_LINK = By.partialLinkText("Register");
    private static final By FIRST_NAME_FIELD = By.id("customer.firstName");
    private static final By LAST_NAME_FIELD = By.id("customer.lastName");
    private static final By ADDRESS_FIELD = By.id("customer.address.street");
    private static final By CITY_FIELD = By.id("customer.address.city");
    private static final By STATE_FIELD = By.id("customer.address.state");
    private static final By ZIPCODE_FIELD = By.id("customer.address.zipCode");
    private static final By PHONE_FIELD = By.id("customer.phoneNumber");
    private static final By SSN_FIELD = By.id("customer.ssn");
    private static final By USERNAME_FIELD = By.id("customer.username");
    private static final By PASSWORD_FIELD = By.id("customer.password");
    private static final By CONFIRM_PASSWORD_FIELD = By.id("repeatedPassword");
    private static final By REGISTER_BUTTON = By.xpath("//input[@value='Register']");
    private static final By ACCOUNT_CREATED_MSG = By.xpath("//p[normalize-space()='Your account was created successfully. You are now logged in.']");
    private static final By LOGOUT_LINK = By.partialLinkText("Log Out");

    /**
     * Clicks the register link.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration clickRegisterLink() {
    	Commons.clickElement(driver,REGISTER_LINK);
        return this;
    }

    /**
     * Enters the first name.
     * @param firstName The first name to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterFirstName(String firstName) {
    	Commons.enterText(driver,FIRST_NAME_FIELD, firstName);
        return this;
    }

    /**
     * Enters the last name.
     * @param lastName The last name to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterLastName(String lastName) {
    	Commons.enterText(driver,LAST_NAME_FIELD, lastName);
        return this;
    }

    /**
     * Enters the address.
     * @param address The address to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterAddress(String address) {
    	Commons.enterText(driver,ADDRESS_FIELD, address);
        return this;
    }

    /**
     * Enters the city.
     * @param city The city to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterCity(String city) {
    	Commons.enterText(driver,CITY_FIELD, city);
        return this;
    }

    /**
     * Enters the state.
     * @param state The state to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterState(String state) {
    	Commons.enterText(driver,STATE_FIELD, state);
        return this;
    }

    /**
     * Enters the zip code.
     * @param zipCode The zip code to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterZipCode(String zipCode) {
    	Commons.enterText(driver,ZIPCODE_FIELD, zipCode);
        return this;
    }

    /**
     * Enters the phone number.
     * @param phone The phone number to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterPhone(String phone) {
    	Commons.enterText(driver,PHONE_FIELD, phone);
        return this;
    }

    /**
     * Enters the SSN.
     * @param ssn The SSN to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterSSN(String ssn) {
    	Commons.enterText(driver,SSN_FIELD, ssn);
        return this;
    }

    /**
     * Enters the username.
     * @param username The username to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterUsername(String username) {
    	Commons.enterText(driver,USERNAME_FIELD, username);
        return this;
    }

    /**
     * Enters the password.
     * @param password The password to enter.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterPassword(String password) {
    	Commons.enterText(driver,PASSWORD_FIELD, password);
        return this;
    }

    /**
     * Enters the confirmation password.
     * @param password The password to confirm.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration enterConfirmPassword(String password) {
    	Commons.enterText(driver,CONFIRM_PASSWORD_FIELD, password);
        return this;
    }

    /**
     * Clicks the register button.
     * @return UserRegistration instance for method chaining.
     */
    public UserRegistration clickRegisterButton() {
    	Commons.clickElement(driver,REGISTER_BUTTON);
        return this;
    }

    /**
     * Checks if the account is created successfully.
     * @return true if account created message is displayed, false otherwise.
     */
    public boolean isAccountCreated() {
        return driver.findElement(ACCOUNT_CREATED_MSG).isDisplayed();
    }

    /**
     * Performs user registration with provided details.
     * @param firstName User's first name.
     * @param lastName User's last name.
     * @param address User's address.
     * @param city User's city.
     * @param state User's state.
     * @param zipCode User's zip code.
     * @param phone User's phone number.
     * @param ssn User's SSN.
     * @param username User's username.
     * @param password User's password.
     */
    public void registerUser(String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password) {
        clickRegisterLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_FIELD));

        this.enterFirstName(firstName)
            .enterLastName(lastName)
            .enterAddress(address)
            .enterCity(city)
            .enterState(state)
            .enterZipCode(zipCode)
            .enterPhone(phone)
            .enterSSN(ssn)
            .enterUsername(username)
            .enterPassword(password)
            .enterConfirmPassword(password)
            .clickRegisterButton();

        if (isAccountCreated()) {
            driver.findElement(LOGOUT_LINK).click();
        }
    }

}
