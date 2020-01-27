package br.com.rsinet.hub_tdd.pageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.utility.MassaDeDados;

public class SearchPage_POF {

	private WebDriver driver;

	public SearchPage_POF(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div")
	private WebElement fecharPesquisa;

	@FindBy(how = How.ID, using = "searchResultLabel")
	private WebElement resultadoDaPesquisa;

	public boolean validaPresencaDoProdutoInexistente() {
		return resultadoDaPesquisa.isDisplayed();
	}

	public boolean validaPresencaDoProdutoExistente() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(MassaDeDados.produtoExistente())))
				.isDisplayed();
	}
}
