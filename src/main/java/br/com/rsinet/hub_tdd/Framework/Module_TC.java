package br.com.rsinet.hub_tdd.Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModule.AcaoLogar;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;

public class Module_TC {

	private static WebDriver driver;

	@BeforeTest
	public void iniciaNavegadorESite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constant.url);
	}

	@AfterTest
	public void fechaNavegador() {
		driver.quit();
	}
	
	@Test
	public void deveLogarUsuarioCadastrado() {
		AcaoLogar.loga(driver);
//		Inserir assertEquals aqui.
	}
	
	@Test
	public void deveCadastrarNovoUsuario() {
		PaginaPrincipal.botaoConta(driver);
//		Inserir assertEquals aqui.
	}
}
