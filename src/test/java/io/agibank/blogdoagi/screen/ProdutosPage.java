package io.agibank.blogdoagi.screen;

import io.agibank.blogdoagi.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdutosPage extends BasePage {

    public ProdutosPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "primary")
    public WebElement passoApassoPix;
    @FindBy(xpath = "//*[@class='no-results not-found']//p")
    public WebElement notfound;
    @FindBy(xpath = "(//*[@id='search-field'])[2]")
    public WebElement inputArtigo;
    @FindBy(xpath = "//*[@class='search-submit']")
    public WebElement buscar;
    @FindBy(xpath = "//*[@class='page-title ast-archive-title']")
    public WebElement lblResutadosEncontrados;


}
