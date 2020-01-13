package br.com.rsinet.hub_tdd.appModule;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PaginaDeCadastro;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;

public class CadastroAction {
	public static void cadastra(WebDriver driver) {
		PaginaPrincipal.botaoConta(driver).click();

		PaginaDeCadastro.botaoCriarConta(driver).sendKeys(Keys.ENTER);
		PaginaDeCadastro.nomeUsuario(driver).sendKeys(Constant.usuario);
		PaginaDeCadastro.definirEmail(driver).sendKeys(Constant.email);
		PaginaDeCadastro.definirSenha(driver).sendKeys(Constant.senha);
		PaginaDeCadastro.confirmarSenha(driver).sendKeys(Constant.senha);
		PaginaDeCadastro.primeiroNome(driver).sendKeys(Constant.primeiroNome);
		PaginaDeCadastro.ultimoNome(driver).sendKeys(Constant.ultimoNome);
		PaginaDeCadastro.telefone(driver).sendKeys(Constant.telefone);
		PaginaDeCadastro.nacionalidade(driver).selectByVisibleText(Constant.nacionalidade);
		PaginaDeCadastro.definirCidade(driver).sendKeys(Constant.cidade);
		PaginaDeCadastro.definirEndereço(driver).sendKeys(Constant.endereco);
		PaginaDeCadastro.definirEstado(driver).sendKeys(Constant.estado);
		PaginaDeCadastro.definirCep(driver).sendKeys(Constant.cep);

		if (PaginaDeCadastro.botaoPromocoes(driver).isSelected()) {
			PaginaDeCadastro.botaoPromocoes(driver).click();
		}

		if (PaginaDeCadastro.botaoConcordar(driver).isSelected() == false) {
			PaginaDeCadastro.botaoConcordar(driver).click();
		}

		PaginaDeCadastro.botaoRegistrar(driver).click();
	}
	
	
}