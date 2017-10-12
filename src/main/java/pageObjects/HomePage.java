package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isValida() {
		return temMensagemDeOla() && temBannerDoSistema();
	}

	private boolean temMensagemDeOla() {

		return driver.getPageSource().contains("Brian");

	}

	private boolean temBannerDoSistema() {
		return driver.findElement(By.cssSelector("a[href*='buttonlinebeta']")) != null;
	}

	public boolean cadastroEfetuadoComSucesso() {

		// Verifica se a mensagem "Seu cadastro foi efetuado com sucesso." aparece.
		String divSucesso = driver.switchTo().alert().getText();
		return divSucesso.contains("Seu cadastro foi efetuado com sucesso.");
	}

 }
