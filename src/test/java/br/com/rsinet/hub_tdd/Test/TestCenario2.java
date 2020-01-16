//package br.com.rsinet.hub_tdd.Test;
//
//import static org.testng.Assert.assertTrue;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import br.com.rsinet.hub_tdd.appModule.BuscarProduto_Action;
//import br.com.rsinet.hub_tdd.utility.Constant;
//
//public class TestCenario2 {
//
//	@Test
//	public void deveEncontrarProdutoExistente() throws Exception {
//		WebDriver driver = new ChromeDriver();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(Constant.url);
//		
//		BuscarProduto_Action.buscaProdutoExistente(driver);
//		
//		assertTrue(BuscarProduto_Action.produtoExistenteConsta(driver));
//	}
//
//	@Test
//	public void naoDeveEncontrarProdutoNaoExistente() throws Exception {
//		WebDriver driver = new ChromeDriver();
//
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(Constant.url);
//
//		BuscarProduto_Action.buscaProdutoNaoExistente(driver);
//
//		assertTrue(BuscarProduto_Action.produtoExistenteNaoConsta(driver));
//	}
//}
