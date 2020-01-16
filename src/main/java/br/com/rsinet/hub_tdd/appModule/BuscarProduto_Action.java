package br.com.rsinet.hub_tdd.appModule;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;

public class BuscarProduto_Action {

	public static void busca(WebDriver driver) throws Exception {
		PaginaPrincipal.botaoPesquisa(driver).click();
		
		PaginaPrincipal.campoPesquisa(driver).sendKeys("chrome");
		PaginaPrincipal.botaoPesquisa(driver).click();
	}
}
