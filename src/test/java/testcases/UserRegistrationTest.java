package testcases;

import org.testng.annotations.Test;
import pages.UserRegistration;
import utils.CSVUtils;

public class UserRegistrationTest extends BaseTest{

    @Test(dataProvider = "csvData", dataProviderClass = CSVUtils.class, description = "Test Case - Automate User Registration process")
    public void registerTest(String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password){
        new UserRegistration(driver).registerUser(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password);
    }
}
