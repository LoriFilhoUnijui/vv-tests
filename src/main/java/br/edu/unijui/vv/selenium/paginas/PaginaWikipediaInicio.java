package br.edu.unijui.vv.selenium.paginas;

import br.edu.unijui.vv.selenium.nucleo.PaginaBase;
import org.openqa.selenium.*;

public class PaginaWikipediaInicio extends PaginaBase {
    private final By busca = By.name("search");
    private final By primeiroParagrafo = By.cssSelector("p");

    public PaginaWikipediaInicio(WebDriver driver) { super(driver); }

    public PaginaWikipediaInicio abrir() {
        abrir(System.getProperty("url.base.wikipedia", "https://pt.wikipedia.org"));
        return this;
    }

    public String buscarELerPrimeiroParagrafo(String termo) {
        var caixa = esperarClicavel(busca);
        caixa.sendKeys(termo);
        caixa.sendKeys(Keys.ENTER);
        return esperarVisivel(primeiroParagrafo).getText();
    }
}
