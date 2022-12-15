package br.com.funcionarios;
import br.com.Paciente;
import br.com.procedimentosMedicosRepository.Consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Atendente {

    public Atendente() {}

    public Paciente conferirCpf(ArrayList<Paciente> listaPacientes){
        System.out.println("Digite seu CPF: ");
        Scanner scanner = new Scanner(System.in);
        String cpf = scanner.next();
        boolean cpfCadastrado = listaPacientes.stream().anyMatch(x -> Objects.equals(x.getCpf(), cpf));
        if(!cpfCadastrado){
            System.out.println("Digite seu nome: ");
            String nome = scanner.next();
            System.out.print("Digite sua data de nascimento: (YYYY-MM-DD) ");
            LocalDate dataNascimento = LocalDate.parse(scanner.next());
            Paciente paciente = new Paciente.Builder()
                    .cpf(cpf)
                    .nome(nome)
                    .dataNascimento(dataNascimento)
                    .build();
            listaPacientes.add(paciente);
            System.out.println("Olá "+nome);
        }else{
            List<Paciente> paciente = listaPacientes.stream()
                    .filter(x -> Objects.equals(x.getCpf(), cpf))
                    .collect(Collectors.toList());
            System.out.println("Olá "+ paciente.get(0).getNome());
        }

        return listaPacientes.stream()
                .filter(x -> Objects.equals(x.getCpf(), cpf))
                .collect(Collectors.toList())
                .get(0);
    }

    public void marcarConsulta(Paciente paciente, ArrayList<Consulta> listaConsultas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a data da sua consulta. Dias disponiveis: (YYYY-MM-DD)");
        checarDiasDisponiveis(listaConsultas);
        int opcaoData = scanner.nextInt();
        LocalDate data = LocalDate.now().plusDays(opcaoData-1);

        System.out.println("Escolha o horário da sua consulta. Horarios disponiveis: ");
        checarHorariosDisponiveis(listaConsultas, data);
        int opcaoHorario = scanner.nextInt();
        LocalTime horario = LocalTime.of(opcaoHorario+7, 0, 0);

        for(Consulta consulta : listaConsultas){
            if(consulta.getData().compareTo(data) == 0 && consulta.getHorario().compareTo(horario) == 0){
                consulta.setPaciente(paciente);
            }
        }

        System.out.println(
                        "------------Comprovante de agendamento------------\n" +
                        "Paciente: " + paciente.getNome() + "\n" +
                        "Data: " + data + "\n" +
                        "Horario: " + horario + "\n"
        );
    }

    public void checarDiasDisponiveis(ArrayList<Consulta> listaConsultas){
        for(int i=0; i<=6; i++) {
            LocalDate data = LocalDate.now().plusDays(i);
            long vagas = listaConsultas.stream()
                    .filter(x -> {
                        LocalDate data1 = x.getData();
                        if (data1.compareTo(data) == 0){
                            return true;
                        }else{
                            return false;
                        }
                    }).count();
            if(vagas > 0){
                System.out.println(i+1 + " - " + data + " - " + data.getDayOfWeek());
            }
        }
    }

    public void checarHorariosDisponiveis(ArrayList<Consulta> listaConsultas, LocalDate data){
        List<Consulta> horariosLivres = listaConsultas.stream()
                                            .filter(x -> {
                                                 LocalDate data1 = x.getData();
                                                 if (data1.compareTo(data) == 0){
                                                    return true;
                                                 }else{
                                                    return false;
                                                 }
                                            })
                                            .filter(x -> x.getPaciente() == null)
                                            .collect(Collectors.toList());
        int i = 0;
        for(Consulta consulta : horariosLivres){
            i++;
            System.out.println(i + " - " + consulta.getHorario());
        };
    }


    public void adiarConsulta(Paciente paciente,ArrayList<Consulta> listaConsultas) {

        List<Consulta> consultasMarcadas = listaConsultas.stream()
                .filter(x -> {
                    Paciente paciente1 = x.getPaciente();
                    if (paciente1 == paciente) {
                        return true;
                    } else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (!consultasMarcadas.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            int i = 1;
            System.out.println("------------Lista de consultas marcadas------------");
            System.out.println("Paciente: " + paciente.getNome());
            for (Consulta consulta : consultasMarcadas) {
                System.out.printf(
                        "------Consulta nº %d------\n" +
                                "id: " + consulta.getId() + "\n" +
                                "Data: " + consulta.getData() + "\n" +
                                "Horario: " + consulta.getHorario() + "\n", i);
                i++;
            }

            System.out.println("Informe o id da consulta que deseja adiar: ");
            int identificador = sc.nextInt();

            System.out.println("Escolha a nova data da sua consulta. Dias disponiveis: (YYYY-MM-DD)");
            checarDiasDisponiveis(listaConsultas);
            int novaData = sc.nextInt();
            LocalDate data = LocalDate.now().plusDays(novaData - 1);

            System.out.println("Escolha o novo horário da sua consulta. Horarios disponiveis: ");
            checarHorariosDisponiveis(listaConsultas, data);
            int novoHorario = sc.nextInt();
            LocalTime horario = LocalTime.of(novoHorario + 7, 0, 0);

            int novoIdentificador = Integer.parseInt("" + data.getYear() + data.getMonthValue() + data.getDayOfMonth() + horario.getHour());
            for (Consulta consultas : listaConsultas) {
                if (consultas.getId().compareTo(identificador) == 0) {
                    consultas.setPaciente(null);
                } else if (consultas.getId().compareTo(novoIdentificador) == 0) {
                    consultas.setPaciente(paciente);
                    System.out.println(consultas); // teste
                    System.out.println(
                            "------------Comprovante de reagendamento ------------\n" +
                                    "Paciente: " + consultas.getPaciente().getNome() + "\n" +
                                    "Novo id: " + consultas.getId() + "\n" +
                                    "Nova data: " + consultas.getData() + "\n" +
                                    "Novo horario: " + consultas.getHorario() + "\n");
                }
            }

            System.out.println(listaConsultas);
        } else {
            System.out.println("----- Você ainda não tem consultas marcadas! -----");
        }
    }


    public void cancelarConsulta(Paciente paciente,ArrayList<Consulta> listaConsultas){

        List<Consulta> consultasMarcadas = listaConsultas.stream()
                .filter(x -> {
                    Paciente paciente1 = x.getPaciente();
                    if (paciente1 == paciente){
                        return true;
                    }else {
                        return false;
                    }
                })
                .collect(Collectors.toList());

        if (!consultasMarcadas.isEmpty() ){
            Scanner sc = new Scanner(System.in);
            int i = 1;
            System.out.println("------------Lista de consultas marcadas------------");
            System.out.println("Paciente: " + paciente.getNome());

            for(Consulta consulta : consultasMarcadas){
                System.out.printf(
                        "------Consulta nº %d------\n" +
                                "id: " + consulta.getId()+ "\n" +
                                "Data: " + consulta.getData() + "\n" +
                                "Horario: " + consulta.getHorario() + "\n", i);
                i++;
            }

            System.out.println("Informe o id da consulta que deseja cancelar: ");
            int identificador = sc.nextInt();

            for(Consulta consultas : listaConsultas){
                if (consultas.getId() == identificador){
                    consultas.setPaciente(null);
                }
            }
        } else {
            System.out.println("----- Você ainda não tem consultas marcadas! -----");
        }
    }
}
