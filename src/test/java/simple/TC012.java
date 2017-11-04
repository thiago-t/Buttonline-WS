package simple;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Set;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC012 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.buttonline.com.br/data/mx_login.php");
		driver.manage().window().maximize(); 
		
		// Thread.sleep(500);
		// driver.quit();

		// Preenche o Email com o valor "brian.roller@hotmail.com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("brian.roller@hotmail.com");
		Thread.sleep(200);
		// Preenche a Senha com o valor "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("123");
		Thread.sleep(200);

		// Clica no botao Login
		WebElement buttonLogin = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonLogin.click();
		Thread.sleep(500);
		// Clica no banner "Experimente o Sistema"
		driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")).click();
		Thread.sleep(500);
		// Clica na funcao "Novo Button"
		WebElement newButton = driver.findElement(By.cssSelector("a[class='ng-binding ng-isolate-scope']"));
		newButton.click();
		Thread.sleep(500);
		// Clica no botao "Redondo - 45mm"
		WebElement button45 = driver.findElement(By.cssSelector("a[href*='editor.php?tamanho=45&formato=redondo']"));
		button45.click();
		Thread.sleep(500);
		// Clica no botao "Imprimir"
		WebElement buttonPrint = driver.findElement(By.cssSelector("a[class='btn btn-default btn-print navbar-btn btn-great ng-binding']"));
		buttonPrint.click();
		Thread.sleep(500);
		

		// Limpa o campo quantidade de button e inseri o valor "8"
		WebElement inputAmount = driver.findElement(By.cssSelector("input[type='number']"));
		inputAmount.clear();
		inputAmount.sendKeys("8");
		Thread.sleep(500);

		
		// Verifica se o botao "Imprimir" existe e clica;
		WebElement buttonPrint2 = driver.findElement(By.xpath("//*[@id=\"printModal\"]/div/div/div[2]/div/div/div[3]/button"));
		assertNotNull(buttonPrint2);
		buttonPrint2.click();
		Thread.sleep(500);
				
		//O metodo registra a janela atual e muda para janela aberta ap�s o clique		
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
			for(String windowHandle  : handles)
			{
			       if(!windowHandle.equals(parentWindow))
			          {
			          driver.switchTo().window(windowHandle);
			          
			          //Verifica se a pagina de impressao existe e aparece para o usuario
			          String actual = driver.getTitle();
			          String expected = "impressao.php";
						
			          	assertEquals(expected, actual);
						
			          WebElement pagePrint = driver.findElement(By.xpath("//*[@id=\"plugin\"]"));
			          assertNotNull(pagePrint);
						
					
			         driver.quit(); //closing child window
			         driver.switchTo().window(parentWindow); //cntrl to parent window
			          }
			       }   	
	}

}
