package br.edu.unijui.vv.selenium.testes.regressao;

import br.edu.unijui.vv.selenium.paginas.PaginaAmazonBusca;
import br.edu.unijui.vv.selenium.testes.TesteBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class AmazonListagemRegressaoTeste extends TesteBase {

    @Test
    @Tag("regressao")
    void deveColetarTitulos() {
        PaginaAmazonBusca amz = new PaginaAmazonBusca(driver).abrir();
        amz.buscar("notebook");
        List<String> titulos = amz.primeirosTitulos(5);
        assertThat(titulos).isNotEmpty();
    }
}
