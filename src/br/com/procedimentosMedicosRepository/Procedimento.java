package br.com.procedimentosMedicosRepository;

public abstract class Procedimento {
    private String nomeDoProcedimento;
    private String nomeDoMedico;

    public Procedimento(String nomeDoProcedimento, String nomeDoMedico) {
        this.nomeDoProcedimento = nomeDoProcedimento;
        this.nomeDoMedico = nomeDoMedico;
    }


    @Override
    public String toString() {
        return "Procedimento: " + nomeDoProcedimento + '\n' +
                "Médico: " + nomeDoMedico;
    }
}
