package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaPrincipal {

	private static WebElement element;

	public static WebElement botaoConta(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser")));
		return element;
	}

	public static WebElement Pesquisa(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}

	public static WebElement campoPesquisa(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}

	public static WebElement botaoDeslogar(WebDriver driver) {
		element = driver.findElement(By.className("option roboto-medium ng-scope"));
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
}
