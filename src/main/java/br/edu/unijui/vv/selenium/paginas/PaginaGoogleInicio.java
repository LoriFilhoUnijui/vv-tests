package br.edu.unijui.vv.selenium.paginas;

import br.edu.unijui.vv.selenium.nucleo.PaginaBase;
import org.openqa.selenium.*;

public class PaginaGoogleInicio extends PaginaBase {
    private final By caixaBusca = By.name("q");

    public PaginaGoogleInicio(WebDriver driver) { super(driver); }

    public PaginaGoogleInicio abrir() {
        abrir(System.getProperty("url.base.google", "https://www.google.com"));
        return this;
    }

    public PaginaGoogleResultados buscar(String termo) {
        var caixa = esperarClicavel(caixaBusca);
        caixa.sendKeys(termo);
        caixa.sendKeys(Keys.ENTER);
        return new PaginaGoogleResultados(driver);
    }
}
