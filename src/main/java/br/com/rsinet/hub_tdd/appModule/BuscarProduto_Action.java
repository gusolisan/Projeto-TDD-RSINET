//package br.com.rsinet.hub_tdd.appModule;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//
//import br.com.rsinet.hub_tdd.pageObjectFactory.HomePage_POF;
//import br.com.rsinet.hub_tdd.pageObjectFactory.PaginaDePesquisa;
//import br.com.rsinet.hub_tdd.utility.Constant;
//
//public class BuscarProduto_Action {
//
//	public static void buscaProdutoExistente(WebDriver driver) throws Exception {
//		HomePage_POF.botaoPesquisa(driver).click();
//
//		HomePage_POF.campoPesquisa(driver).sendKeys(Constant.produtoExistente());
//		HomePage_POF.campoPesquisa(driver).sendKeys(Keys.ENTER);
//	}
//
//	public static void buscaProdutoNaoExistente(WebDriver driver) throws Exception {
//		HomePage_POF.botaoPesquisa(driver).click();
//
//		HomePage_POF.campoPesquisa(driver).sendKeys(Constant.produtoNaoExistente());
//		HomePage_POF.campoPesquisa(driver).sendKeys(Keys.ENTER);
//	}
//
//	public static boolean produtoExistenteConsta(WebDriver driver) throws Exception {
//		return PaginaDePesquisa.produtoEsperadoExistente(driver).isDisplayed();
//	}
//
//	public static boolean produtoExistenteNaoConsta(WebDriver driver) throws Exception {
//		return PaginaDePesquisa.produtoEsperadoNaoExistente(driver).isDisplayed();
//	}
//}
