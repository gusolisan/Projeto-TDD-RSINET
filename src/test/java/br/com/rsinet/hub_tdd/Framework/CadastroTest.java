package br.com.rsinet.hub_tdd.Framework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModule.CadastroAction;
import br.com.rsinet.hub_tdd.appModule.LoginAction;
import br.com.rsinet.hub_tdd.pageObjects.PaginaDeLogin;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;

public class CadastroTest {

	private static WebDriver driver;

	@BeforeTest
	public void iniciaNavegadorESite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constant.url);
	}

//	@AfterTest
//	public void encerraNavegador() {
//		driver.quit();
//	}

//	 Testes positivos abaixo:

	@Test(priority = 0)
	public void deveCadastrarNovoUsuario() throws InterruptedException {
		CadastroAction.cadastra(driver);
		PaginaPrincipal.botaoConta(driver).click();
		assertTrue(PaginaPrincipal.botaoMyAccount(driver).isDisplayed());
	}

	@Test(priority = 1, enabled = false)
	public void deveLogarUsuarioExistente() {
		LoginAction.loga(driver);
		
	}

	@Test(priority = 2, enabled = false)
	public void deveDeslogarUsuarioExistente() {
		LoginAction.loga(driver);

		PaginaPrincipal.botaoConta(driver).click();

		
	}

//	Testes negativos abaixo:

//	@Test(priority = 1)
//	public void naoDeveCadastrarUsuarioExistente() {
//		CadastroAction.cadastra(driver);
//		boolean usuarioCadastradoELogado = LoginAction.usuario(driver).isDisplayed();
//		assertEquals(usuarioCadastradoELogado, false);
//	}
//
//	@Test(priority = 2)
//	public void naoDeveLogarUsuarioInexistente() {
//		LoginAction.loga(driver);
//		boolean usuarioCadastradoELogado = LoginAction.usuario(driver).isDisplayed();
//		assertEquals(usuarioCadastradoELogado, true);
//	}
}
