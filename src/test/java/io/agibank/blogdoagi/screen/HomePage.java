package io.agibank.blogdoagi.screen;

import io.agibank.blogdoagi.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@class='slide-search astra-search-icon']")
    public WebElement lupa;
    @FindBy(id = "search-field")
    public WebElement inputArtigo;
    @FindBy(name = "s")
    public WebElement buscar;

}
