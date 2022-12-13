import br.com.funcionarios.Atendente;
import br.com.procedimentosMedicosRepository.Cirurgia;
import br.com.procedimentosMedicosRepository.Consulta;
import br.com.procedimentosMedicosRepository.Exame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean procedimentoIncorreto = true;
        Atendente atendente = new Atendente();

        System.out.println("Bem vindo a Clínica Médica!");
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.next();
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();

        while(procedimentoIncorreto){
            System.out.println("Selecione a opção que deseja:\n" +
                    "1 - Marcar consulta\n" +
                    "2 - Marcar exame\n" +
                    "3 - Marcar cirurgia\n" +
                    "4 - Adiar consulta\n" +
                    "5 - Adiar exame\n" +
                    "6 - Adiar cirurgia\n" +
                    "7 - Cancelar consulta\n" +
                    "8 - Cancelar exame\n" +
                    "9 - Cancelar cirurgia");
            int procedimento = scanner.nextInt();

        }
    }
}