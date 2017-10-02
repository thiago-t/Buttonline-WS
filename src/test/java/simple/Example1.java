package simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/teste/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.buttonline.com.br/data/mx_login.php");
		// String title = driver.getTitle();
		// Thread.sleep(500);
		// driver.quit();

		// Preenche o Email com o valor "thia@gmail.com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("thia@gmail.com");
		// Preenche a Senha com o valor "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("123");

		// Clica no botão Login
		WebElement buttonLogin = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonLogin.click();

		//Verifica os Resultados		
		// Por meio da asserção Hamcrest, procura pela string “SouFernandoBaleia"
		String codigoPagina = driver.getPageSource();
		assertThat(codigoPagina, Matchers.containsString("SouFernandoBaleia"));
		// Verifica se existe o link que acessa a ferramenta.
		assertNotNull(driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")));

		// driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")).click();

	}

}
