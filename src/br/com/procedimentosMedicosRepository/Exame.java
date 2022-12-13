package br.com.procedimentosMedicosRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class Exame extends Procedimento{
    public Exame(String nomeDoProcedimento, LocalDate data, LocalTime horario) {
        super(nomeDoProcedimento,  data, horario);
    }
}
