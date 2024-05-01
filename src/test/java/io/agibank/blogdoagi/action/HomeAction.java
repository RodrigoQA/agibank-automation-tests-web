package io.agibank.blogdoagi.action;

import io.agibank.blogdoagi.screen.HomePage;

import static io.agibank.blogdoagi.core.DriverFactory.getDriver;
import static io.agibank.blogdoagi.utils.Relatorio.EvidenceReport.gerarRelatorio;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomeAction extends HomePage {

    public HomeAction() {
        super(getDriver());
    }

    public HomeAction realizarPesquisaNoBlog(String artigo) {
        click(lupa).insertText(inputArtigo,artigo).enter(buscar);
        gerarRelatorio("Pesquisar","Buscar por artigo desejado");
        return new HomeAction();

    }
    public void selecionarArtigo(String artigo) {
        clickText(artigo);
        gerarRelatorio("Artigo",artigo);
    }

}
