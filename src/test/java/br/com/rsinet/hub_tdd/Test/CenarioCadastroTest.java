package br.com.rsinet.hub_tdd.Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_tdd.pageObjectFactory.LoginPage_POF;
import br.com.rsinet.hub_tdd.pageObjectFactory.RegisterPage_POF;
import br.com.rsinet.hub_tdd.utility.Constant;
import br.com.rsinet.hub_tdd.utility.DriverFactory;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;

public class CenarioCadastroTest {

	private static WebDriver driver;
	private static Logger log = Logger.getLogger("Config");
	private static Logger cadastro = Logger.getLogger("Cadastro");
	private static Logger login = Logger.getLogger("Login");

	HomePage_POF HomePage;
	LoginPage_POF LoginPage;
	RegisterPage_POF RegisterPage;

	@BeforeMethod
	public void iniciaConfiguracoes() throws Exception {
		driver = DriverFactory.getDriver();
		log.info("Driver inicializado");

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		log.info("HomePageFactory inicializado");

		LoginPage = PageFactory.initElements(driver, LoginPage_POF.class);
		log.info("LoginPageFactory inicializado");

		RegisterPage = PageFactory.initElements(driver, RegisterPage_POF.class);
		log.info("RegisterPageFactory inicializado");

		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, "CenariosDeTeste");
		log.info("Massa de dados inicializada");
	}

	@AfterMethod
	public void encerraConfiguracoes() {
		DriverFactory.quitDriver(driver);
		log.info("Navegador encerrado");
	}

	@Test(priority = 0, testName = "CadastrarNovoUsuario", suiteName = "Cenario de Cadastro")
	public void deveCadastrarNovoUsuario() throws Exception {
		Reporter.log("Aplicação Web inicializada | ");

		HomePage.clicaEmBotaoConta();
		cadastro.info("Botao conta clicado");

		RegisterPage.clicaEmBotaoCriarConta();
		cadastro.info("Botao criar nova conta clicado");

		RegisterPage.insereUsername(Constant.usuario());
		cadastro.info("Iniciado o cadastro");
		cadastro.info("Nome de usuario inserido");

		RegisterPage.insereEmail(Constant.email());
		cadastro.info("Email inserido");

		RegisterPage.insereSenha(Constant.senha());
		cadastro.info("Senha inserida");

		RegisterPage.confirmaSenha(Constant.senha());
		cadastro.info("Senha confirmada");

		RegisterPage.insereNomeDoUsuario(Constant.nome());
		cadastro.info("Nome inserido");

		RegisterPage.insereSobrenomeDoUsuario(Constant.sobrenome());
		cadastro.info("Sobrenome inserido");

		RegisterPage.insereTelefone(Constant.telefone());
		cadastro.info("Telefone inserido");

		RegisterPage.insereNacionalidade(Constant.nacionalidade());
		cadastro.info("Nacionalidade selecionada");

		RegisterPage.insereCidade(Constant.cidade());
		cadastro.info("Cidade inserida");

		RegisterPage.insereEndereco(Constant.endereco());
		cadastro.info("Endereco inserido");

		RegisterPage.insereEstado(Constant.estado());
		cadastro.info("Estado inserido");

		RegisterPage.insereCEP(Constant.cep());
		cadastro.info("CEP inserido");

		RegisterPage.clicaNoBotaoPromocoes();
		cadastro.info("Botao promocoes clicado");

		RegisterPage.clicaNoBotaoTermos();
		cadastro.info("Botao termos de uso clicado");

		RegisterPage.clicaNoBotaoRegistrar();
		cadastro.info("Botao register clicado");
		cadastro.info("cadastro finalizado");

		Reporter.log("Cadastro realizado com sucesso | ");

		Assert.assertEquals(LoginPage.getNomeDeUsuario(), Constant.usuario());

		Reporter.log("Aplicação Web encerrada");
	}

	@Test(priority = 1, testName = "LogarUsuarioExistente", suiteName = "Cenario de Cadastro")
	public void deveLogarUsuarioExistente() throws Exception {
		Reporter.log("Aplicação Web inicializada | ");

		HomePage.clicaEmBotaoConta();
		login.info("Botao conta clicado");

		LoginPage.insereUsuario(Constant.usuario());
		login.info("Nome de usuario inserido no campo username");
		
		LoginPage.insereSenha(Constant.senha());
		login.info("Senha do usuario inserida no campo password");
		
		LoginPage.clicaEmBotaoLogar();
		login.info("Botao login clicado");
		
		Reporter.log("Login realizado com sucesso | ");
		
		Assert.assertTrue(LoginPage.getNomeDeUsuario().isDisplayed());
		
		Reporter.log("Aplicação Web encerrada");
	}

	@Test(priority = 2, testName = "CadastrarUsuarioExistente", suiteName = "Cenario de Cadastro")
	public void naoDeveCadastrarUsuarioExistente() throws Exception {
		Reporter.log("Aplicação Web inicializada | ");

		HomePage.clicaEmBotaoConta();
		cadastro.info("Botao conta clicado");

		RegisterPage.clicaEmBotaoCriarConta();
		cadastro.info("Botao criar nova conta clicado");

		RegisterPage.insereUsername(Constant.usuario());
		cadastro.info("Iniciado o cadastro");
		cadastro.info("Nome de usuario inserido");

		RegisterPage.insereEmail(Constant.email());
		cadastro.info("Email inserido");

		RegisterPage.insereSenha(Constant.senha());
		cadastro.info("Senha inserida");

		RegisterPage.confirmaSenha(Constant.senha());
		cadastro.info("Senha confirmada");

		RegisterPage.insereNomeDoUsuario(Constant.nome());
		cadastro.info("Nome inserido");

		RegisterPage.insereSobrenomeDoUsuario(Constant.sobrenome());
		cadastro.info("Sobrenome inserido");

		RegisterPage.insereTelefone(Constant.telefone());
		cadastro.info("Telefone inserido");

		RegisterPage.insereNacionalidade(Constant.nacionalidade());
		cadastro.info("Nacionalidade selecionada");

		RegisterPage.insereCidade(Constant.cidade());
		cadastro.info("Cidade inserida");

		RegisterPage.insereEndereco(Constant.endereco());
		cadastro.info("Endereco inserido");

		RegisterPage.insereEstado(Constant.estado());
		cadastro.info("Estado inserido");

		RegisterPage.insereCEP(Constant.cep());
		cadastro.info("CEP inserido");

		RegisterPage.clicaNoBotaoPromocoes();
		cadastro.info("Botao promocoes clicado");

		RegisterPage.clicaNoBotaoTermos();
		cadastro.info("Botao termos de uso clicado");

		RegisterPage.clicaNoBotaoRegistrar();
		cadastro.info("Botao register clicado");
		cadastro.info("cadastro finalizado");

		Reporter.log("Cadastro não realizado (usuario já existente) | ");

		Assert.assertEquals(LoginPage.getNomeDeUsuario(), Constant.usuario());

		Reporter.log("Aplicação Web encerrada");
	}
}
