package simple;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://buttonline.com.br/data/mx_cadastro.php");

		// Fill the field with "fulano@gmail,com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("fulano@gmail,com");
        Thread.sleep(2000); 
        
        // Fill the password field with "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("123");
        Thread.sleep(2000);
        
        // Fill confirm password with the value of "123"
		WebElement inputSenhaConf = driver.findElement(By.name("senha_conf"));
		inputSenhaConf.sendKeys("123");
        Thread.sleep(2000);
        
        // Complete the field name with "Fulana"
		WebElement inputNome = driver.findElement(By.name("nome"));
		inputNome.sendKeys("Fulana");
		Thread.sleep(2000);
		
		// Complete the field of occupation with the value of "Tester"
		WebElement inputProfissao = driver.findElement(By.name("profissao"));
		inputProfissao.sendKeys("Tester");
		Thread.sleep(2500);

		// Click in 'Enviar' button
		WebElement buttonEnviar = driver.findElement(By.cssSelector("input[value='Enviar'"));
		buttonEnviar.click();
		Thread.sleep(1000);
		
		// Verify if the system returns the error message.
		String expected = "Por favor, preencha corretamente o campo 'E-mail'.";
		String actual = driver.switchTo().alert().getText();
					
			assertEquals(expected, actual);
			
		driver.quit();
	}
}