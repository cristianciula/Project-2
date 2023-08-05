package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class SeleniumUtils{

    private static WebDriver driver;
    public static void setDriver(WebDriver driver) {
        SeleniumUtils.driver = driver;
    }

    //------------------------------------------------------------------------------------------------------------//

    public static WebElement findElement(By by) {
        return driver.findElement(by);
    }
    public static void navigateTo(String string) {
        driver.get(string);
    }
    public static void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void click(By by) {
        driver.findElement(by).click();
    }
    public static void clear(By by) {
        driver.findElement(by).clear();
    }
    public static String getUrl() {
        return driver.getCurrentUrl();
    }
    public static String getText(By by) {
        return driver.findElement(by).getText();
    }
    public static boolean isElementDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }
    public static boolean isElementSelected(By by) {
        return driver.findElement(by).isSelected();
    }
    public static boolean isElementEnabled(By by) {
        return driver.findElement(by).isEnabled();
    }
    public static void sendKeys(By by, String string) {
        driver.findElement(by).sendKeys(string);
    }
}
