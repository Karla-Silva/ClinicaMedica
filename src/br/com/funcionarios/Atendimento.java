package br.com.funcionarios;

import br.com.procedimentosMedicosRepository.Procedimento;


public interface Atendimento<T extends Procedimento>{
    void marcarProcedimento(T t, String paciente);

}
