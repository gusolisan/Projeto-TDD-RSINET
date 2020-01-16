package br.com.rsinet.hub_tdd.Test;

import static org.testng.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModule.BuscarProduto_Action;
import br.com.rsinet.hub_tdd.utility.Constant;

public class TestCenario2 {

	@Test
	public void buscaDeProduto() throws Exception {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get(Constant.url);
		
		BuscarProduto_Action.busca(driver);
		
		assertFalse(driver.findElement(By.className("ng-binding")).isDisplayed());
	}
}
