package firstCodeClass.PO;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
    private WebDriver driver;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // Needed to use the @FindByMethods
    }

    @FindBy(xpath = "//*[@id=\"item_3_title_link\"]/div")
    WebElement TestallTheThingsTShirtIncart_Label;

    @FindBy(xpath = "//*[@id=\"item_2_title_link\"]/div")
    WebElement SauceLabsOnesieIncart_Label;

    public void AssertElementsInCart()
    {
        Assert.assertEquals("Test.allTheThings() T-Shirt (Red)",TestallTheThingsTShirtIncart_Label.getText());
        Assert.assertEquals("Sauce Labs Onesie",SauceLabsOnesieIncart_Label.getText());
        System.out.println("Homework 3.1");
    }

}
