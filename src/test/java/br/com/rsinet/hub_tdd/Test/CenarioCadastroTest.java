package br.com.rsinet.hub_tdd.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModule.CadastroAction;
import br.com.rsinet.hub_tdd.appModule.LoginAction;
import br.com.rsinet.hub_tdd.pageObjects.PaginaDeCadastro;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;

public class CenarioCadastroTest {

	private static WebDriver driver;
	private static Logger log = Logger.getLogger("CenarioCadastroTest");
	private static Logger cadastro = Logger.getLogger("NovoUsuario");
	private static Logger login = Logger.getLogger("LoginUsuario");

	@BeforeMethod
	public void iniciaNavegadorESite() {
		DOMConfigurator.configure("log4j.xml");

		driver = new ChromeDriver();
		log.info("Inicializado o driver do navegador Google Chrome");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Inicializado comando de espera ImplicityWait");

		driver.get(Constant.url);
		log.info("Navegador inicializado com o site https://www.advantageonlineshopping.com/#/");

		driver.manage().window().maximize();
		log.info("Navegador maximizado");
	}

	@AfterMethod
	public void encerraNavegador() {
		driver.quit();
		log.info("Navegador fechado");
	}

	@Test(priority = 1)
	public void deveCadastrarNovoUsuario() {
		Reporter.log("Aplicação Web inicializada | ");

		CadastroAction.preenchimentoDeFormulario(driver);
		Reporter.log("Formulário de cadastro preenchido | ");

		if (PaginaDeCadastro.botaoPromocoes(driver).isSelected()) {
			PaginaDeCadastro.botaoPromocoes(driver).click();
			cadastro.info("Botao receber novas promoções deselecionado");
		}

		if (PaginaDeCadastro.botaoConcordar(driver).isSelected() == false) {
			PaginaDeCadastro.botaoConcordar(driver).click();
			cadastro.info("Botao concordar com os termos selecionado");
		}
		
		PaginaDeCadastro.botaoRegistrar(driver).click();

		Reporter.log("Cadastro validado e concluido com sucesso | ");

		assertEquals(true, PaginaPrincipal.nomeUsuarioLogado(driver).isDisplayed());

		Reporter.log("Aplicação Web Finalizada");
	}

	@Test(priority = 2)
	public void deveLogarUsuarioExistente() {
		Reporter.log("Aplicação Web iniciada | ");

		LoginAction.loga(driver);
		login.info("Usuario logado");

		Reporter.log("Login realizado com sucesso | ");

		assertEquals(true, PaginaPrincipal.nomeUsuarioLogado(driver).isDisplayed());

		Reporter.log("Aplicação web e navegador fechados");
	}

	@Test(priority = 3)
	public void naoDeveCadastrarUsuarioExistente() {
		Reporter.log("Aplicação Web inicializada | ");

		CadastroAction.preenchimentoDeFormulario(driver);
		Reporter.log("Formulário de cadastro preenchido | ");

		if (PaginaDeCadastro.botaoPromocoes(driver).isSelected()) {
			PaginaDeCadastro.botaoPromocoes(driver).click();
			cadastro.info("Botao receber novas promoções deselecionado");
		}

		if (PaginaDeCadastro.botaoConcordar(driver).isSelected() == false) {
			PaginaDeCadastro.botaoConcordar(driver).click();
			cadastro.info("Botao concordar com os termos selecionado");
		}
		
		PaginaDeCadastro.botaoRegistrar(driver).click();

		Reporter.log("Cadastro invalidado e não sucedido | ");
		
		String urlAtual = driver.getCurrentUrl();

		assertNotEquals(Constant.url, urlAtual);

		Reporter.log("Aplicação Web Finalizada");
	}
}
