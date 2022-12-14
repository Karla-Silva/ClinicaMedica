package br.com.procedimentosMedicosRepository;

import br.com.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Procedimento {
    private LocalDate data;
    private LocalTime horario;
    private Paciente paciente;

    public Procedimento(LocalDate data, LocalTime horario, Paciente paciente) {
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
    }

    public Procedimento(LocalDate data, LocalTime horario) {
        this.data = data;
        this.horario = horario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Procedimento{" +
                "data=" + data +
                ", horario=" + horario +
                ", paciente=" + paciente +
                '}';
    }
}
