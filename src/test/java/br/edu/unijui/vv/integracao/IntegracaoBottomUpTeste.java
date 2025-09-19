package br.edu.unijui.vv.integracao;


import br.edu.unijui.vv.integracao.ServicoPaciente;
import br.edu.unijui.vv.integracao.Consulta;
import br.edu.unijui.vv.integracao.RepositorioConsultasMemoria;
import br.edu.unijui.vv.integracao.Paciente;
import br.edu.unijui.vv.integracao.ValidadorSimples;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.time.*;

public class IntegracaoBottomUpTeste {
    @Test
    void deveValidarClusterIndependente() {
        ValidadorSimples v = new ValidadorSimples();
        RepositorioConsultasMemoria r = new RepositorioConsultasMemoria();

        assertTrue(v.ehAdulto(LocalDate.now().minusYears(30)));
        assertFalse(v.estaNoHorarioClinica(LocalDateTime.of(2025,9,7,12,0)));
        assertEquals(0, r.contarPorPaciente("x"));
    }

    @Test
    void deveMontarServicoDepoisClusterValidado() {
        ValidadorSimples v = new ValidadorSimples();
        RepositorioConsultasMemoria r = new RepositorioConsultasMemoria();
        ServicoPaciente servico = new ServicoPaciente(v, r);

        Paciente p = new Paciente("p3", "Carol", LocalDate.now().minusYears(40));
        LocalDateTime quando = LocalDateTime.of(2025, 9, 8, 15, 0);

        Consulta c = servico.agendar(p, quando, "Consulta");

        assertEquals(1, r.contarPorPaciente("p3"));
        assertTrue(r.buscarPorId(c.id()).isPresent());
    }
}
