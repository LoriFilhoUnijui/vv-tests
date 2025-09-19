package br.edu.unijui.vv.integracao;

import java.time.*;

public class ValidadorSimples implements Validador {
    @Override
    public boolean ehAdulto(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears() >= 18;
    }
    @Override
    public boolean estaNoHorarioClinica(LocalDateTime dataHora) {
        DayOfWeek dia = dataHora.getDayOfWeek();
        int hora = dataHora.getHour();
        boolean diaUtil = dia != DayOfWeek.SATURDAY && dia != DayOfWeek.SUNDAY;
        return diaUtil && hora >= 8 && hora <= 17;
    }
}
