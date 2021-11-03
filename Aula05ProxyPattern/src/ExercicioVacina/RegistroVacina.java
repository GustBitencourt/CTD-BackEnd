package ExercicioVacina;

public class RegistroVacina implements IRegistro{

    @Override
    public void registrar(Object[] dados) {
        System.out.println("Foi registrado o Rg:" + dados[0] + " na data " + dados[1].toString());
    }
}
