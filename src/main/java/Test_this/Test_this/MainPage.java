package Test_this.Test_this;

import Test_this.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends TestBase {



    @FindBy(css ="a[href=\"/user/register/\"]") private WebElement SignInLink;


    public void openRegistration()  {
      SignInLink.sendKeys(Keys.ENTER);
    }


}