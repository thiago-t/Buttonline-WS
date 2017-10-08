package simple;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		// Preenche a Senha com o valor "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("123");

		// Clica no botão Login
		WebElement buttonLogin = driver.findElement(By.cssSelector("input[type='submit'"));
		buttonLogin.click();
		Thread.sleep(500);
		
		//Clica no banner "Experimente o Sistema"
		driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")).click();
		Thread.sleep(500);
		
		WebElement newButton = driver.findElement(By.cssSelector("a[class='ng-binding ng-isolate-scope']"));
		newButton.click();
		Thread.sleep(500);
		
		WebElement button45 = driver.findElement(By.cssSelector("a[href*='editor.php?tamanho=45&formato=redondo']"));
		button45.click();
		Thread.sleep(500);
	
		
	
		
	}

}
