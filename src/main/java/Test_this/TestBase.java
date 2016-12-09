package Test_this;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBase {
 // Create the Global Objects
 public static Logger APPLICATION_LOGS = null;
 public static Properties CONFIG = null;
 public WebDriver driver = null;
 
 // Initialize Configuration
 private void initConfig() {
 APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
 CONFIG = new Properties();
 try {

     InputStream input = null;
     input = new FileInputStream("src/webDriver.properties");
 // load a properties file
 CONFIG.load(input);
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 
 // To initialize the Driver
 public void initBrowser(WebDriver driver) throws Exception {
 if (this.driver == null) {
 if (CONFIG.getProperty("driverWEBs").equalsIgnoreCase("ChromeDriver")) {
  DesiredCapabilities cap = DesiredCapabilities.chrome();
  cap.setCapability("version","");
  cap.setCapability("platform","LINUX");
  this.driver = new RemoteWebDriver(new URL("http://localhost:32769/wd/hub"), cap); }
 //else if (CONFIG.getProperty("driverWEBs").equalsIgnoreCase("ChromeDriver")){
 // System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
 //this.driver = new ChromeDriver();}
 this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 this.driver.manage().window().maximize();
 APPLICATION_LOGS.info("Browser Initialized");
 } else {
 APPLICATION_LOGS.log(Level.CONFIG,"Instance was avaiable");
 }
 }
 
 public void invokeApplication() {
 driver.get("http://hotline.ua/");
 }
 
 public void closeBrowser() {
 driver.close();
 APPLICATION_LOGS.info("Browser Closed");
 }
 
 public void quitDriver() {
 driver.quit();
 APPLICATION_LOGS.info("All Browser Instance are closed");
 }
 
 @Before
 public void init() {
 initConfig();
  try {
   initBrowser(driver);
  } catch (Exception e) {
   e.printStackTrace();
  }
  invokeApplication();
 }
}
