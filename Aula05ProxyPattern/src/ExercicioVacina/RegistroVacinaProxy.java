package ExercicioVacina;

import java.util.Date;

public class RegistroVacinaProxy implements IRegistro{

    //Proxy que controla se a vacina está na data agendada ou posterior
    @Override
    public void registrar(Object[] dados) {
        if (verificarData((Date)(dados[1]))) {
            RegistroVacina registro = new RegistroVacina();
            registro.registrar(dados);

        } else {
            System.out.println("Não pode vacinar em uma data futura");
        }
    }

    //Verifica se a data é anterior ou igual a atual
    public boolean verificarData(Date data) {
        return data.before(new Date());
    }
}
