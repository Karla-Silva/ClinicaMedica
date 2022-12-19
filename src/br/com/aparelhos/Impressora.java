package br.com.aparelhos;

import br.com.Paciente;
import br.com.procedimentosMedicosRepository.Consulta;

import java.util.ArrayList;
import java.util.List;

public class Impressora {

    public Impressora() {}

    public void comprovanteAgendamento (List<Consulta> consultaMarcada ){
        System.out.println(
                "------------Comprovante de agendamento------------\n" +
                        "Paciente: " + consultaMarcada.get(0).getPaciente().getNome() + "\n" +
                        "Id: " + consultaMarcada.get(0).getId() + "\n" +
                        "Data: " + consultaMarcada.get(0).getData() + "\n" +
                        "Horario: " +  consultaMarcada.get(0).getHorario() + "\n"
        );
    }

    public void consultasMarcadas(List<Consulta> consultasMarcadas) {
        System.out.println("------------Lista de consultas marcadas------------");
        System.out.println("Paciente: " + consultasMarcadas.get(0).getPaciente().getNome());
        int i = 1;
        for (Consulta consulta : consultasMarcadas) {
            System.out.printf(
                    "------Consulta nº %d------\n" +
                            "id: " + consulta.getId() + "\n" +
                            "Data: " + consulta.getData() + "\n" +
                            "Horario: " + consulta.getHorario() + "\n", i);
            i++;
        }
    }

    public void comprovanteReagendamento(ArrayList<Consulta> listaConsultas, String novoIdentificador) {
        for (Consulta consultas : listaConsultas) {
            if (consultas.getId().compareTo(novoIdentificador) == 0) {
                System.out.println(
                        "------------Comprovante de reagendamento ------------\n" +
                                "Paciente: " + consultas.getPaciente().getNome() + "\n" +
                                "Novo id: " + consultas.getId() + "\n" +
                                "Nova data: " + consultas.getData() + "\n" +
                                "Novo horario: " + consultas.getHorario() + "\n");
            }
        }
    }
}
