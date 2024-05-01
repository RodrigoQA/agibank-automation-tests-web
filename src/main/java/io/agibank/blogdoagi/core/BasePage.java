package io.agibank.blogdoagi.core;

import com.google.common.io.Resources;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.logging.Logger;

import static io.agibank.blogdoagi.core.DriverFactory.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

abstract public class BasePage {
    public Logger log = Logger.getLogger("QALogger");

    public void waitElementVisible(WebElement element, int segundos) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(segundos))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        log.info("Elemento: " + element + " encontrado com sucesso!");
    }

    public BasePage insertText(WebElement el, String text) {
        el.sendKeys(text);
        log.info("texto: " + text + " foi preenchido com sucesso!");
        return this;

    }

    public BasePage click(WebElement el) {
        el.click();
        log.info("Elemento: " + el + " clicado com sucesso!");
        return this;

    }
    public void clickText(String texto) {
        getDriver().findElement(By.xpath("//*[text()='"+texto+"']")).click();
        log.info("Texto: " + texto + " clicado com sucesso!");

    }

    public void enter(WebElement el) {
        el.sendKeys(Keys.ENTER);
        log.info("Elemento: " + el + " Enter");

    }

    public void validateContainsText(WebElement texto_atual, String texto_esperado) {
        assertThat(texto_atual.getText(), containsString(texto_esperado));
        log.info("Texto: " + texto_esperado + " validado com sucesso!");

    }

    public void validadeExactlyText(WebElement texto_atual, String texto_esperado) {
        assertThat(texto_atual.getText(), CoreMatchers.is(texto_esperado));
        log.info("Texto: " + texto_esperado + " validado com sucesso!");

    }

    public void scrollToElement(WebElement elemento) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", elemento);
        waitElementVisible(elemento, 5);
        log.info("Scroll: Scroll efetuado até o elemento com sucesso!");

    }

    public String readFileFromResources(String fileName){
        URL url = Resources.getResource(fileName);
        try {
            return Resources.toString(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
