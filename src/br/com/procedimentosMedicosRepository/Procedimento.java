package br.com.procedimentosMedicosRepository;

import br.com.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Procedimento {
    private String nomeDoProcedimento;
    private LocalDate data;
    private LocalTime horario;
    private Paciente paciente;

    public Procedimento(String nomeDoProcedimento, LocalDate data, LocalTime horario, Paciente paciente) {
        this.nomeDoProcedimento = nomeDoProcedimento;
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Procedimento: " + nomeDoProcedimento + '\n';

    }
}
