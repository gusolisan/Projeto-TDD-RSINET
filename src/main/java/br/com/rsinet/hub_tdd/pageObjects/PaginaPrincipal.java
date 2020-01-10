package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaPrincipal {

	private static WebElement element;

	public static WebElement botaoConta(WebDriver driver) {
		element = driver.findElement(By.id("menuUser"));
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

	public static WebElement desloga(WebDriver driver) {
		element = driver.findElement(By.className("option roboto-medium ng-scope"));
		return element;
	}
}
