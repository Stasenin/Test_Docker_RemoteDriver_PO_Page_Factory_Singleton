package Test_this;

import Test_this.Test_this.MainPage;
import Test_this.Test_this.RegistrattionPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HotlineTest extends TestBase {
    private MainPage mainPage;
    private RegistrattionPage registrationPage ;  //  это мы класс делаем переменной?

    @Before
    public void precondition() throws IOException {
        mainPage = new MainPage();
        registrationPage = new RegistrattionPage(); // обявленную переменную инстанциируем. вызываем конструктор. а конструктор возвращает элемент данного класса.
        }

    @Test
    public void NegativeRegistrationTest() throws InterruptedException, IOException {
        mainPage = PageFactory.initElements(driver,MainPage.class);
        registrationPage  = PageFactory.initElements(driver,RegistrattionPage.class);
        mainPage.openRegistration();
        registrationPage.login("SomeLogin");
        registrationPage.password("SomePossword");
        registrationPage.email(")(*@#$)(@gmalele.com");
        registrationPage.submit();
        registrationPage.assertElementPresent();
    }

   @After
   public void postcondition() throws IOException {
       closeBrowser();
       quitDriver();
   }

}
