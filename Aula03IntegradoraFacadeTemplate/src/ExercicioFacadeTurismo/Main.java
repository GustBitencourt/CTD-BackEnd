package ExercicioFacadeTurismo;

public class Main {
    public static void main(String[] args) {

        System.out.println("--------Primeiro cliente----------");
        //Criando primeiro cliente
        ICheckFacade cliente1 = new CheckFacade();
        //buscas do primeiro cleinte
        cliente1.buscar("19/10/2021", "10/12/2021", "São Paulo", "Salvador");

        System.out.println("\n-----------Segundo cliente------------");
        //segundo cliente
        ICheckFacade cliente2 = new CheckFacade();
        //buscas do segundo cleinte
        cliente2.buscar("25/10/2021", "1/12/2021", "Salvador", "São Paulo");
    }
}
