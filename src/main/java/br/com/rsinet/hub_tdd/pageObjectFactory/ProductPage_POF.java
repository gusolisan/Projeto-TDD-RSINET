package br.com.rsinet.hub_tdd.pageObjectFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage_POF {

	private final WebDriver driver;
	private static Logger log = Logger.getLogger("HomePage Actions");

	public ProductPage_POF(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	private WebElement nomeDoProduto;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement adicionarAoCarrinho;

	@FindBy(how = How.NAME, using = "quantity")
	private WebElement quantidadeDeProdutos;

	public String getNomeDoProduto() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(nomeDoProduto)).getText();
	}

	public void adicionaNoCarrinho() {
		adicionarAoCarrinho.click();
	}

	public void insereQtdDeProdutos(String quantidade) {
		quantidadeDeProdutos.sendKeys(quantidade);
	}
}
