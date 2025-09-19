package br.edu.unijui.vv.integracao;

import java.util.*;

public interface RepositorioConsultas {
    void salvar(Consulta consulta);
    Optional<Consulta> buscarPorId(String id);
    int contarPorPaciente(String idPaciente);
}
