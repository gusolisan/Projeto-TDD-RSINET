package br.com.rsinet.hub_tdd.appModule;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PaginaDeLogin;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;

public class AcaoLogar {
	public static void loga(WebDriver driver) {
		PaginaPrincipal.botaoConta(driver).click();
		
		PaginaDeLogin.logaUsuario(driver).sendKeys(Constant.usuario);
		PaginaDeLogin.logaSenha(driver).sendKeys(Constant.senha);
		PaginaDeLogin.botaoLogar(driver).click();
	}
}
