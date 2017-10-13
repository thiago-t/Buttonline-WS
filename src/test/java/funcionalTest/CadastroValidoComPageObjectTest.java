package funcionalTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class CadastroValidoComPageObjectTest {

	//private WebDriver driver;

	/*@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Brian Tessele/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	} */
	
	@Test
	public void cadastroValido() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Brian Tessele/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		RegisterPage registerPage = new RegisterPage(driver);
		HomePage homePage = new HomePage(driver);
			registerPage.visita("http://buttonline.com.br/data/mx_cadastro.php").
			autentica("aa276555@gmail.com", "123", "123","Brian", "tester");
			
		
		assertTrue(homePage.cadastroEfetuadoComSucesso());

		registerPage.aceitarAlert();

		assertTrue(homePage.isValida());
	}

	//@After
	//public void after() {
		//driver.quit();
	//}

}