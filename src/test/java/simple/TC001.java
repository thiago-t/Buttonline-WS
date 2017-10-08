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
		System.setProperty("webdriver.chrome.driver", "C:/Users/Brian Tessele/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://buttonline.com.br/data/mx_cadastro.php");
		// String title = driver.getTitle();
		// Thread.sleep(500);
		// driver.quit();

		// Preenche o Email com o valor "teste.2017@gmail.com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("carinhadeanjo@gmail.com");
		//Pause for 2 seconds
        Thread.sleep(2000);
		// Preenche a Senha com o valor "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("123");
        Thread.sleep(2000);
		// Preenche a Senha com o valor "123"
		WebElement inputSenhaConf = driver.findElement(By.name("senha_conf"));
		inputSenhaConf.sendKeys("123");
        Thread.sleep(2000);
		// Preenche a Senha com o valor "Jaqueline"
		WebElement inputNome = driver.findElement(By.name("nome"));
		inputNome.sendKeys("Jaqueline");
		Thread.sleep(2000);
		// Preenche a Senha com o valor "Tester"
		WebElement inputProfissao = driver.findElement(By.name("profissao"));
		inputProfissao.sendKeys("Veterinária");
		Thread.sleep(2000);
		

		// Clica no botão Login
		WebElement buttonEnviar = driver.findElement(By.cssSelector("input[value='Enviar'"));
		buttonEnviar.click();
		Thread.sleep(3000);
		
		//System.out.println("Alert text is: " +driver.switchTo().alert().getText());
		
		//Verifica se a mensagem "Seu cadastro foi efetuado com sucesso." aparece.
		String expected = "Seu cadastro foi efetuado com sucesso.";
		String actual = driver.switchTo().alert().getText();
			
			assertEquals(expected, actual);
		
		//Aceita o Alert();	
		driver.switchTo().alert().accept();
		
		System.out.println(actual);	
		
	   
		//Verifica os Resultados por meio da asserção Hamcrest,
		//procura pela string “Jaqueline"
		String codigoPagina = driver.getPageSource();
		assertThat(codigoPagina, Matchers.containsString("Jaqueline"));
		Thread.sleep(500);
		
		// Verifica se existe o link que acessa a ferramenta.
		assertNotNull(driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")));
		Thread.sleep(500);
		
		driver.quit();
		
	}
}

