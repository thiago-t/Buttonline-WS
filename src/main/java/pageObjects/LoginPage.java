package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 
	 private WebDriver driver;
	 
	 public LoginPage(WebDriver driver) {
	   this.driver = driver;
	 }
	 
	 public LoginPage visita(String url) {
	   driver.get(url);
	   return this;
	 }
	 
	 public HomePage autentica(String usuario, String senha) {
	   driver.findElement(By.name("email")).sendKeys(usuario);
	   driver.findElement(By.name("senha")).sendKeys(senha);
	   driver.findElement(By.cssSelector("input[type='submit'")).click();
	 
	   return new HomePage(driver);
	 }
	 
	}