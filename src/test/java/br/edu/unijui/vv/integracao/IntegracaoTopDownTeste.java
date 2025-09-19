package br.edu.unijui.vv.integracao;

import br.edu.unijui.vv.integracao.ServicoPaciente;
import br.edu.unijui.vv.integracao.Consulta;
import br.edu.unijui.vv.integracao.Validador;
import br.edu.unijui.vv.integracao.Paciente;
import br.edu.unijui.vv.integracao.RepositorioConsultas;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.time.*;
import java.util.*;

class ValidadorStub implements Validador {
    boolean adulto = true;
    boolean horario = true;
    @Override public boolean ehAdulto(LocalDate d){ return adulto; }
    @Override public boolean estaNoHorarioClinica(LocalDateTime h){ return horario; }
}
class RepositorioEspie implements RepositorioConsultas {
    Consulta salva;
    Map<String, Consulta> mapa = new HashMap<>();
    @Override public void salvar(Consulta c){ this.salva = c; mapa.put(c.id(), c); }
    @Override public Optional<Consulta> buscarPorId(String id){ return Optional.ofNullable(mapa.get(id)); }
    @Override public int contarPorPaciente(String idPaciente){ return (int) mapa.values().stream().filter(c->c.paciente().id().equals(idPaciente)).count(); }
}

public class IntegracaoTopDownTeste {
    @Test
    void deveAgendarConsulta() {
        ValidadorStub validador = new ValidadorStub();
        RepositorioEspie repo = new RepositorioEspie();
        ServicoPaciente servico = new ServicoPaciente(validador, repo);

        Paciente p = new Paciente("p1", "Alice", LocalDate.now().minusYears(25));
        LocalDateTime quando = LocalDateTime.of(2025, 9, 8, 9, 30);

        Consulta c = servico.agendar(p, quando, "Checkup");

        assertNotNull(repo.salva);
        assertEquals("p1-1", c.id());
        assertEquals("Alice", c.paciente().nome());
    }

    @Test
    void deveFalharSePacienteNaoForAdulto() {
        ValidadorStub validador = new ValidadorStub();
        validador.adulto = false;
        RepositorioEspie repo = new RepositorioEspie();
        ServicoPaciente servico = new ServicoPaciente(validador, repo);

        Paciente p = new Paciente("p2", "Bob", LocalDate.now().minusYears(16));
        LocalDateTime quando = LocalDateTime.of(2025, 9, 8, 10, 0);

        assertThrows(IllegalArgumentException.class, () -> servico.agendar(p, quando, "Exame"));
        assertNull(repo.salva);
    }
}
