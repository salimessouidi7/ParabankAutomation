package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import utils.Commons;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountOverview {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger log = Logger.getLogger(AccountOverview.class);

    // Locators
    private static final By TRANSFER_FUND_LINK = By.partialLinkText("Accounts Overview");
    private static final By ACCOUNT_TBODY = By.tagName("tbody");

    public AccountOverview(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    /**
     * Extracts account table information into a list of maps.
     *
     * @return List of maps containing account table data.
     */
    public List<Map<String, String>> extractAccountTableInfo() {
        List<Map<String, String>> tableData = new ArrayList<>();

        try {
            WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_TBODY));
            List<WebElement> rows = tbody.findElements(By.tagName("tr"));

            // Iterate over rows, skipping the 'Total' row
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                if (cells.size() > 1) {
                    Map<String, String> rowData = new HashMap<>();
                    rowData.put("Account", cells.get(0).getText());
                    rowData.put("Balance", cells.get(1).getText());
                    rowData.put("Available Amount", cells.get(2).getText());
                    tableData.add(rowData);
                }
            }
        } catch (Exception e) {
            log.error("Error extracting account table information: ", e);
            System.err.println("Error extracting account table information: " + e.getMessage());
        }
        return tableData;
    }

    /**
     * Navigates to the account overview page and verifies the account table data.
     */
    public void accountOverview() {
        try {
            Commons.clickElement(driver, TRANSFER_FUND_LINK);
            wait.until(ExpectedConditions.visibilityOfElementLocated(ACCOUNT_TBODY));
            List<Map<String, String>> tableData = extractAccountTableInfo();

            // Example assertions
            Assert.assertFalse(tableData.isEmpty(), "Account table data should not be empty.");
            for (Map<String, String> row : tableData) {
                Assert.assertNotNull(row.get("Account"), "Account should not be null.");
                Assert.assertNotNull(row.get("Balance"), "Balance should not be null.");
                Assert.assertNotNull(row.get("Available Amount"), "Available Amount should not be null.");
            }

            // Log extracted data for verification
            for (Map<String, String> row : tableData) {
                log.info("Extracted Row: " + row);
                System.out.println("Extracted Row: " + row); // Fallback to ensure visibility
            }
        } catch (Exception e) {
            log.error("Error in account overview process: ", e);
            System.err.println("Error in account overview process: " + e.getMessage());
            Assert.fail("Account overview process failed.");
        }
    }
}
