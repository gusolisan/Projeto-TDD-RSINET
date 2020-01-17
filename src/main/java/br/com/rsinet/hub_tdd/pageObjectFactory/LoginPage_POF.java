package br.com.rsinet.hub_tdd.pageObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage_POF {

	final WebDriver driver;

	public LoginPage_POF(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "username")
	private WebElement nomeDeUsuario;

	@FindBy(how = How.NAME, using = "password")
	private WebElement senhaDoUsuario;

	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	private WebElement botaoLogar;

	public void insereUsuario(String usuario) {
		nomeDeUsuario.sendKeys(usuario);
	}

	public void insereSenha(String senha) {
		senhaDoUsuario.sendKeys(senha);
	}

	public void clicaEmBotaoLogar() {
		botaoLogar.click();
	}
}
