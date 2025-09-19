package br.edu.unijui.vv.selenium.testes.regressao;

import br.edu.unijui.vv.selenium.paginas.PaginaYouTubeInicio;
import br.edu.unijui.vv.selenium.testes.TesteBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class YouTubeBuscaRegressaoTeste extends TesteBase {

    @Test
    @Tag("regressao")
    void deveBuscarEVidearPrimeiroResultado() {
        PaginaYouTubeInicio yt = new PaginaYouTubeInicio(driver).abrir();
        yt.buscar("Selenium tutorial");
        String titulo = yt.abrirPrimeiroVideoETitulo();
        assertThat(titulo).isNotBlank();
    }
}
