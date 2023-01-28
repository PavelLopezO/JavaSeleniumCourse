package firstCodeClass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class test1 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"  );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        //Declare elements from Login Page
        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        //Send Username and Password, click on login button
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        //Declare SauceLabsBackpack_label Label for assertion
        WebElement SauceLabsBackpack_label = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));

        //Use the code below, to match the expected text of the first item in the shop
        Assert.assertEquals("Sauce Labs Backpack",SauceLabsBackpack_label.getText());

        //Declare items to add to the cart (SauceLabsBackpack_AddtoCartButton and SauceLabsBikeLight_AddtoCartButton) and CartButton
        WebElement SauceLabsBackpack_AddtoCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
        WebElement SauceLabsBikeLight_AddtoCartButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
        WebElement CartButton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));

        //Declare elements by Class and print the text of all the labels one by one
        List<WebElement> allLabels = driver.findElements(By.className("inventory_item_name"));
        for(int i = 0; i < allLabels.size(); i++)
        {
            System.out.println("Element " + i + " " + allLabels.get(i).getText());
        }
        System.out.println("Homework 3.1, Done");


        //Click on both elements declared and the go to the Cart page

        SauceLabsBackpack_AddtoCartButton.click();
        SauceLabsBikeLight_AddtoCartButton.click();
        CartButton.click();

        //Declare labels on products from inside the Cart
        WebElement SauceLabsBackpack_Incart = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        WebElement SauceLabsBackpackSauceLabsBikeLight_Incart = driver.findElement(By.xpath("//*[@id=\"item_0_title_link\"]/div"));

        //validate if names of Labels are in the Cart
        Assert.assertEquals("Sauce Labs Backpack",SauceLabsBackpack_Incart.getText());
        Assert.assertEquals("Sauce Labs Bike Light",SauceLabsBackpackSauceLabsBikeLight_Incart  .getText());

        System.out.println("Homework 3.2, Done");
        System.out.println("Everything works");




        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }
}
