package br.com;

import java.time.LocalDate;

public class Paciente {
    String cpf;
    String nome;
    LocalDate dataNascimento;

    private Paciente(Builder builder) {
        super();
        this.cpf = builder.cpf;
        this.nome = builder.nome;
        this.dataNascimento = builder.dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public static class Builder {
        String cpf;
        String nome;
        LocalDate dataNascimento;

        public Builder(){}

        public Builder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }

        public Builder nome(String nome){
            this.nome = nome;
            return this;
        }

        public Builder dataNascimento(LocalDate dataNascimento){
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Paciente build(){
            return new Paciente(this);
        }
    }
}
