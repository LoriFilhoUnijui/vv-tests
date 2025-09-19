package br.edu.unijui.vv.selenium.nucleo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class FabricaDriver {
    private static final ThreadLocal<WebDriver> LOCAL = new ThreadLocal<>();

    public static WebDriver obterDriver() {
        if (LOCAL.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions opcoes = new ChromeOptions();
            if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
                opcoes.addArguments("--headless=new");
            }
            opcoes.addArguments("--start-maximized");
            org.openqa.selenium.chrome.ChromeDriver drv = new org.openqa.selenium.chrome.ChromeDriver(opcoes);
            drv.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            LOCAL.set(drv);
        }
        return LOCAL.get();
    }

    public static void encerrarDriver() {
        WebDriver d = LOCAL.get();
        if (d != null) {
            d.quit();
            LOCAL.remove();
        }
    }
}
