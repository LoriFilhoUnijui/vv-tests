package br.edu.unijui.vv.integracao;

import java.time.LocalDateTime;
import java.util.Objects;

public class ServicoPaciente {
    private final Validador validador;
    private final RepositorioConsultas repositorio;

    public ServicoPaciente(Validador validador, RepositorioConsultas repositorio) {
        this.validador = Objects.requireNonNull(validador);
        this.repositorio = Objects.requireNonNull(repositorio);
    }

    public Consulta agendar(Paciente paciente, LocalDateTime dataHora, String motivo) {
        if (!validador.ehAdulto(paciente.dataNascimento())) {
            throw new IllegalArgumentException("O paciente deve ser adulto");
        }
        if (!validador.estaNoHorarioClinica(dataHora)) {
            throw new IllegalArgumentException("Consulta fora do horário da clínica");
        }
        String id = paciente.id() + "-" + (repositorio.contarPorPaciente(paciente.id()) + 1);
        Consulta consulta = new Consulta(id, paciente, dataHora, motivo);
        repositorio.salvar(consulta);
        return consulta;
    }
}
