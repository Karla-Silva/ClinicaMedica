import br.com.funcionarios.Atendente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean opcaoIncorreta = false;
        Atendente atendente = new Atendente();

        System.out.println("Bem vindo a Clínica Médica!");
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.next();
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();

        do{
            System.out.println("Selecione a opção que deseja:\n" +
                    "1 - Marcar consulta\n" +
                    "2 - Adiar consulta\n" +
                    "3 - Cancelar consulta\n" +
                    "4 - Realizar exame\n" +
                    "5 - Buscar resultado de exame"
            );
            String opcao = scanner.next();
            switch (opcao){
                case "1":
                    //marcar consulta
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