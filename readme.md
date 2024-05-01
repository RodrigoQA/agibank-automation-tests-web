# Teste Técnico Agibank Sobre Automação de Testes WEB

Este projeto foi elaborado pensando em garantir uma cobertura de testes.

##  Requisitos
* Java 11+ JDK deve estar instalado
* Maven deve estar instalado e configurado no path da aplicação


## :open_file_foder: Estrutura do projeto

````text

|__src (java root path projeto)
    |__main
    |  |__java
    |  |  |__io.agibank.blogdoagi
    |  |    |__core
    |  |    |     |__BasePage
    |  |    |     |__DriverFactory
    |  |    |     |__Setup
    |  |    |__utils
    |  |        |__Enums
    |  |            |__Navegadores
    |  |___resources (contém arquivos de configuração caso haja)
    | 
    |__test
    |    |__io.agibank.blogdoagi
    |      |__action
    |      |__screen
    |      |__tests
    |__pom.xml (Contém as dependências relacionada ao projeto)
    |__.gitignore (Contém o diretório de arquivos que devem ser ignorados no momento do commit)   
````

## Como executar os testes
É Possivel executar pela propria IDE, selecionado qual Teste deseja executar e simplismente dar play no método <br>
do teste ou podera executar pela linha de comando atraves do comando:<br>

Rodar todos os testes<br>
```bash
mvn test  
```
Rodar teste especifico utilizando o nome da Tag<br>
```bash
mvn test  -Dgroups="pix"
```
Rodas diversas Tags
```bash
mvn test  -Dgroups="pix, consignado"
```
Não excutar alguma Tag
```bash
mvn -DexcludedGroups="bug"
```
Selecionar Browser 
```bash
mvn test  -Dgroups="pix",-DBrowser=HEADLESS
```
## Relatório customizado
Após execução do teste a automação gera um relatorio com as evidências do teste localizado na raiz do projeto dentro da pasta:<br>

Evidencias.

## Allure 
Após a execução dos testes é possivel gerar o relatório com a biblioteca Allure tanto Local como no github com actions integration, e assim visualizar os resultados de forma mais simplificada.<br> 

Para visualizar o relatório:<br>

Local: Basta executar o comando:
```bash
mvn allure:serve
```
Github: Bastar clicar no link:
'github-pages'