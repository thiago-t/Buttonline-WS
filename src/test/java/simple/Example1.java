package simple;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/teste/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.navigate().to("http://www.buttonline.com.br/data/mx_login.php");
		//String title = driver.getTitle();
		Thread.sleep(500);
		driver.quit();
	}

}
