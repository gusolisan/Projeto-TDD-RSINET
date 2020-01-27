package br.com.rsinet.hub_tdd.Test;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_tdd.pageObjectFactory.ProductPage_POF;
import br.com.rsinet.hub_tdd.utility.DriverFactory;
import br.com.rsinet.hub_tdd.utility.ExcelUtils;
import br.com.rsinet.hub_tdd.utility.MassaDeDados;
import br.com.rsinet.hub_tdd.utility.Screenshot;

public class CenarioBuscaProdutoPelaTela {

	private static Logger log = Logger.getLogger("ConfigInicial");
	private static Logger print = Logger.getLogger("PrintScreen");

	WebDriver driver;
	String printPath;

	HomePage_POF HomePage;
	ProductPage_POF ProductPage;

	@BeforeMethod
	public void iniciaConfiguracoes() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		log.info("Configuracoes iniciais em andamento");

		driver = DriverFactory.driverInit();
		log.info("Driver fabricado");

		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		log.info("HomePageFactory inicializada");

		ProductPage = PageFactory.initElements(driver, ProductPage_POF.class);
		log.info("ProductPageFactory inicializada");

		printPath = "C:\\Users\\g.santos\\eclipse-workspace\\ProjetoTDD\\target\\Screenshots";
		log.info("Caminho para envio das capturas de tela definido");
		
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
	public void deveEncontrarProdutoRespectivoAoExibido() throws Exception {
		String nomeDoProdutoSelecionado = HomePage.getNomeDoTerceiroProduto();

		HomePage.clicaNoTerceiroProdutoPopular();
		
		Screenshot.printScreen(driver, "ProdutoRespectivo", MassaDeDados.getPrintPath());

		String nomeDoProdutoCarregado = ProductPage.getNomeDoProduto();

		Assert.assertEquals(nomeDoProdutoSelecionado, nomeDoProdutoCarregado);
	}

	@Test(priority = 1)
	public void naoDeveEncontrarProdutoRespectivoAoExibido() throws Exception {
		String nomeDoProdutoSelecionado = HomePage.getNomeDoSegundoProduto();
		
		HomePage.clicaNoSegundoProdutoPopular();
		
		Screenshot.printScreen(driver, "ProdutoNaoRespectivo", MassaDeDados.getPrintPath());
		
		String nomeDoProdutoCarregado = ProductPage.getNomeDoProduto();
		
		Assert.assertNotEquals(nomeDoProdutoSelecionado, nomeDoProdutoCarregado);
	}
}