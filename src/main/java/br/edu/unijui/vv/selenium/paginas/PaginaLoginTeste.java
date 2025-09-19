package br.edu.unijui.vv.selenium.paginas;

import br.edu.unijui.vv.selenium.nucleo.PaginaBase;
import org.openqa.selenium.*;

public class PaginaLoginTeste extends PaginaBase {
    private final By usuario = By.id("username");
    private final By senha = By.id("password");
    private final By alerta = By.id("flash");

    public PaginaLoginTeste(WebDriver driver) { super(driver); }

    public PaginaLoginTeste abrir() {
        abrir(System.getProperty("url.base.login", "https://the-internet.herokuapp.com/login"));
        return this;
    }

    public void autenticar(String user, String pass) {
        esperarClicavel(usuario).sendKeys(user);
        driver.findElement(senha).sendKeys(pass + Keys.ENTER);
    }

    public String mensagem() {
        return esperarVisivel(alerta).getText();
    }
}
