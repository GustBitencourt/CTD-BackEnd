package ExercicioGerenciamentoEmail;

public class CheckMail {
    Handler initial;

    public CheckMail() {
        this.initial = new DepartamentoGerencial();
        Handler tecnico = new DepartamentoTecnico();
        Handler comercial = new DepartamentoComercial();
        Handler spam = new HandlerSpam();

        initial.setSeguinte(tecnico);
        tecnico.setSeguinte(comercial);
        comercial.setSeguinte(spam);
    }

    public void verificar(Mail email){
        initial.verificar(email);
    }
}
