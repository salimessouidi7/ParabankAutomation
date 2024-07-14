package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Commons {
	 static WebDriver driver;
	 
	public static void enterText(WebDriver driver,By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public static void clickElement(WebDriver driver,By locator) {
        driver.findElement(locator).click();
    }

}
