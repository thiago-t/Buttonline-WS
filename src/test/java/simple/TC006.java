package simple;

//import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

//import org.hamcrest.MatcherAssert;
//import org.hamcrest.Matchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC006 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://buttonline.com.br/data/mx_cadastro.php");
		driver.manage().window().maximize();
		// Fill the e-mail field with "brian.roller@hotmail.com"
		WebElement inputEmail = driver.findElement(By.name("email"));
		inputEmail.sendKeys("brian.roller@hotmail.com");
        Thread.sleep(5000); 
        
        // Fill the password field with "123"
		WebElement inputSenha = driver.findElement(By.name("senha"));
		inputSenha.sendKeys("123");
		Thread.sleep(3000);
       
		// Verify if the system returns the error message.
		String expected = "E-mail ja cadastrado !";
		String actual = driver.switchTo().alert().getText();
					
			assertEquals(expected, actual);
		
			Thread.sleep(5000);
		driver.quit();
	}
}