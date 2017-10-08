package simple;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.hamcrest.Matchers;

public class TC012 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Brian Tessele/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.buttonline.com.br/data/mx_login.php");
		driver.manage().window().maximize(); 
		// String title = driver.getTitle();
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

		// Clica no botão Login
		WebElement buttonLogin = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonLogin.click();
		Thread.sleep(500);
		// Clica no banner "Experimente o Sistema"
		driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")).click();
		Thread.sleep(500);
		// Clica na função "Novo Button"
		WebElement newButton = driver.findElement(By.cssSelector("a[class='ng-binding ng-isolate-scope']"));
		newButton.click();
		Thread.sleep(500);
		// Clica no botão "Redondo - 45mm"
		WebElement button45 = driver.findElement(By.cssSelector("a[href*='editor.php?tamanho=45&formato=redondo']"));
		button45.click();
		Thread.sleep(500);
		// Clica no botão "Imprimir"
		WebElement buttonPrint = driver.findElement(By.cssSelector("a[class='btn btn-default btn-print navbar-btn btn-great ng-binding']"));
		buttonPrint.click();
		Thread.sleep(500);
		

		// Limpa o campo quantidade de button e inseri o valor "8"
		WebElement inputAmount = driver.findElement(By.cssSelector("input[type='number']"));
		inputAmount.clear();
		inputAmount.sendKeys("8");
		

		//driver.findElement(By.xpath("//*[@id=\"printModal\"]/div/div/div[2]/div/div/div[3]/button")).click();
		
		
		//// Verifica se o botão "Imprimir" existe e clica;
		WebElement buttonPrint2 = driver.findElement(By.xpath("//*[@id=\"printModal\"]/div/div/div[2]/div/div/div[3]/button"));
		assertNotNull(buttonPrint2);
		buttonPrint2.click();
		

		//http://www.buttonline.com.br/data/buttonlinebeta/api/impressao.php
		
	}

}
