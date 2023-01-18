package firstCodeClass;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WaitTypes {
    WebDriver driver;

   public WaitTypes() {
       System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe"  );
       driver = new ChromeDriver();
       driver.manage().window().maximize();
    }






    public void testWaitImplicit(int seconds) {
        System.out.println("WaitTests.testWaitImplicit");
        driver.get("https://demoqa.com/dynamic-properties");
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Deprecated in Selenium4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        WebElement visibleAfter5SecondsButton = driver.findElement(By.id("visibleAfter"));
        Assert.assertEquals("Visible After 5 Seconds", visibleAfter5SecondsButton.getText());
    }


    public void testWaitExplicit(int seconds) {
        System.out.println("WaitTests.testWaitExplicit");
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='enableAfter']")));
        WebElement visibleAfter5SecondsButton = driver.findElement(By.xpath("//button[@id='enableAfter']"));
        Assert.assertTrue(visibleAfter5SecondsButton.isEnabled());
    }

    public void testFluentWait(int waitForThisManySeconds, int checkEveryMilliseconds) {
        System.out.println("WaitTests.testFluentWait");
        driver.get("https://demoqa.com/dynamic-properties");
        //Declare and initialise a fluent wait
        FluentWait wait = new FluentWait(driver);
//Specify the timout of the wait
        wait.withTimeout(Duration.ofSeconds(waitForThisManySeconds));
//Sepcify polling time
        wait.pollingEvery(Duration.ofMillis(checkEveryMilliseconds));
//Specify what exceptions to ignore
        wait.ignoring(NoSuchElementException.class);

//This is how we specify the condition to wait on.
//This is what we will explore more in this chapter
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='visibleAfter']")));
    }

    public void finishTesting(){
       driver.quit();
    }


}
