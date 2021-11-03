package ExercicioGerenciamentoEmail;

public class Main {
    public static void main(String[] args) {
        CheckMail check = new CheckMail();
        check.verificar(new Mail("uesley@dh.com", "tecnico@comeia.com", "Teste"));
        check.verificar(new Mail("uesley@dh.com", "gerencia@comeia.com", "Teste"));
        check.verificar(new Mail("uesley@dh.com", "comercial@comeia.com", "Teste"));
        check.verificar(new Mail("uesley@dh.com", "teste@comeia.com", "Teste"));

        System.out.println("\nSegunda rodada de exemplo com assuntos dos departamentos:");
        check.verificar(new Mail("uesley@dh.com", "teste@comeia.com", "gerencial"));
        check.verificar(new Mail("uesley@dh.com", "teste@comeia.com", "comercial"));
        check.verificar(new Mail("uesley@dh.com", "teste@comeia.com", "tecnico"));
        check.verificar(new Mail("uesley@dh.com", "teste@comeia.com", "Teste"));
    }
}
