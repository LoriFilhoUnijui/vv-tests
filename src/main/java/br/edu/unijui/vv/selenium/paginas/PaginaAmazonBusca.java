package br.edu.unijui.vv.selenium.paginas;

import br.edu.unijui.vv.selenium.nucleo.PaginaBase;
import org.openqa.selenium.*;
import java.util.List;
import java.util.stream.Collectors;

public class PaginaAmazonBusca extends PaginaBase {
    private final By caixaBusca = By.id("twotabsearchtextbox");
    private final By titulos = By.cssSelector("span.a-text-normal");
    private final By precos = By.cssSelector("span.a-price-whole");

    public PaginaAmazonBusca(WebDriver driver) { super(driver); }

    public PaginaAmazonBusca abrir() {
        abrir(System.getProperty("url.base.amazon", "https://www.amazon.com.br"));
        return this;
    }

    public void buscar(String termo) {
        var caixa = esperarClicavel(caixaBusca);
        caixa.sendKeys(termo);
        caixa.sendKeys(Keys.ENTER);
    }

    public List<String> primeirosTitulos(int limite) {
        return driver.findElements(titulos).stream().limit(limite).map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> primeirosPrecos(int limite) {
        return driver.findElements(precos).stream().limit(limite).map(WebElement::getText).collect(Collectors.toList());
    }
}
