package br.edu.unijui.vv.integracao;

import br.edu.unijui.vv.integracao.ServicoPaciente;
import br.edu.unijui.vv.integracao.Consulta;
import br.edu.unijui.vv.integracao.RepositorioConsultasMemoria;
import br.edu.unijui.vv.integracao.Paciente;
import br.edu.unijui.vv.integracao.ValidadorSimples;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.time.*;

public class IntegracaoFumacaTeste {
    @Test
    void caminhoBasicoDaBuildEhSaudavel() {
        Paciente p = new Paciente("p4", "Dora", LocalDate.now().minusYears(20));
        ServicoPaciente servico = new ServicoPaciente(new ValidadorSimples(), new RepositorioConsultasMemoria());
        Consulta c = servico.agendar(p, LocalDateTime.of(2025,9,8,8,0), "Rotina");
        assertNotNull(c);
    }
}
