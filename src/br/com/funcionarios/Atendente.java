package br.com.funcionarios;

import br.com.procedimentosMedicosRepository.Procedimento;

public class Atendente {

    public Atendente() {};

    public void marcarProcedimento(Procedimento procedimento, String paciente) {
        //colocar o procedimento em uma list
        System.out.println(
                        "------------Comprovante de agendamento------------\n" +
                        "Paciente: " + paciente + "\n" +
                                procedimento.toString()
        );
    }


}
