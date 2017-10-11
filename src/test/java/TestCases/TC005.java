package TestCases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC005 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/teste/Desktop/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.buttonline.com.br/data/buttonlinebeta/");

		// Clica no botão Ajuda
		WebElement buttonHelp = driver.findElement(By.cssSelector("a[href*='novo-button']")); //it doesn't work
		Thread.sleep(1000);
		buttonHelp.click();
	}

}
