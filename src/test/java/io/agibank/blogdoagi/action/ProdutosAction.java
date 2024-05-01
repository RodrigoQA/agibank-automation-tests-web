package io.agibank.blogdoagi.action;


import io.agibank.blogdoagi.screen.ProdutosPage;

import static io.agibank.blogdoagi.core.DriverFactory.getDriver;
import static io.agibank.blogdoagi.utils.Relatorio.EvidenceReport.gerarRelatorio;



public class ProdutosAction extends ProdutosPage {


    public ProdutosAction(){
        super(getDriver());
    }
    private static final String PASSO_A_PASSO_PIX_AGIBANK = "validate/passo-a-passo-pix-agibank.txt";
    public void validarPassoAPassoPixNoAgibank() {
        String passoApassoComoFazerPixAgiBank = readFileFromResources(PASSO_A_PASSO_PIX_AGIBANK);
        validateContainsText(passoApassoPix,passoApassoComoFazerPixAgiBank.replace("\r",""));
        gerarRelatorio("Passo a Passo","Validar passo a passo de como fazer pix no agibank");

    }
    public ProdutosAction validarMensagemResultadoPesquisaNaoEncontrado(String mensagem) {
        validadeExactlyText(notfound,mensagem);
        gerarRelatorio("Não Encontrado","Não foi encontrado nenhum resultado para a pesquisa");
        return new ProdutosAction();

    }
    public ProdutosAction realizarNovaPesquisa(String artigo) {
        insertText(inputArtigo,artigo);
        buscar.click();
        gerarRelatorio("Resultado","Resultado encontrado para a pesquisa");
        return this;
    }

    public void validarMensagemResultadoPesquisaEncontrado(String mensagem) {
        validadeExactlyText(lblResutadosEncontrados,mensagem);
    }
}

