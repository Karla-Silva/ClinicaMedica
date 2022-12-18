package br.com.funcionarios;

public class ThreadMenu implements Runnable{
    public ThreadMenu(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Selecione a opção que deseja:\n" +
                    "1 - Marcar consulta\n" +
                    "2 - Adiar consulta\n" +
                    "3 - Cancelar consulta\n" +
                    "4 - Realizar exame\n" +
                    "5 - Buscar resultado de exame\n" +
                    "6 - Sair");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
