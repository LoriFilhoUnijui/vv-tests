package br.edu.unijui.vv.integracao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RepositorioConsultasMemoria implements RepositorioConsultas {
    private final Map<String, Consulta> banco = new ConcurrentHashMap<>();

    @Override
    public void salvar(Consulta consulta) {
        banco.put(consulta.id(), consulta);
    }

    @Override
    public Optional<Consulta> buscarPorId(String id) {
        return Optional.ofNullable(banco.get(id));
    }

    @Override
    public int contarPorPaciente(String idPaciente) {
        return (int) banco.values().stream().filter(c -> c.paciente().id().equals(idPaciente)).count();
    }
}
