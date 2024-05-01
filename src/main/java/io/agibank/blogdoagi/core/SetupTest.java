package io.agibank.blogdoagi.core;

import io.agibank.blogdoagi.utils.Enums.Navegadores;
import io.agibank.blogdoagi.utils.Relatorio.EvidenceReport;
import io.agibank.blogdoagi.utils.Relatorio.ReportFail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(ReportFail.class)
public class SetupTest extends DriverFactory{
    /**
     *  Ex: Run Handless
     openBrowser(Navegadores.HEADLESS,"https://blogdoagi.com.br/");

     */

    @BeforeEach
    public void inicializarBrowser(TestInfo testInfo) {
        openBrowser(Navegadores.HEADLESS,"https://blogdoagi.com.br/");
        EvidenceReport.nomeCenario = testInfo.getDisplayName();
        EvidenceReport.novoCenario = true;

    }

}
