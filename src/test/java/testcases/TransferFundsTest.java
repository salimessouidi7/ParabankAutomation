package testcases;

import org.testng.annotations.Test;

import pages.TransferFunds;

public class TransferFundsTest extends BaseTest{
	
	private final int amount = 100;

	@Test(description = "Test Case - Automate that User is able to transfer funds successfully")
	  
	public void transferFundsTest() {
		new TransferFunds(driver).transferFunds(amount);
		
	}
}
