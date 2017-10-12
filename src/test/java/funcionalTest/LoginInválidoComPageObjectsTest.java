package funcionalTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginInválidoComPageObjectsTest {

	private WebDriver driver;
	 
	 @Before
	 public void before() {
		 System.setProperty("webdriver.chrome.driver", "C:/Users/Brian Tessele/Desktop/chromedriver.exe");
		 driver = new ChromeDriver();
	  
	 }
	 
	 @Test
	 public void loginComSucesso() {
	   LoginPage loginPage = new LoginPage(driver);
	   HomePage homePage = loginPage.
			   						visita("http://www.buttonline.com.br/data/mx_login.php").
	                                autentica("brian.roller@hotmail.com","321");
	 
	   assertTrue(homePage.isValida());
	 }
	 
	 @After
	 public void after() {
	   driver.quit();
	 }
	 
	}