package br.edu.unijui.vv.selenium.testes.regressao;

import br.edu.unijui.vv.selenium.paginas.PaginaWikipediaInicio;
import br.edu.unijui.vv.selenium.testes.TesteBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WikipediaLeituraRegressaoTeste extends TesteBase {

    @Test
    @Tag("regressao")
    void deveLerPrimeiroParagrafo() {
        String texto = new PaginaWikipediaInicio(driver)
                .abrir()
                .buscarELerPrimeiroParagrafo("Engenharia de Software");
        assertThat(texto).containsIgnoringCase("software");
    }
}
