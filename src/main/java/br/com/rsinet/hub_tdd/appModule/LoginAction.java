package br.com.rsinet.hub_tdd.appModule;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PaginaDeLogin;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;

public class LoginAction {
	
	private static Logger log = Logger.getLogger("LoginAction");
	
	public static void loga(WebDriver driver) {
		PaginaPrincipal.botaoConta(driver).click();
		log.info("Botao da pagina de login clicado");

		PaginaDeLogin.logaUsuario(driver).sendKeys(Constant.usuario);
		log.info("Nome de usuário inserido");
		
		PaginaDeLogin.logaSenha(driver).sendKeys(Constant.senha);
		log.info("Senha inserida");
		
		PaginaDeLogin.botaoLogar(driver).sendKeys(Keys.ENTER);
		log.info("Botao de logar clicado");
	}
}
