import br.com.Paciente;
import br.com.funcionarios.Atendente;
import br.com.procedimentosMedicosRepository.Consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Atendente atendente = new Atendente();
        ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
        ArrayList<Consulta> listaConsultas = new ArrayList<Consulta>();
        consultasDaSemana(listaConsultas);

        Paciente paciente1 = new Paciente.Builder()
                .cpf("11122233344")
                .nome("Jose")
                .dataNascimento(LocalDate.now())
                .build();
        listaPacientes.add(paciente1);

        while(true){
            System.out.println("Bem vindo a Clínica Médica!");
            Paciente paciente = atendente.conferirCpf(listaPacientes);

            boolean opcaoIncorreta = false;
            do{
                System.out.println("Selecione a opção que deseja:\n" +
                      "1 - Marcar consulta\n" +
                      "2 - Adiar consulta\n" +
                      "3 - Cancelar consulta\n" +
                      "4 - Realizar exame\n" +
                      "5 - Buscar resultado de exame"
                );
                String opcao = scanner.nextLine();
                switch (opcao){
                case "1":
                    atendente.marcarConsulta(paciente, listaConsultas);
                    break;
                case "2":
                    //adiar consulta
                    break;
                case "3":
                    //cancelar consulta
                    break;
                case "4":
                    //realizar exame
                    break;
                case "5":
                    //buscar resultado do exame
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
                Consulta consulta = new Consulta(data, horario);
                listaConsultas.add(consulta);
            }
        }
    }
}