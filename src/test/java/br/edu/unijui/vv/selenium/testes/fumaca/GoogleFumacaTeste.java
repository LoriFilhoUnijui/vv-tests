package br.edu.unijui.vv.selenium.testes.fumaca;

import br.edu.unijui.vv.selenium.paginas.PaginaGoogleInicio;
import br.edu.unijui.vv.selenium.testes.TesteBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GoogleFumacaTeste extends TesteBase {

    @Test
    @Tag("fumaca")
    void deveBuscarNoGoogle() {
        var resultados = new PaginaGoogleInicio(driver)
                .abrir()
                .buscar("Selenium WebDriver")
                .primeirosResultados();

        assertThat(resultados).isNotEmpty();
        assertThat(resultados.get(0).getText()).isNotBlank();
    }
}
