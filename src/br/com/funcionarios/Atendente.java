package br.com.funcionarios;
import br.com.Paciente;
import br.com.aparelhos.Impressora;
import br.com.procedimentosMedicosRepository.Consulta;
import br.com.procedimentosMedicosRepository.Exame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
public class Atendente {

    public Atendente() {}

    public Paciente conferirCpf(ArrayList<Paciente> listaPacientes){
        var ThreadConferirCpf = new ThreadConferirCpf();
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
        LocalTime horario = LocalTime.of(opcaoHorario, 0, 0);

        for(Consulta consulta : listaConsultas){
            if(consulta.getData().isEqual(data) && consulta.getHorario().equals(horario)){
                consulta.setPaciente(paciente);
            }
        }

        List<Consulta> consultaMarcada = listaConsultas.stream()
                .filter(x -> x.getPaciente() == paciente)
                .filter(x -> x.getData().isEqual(data))
                .filter(x -> x.getHorario().equals(horario))
                .collect(Collectors.toList());

        Impressora impressora = new Impressora();
        impressora.comprovanteAgendamento(consultaMarcada);
    }

    public void checarDiasDisponiveis(ArrayList<Consulta> listaConsultas){
        for(int i=0; i<=6; i++) {
            LocalDate data = LocalDate.now().plusDays(i);
            long vagas = listaConsultas.stream()
                    .filter(x -> x.getData().isEqual(data))
                    .count();
            if(vagas > 0){
                System.out.println(i+1 + " - " + data + " - " + data.getDayOfWeek());
            }
        }
    }

    public void checarHorariosDisponiveis(ArrayList<Consulta> listaConsultas, LocalDate data){
        List<Consulta> horariosLivres = listaConsultas.stream()
                                            .filter(x -> x.getData().isEqual(data))
                                            .filter(x -> x.getPaciente() == null)
                                            .collect(Collectors.toList());
        for(Consulta consulta : horariosLivres){
            System.out.println(consulta.getHorario());
        }
    }


    public void adiarConsulta(Paciente paciente,ArrayList<Consulta> listaConsultas) {

        List<Consulta> consultasMarcadas = listaConsultas.stream()
                .filter(x -> x.getPaciente() == paciente)
                .collect(Collectors.toList());

        if (!consultasMarcadas.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            int i = 1;
            Impressora impressora = new Impressora();
            impressora.consultasMarcadas(consultasMarcadas);

            System.out.println("Informe o id da consulta que deseja adiar: ");
            String identificador = sc.nextLine();

            System.out.println("Escolha a nova data da sua consulta. Dias disponiveis: (YYYY-MM-DD)");
            checarDiasDisponiveis(listaConsultas);
            int novaData = sc.nextInt();
            LocalDate data = LocalDate.now().plusDays(novaData - 1);

            System.out.println("Escolha o novo horário da sua consulta. Horarios disponiveis: ");
            checarHorariosDisponiveis(listaConsultas, data);
            int novoHorario = sc.nextInt();
            LocalTime horario = LocalTime.of(novoHorario + 7, 0, 0);

            String novoIdentificador = String.valueOf(Integer.parseInt("" + data.getYear() + data.getMonthValue() + data.getDayOfMonth() + horario.getHour()));
            for (Consulta consultas : listaConsultas) {
                if (consultas.getId().compareTo(identificador) == 0) {
                    consultas.setPaciente(null);
                } else if (consultas.getId().compareTo(novoIdentificador) == 0) {
                    consultas.setPaciente(paciente);
                    impressora.comprovanteReagendamento(listaConsultas, novoIdentificador);
                }
            }
        } else {
            System.out.println("----- Você ainda não tem consultas marcadas! -----");
        }
    }

    public void cancelarConsulta(Paciente paciente,ArrayList<Consulta> listaConsultas){

        List<Consulta> consultasMarcadas = listaConsultas.stream()
                .filter(x -> x.getPaciente() == paciente)
                .collect(Collectors.toList());

        if (!consultasMarcadas.isEmpty() ){
            Scanner sc = new Scanner(System.in);

            Impressora impressora = new Impressora();
            impressora.consultasMarcadas(consultasMarcadas);

            System.out.println("Informe o id da consulta que deseja cancelar: ");
            String identificador = sc.nextLine();

            for(Consulta consultas : listaConsultas){
                if (identificador.equals(consultas.getId())){
                    consultas.setPaciente(null);
                    System.out.println("Consulta cancelada com sucesso.");
                }
            }
        } else {
            System.out.println("----- Você ainda não tem consultas marcadas! -----");
        }
    }

    public void realizarExame(Paciente paciente, ArrayList<Exame> listaExames){
        LocalDate dataDoExame = LocalDate.now();
        LocalTime horaDoExame = LocalTime.now();

        String id = String.valueOf(dataDoExame.getYear()
                + dataDoExame.getMonthValue()
                + dataDoExame.getDayOfMonth()
                + horaDoExame.getHour());

        String fileName = id + ".txt";

        String resultado = "Paciente: " + paciente.getNome() + "\n" +
                "Data: " + dataDoExame + "\n" +
                "Hora: " + horaDoExame + "\n" +
                "Resultado: " + resultadoDoenca() + "\n";

        try{
            Exame exame = new Exame(id, dataDoExame, horaDoExame, paciente);
            listaExames.add(exame);
            Path path = Paths.get(fileName);
            Files.write(path, resultado.getBytes());
            System.out.println("Exame realizado.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String resultadoDoenca(){
        Random gerador = new Random();

        int resultado = gerador.nextInt(5);

        switch (resultado) {
            case 0:
                return "Gripe";
            case 1:
                return "Catapora";
            case 2:
                return "Diabetes";
            case 3:
                return "Hipertensão";
            default:
                return "Saudável";
        }
    }

    public void buscarResultadoExame(Paciente paciente, ArrayList<Exame> listaExames){
        System.out.println("Seus exames: ");
        for(Exame exame : listaExames){
            if(exame.getPaciente().equals(paciente)){
                System.out.println("-------------Resultado do exame-------------\n");
                try{
                    FileReader arq = new FileReader(exame.getId() + ".txt");
                    BufferedReader lerArq = new BufferedReader(arq);
                    String linha = lerArq.readLine();
                    while (linha != null) {
                        System.out.println(linha);
                        linha = lerArq.readLine();
                    }
                }catch (IOException e ){
                    e.printStackTrace();
                }
            }
        }
    }

}
