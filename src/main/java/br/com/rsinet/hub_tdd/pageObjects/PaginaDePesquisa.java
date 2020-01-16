package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.hub_tdd.utility.Constant;

public class PaginaDePesquisa {

	private static WebElement element;
	
	public static WebElement produto(WebDriver driver) throws Exception {
		element = driver.findElement(By.partialLinkText(Constant.produtoEsperado()));
		return element;
	}
}
