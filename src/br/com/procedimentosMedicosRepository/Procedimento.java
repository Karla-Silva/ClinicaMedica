package br.com.procedimentosMedicosRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Procedimento {
    private String nomeDoProcedimento;
    private LocalDate data;
    private LocalTime horario;

    public Procedimento(String nomeDoProcedimento, LocalDate data, LocalTime horario) {
        this.nomeDoProcedimento = nomeDoProcedimento;

        this.data = data;
        this.horario = horario;
    }


    @Override
    public String toString() {
        return "Procedimento: " + nomeDoProcedimento + '\n';

    }
}
