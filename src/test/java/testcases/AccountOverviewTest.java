package testcases;

import org.testng.annotations.Test;
import pages.AccountOverview;

public class AccountOverviewTest extends BaseTest{

    @Test(description = "Test Case - Extract account information from account table")
    public void extractAccountTableInfoTest() {
        new AccountOverview(driver).accountOverview();
    }
}
