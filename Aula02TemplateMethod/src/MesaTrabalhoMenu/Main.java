package MesaTrabalhoMenu;

public class Main {
    public static void main(String[] args) {
        Cardapio adulto = new Adulto("adulto", 50);
        adulto.getPrecoBase();
        adulto.montar();

        System.out.println("\n----------------------------------------------");

        Cardapio infatil = new Infantil("infatil", 50,"Batman", 10);
        infatil.getPrecoBase();
        infatil.montar();

        System.out.println("\n----------------------------------------------");

        Cardapio vegetariano = new Vegetarianos("vegetariano", 50);
        vegetariano.getPrecoBase();
        vegetariano.montar();

    }
}
