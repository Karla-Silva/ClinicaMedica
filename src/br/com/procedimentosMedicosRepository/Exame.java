package br.com.procedimentosMedicosRepository;

import br.com.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exame extends Procedimento{
    public Exame(LocalDate data, LocalTime horario, Paciente paciente) {
        super(data, horario, paciente);
    }
}
