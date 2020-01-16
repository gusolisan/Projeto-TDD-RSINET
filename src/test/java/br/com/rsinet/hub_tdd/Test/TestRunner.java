package br.com.rsinet.hub_tdd.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appModule.Cadastro_Action;
import br.com.rsinet.hub_tdd.appModule.Login_Action;
import br.com.rsinet.hub_tdd.pageObjects.PaginaDeCadastro;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;
import br.com.rsinet.hub_tdd.utility.Screenshot;

public class TestRunner {

	private static WebDriver driver;
	private static Logger log = Logger.getLogger("Configuracao");
	private static Logger cadastro = Logger.getLogger("NovoUsuario");
	private static Logger login = Logger.getLogger("LoginUsuario");

	@BeforeMethod
	public void iniciaConfiguracoes() throws Exception {
		DOMConfigurator.configure("log4j.xml");

		driver = new ChromeDriver();
		log.info("Inicializado o driver do navegador Google Chrome");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Inicializado comando de espera ImplicityWait");

		driver.get(Constant.url);
		log.info("Navegador inicializado com o site https://www.advantageonlineshopping.com/#/");

		driver.manage().window().maximize();
		log.info("Navegador maximizado");

		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, "cadastro");
		log.info("Massa de dados inicializada");
	}

	@AfterMethod
	public void encerraConfiguracoes() {
		driver.quit();
		log.info("Navegador fechado");
	}

	@Test(priority = 0, testName = "CadastrarNovoUsuario", suiteName = "Cenario de Cadastro")
	public void deveCadastrarNovoUsuario() throws Exception {
		Reporter.log("Aplicação Web inicializada | ");

		Cadastro_Action.preenchimentoDeFormulario(driver);
		Reporter.log("Formulário de cadastro preenchido | ");

		PaginaDeCadastro.botaoRegistrar(driver).click();

		Reporter.log("Cadastro validado e concluido com sucesso | ");

		assertEquals(true, PaginaPrincipal.nomeUsuarioLogado(driver).isDisplayed());

		Screenshot.printScreen("CadastroComSucesso", driver);

		Reporter.log("Aplicação Web Finalizada");
	}

	@Test(priority = 1, testName = "LogarUsuarioExistente", suiteName = "Cenario de Cadastro")
	public void deveLogarUsuarioExistente() throws Exception {
		Reporter.log("Aplicação Web iniciada | ");

		Login_Action.loga(driver);
		login.info("Usuario logado");

		Reporter.log("Login realizado com sucesso | ");

		assertEquals(true, PaginaPrincipal.nomeUsuarioLogado(driver).isDisplayed());

		Screenshot.printScreen("UsuarioLogado", driver);

		Reporter.log("Aplicação web e navegador fechados");
	}

	@Test(priority = 2, testName = "CadastrarUsuarioExistente", suiteName = "Cenario de Cadastro")
	public void naoDeveCadastrarUsuarioExistente() throws Exception {
		Reporter.log("Aplicação Web inicializada | ");

		Cadastro_Action.preenchimentoDeFormulario(driver);
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
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

		Screenshot.printScreen("CadastroNaoRealizado", driver);

		Reporter.log("Aplicação Web Finalizada");
	}

}
