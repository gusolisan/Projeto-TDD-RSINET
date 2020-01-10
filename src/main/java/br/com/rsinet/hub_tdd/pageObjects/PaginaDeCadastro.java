package br.com.rsinet.hub_tdd.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PaginaDeCadastro {

	private static WebElement element;

	public static WebElement nomeUsuario(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		return element;
	}
	
	public static WebElement definirEmail(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		return element;
	}
	
	public static WebElement definirSenha(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		return element;
	}
	
	public static WebElement confirmarSenha(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		return element;
	}
	
	public static WebElement primeiroNome(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		return element;
	}
	
	public static WebElement ultimoNome(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		return element;
	}
	
	public static WebElement telefone(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}
	
	public static Select nacionalidade(WebDriver driver) {
		element = driver.findElement(By.name("countryListboxRegisterPage"));
		Select select = new Select(element);
		return select;
	}
	
	public static WebElement definirCidade(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		return element;
	}
	
	public static WebElement definirEndereço(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		return element;
	}
	
	public static WebElement definirEstado(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return element;
	}
	
	public static WebElement botaoPromocoes(WebDriver driver) {
		element = driver.findElement(By.name("allowOffersPromotion"));
		return element;
	}
	
	public static WebElement botaoConcordad(WebDriver driver) {
		element = driver.findElement(By.name("i_agree"));
		return element;
	}
	
	public static WebElement botaoRegistrar(WebDriver driver) {
		element = driver.findElement(By.name("register_btnundefined"));
		return element;
	}
}
