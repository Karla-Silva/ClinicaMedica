package br.com.procedimentosMedicosRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cirurgia extends Procedimento{
    public Cirurgia(String nomeDoProcedimento, LocalDate data, LocalTime horario) {
        super(nomeDoProcedimento,  data, horario);
    }
}
