package br.com.funcionarios;

import br.com.procedimentosMedicosRepository.Procedimento;

public class Atendente implements Atendimento{

    public Atendente() {};

    @Override
    public void marcarProcedimento(Procedimento procedimento, String paciente) {
        System.out.println(
                        "------------Comprovante de agendamento------------\n" +
                        "Paciente: " + paciente + "\n" +
                                procedimento.toString()
        );
    }
}
