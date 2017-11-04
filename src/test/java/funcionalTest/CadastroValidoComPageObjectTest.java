package funcionalTest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
public class CadastroValidoComPageObjectTest {

	//private WebDriver driver;

	@Before
	 public void before() {
		
	 } 
	
	@Test
	public void cadastroValido() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Brian Tessele\\git\\Buttonline-WS\\src\\test\\resources\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		RegisterPage registerPage = new RegisterPage(driver);
		HomePage homePage = new HomePage(driver);
			registerPage.visita("http://buttonline.com.br/data/mx_cadastro.php").
			autentica("n9776969@gmail.com", "123", "123","Brian", "tester");
			
		
		assertTrue(homePage.cadastroEfetuadoComSucesso());

		registerPage.aceitarAlert();
		
		
		
		
		
		
		
		
		
		
		
		

		assertTrue(homePage.isValida());
	}

	@After
	public void after() {
		//driver.quit();
	}

}