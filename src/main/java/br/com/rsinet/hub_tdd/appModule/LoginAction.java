package br.com.rsinet.hub_tdd.appModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.pageObjects.PaginaDeLogin;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;

public class LoginAction {
	
	private static WebElement element;
	
	public static void loga(WebDriver driver) {
		PaginaPrincipal.botaoConta(driver).click();

		PaginaDeLogin.logaUsuario(driver).sendKeys(Constant.usuario);
		PaginaDeLogin.logaSenha(driver).sendKeys(Constant.senha);
		PaginaDeLogin.botaoLogar(driver).click();
	}

//	public static boolean usuarioLogado(WebDriver driver) {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"menuUserLink\"]/span")));
//		boolean elementEnable = wait
//				.until(ExpectedConditions.);
//		return elementEnable;
//	}
}
