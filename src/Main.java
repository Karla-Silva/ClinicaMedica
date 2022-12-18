import br.com.Paciente;
import br.com.funcionarios.Atendente;
import br.com.procedimentosMedicosRepository.Consulta;
import br.com.procedimentosMedicosRepository.Exame;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //criar listas como variáveis globais para evitar serem resetadas quando o cliente sair

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Atendente atendente = new Atendente();
        ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
        ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
        ArrayList<Exame> listaExames = new ArrayList<Exame>();
        consultasDaSemana(listaConsultas);

        Paciente paciente1 = new Paciente.Builder()
                .cpf("11122233344")
                .nome("Jose")
                .dataNascimento(LocalDate.now())
                .build();
        listaPacientes.add(paciente1);

        boolean continuar = true;
        while(continuar){
            System.out.println("Bem vindo a Clínica Médica!");
            Paciente paciente = atendente.conferirCpf(listaPacientes);

            boolean opcaoIncorreta = false;
            do{
                System.out.println("Selecione a opção que deseja:\n" +
                      "1 - Marcar consulta\n" +
                      "2 - Adiar consulta\n" +
                      "3 - Cancelar consulta\n" +
                      "4 - Realizar exame\n" +
                      "5 - Buscar resultado de exame\n" +
                      "6 - Sair"
                );
                String opcao = scanner.nextLine();
                switch (opcao){
                case "1":
                    atendente.marcarConsulta(paciente, listaConsultas);
                    break;
                case "2":
                    atendente.adiarConsulta(paciente, listaConsultas);
                    break;
                case "3":
                    atendente.cancelarConsulta(paciente, listaConsultas);
                    break;
                case "4":
                    atendente.realizarExame(paciente, listaExames);
                    break;
                case "5":
                    atendente.buscarResultadoExame(paciente, listaExames);
                    break;
                case "6":
                   continuar = false;
                   break;
                default:
                    opcaoIncorreta = true;
                    System.out.println("Opção incorreta. Tente novamente.");
                    break;
                }
            }while(opcaoIncorreta);
        }
    }

    public static void consultasDaSemana(ArrayList<Consulta> listaConsultas){
        for(int i=0; i<=6; i++){
            LocalDate data = LocalDate.now().plusDays(i);
            for(int j=8; j<=16; j++){
                LocalTime horario = LocalTime.of(j, 0);
                String id = String.valueOf(data.getYear() + data.getMonthValue() + data.getDayOfMonth() + horario.getHour()); //Identificação da consulta no format YYYYMMDDHH
                Consulta consulta = new Consulta(id, data, horario);
                listaConsultas.add(consulta);
            }
        }
    }
}