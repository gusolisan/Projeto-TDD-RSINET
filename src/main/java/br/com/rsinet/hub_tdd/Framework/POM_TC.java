package br.com.rsinet.hub_tdd.Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.pageObjects.PaginaDeLogin;
import br.com.rsinet.hub_tdd.utility.Constant;

public class POM_TC {

	private static WebDriver driver;

	@BeforeTest
	public void iniciaNavegadorESite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");
	}

	@AfterTest
	public void fechaNavegador() {
		driver.quit();
	}
	
	@Test
	public void deveLogarUsuarioCadastrado() {
		PaginaPrincipal.botaoConta(driver).click();

		PaginaDeLogin.logaUsuario(driver).sendKeys(Constant.usuario);
		PaginaDeLogin.logaSenha(driver).sendKeys(Constant.senha);
		PaginaDeLogin.botaoLogar(driver).click();

		PaginaPrincipal.desloga(driver).click();
	}
	
	@Test
	public void deveCadastrarNovoUsuario() {
		PaginaPrincipal.botaoConta(driver);
		
	}
}
