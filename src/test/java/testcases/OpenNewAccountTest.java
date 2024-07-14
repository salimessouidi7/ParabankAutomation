package testcases;

import org.testng.annotations.Test;

import pages.OpenNewAccount;

public class OpenNewAccountTest extends BaseTest{
	
	private final String typeName = "CHECKING";
	private final String existAccountName = "17451";
	
	@Test(description = "Test Case - Automate that User is able to Open a new Account successfully")
	public void openAccountTest() {
		new OpenNewAccount(driver).openNewAccount(typeName);
	}
}
