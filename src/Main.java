import br.com.funcionarios.Atendente;
import br.com.funcionarios.Secretaria;
import br.com.procedimentosMedicosRepository.Cirurgia;
import br.com.procedimentosMedicosRepository.Consulta;
import br.com.procedimentosMedicosRepository.Exame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean funcionarioIncorreto = true;
        boolean procedimentoIncorreto = true;
        Atendente atendente = new Atendente();
        Secretaria secretaria = new Secretaria();

        System.out.println("Bem vindo a Clínica Médica!");
        System.out.println("Digite seu nome: ");
        String nome = scanner.next();

        while(funcionarioIncorreto){
            System.out.println("Para consultas e exames, fale com a atendente (1).\n" +
                    "Para cirurgias, fale com a secretária do médico (2).\n" +
                    "Com quem você deseja falar?\n" +
                    "1 - Atendente\n" +
                    "2 - Secretária");
            int funcionario = scanner.nextInt();

            if (funcionario == 1){
                funcionarioIncorreto = false;
                while(procedimentoIncorreto){
                    System.out.println("Selecione a opção que deseja:\n" +
                            "1 - Marcar consulta\n" +
                            "2 - Marcar exame\n");
                    int procedimento = scanner.nextInt();
                    if(procedimento == 1){
                        procedimentoIncorreto = false;
                        Consulta consulta = new Consulta("Consulta", "Dr. Alberto");
                        atendente.marcarProcedimento(consulta, nome);
                    } else if(procedimento == 2){
                        procedimentoIncorreto = false;
                        Exame exame = new Exame("Exame", "Dra. Fátima");
                        atendente.marcarProcedimento(exame, nome);
                    } else {
                        System.out.println("Resposta incorreta. Tente novamente.");
                    }
                }
            } else if(funcionario == 2){
                funcionarioIncorreto = false;
                Cirurgia cirurgia = new Cirurgia("Cirurgia", "Dra. Angélica");
                secretaria.marcarProcedimento(cirurgia, nome);
            }else{
                System.out.println("Resposta incorreta. Tente novamente.");
            }
        }
    }
}