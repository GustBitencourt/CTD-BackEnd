package ExercicioGerenciamentoEmail;

public class HandlerSpam extends Handler{

    @Override
    public void verificar(Mail email) {
        System.out.println("Marcado ao SPAM");
    }
}
