package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.utility.Constant;

public class PaginaPrincipal {

	private static WebElement element;

	public static WebElement botaoConta(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefUserIcon")));
		return element;
	}

	public static WebElement botaoPesquisa(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}
	
	public static WebElement limparPesquisa(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search\"]/div/div")));
		return element;
	}

	public static WebElement campoPesquisa(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("autoComplete")));
		return element;
	}

//	Página com usuario logado:

	public static WebElement nomeUsuarioLogado(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(Constant.usuario())));
		return element;
	}

	public static WebElement botaoMyAccount(WebDriver driver) {
		element = driver.findElement(By.linkText("My account"));
		return element;
	}

	public static WebElement botaoMyOrders(WebDriver driver) {
		element = driver.findElement(By.linkText("My orders"));
		return element;
	}

	public static WebElement botaoDeslogar(WebDriver driver) {
		element = driver.findElement(By.className("option roboto-medium ng-scope"));
		return element;
	}
}
