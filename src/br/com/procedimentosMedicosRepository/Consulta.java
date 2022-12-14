package br.com.procedimentosMedicosRepository;

import br.com.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta extends Procedimento{
    public Consulta(LocalDate data, LocalTime horario) {
        super(data, horario);
    }


}
