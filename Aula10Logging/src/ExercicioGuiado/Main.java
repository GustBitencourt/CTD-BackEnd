package ExercicioGuiado;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        //Arquivo de configuração do Logger
        BasicConfigurator.configure();
        Leao leao = new Leao("Leo", 4,true);
        leao.correr();


        try {
            leao.ehMaiorQueDez();
        } catch (Exception e) {
            logger.error("A idade do leão " + leao.getNome() + "está incorreta", e);
        }


        Leao leao2 = new Leao("Koba", -5,false);
        leao2.correr();

        try {
            leao2.ehMaiorQueDez();
        } catch (Exception e) {
            logger.error("A idade do leão " + leao2.getNome() + "está incorreta", e);
        }



    }
}
