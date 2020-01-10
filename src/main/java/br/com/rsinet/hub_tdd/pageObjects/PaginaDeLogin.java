package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaDeLogin {

	private static WebElement element;

	public static WebElement logaUsuario(WebDriver driver) {
		element = driver.findElement(By.name("username"));
		return element;
	}

	public static WebElement logaSenha(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}

	public static WebElement botaoLogar(WebDriver driver) {
		element = driver.findElement(By.id("sign_in_btnundefined"));
		return element;
	}

}
