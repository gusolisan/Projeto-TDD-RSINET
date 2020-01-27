package br.com.rsinet.hub_tdd.pageObjectFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.utility.Constant;

public class HomePage_POF {

	private final WebDriver driver;

	public HomePage_POF(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[6]/a")
	private WebElement botaoPopularItems;

	@FindBy(how = How.XPATH, using = "//*[@id=\"popular_items\"]/h3")
	private WebElement pagePopularItems;

	@FindBy(how = How.ID, using = "details_16")
	private WebElement primeiroProdutoPopular;

	@FindBy(how = How.NAME, using = "popular_item_16_name")
	private WebElement nomeDoPrimeiroProduto;

	@FindBy(how = How.ID, using = "details_10")
	private WebElement segundoProdutoPopular;

	@FindBy(how = How.NAME, using = "popular_item_10_name")
	private WebElement nomeDoSegundoProduto;

	@FindBy(how = How.ID, using = "details_21")
	private WebElement terceiroProdutoPopular;

	@FindBy(how = How.NAME, using = "popular_item_21_name")
	private WebElement nomeDoTerceiroProduto;

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

	public void clicaProdutosPopulares() {
		botaoPopularItems.click();
	}

	public void clicaNoPrimeiroProdutoPopular() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(primeiroProdutoPopular));
		primeiroProdutoPopular.click();
	}

	public void clicaNoSegundoProdutoPopular() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(segundoProdutoPopular));
		segundoProdutoPopular.click();
	}

	public void clicaNoTerceiroProdutoPopular() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(terceiroProdutoPopular));
		terceiroProdutoPopular.click();
	}

	public String getNomeDoPrimeiroProduto() {
		return nomeDoPrimeiroProduto.getText();
	}

	public String getNomeDoSegundoProduto() {
		return nomeDoSegundoProduto.getText();
	}

	public String getNomeDoTerceiroProduto() {
		return nomeDoTerceiroProduto.getText();
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

	public void pesquisarProduto(String produto) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoPesquisa)).click();
		wait.until(ExpectedConditions.elementToBeClickable(campoPesquisa)).sendKeys(produto);
		campoPesquisa.sendKeys(Keys.ENTER);
	}

	public boolean nomeUsuarioLogadoApareceNaTela() throws Exception {
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		return nomeUsuarioLogado.isDisplayed();
	}

	public WebElement nomeUsuarioLogado() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(nomeUsuarioLogado, Constant.usuario()));
			return nomeUsuarioLogado;
		} catch (Exception e) {
			return nomeUsuarioLogado;
		}
	}
}