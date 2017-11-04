package funcionalTest;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LoginPage;


public class LoginInvalidoComPageObjectsTest {

	//private WebDriver driver;

	@Before
	public void before() {
		
		
	}

	@Test
	public void loginSemSucesso () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Brian Tessele\\git\\Buttonline-WS\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.visita("http://www.buttonline.com.br/data/mx_login.php").
				  autentica("brian.roller@hotmail.com", "321");

		assertTrue(loginPage.isLoginPage());
	}

	@After
	public void after() {
		//driver.quit();
	}

}