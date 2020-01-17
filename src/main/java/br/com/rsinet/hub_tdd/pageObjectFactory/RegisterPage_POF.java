package br.com.rsinet.hub_tdd.pageObjectFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage_POF {

	final WebDriver driver;

	public RegisterPage_POF(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement botaoCriarConta;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement usuario;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement email;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement senha;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement confirmarSenha;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement nome;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement sobrenome;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement telefone;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private WebElement nacionalidade;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement cidade;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement endereco;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement estado;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement cep;

	@FindBy(how = How.NAME, using = "allowOffersPromotion")
	private WebElement botaoPromocoes;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement botaoTermos;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement botaoRegistrar;

	public void clicaEmBotaoCriarConta() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoCriarConta)).sendKeys(Keys.ENTER);
	}

	public void insereUsername(String username) throws Exception {
		usuario.sendKeys(username);
		;
	}

	public void insereEmail(String emailDoUsuario) throws Exception {
		email.sendKeys(emailDoUsuario);
	}

	public void insereSenha(String senhaDoUsuario) {
		senha.sendKeys(senhaDoUsuario);
	}

	public void confirmaSenha(String senhaDoUsuario) {
		confirmarSenha.sendKeys(senhaDoUsuario);
	}

	public void insereNomeDoUsuario(String nomeDoUsuario) {
		nome.sendKeys(nomeDoUsuario);
	}

	public void insereSobrenomeDoUsuario(String sobrenomeDoUsuario) {
		sobrenome.sendKeys(sobrenomeDoUsuario);
	}

	public void insereTelefone(String telefoneDoUsuario) {
		telefone.sendKeys(telefoneDoUsuario);
	}

	public void insereNacionalidade(String nacionalidadeDoUsuario) {
		Select select = new Select(nacionalidade);
		select.selectByVisibleText(nacionalidadeDoUsuario);
	}

	public void insereCidade(String cidadeDoUsuario) {
		cidade.sendKeys(cidadeDoUsuario);
	}

	public void insereEndereco(String enderecoDoUsuario) {
		endereco.sendKeys(enderecoDoUsuario);
	}

	public void insereEstado(String estadoDoUsuario) {
		estado.sendKeys(estadoDoUsuario);
	}

	public void insereCEP(String cepDoUsuario) {
		cep.sendKeys(cepDoUsuario);
	}

	public void clicaNoBotaoPromocoes() {
		botaoPromocoes.click();
	}

	public void clicaNoBotaoTermos() {
		if (botaoTermos.isSelected() == false) {
			botaoTermos.click();
		}
	}

	public void clicaNoBotaoRegistrar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoRegistrar)).click();
	}
}
