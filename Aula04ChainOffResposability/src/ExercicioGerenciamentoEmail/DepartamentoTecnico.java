package ExercicioGerenciamentoEmail;

public class DepartamentoTecnico extends Handler{
    @Override
    public void verificar(Mail email) {
        if ((email.getDestino().equalsIgnoreCase("tecnico@comeia.com")) || (email.getAssunto().equalsIgnoreCase("tecnico"))) {
            System.out.println("Enviado ao tecnico");

        } else {
            if(this.getSeguinte() != null) {
                this.getSeguinte().verificar(email);
            }
        }

    }
}
