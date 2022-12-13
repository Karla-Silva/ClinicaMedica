package br.com.procedimentosMedicosRepository;

import br.com.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta extends Procedimento{
    public Consulta(String nomeDoProcedimento, LocalDate data, LocalTime horario, Paciente paciente) {
        super(nomeDoProcedimento, data, horario, paciente);
    }
}
