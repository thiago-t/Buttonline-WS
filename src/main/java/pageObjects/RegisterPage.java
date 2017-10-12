package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	private WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPage visita(String url) {
		driver.get(url);
		return this;
	}

	public RegisterPage autentica(String email, String senha, String conf, String nome, String profissao) {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("senha")).sendKeys(senha);
		driver.findElement(By.name("senha_conf")).sendKeys(conf);
		driver.findElement(By.name("nome")).sendKeys(nome);
		driver.findElement(By.name("profissao")).sendKeys(profissao);

		driver.findElement(By.cssSelector("input[value='Enviar'")).click();

		return new RegisterPage(driver);

	}

	public HomePage aceitarAlert() {

		driver.switchTo().alert().accept();
		return new HomePage(driver);
	}

}