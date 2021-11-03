package com.company;

public class FuncionarioEfetivo extends Funcionario{
    private double salarioBase;
    private double descontos;
    private double bonificacoes;

    public FuncionarioEfetivo(String nome, String sobrenome, String numeroConta, double salarioBase, double descontos, double bonificacoes) {
        super(nome, sobrenome, numeroConta);
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.bonificacoes = bonificacoes;
    }


    @Override
    public double calcularSalario() {
        return salarioBase + bonificacoes - descontos;
    }

    @Override
    public void imprimirRecibo(double quantia) {
        System.out.println("Recibo no valor de: " + quantia);
    }

    @Override
    public void depositar(double quantia) {
        System.out.println("Depósito no valor de " + quantia);
    }
}
