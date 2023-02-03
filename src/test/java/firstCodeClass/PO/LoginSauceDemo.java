package firstCodeClass.PO;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSauceDemo
{
    private WebDriver driver;

    public LoginSauceDemo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // Needed to use the @FindByMethods
    }

    @FindBy(xpath = "//*[@id=\"user-name\"]") //@FindBy is an alternative way to declare a WebElement
    WebElement UsernameInput;

    @FindBy(xpath = "//*[@id=\"password\"]") //@FindBy is an alternative way to declare a WebElement
    WebElement PasswordImput;

    @FindBy(xpath = "//*[@id=\"login-button\"]\n") //@FindBy is an alternative way to declare a WebElement
    WebElement LoginButton;

    public void sendUserName()
    {
        UsernameInput.sendKeys("standard_user");
    }

    public void sendUserPassword()
    {
        PasswordImput.sendKeys("secret_sauce");
    }

    public void clickLoginButton()
    {
        LoginButton.click();
    }

    public void login()
    {
        driver.get("https://www.saucedemo.com/");
        sendUserName();
        sendUserPassword();
        clickLoginButton();
    }





}
