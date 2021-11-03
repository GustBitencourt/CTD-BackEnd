package ExercicioVacina;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //escolhendo data vacinação
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,9,21);

        //pegando hora
        Date date = calendar.getTime();

        //criando pessoa
        Pessoa pessoa = new Pessoa("Gustavo", "Gama", "123", "Coronavac", date);

        //registro da vacina pelo
        IRegistro registro = new RegistroVacinaProxy();
        registro.registrar(pessoa.dados());

    }
}
