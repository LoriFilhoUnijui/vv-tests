package br.edu.unijui.vv.integracao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Validador {
    boolean ehAdulto(LocalDate dataNascimento);
    boolean estaNoHorarioClinica(LocalDateTime dataHora);
}
