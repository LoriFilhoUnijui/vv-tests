package br.edu.unijui.vv.selenium.testes.e2e;

import br.edu.unijui.vv.selenium.paginas.PaginaLoginTeste;
import br.edu.unijui.vv.selenium.testes.TesteBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginE2ETeste extends TesteBase {

    @Test
    @Tag("e2e")
    void deveLogarComSucesso() {
        PaginaLoginTeste pagina = new PaginaLoginTeste(driver).abrir();
        pagina.autenticar("tomsmith", "SuperSecretPassword!");
        assertThat(pagina.mensagem()).contains("You logged into a secure area!");
    }

    @Test
    @Tag("e2e")
    void deveFalharComSenhaInvalida() {
        PaginaLoginTeste pagina = new PaginaLoginTeste(driver).abrir();
        pagina.autenticar("tomsmith", "senha-errada");
        assertThat(pagina.mensagem()).contains("Your password is invalid!");
    }
}
