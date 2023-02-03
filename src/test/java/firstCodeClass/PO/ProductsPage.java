package firstCodeClass.PO;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage
{
    private WebDriver driver;

    public ProductsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // Needed to use the @FindByMethods
    }

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement SauceLabsBackpack_addtoCart_button;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    WebElement SauceLabsBikeLight_addtoCart_button;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    WebElement SauceLabsBoltTShirt_addtoCart_button;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
    WebElement SauceLabsFleeceJacket_addtoCart_button;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    WebElement SauceLabsOnesie_addtoCart_button;

    @FindBy(xpath = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    WebElement TestallTheThingsTShirt_addtoCart_button;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement Cart_button;

    @FindBy(className = "inventory_item_name")
    List<WebElement> allProducts_Labels;


    public void addTwoElementsToCart ()
    {
        TestallTheThingsTShirt_addtoCart_button.click();
        SauceLabsOnesie_addtoCart_button.click();
    }
    public void goToCartPage()
    {
        Cart_button.click();
    }

    public void printAllProductsName()
    {
        for(int i = 0; i < allProducts_Labels.size(); i++)
        {
            System.out.println("Element " + i + " " + allProducts_Labels.get(i).getText());
        }
        System.out.println("Homework 3.2, Done");
    }

}
