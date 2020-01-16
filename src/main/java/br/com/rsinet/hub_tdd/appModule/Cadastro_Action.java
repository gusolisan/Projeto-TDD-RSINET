package br.com.rsinet.hub_tdd.appModule;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.pageObjects.PaginaDeCadastro;
import br.com.rsinet.hub_tdd.pageObjects.PaginaPrincipal;
import br.com.rsinet.hub_tdd.utility.Constant;

public class Cadastro_Action {

	private static Logger log = Logger.getLogger("CadastroAction");

	public static void preenchimentoDeFormulario(WebDriver driver) throws Exception {
		PaginaPrincipal.botaoConta(driver).click();
		log.info("Botao da pagina de login clicado");

		PaginaDeCadastro.botaoCriarConta(driver).sendKeys(Keys.ENTER);
		log.info("Botao criar nova conta clicado, navegador redirecionado para a pagina de cadastro");

		PaginaDeCadastro.nomeUsuario(driver).sendKeys(Constant.usuario());
		log.info("Preenchendo formulario de cadastro:");
		log.info("Nome de usuario inserido");

		PaginaDeCadastro.definirEmail(driver).sendKeys(Constant.email());
		log.info("E-mail inserido");

		PaginaDeCadastro.definirSenha(driver).sendKeys(Constant.senha());
		log.info("Senha criada e inserida");

		PaginaDeCadastro.confirmarSenha(driver).sendKeys(Constant.senha());
		log.info("Confirmada a senha");

		PaginaDeCadastro.primeiroNome(driver).sendKeys(Constant.nome());
		log.info("Primeiro nome inserido");

		PaginaDeCadastro.ultimoNome(driver).sendKeys(Constant.sobrenome());
		log.info("Sobrenome inserido");

		PaginaDeCadastro.telefone(driver).sendKeys(Constant.telefone());
		log.info("Numero de telefone inserido");

		PaginaDeCadastro.nacionalidade(driver).selectByVisibleText(Constant.nacionalidade());
		log.info("País local selecionado");

		PaginaDeCadastro.definirCidade(driver).sendKeys(Constant.cidade());
		log.info("Nome da cidade inserido");

		PaginaDeCadastro.definirEndereço(driver).sendKeys(Constant.endereco());
		log.info("Endereço inserido");

		PaginaDeCadastro.definirEstado(driver).sendKeys(Constant.estado());
		log.info("Estado inserido");

		PaginaDeCadastro.definirCep(driver).sendKeys(Constant.cep());
		log.info("CEP inserido");
		
		if (PaginaDeCadastro.botaoPromocoes(driver).isSelected()) {
			PaginaDeCadastro.botaoPromocoes(driver).click();
			log.info("Botao receber novas promoções deselecionado");
		}

		if (PaginaDeCadastro.botaoConcordar(driver).isSelected() == false) {
			PaginaDeCadastro.botaoConcordar(driver).click();
			log.info("Botao concordar com os termos selecionado");
		}
	}
}