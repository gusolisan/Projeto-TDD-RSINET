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

	private static Logger log = Logger.getLogger("Configs");
	private static Logger Pesquisa = Logger.getLogger("Pesquisa de Produto");
	private static Logger print = Logger.getLogger("PrintScreen");

	HomePage_POF HomePage;
	SearchPage_POF SearchPage;

	@BeforeMethod
	public void iniciaConfiguracoes() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		log.info("Configuracoes iniciais em andamento");

		DriverFactory.driverInit();
		log.info("Driver fabricado");

		HomePage = PageFactory.initElements(DriverFactory.driverInit(), HomePage_POF.class);
		log.info("HomePageFactory inicializada");

		SearchPage = PageFactory.initElements(DriverFactory.driverInit(), SearchPage_POF.class);
		log.info("SearchPageFactory inicializada");

		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, "CenariosDeTeste");
		log.info("Massa de dados inicializada");
		log.info("Configuracoes iniciais concluidas");
	}

	@AfterMethod
	public void encerraConfiguracoes() {
		DriverFactory.endDriver();
		log.info("Navegador encerrado");
	}

	@Test
	public void deveMostrarProdutoExistente() throws Exception {
		Reporter.log("Aplicação Web iniciada | ");

		HomePage.pesquisarProduto(Constant.produtoExistente());
		Pesquisa.info("Campo de pesquisa acionado");
		Pesquisa.info("Produto a pesquisar digitado: " + Constant.produtoExistente());
		Pesquisa.info("Pesquisa executada");

		SearchPage.fecharPesquisa();
		Pesquisa.info("Aba pesquisa fechada");

		Screenshot.printScreen(DriverFactory.driverInit(), "ProdutoEncontrado", Constant.getPrintPath());
		print.info("Print da tela efetuado");

		Assert.assertTrue(SearchPage.validaPresencaDoProdutoExistente());

		Reporter.log("Produto pesquisado aparece com sucesso | ");

		Reporter.log("Aplicação Web finalizada");
	}

	@Test
	public void naoDeveMostrarProdutoInexistente() throws Exception {
		Reporter.log("Aplicação Web iniciada | ");

		HomePage.pesquisarProduto(Constant.produtoInexistente());
		Pesquisa.info("Campo de pesquisa acionado");
		Pesquisa.info("Produto a pesquisar digitado: " + Constant.produtoInexistente());
		Pesquisa.info("Pesquisa executada");

		SearchPage.fecharPesquisa();
		Pesquisa.info("Aba pesquisa fechada");

		Screenshot.printScreen(DriverFactory.driverInit(), "ProdutoNaoEncontrado", Constant.getPrintPath());
		print.info("Print da tela efetuado");
		
		Reporter.log("Sem resultados de pesquisa | ");

		Assert.assertFalse(SearchPage.validaPresencaDoProdutoInexistente());

		Reporter.log("Aplicação Web finalizada");
	}
}