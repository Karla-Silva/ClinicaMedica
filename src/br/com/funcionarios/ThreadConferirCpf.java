package br.com.funcionarios;

public class ThreadConferirCpf implements Runnable{
    public ThreadConferirCpf(){
        new Thread(this).start();
    }
    @Override
    public void run() {
        System.out.println("Bem vindo a clínica médica!");
        System.out.println("Digite seu CPF: ");
    }
}
