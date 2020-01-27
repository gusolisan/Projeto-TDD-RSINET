package br.com.rsinet.hub_tdd.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_tdd.pageObjectFactory.LoginPage_POF;
import br.com.rsinet.hub_tdd.pageObjectFactory.RegisterPage_POF;
import br.com.rsinet.hub_tdd.utility.MassaDeDados;
import br.com.rsinet.hub_tdd.utility.DriverFactory;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;
import br.com.rsinet.hub_tdd.utility.Screenshot;

public class CenarioCadastroTest {

	private static Logger log = Logger.getLogger("ConfigInicial");
	private static Logger cadastro = Logger.getLogger("Cadastro");
	private static Logger login = Logger.getLogger("Login");
	private static Logger print = Logger.getLogger("PrintScreen");

	private WebDriver driver;

	HomePage_POF HomePage;
	LoginPage_POF LoginPage;
	RegisterPage_POF RegisterPage;
	Screenshot capturaDeTela;

	@BeforeMethod
	public void iniciaConfiguracoes() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		log.info("Configuracoes iniciais em andamento");

		driver = DriverFactory.driverInit();
		log.info("Driver fabricado");

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		log.info("HomePageFactory inicializado");

		LoginPage = PageFactory.initElements(driver, LoginPage_POF.class);
		log.info("LoginPageFactory inicializado");

		RegisterPage = PageFactory.initElements(driver, RegisterPage_POF.class);
		log.info("RegisterPageFactory inicializado");

		ExcelUtils.setExcelFile(MassaDeDados.Path_DadosParaTeste, "CenariosDeTeste");
		log.info("Massa de dados inicializada");
		log.info("Configuracoes iniciais concluidas");
	}

	@AfterMethod
	public void encerraConfiguracoes() {
		DriverFactory.endDriver();
		log.info("Navegador encerrado");
	}

	@Test(priority = 0)
	public void deveCadastrarNovoUsuario() throws Exception {
		Reporter.log("Aplicação Web inicializada | ");

		HomePage.clicaEmBotaoConta();
		cadastro.info("Botao conta clicado");

		RegisterPage.clicaEmBotaoCriarConta();
		cadastro.info("Botao criar nova conta clicado");

		RegisterPage.insereUsername(MassaDeDados.usuario());
		cadastro.info("Iniciado o cadastro");
		cadastro.info("Nome de usuario inserido");

		RegisterPage.insereEmail(MassaDeDados.email());
		cadastro.info("Email inserido");

		RegisterPage.insereSenha(MassaDeDados.senha());
		cadastro.info("Senha inserida");

		RegisterPage.confirmaSenha(MassaDeDados.senha());
		cadastro.info("Senha confirmada");

		RegisterPage.insereNomeDoUsuario(MassaDeDados.nome());
		cadastro.info("Nome inserido");

		RegisterPage.insereSobrenomeDoUsuario(MassaDeDados.sobrenome());
		cadastro.info("Sobrenome inserido");

		RegisterPage.insereTelefone(MassaDeDados.telefone());
		cadastro.info("Telefone inserido");

		RegisterPage.insereNacionalidade(MassaDeDados.nacionalidade());
		cadastro.info("Nacionalidade selecionada");

		RegisterPage.insereCidade(MassaDeDados.cidade());
		cadastro.info("Cidade inserida");

		RegisterPage.insereEndereco(MassaDeDados.endereco());
		cadastro.info("Endereco inserido");

		RegisterPage.insereEstado(MassaDeDados.estado());
		cadastro.info("Estado inserido");

		RegisterPage.insereCEP(MassaDeDados.cep());
		cadastro.info("CEP inserido");

		RegisterPage.clicaNoBotaoPromocoes();
		cadastro.info("Botao promocoes clicado");

		RegisterPage.clicaNoBotaoTermos();
		cadastro.info("Botao termos de uso clicado");

		RegisterPage.clicaNoBotaoRegistrar();
		cadastro.info("Botao register clicado");

		Reporter.log("Cadastro realizado com sucesso | ");

		Assert.assertTrue(HomePage.nomeUsuarioLogado().isDisplayed());

		Screenshot.printScreen(driver, "UsuarioCadastrado", MassaDeDados.getPrintPath());
		print.info("Print da tela efetuado");
		Reporter.log("Aplicação Web encerrada");
	}

	@Test(priority = 1)
	public void deveLogarUsuarioExistente() throws Exception {
		Reporter.log("Aplicação Web inicializada | ");

		HomePage.clicaEmBotaoConta();
		login.info("Botao conta clicado");

		LoginPage.insereUsuario(MassaDeDados.usuario());
		login.info("Nome de usuario inserido no campo username");

		LoginPage.insereSenha(MassaDeDados.senha());
		login.info("Senha do usuario inserida no campo password");

		LoginPage.clicaEmBotaoLogar();
		login.info("Botao login clicado");

		Reporter.log("Login realizado com sucesso | ");

		Assert.assertTrue(HomePage.nomeUsuarioLogado().isDisplayed());

		Screenshot.printScreen(driver, "UsuarioLogado", MassaDeDados.getPrintPath());
		print.info("Print da tela efetuado");

		Reporter.log("Aplicação Web encerrada");
	}

	@Test(priority = 2)
	public void naoDeveCadastrarUsuarioExistente() throws Exception {
		Reporter.log("Aplicação Web inicializada | ");

		HomePage.clicaEmBotaoConta();
		cadastro.info("Botao conta clicado");

		RegisterPage.clicaEmBotaoCriarConta();
		cadastro.info("Botao criar nova conta clicado");

		RegisterPage.insereUsername(MassaDeDados.usuario());
		cadastro.info("Iniciado o cadastro");
		cadastro.info("Nome de usuario inserido");

		RegisterPage.insereEmail(MassaDeDados.email());
		cadastro.info("Email inserido");

		RegisterPage.insereSenha(MassaDeDados.senha());
		cadastro.info("Senha inserida");

		RegisterPage.confirmaSenha(MassaDeDados.senha());
		cadastro.info("Senha confirmada");

		RegisterPage.insereNomeDoUsuario(MassaDeDados.nome());
		cadastro.info("Nome inserido");

		RegisterPage.insereSobrenomeDoUsuario(MassaDeDados.sobrenome());
		cadastro.info("Sobrenome inserido");

		RegisterPage.insereTelefone(MassaDeDados.telefone());
		cadastro.info("Telefone inserido");

		RegisterPage.insereNacionalidade(MassaDeDados.nacionalidade());
		cadastro.info("Nacionalidade selecionada");

		RegisterPage.insereCidade(MassaDeDados.cidade());
		cadastro.info("Cidade inserida");

		RegisterPage.insereEndereco(MassaDeDados.endereco());
		cadastro.info("Endereco inserido");

		RegisterPage.insereEstado(MassaDeDados.estado());
		cadastro.info("Estado inserido");

		RegisterPage.insereCEP(MassaDeDados.cep());
		cadastro.info("CEP inserido");

		RegisterPage.clicaNoBotaoPromocoes();
		cadastro.info("Botao promocoes clicado");

		RegisterPage.clicaNoBotaoTermos();
		cadastro.info("Botao termos de uso clicado");

		RegisterPage.clicaNoBotaoRegistrar();
		cadastro.info("Botao register clicado");

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

		Reporter.log("Cadastro não realizado (usuario já existente) | ");

		Assert.assertFalse(HomePage.nomeUsuarioLogadoApareceNaTela());

		Screenshot.printScreen(driver, "UsuarioNaoCadastrado", MassaDeDados.getPrintPath());
		print.info("Print da tela efetuado");

		Reporter.log("Aplicação Web encerrada");
	}
}