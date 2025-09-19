package br.edu.unijui.vv.selenium.paginas;

import br.edu.unijui.vv.selenium.nucleo.PaginaBase;
import org.openqa.selenium.*;
import java.util.List;

public class PaginaGoogleResultados extends PaginaBase {
    private final By titulos = By.cssSelector("h3");

    public PaginaGoogleResultados(WebDriver driver) { super(driver); }

    public List<WebElement> primeirosResultados() {
        return driver.findElements(titulos);
    }
}
