package br.com.rsinet.hub_tdd.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaDoProduto {

	private static WebElement element;
	
	public static List<WebElement> cores(WebDriver driver) {
		List<WebElement> cores = driver.findElements(By.id("bunny"));
		return cores;
	}
	
	public static WebElement quantidade(WebDriver driver) {
		element = driver.findElement(By.name("quantity"));
		return element;
	}
	
	public static WebElement adicionarAoCarrinho(WebDriver driver) {
		element = driver.findElement(By.name("save_to_cart"));
		return element;
	}
}
