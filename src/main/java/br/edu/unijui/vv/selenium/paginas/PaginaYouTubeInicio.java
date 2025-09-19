package br.edu.unijui.vv.selenium.paginas;

import br.edu.unijui.vv.selenium.nucleo.PaginaBase;
import org.openqa.selenium.*;

public class PaginaYouTubeInicio extends PaginaBase {
    private final By caixaBusca = By.name("search_query");
    private final By primeiroVideo = By.xpath("(//a[@id='video-title'])[1]");

    public PaginaYouTubeInicio(WebDriver driver) { super(driver); }

    public PaginaYouTubeInicio abrir() {
        abrir(System.getProperty("url.base.youtube", "https://www.youtube.com"));
        return this;
    }

    public void buscar(String termo) {
        WebElement caixa = esperarClicavel(caixaBusca);
        caixa.sendKeys(termo);
        caixa.sendKeys(Keys.ENTER);
    }

    public String abrirPrimeiroVideoETitulo() {
        WebElement link = esperarClicavel(primeiroVideo);
        String titulo = link.getAttribute("title");
        link.click();
        return titulo;
    }
}
