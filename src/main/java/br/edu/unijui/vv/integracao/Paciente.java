package br.edu.unijui.vv.integracao;

import java.time.LocalDate;
import java.util.Objects;

public record Paciente(String id, String nome, LocalDate dataNascimento) {
    public Paciente {
        Objects.requireNonNull(id);
        Objects.requireNonNull(nome);
        Objects.requireNonNull(dataNascimento);
    }
}
