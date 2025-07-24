package com.mitocode.service;

import com.mitocode.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    Paciente registrar(Paciente p);
    Paciente modificar(Paciente p);
    List<Paciente> listar();
    Paciente listarPorId(Integer id);
    void eliminar (Integer id);
}
