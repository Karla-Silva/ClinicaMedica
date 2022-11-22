package br.com.funcionarios;

import br.com.procedimentosMedicosRepository.Procedimento;

public class Secretaria implements Atendimento{

    public Secretaria() {};

    @Override
    public void marcarProcedimento(Procedimento procedimento, String paciente) {
        System.out.println(
                        "------------Comprovante de agendamento------------\n" +
                        "Paciente: " + paciente + "\n" +
                                procedimento.toString()
        );

    }
}
