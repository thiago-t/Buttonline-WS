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
	 
	 public boolean isLoginPage() {
		 
		return temFormularioLogin() && temTituloLogin();
		
		
		}
	 
	 public boolean temFormularioLogin() {
		 
			return driver.findElements(By.xpath("/html/body/div[5]/div/div[3]")) != null;
			
			
			}
	 
	 private boolean temTituloLogin() {
		 
		   return driver.findElement(By.className(" pf_titulos_login")).
				   getText().contains("Login");
	}
}