# ProjetoTDD
Testes no site de loja usando TDD

  Pasta src/main/java
  
    pacote br.com.rsinet.hub_bdd.dadosParaTeste
      DadosParaTeste.xlsx -> Arquivo em Excel para ser consumida como massa de dados
      
    pacote br.com.rsinet.hub_bdd.pageObjectFactory (Pacote com classes criadas seguindo o design pattern PageObjectFactory)
      HomePage_POF -> Classe utilizada para armazenar elementos e ações da página principal da aplicação WEB.
      LoginPage_POF -> Classe utilizada para armazenar elementos e ações da página de login da aplicação WEB.
      ProductPage_POF -> Classe utilizada para armazenar elementos e ações da página do produto da aplicação WEB.
      RegisterPage_POF -> Classe utilizada para armazenar elementos e ações da página de cadastro da aplicação WEB.
      SearchPage_POF -> Classe utilizada para armazenar elementos e ações da página de pesquisa de produtos da aplicação WEB.

    pacote br.com.rsinet.hub_bdd.utility
      Constant -> Classe utilizada para guardar o link da aplicação web, o caminho para depósito dos prints consumir a massa de dados e 
    organiza-las para utilizar no código.
      DriverFactory -> Classe que gerencia a instância de objetos WebDriver.
      ExcelUtils -> Classe utilizada para ler a massa de dados de arquivos Excel.
      Screenshot -> Classe utilizada para criar método para realizar capturas de tela.
      
  pasta src/test/java
  
    pacote br.com.rsinet.hub_bdd.Test
      CenarioBuscaProdutoPelaTela -> Classe utilizada para rodar os testes do cenario de buscar produto pela pagina principal.
      CenarioBuscaProdutoPorBarraDePesquisa -> Classe utilizada para rodar os testes do cenario de buscar produto pelo campo de pesquisa.
      CenarioCadastroTest -> Classe utilizada para rodar os testes do cenario de cadastrar usuario.
