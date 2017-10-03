package invalid.login;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/teste/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.buttonline.com.br/data/mx_login.php");

		// Preenche o Email com o valor "thia@gmail.com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("thia@gmail.com");
		Thread.sleep(500);
		// Preenche a Senha com o valor "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("1235678");
		Thread.sleep(500);

		// Clica no botão Login
		WebElement buttonLogin = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonLogin.click();
		Thread.sleep(1000);
		
		// Resultado: O sistema não loga e a mensagem de login inválido não aparece
	}

}
