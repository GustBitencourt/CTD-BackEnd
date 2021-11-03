package com.company;

public class FuncionarioPJ extends Funcionario{
    private double valorHora;
    private int horas;

    public FuncionarioPJ(String nome, String sobrenome, String numeroConta, double valorHora, int horas) {
        super(nome, sobrenome, numeroConta);
        this.valorHora = valorHora;
        this.horas = horas;
    }

    @Override
    public double calcularSalario() {
        return valorHora * horas;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Recibo no valor de " + quantia);
    }

    @Override
    public void depositar(double quantia) {
        System.out.println("Depósito no valor de " + quantia);
    }
}
