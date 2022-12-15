package br.com.procedimentosMedicosRepository;

import br.com.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Procedimento {

    private int id;
    private LocalDate data;
    private LocalTime horario;
    private Paciente paciente;

    public Procedimento(int id, LocalDate data, LocalTime horario, Paciente paciente) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.paciente = paciente;
    }

    public Procedimento(int id, LocalDate data, LocalTime horario) {
        this.id = id;
        this.data = data;
        this.horario = horario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", data=" + data +
                ", horario=" + horario +
                ", paciente=" + paciente +
                '}';
    }
}
