package simple;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC004 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/teste/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.buttonline.com.br/data/mx_login.php");

		// Preenche o Email com o valor "brian.roller@hotmail.com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("brian.roller@hotmail.com");
		Thread.sleep(500);
		// Preenche a Senha com o valor "321"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("321");
		Thread.sleep(500);

		// Clica no botao Login
		WebElement buttonLogin = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonLogin.click();
		Thread.sleep(1000);
		
		
		// Verifica se existe o formulario de login
		assertNotNull(driver.findElements(By.xpath("//form[@name='login']/*")));
		Thread.sleep(500);
				
		
		//Verifica se existe algum Texto informando "Usuario ou Senha Invalidos".
		String codigoPagina = driver.getPageSource();
		assertTrue(codigoPagina.contains("Usuario ou Senha Invalidos"));
		Thread.sleep(500);
	
	}

}
