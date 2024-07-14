package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Commons;

public class TransferFunds {

	private final WebDriver driver;
	private final WebDriverWait wait;

	// Locators
	private static final By TRANSFER_FUND_LINK = By.partialLinkText("Transfer Funds");
	private static final By TRANSFER_AMOUNT = By.id("amount");
	private static final By VIEW_ACCOUNTS = By.xpath("//select[@id='toAccountId']");
	private static final By SELECT_TO_ACCOUNT = By.xpath("//select[@id='toAccountId']/option");
	private static final By TRANSFER_BUTTON = By.xpath("//input[@value='Transfer']");
	private static final By TRANSFERED_MSG = By.xpath("//h1[normalize-space()='Transfer Complete!']");

	public TransferFunds(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
	}

	private TransferFunds navigateToTransferFundsPage() {
		Commons.clickElement(driver, TRANSFER_FUND_LINK);
		return this;
	}

	private TransferFunds enterTransferAmount(int amount) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TRANSFER_AMOUNT));
		Commons.enterText(driver, TRANSFER_AMOUNT, String.valueOf(amount));
		return this;
	}

	private TransferFunds selectTransferToAccount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(VIEW_ACCOUNTS));
		WebElement accountElement = driver.findElement(VIEW_ACCOUNTS);

		// Wait until the dropdown has more than 0 options
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(SELECT_TO_ACCOUNT, 0));
		Select select = new Select(accountElement);
		select.selectByIndex(0); // Select the first option

		return this;
	}

	private TransferFunds clickTransfer() {
		Commons.clickElement(driver, TRANSFER_BUTTON);
		return this;
	}

	private boolean checkTransferedSuccessfully() {
		return  driver.findElement(TRANSFERED_MSG).isDisplayed();

	}

	public void transferFunds(int amount) {
		this.navigateToTransferFundsPage()
				.enterTransferAmount(amount)
				.selectTransferToAccount()
				.clickTransfer();
		checkTransferedSuccessfully();
	}
}
