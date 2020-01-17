package br.com.rsinet.hub_tdd.pageObjectFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.utility.Constant;

public class HomePage_POF {

	final WebDriver driver;

	public HomePage_POF(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "hrefUserIcon")
	private WebElement botaoConta;

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement botaoPesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement campoPesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	private WebElement nomeUsuarioLogado;

	@FindBy(how = How.LINK_TEXT, using = "My account")
	private WebElement botaoMyAccount;

	@FindBy(how = How.LINK_TEXT, using = "My orders")
	private WebElement botaoMyOrders;

	@FindBy(how = How.CLASS_NAME, using = "option roboto-medium ng-scope")
	private WebElement botaoDeslogar;

	public void clicaEmBotaoConta() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoConta)).click();
	}

	public void pesquisarProduto(String produto) {
		botaoPesquisa.click();
		campoPesquisa.sendKeys(produto);
		campoPesquisa.sendKeys(Keys.ENTER);
	}

	public void myAccount() {
		botaoMyAccount.click();
	}

	public void myOrders() {
		botaoMyOrders.click();
	}

	public void deslogar() {
		botaoDeslogar.click();
	}

	public boolean nomeUsuarioLogadoApareceNaTela() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(nomeUsuarioLogado, Constant.usuario()));
			return nomeUsuarioLogado.isDisplayed();
		} catch (Exception e) {
			return nomeUsuarioLogado.isDisplayed();
		}
	}

	public String nomeUsuarioLogado() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(nomeUsuarioLogado, Constant.usuario()));
			return nomeUsuarioLogado.getText();
		} catch (Exception e) {
			return nomeUsuarioLogado.getText();
		}
	}

}
