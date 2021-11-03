package ExercicioGerenciamentoEmail;

public class DepartamentoGerencial extends Handler{

    @Override
    public void verificar(Mail email) {
        if ((email.getDestino().equalsIgnoreCase("gerencia@comeia.com")) || (email.getAssunto().equalsIgnoreCase("gerencia"))) {
            System.out.println("Enviado ao gerencial");

        } else {
            if(this.getSeguinte() != null) {
                this.getSeguinte().verificar(email);
            }
        }

    }
}
