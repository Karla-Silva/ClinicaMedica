package br.com.procedimentosMedicosRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta extends Procedimento{
    public Consulta(String id, LocalDate data, LocalTime horario) {
        super(id, data, horario);
    }


}
