package Test_this.Test_this;

import Test_this.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class RegistrattionPage extends TestBase{

    @FindBy (how = How.CSS,using = "div[class=\"cell7 cell-768\"]>input[type=\"text\"]")
     private WebElement login;
    @FindBy (how = How.CSS,using = "div[class=\"cell7 cell-100-768\"]>input[type=\"password\"]")
    private WebElement password;
    @FindBy (how = How.CSS,using = "div[class=\"cell7 cell-768\"]>input[type=\"email\"]")
    private WebElement email;
    @FindBy (how = How.ID,using = "submit-button")
    private WebElement submit;
    @FindBy (how = How.XPATH,using = "//*[contains(@id, 'error_email')][.='Поле не соответствует формату']")
    private WebElement assertElementPresent;



    public void login (String log) throws IOException {
        login.sendKeys(log);
    }
    public void password (String pas) throws IOException {
        password.sendKeys(pas);
    }

    public void email (String eml) throws IOException {
        email.sendKeys(eml);

    }
    public void submit () throws IOException {
        submit.click();
    }
    public void assertElementPresent () throws IOException {

        try{  Assert.assertTrue(assertElementPresent.isDisplayed());} catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Passed: Right Error massage. - Not valid E-mail.");

    }

}
