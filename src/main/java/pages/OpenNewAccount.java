package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.Commons;

public class OpenNewAccount {

	private final WebDriver driver;
	private final WebDriverWait wait;

	// Locators
	private static final By NEW_ACCOUNT_LINK = By.partialLinkText("Open New Account");
	private static final By ACCOUNT_TYPE = By.id("type");
	private static final By EXIST_ACCOUNT = By.id("fromAccountId");
	private static final By EXIST_ACCOUNT_OPT1 = By.xpath("//select[@id='fromAccountId']/option");
	private static final By OPEN_ACCOUNT_BUTTON = By.xpath("//*[@id=\"openAccountForm\"]/form/div/input");
	private static final By ACCOUNT_OPENED_MSG = By.xpath("//p[normalize-space()='Congratulations, your account is now open.']");


	public OpenNewAccount(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
	}

	private OpenNewAccount clickOpenAccountLink() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_ACCOUNT_LINK));
		Commons.clickElement(driver, NEW_ACCOUNT_LINK);
		return this;
	}

	private OpenNewAccount selectAccountType(String typeName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_TYPE));
		WebElement accountTypeElement = driver.findElement(ACCOUNT_TYPE);
		Select select = new Select(accountTypeElement);
		select.selectByVisibleText(typeName);

		return this;
	}

	private OpenNewAccount selectExistingAccount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXIST_ACCOUNT));
		WebElement existAccountElement = driver.findElement(EXIST_ACCOUNT);

		// Wait until the dropdown has more than 0 options
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(EXIST_ACCOUNT_OPT1, 0));
		Select select = new Select(existAccountElement);
		select.selectByIndex(0); // Select the first option

		return this;
	}



	private OpenNewAccount clickOpenAccountButton() {
		wait.until(ExpectedConditions.elementToBeClickable(OPEN_ACCOUNT_BUTTON));
		Commons.clickElement(driver, OPEN_ACCOUNT_BUTTON);

		return this;
	}

	private boolean isAccountOpenedSuccessfully() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_OPENED_MSG));
		return driver.findElement(ACCOUNT_OPENED_MSG).isDisplayed();
	}

	public void openNewAccount(String typeName) {
		this.clickOpenAccountLink()
			.selectAccountType(typeName)
			.selectExistingAccount()
			.clickOpenAccountButton();
		isAccountOpenedSuccessfully();
	}
}
