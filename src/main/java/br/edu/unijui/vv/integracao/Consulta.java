package br.edu.unijui.vv.integracao;

import java.time.LocalDateTime;
import java.util.Objects;

public record Consulta(String id, Paciente paciente, LocalDateTime dataHora, String motivo) {
    public Consulta {
        Objects.requireNonNull(id);
        Objects.requireNonNull(paciente);
        Objects.requireNonNull(dataHora);
        Objects.requireNonNull(motivo);
    }
}
