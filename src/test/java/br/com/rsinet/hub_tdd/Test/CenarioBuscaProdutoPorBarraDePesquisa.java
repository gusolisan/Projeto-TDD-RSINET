package br.com.rsinet.hub_tdd.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_tdd.pageObjectFactory.SearchPage_POF;
import br.com.rsinet.hub_tdd.utility.Constant;
import br.com.rsinet.hub_tdd.utility.DriverFactory;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;
import br.com.rsinet.hub_tdd.utility.Screenshot;

public class CenarioBuscaProdutoPorBarraDePesquisa {
	private static Logger log = Logger.getLogger("ConfigInicial");
	private static Logger print = Logger.getLogger("PrintScreen");

	WebDriver driver;

	HomePage_POF HomePage;
	SearchPage_POF SearchPage;

	@BeforeMethod
	public void iniciaConfiguracoes() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		log.info("Configuracoes iniciais em andamento");

		driver = DriverFactory.driverInit();
		log.info("Driver fabricado");

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		log.info("HomePageFactory inicializada");

		SearchPage = PageFactory.initElements(driver, SearchPage_POF.class);
		log.info("SearchPageFactory inicializada");

		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, "CenariosDeTeste");
		log.info("Massa de dados inicializada");
		log.info("Configuracoes iniciais concluidas");
	}

	@AfterMethod
	public void encerraConfiguracoes() {
		DriverFactory.driverQuit();
		log.info("Navegador encerrado");
	}

	@Test
	public void deveMostrarProdutoExistente() throws Exception {
		Reporter.log("Aplicação Web iniciada | ");

		HomePage.pesquisarProduto(Constant.produtoExistente());

		Screenshot.printScreen(driver, "ProdutoEncontrado",
				"C:\\Users\\g.santos\\eclipse-workspace\\ProjetoTDD\\src\\main\\java\\br\\com\\rsinet\\hub_tdd\\screenshotsDosTestes\\Cenario de Busca de Produto\\");
		print.info("Print da tela efetuado");

		Assert.assertTrue(SearchPage.validaPresencaDoProdutoExistente());

		Reporter.log("Produto pesquisado aparece com sucesso | ");

		Reporter.log("Aplicação Web finalizada");
	}

	@Test
	public void naoDeveMostrarProdutoInexistente() throws Exception {
		Reporter.log("Aplicação Web iniciada | ");

		HomePage.pesquisarProduto(Constant.produtoInexistente());

		Screenshot.printScreen(driver, "ProdutoNaoEncontrado",
				"C:\\Users\\g.santos\\eclipse-workspace\\ProjetoTDD\\src\\main\\java\\br\\com\\rsinet\\hub_tdd\\screenshotsDosTestes\\Cenario de Busca de Produto\\");
		print.info("Print da tela efetuado");

		Assert.assertFalse(SearchPage.validaPresencaDoProdutoInexistente());

		Reporter.log("Sem resultados de pesquisa | ");

		Reporter.log("Aplicação Web finalizada");
	}
}