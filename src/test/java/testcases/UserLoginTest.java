package testcases;

import org.testng.annotations.Test;

import pages.UserLogin;
import utils.CSVUtils;

public class UserLoginTest extends BaseTest{
	
	 @Test(dataProvider = "csvData", dataProviderClass = CSVUtils.class, description = "Test Case - Automate that User is able to Open the Account successfully")
	    public void loginTest(String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password){
	        new UserLogin(driver).loginUser(username, password);
	    }
}
