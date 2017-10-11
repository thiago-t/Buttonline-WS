package simple;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC003 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/teste/Desktop/chromedriver.exe");
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

		//Verifica os Resultados		
		// Por meio da assersao Hamcrest, procura pela string Brian"
		String codigoPagina = driver.getPageSource();
		assertTrue(codigoPagina.contains("Brian"));
		Thread.sleep(500);
		

		// Verifica se existe o link que acessa a ferramenta.
		assertNotNull(driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")));

		driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")).click();

	}

}
