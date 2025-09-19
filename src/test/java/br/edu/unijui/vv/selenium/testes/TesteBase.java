package br.edu.unijui.vv.selenium.testes;

import br.edu.unijui.vv.selenium.nucleo.FabricaDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class TesteBase {
    protected WebDriver driver;

    @BeforeEach
    void preparar() { driver = FabricaDriver.obterDriver(); }

    @AfterEach
    void finalizar() { FabricaDriver.encerrarDriver(); }
}
