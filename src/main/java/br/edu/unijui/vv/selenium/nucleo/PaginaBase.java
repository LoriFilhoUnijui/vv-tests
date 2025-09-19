package br.edu.unijui.vv.selenium.nucleo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class PaginaBase {
    protected final WebDriver driver;
    protected final WebDriverWait espera;

    public PaginaBase(WebDriver driver) {
        this.driver = driver;
        int timeout = Integer.parseInt(System.getProperty("timeout.segundos", "15"));
        this.espera = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected WebElement esperarClicavel(By seletor) {
        return espera.until(ExpectedConditions.elementToBeClickable(seletor));
    }

    protected WebElement esperarVisivel(By seletor) {
        return espera.until(ExpectedConditions.visibilityOfElementLocated(seletor));
    }

    protected void abrir(String url) {
        driver.get(url);
    }
}
