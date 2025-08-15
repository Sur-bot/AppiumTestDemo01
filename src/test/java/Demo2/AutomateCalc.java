package Demo2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AutomateCalc {

    public static void main(String[] args) {
        AndroidDriver driver = null;
        try {
            // Khởi tạo DesiredCapabilities
            DesiredCapabilities capabilities = getCalculatorCapabilities();

            // Khởi tạo driver
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);

            // WebDriverWait  Selenium 4
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            System.out.println("Application Started");

            // Perform calculation: 8 + 2
            clickElement(wait, By.id("com.google.android.calculator:id/digit_8"));
            clickElement(wait, By.id("com.google.android.calculator:id/op_add"));
            clickElement(wait, By.id("com.google.android.calculator:id/digit_2"));
            clickElement(wait, By.id("com.google.android.calculator:id/eq"));

            // Lấy kết quả
            WebElement resultElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.calculator:id/result_final")));
            String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

            // Kiểm tra kết quả
            if ("10".equals(result)) {
                System.out.println("Test Passed: Result = " + result);
            } else {
                System.out.println("Test Failed: Result = " + result);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit(); //  close session
            }
        }
    }

    // Helper method click element
    private static void clickElement(WebDriverWait wait, By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    private static DesiredCapabilities getCalculatorCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:platformVersion", "15");
        capabilities.setCapability("appium:appPackage", "com.google.android.calculator");
        capabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
        return capabilities;
    }
}
