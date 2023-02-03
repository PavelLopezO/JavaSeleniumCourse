package firstCodeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {
    private WebDriver driver;

    public void initDriver() {
        System.out.println("Init!");
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;   //We return driver, since we want to mantain the same driver instance
    }

    public void quitBrowser() {
        driver.quit();
    }
}