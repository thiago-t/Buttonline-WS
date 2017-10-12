package funcionalTest;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class CadastroVálidoComPageObjectTest {

	private WebDriver driver;

	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Brian Tessele/Desktop/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void cadastroVálido() throws InterruptedException {

		RegisterPage registerPage = new RegisterPage(driver);
		HomePage homePage = new HomePage(driver);
			registerPage.visita("http://buttonline.com.br/data/mx_cadastro.php").
			autentica("TesterDoS2b@gmail.com", "123", "123","Brian", "tester");
			
			Thread.sleep(3000);

		assertTrue(homePage.cadastroEfetuadoComSucesso());

		registerPage.aceitarAlert();

		assertTrue(homePage.isValida());
	}

	@After
	public void after() {
		driver.quit();
	}

}