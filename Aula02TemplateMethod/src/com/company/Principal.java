package com.company;

public class Principal {
    public static void main(String[] args) {
        Funcionario funcionario = new FuncionarioEfetivo("Nelson", "Koba", "123", 6000, 850,2500);
        funcionario.pagamentoSalario();

        funcionario = new FuncionarioPJ("Jennifer", "Mayumi", "321", 350, 150);
        funcionario.pagamentoSalario();
    }
}
