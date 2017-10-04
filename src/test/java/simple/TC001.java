package simple;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC001 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/PC 09/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://buttonline.com.br/data/mx_cadastro.php");
		// String title = driver.getTitle();
		// Thread.sleep(500);
		// driver.quit();

		// Preenche o Email com o valor "teste.2017@gmail.com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("teste.asd201asd337@gmail.com");
		// Preenche a Senha com o valor "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("123");
		// Preenche a Senha com o valor "123"
		WebElement inputSenhaConf = driver.findElement(By.name("senha_conf"));
		inputSenhaConf.sendKeys("123");
		// Preenche a Senha com o valor "Jaqueline"
		WebElement inputNome = driver.findElement(By.name("nome"));
		inputNome.sendKeys("Jaqueline");
		// Preenche a Senha com o valor "Tester"
		WebElement inputProfissao = driver.findElement(By.name("profissao"));
		inputProfissao.sendKeys("Tester");
		

		// Clica no botão Login
		WebElement buttonEnviar = driver.findElement(By.cssSelector("input[value='Enviar'"));
		buttonEnviar.click();
		
		
		driver.get("http://buttonline.com.br/data/mx_cadastro.php");
		WebElement sign = driver.findElement(By.xpath("//html/body/div[3]/div[3]/span[4]/span/a"));
		sign.click();
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
		driver.findElement(By.xpath("//*[@string='ok']/a[1]")).click();
	
		//Verifica os Resultados		
		// Por meio da asserção Hamcrest, procura pela string “Seu cadastro foi efetuado com sucesso."
		String codigoPagina = driver.getPageSource();
		assertThat(codigoPagina, Matchers.containsString("Seu cadastro foi efetuado com sucesso."));
		Thread.sleep(500);
		
		String codigoPagina1 = driver.getPageSource();
		assertThat(codigoPagina1, Matchers.containsString("Jaquel"));
		Thread.sleep(500);
		
		
		// Por meio da asserção Hamcrest, procura pela string “Seu cadastro foi efetuado com sucesso."
		String codigoPagina2 = driver.getPageSource();
		assertThat(codigoPagina2, Matchers.containsString("Jaqueline"));
		Thread.sleep(500);
		
		// Verifica se existe o link que acessa a ferramenta.
		assertNotNull(driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")));
		Thread.sleep(500);
		
		driver.quit();
		
	}

}
