package testcases;

import org.testng.annotations.Test;
import pages.Logout;

public class LogoutTest extends BaseTest{

    @Test(description = "Test Case - Automate that User is able to Log Out after Logging in")
    public void logouTest(){
        new Logout(driver).Logout();
    }
}
