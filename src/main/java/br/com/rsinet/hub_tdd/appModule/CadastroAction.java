package br.com.rsinet.hub_tdd.appModule;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;

public class CadastroAction {
	public static void cadastra(WebDriver driver) {
		PaginaPrincipal.botaoConta(driver).click();
		
		
	}
}
