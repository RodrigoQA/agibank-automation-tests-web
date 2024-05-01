package io.agibank.blogdoagi.tests;

import io.agibank.blogdoagi.action.HomeAction;
import io.agibank.blogdoagi.action.ProdutosAction;
import io.agibank.blogdoagi.core.SetupTest;
import io.agibank.blogdoagi.utils.Relatorio.ReportFail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ReportFail.class)
public class PesquisaDeArtigosDoBlogTest extends SetupTest {

    @Test
    @Tags(value = {@Tag("pix"),@Tag("regressivo")})
    @DisplayName("Realizar uma pesquisa sobre o passo a passo para realizar um pagamento via PIX no agibank")
    public void realizarUmaPesquisaSobreComoRealizarPIX(){
        new HomeAction()
                .realizarPesquisaNoBlog("Como fazer Pix?")
                .selecionarArtigo("Como fazer Pix? Passo a passo para transferir dinheiro");

        new ProdutosAction()
                .validarPassoAPassoPixNoAgibank();



    }
    @Test
    @Tags(value = {@Tag("nao_encontrado"),@Tag("regressivo")})
    @DisplayName("Validar mensagem ao não encontrar a pesquisa desejada")
    public void validarMensagemParaPesquisaNaoEncontrada(){
        new HomeAction()
                .realizarPesquisaNoBlog("Pacotes de viagens");

        new ProdutosAction()
                .validarMensagemResultadoPesquisaNaoEncontrado("Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.");

    }
    @Test
    @Tags(value = {@Tag("pesquisa2"),@Tag("regressivo")})
    @DisplayName("Validar quando não a resultado encontrado é disponibilizado uma nova opção de pesquisa")
    public void validarBarraDePesquisaParaQuandoOResultadoNaoEhEncontrado(){
        new HomeAction()
                .realizarPesquisaNoBlog("corta corrente");

        new ProdutosAction()
                .validarMensagemResultadoPesquisaNaoEncontrado("Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.")
                .realizarNovaPesquisa("conta corrente")
                .validarMensagemResultadoPesquisaEncontrado("Resultados encontrados para: conta corrente");

    }

}
