package br.com.procedimentosMedicosRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta extends Procedimento{
    public Consulta(String nomeDoProcedimento, LocalDate data, LocalTime horario) {
        super(nomeDoProcedimento, data, horario);
    }
}
