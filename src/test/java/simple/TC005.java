package simple;


import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC005 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Brian Tessele/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.buttonline.com.br/data/mx_login.php");
		// String title = driver.getTitle();
		// Thread.sleep(500);
		// driver.quit();

		// Preenche o Email com o valor "brian.roller@hotmail.com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("brian.roller@hotmail.com");
		// Preenche a Senha com o valor "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("123");

		// Clica no botao Login
		WebElement buttonLogin = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonLogin.click();
		
		//Clica no banner "Experimente o Sistema"
		driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")).click();


		// Verifica se existe o botao Help.
		WebElement helpButton = driver.findElement(By.xpath("//a[@class='btn btn-help navbar-btn ng-binding']"));
		assertNotNull(helpButton);
		helpButton.click();
		
		// Por meio da assercao Hamcrest, procura pela string "Instrucoes"
		String codigoPagina = driver.getPageSource();
		assertTrue(codigoPagina.contains("Instrucoes"));
		Thread.sleep(500);
	
		
	}

}
