package MesaTrabalho;


import org.apache.log4j.Logger;
import java.util.ArrayList;

public class Lista {

    private static final Logger logger = Logger.getLogger(Lista.class);

    private ArrayList<Integer> lista = new ArrayList<>();

    public Lista(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    public void verificarLista() throws Exception {
        if (lista.size() >5 && lista.size() < 10) {
            logger.info("O comprimento da lista é maior que 5 itens");
        }

        if (lista.size() > 10) {
            logger.info("O comprimento da lista é maior que 10 itens");
        }

        if (lista.size() > 0) {
            logger.error("A lista não pode ser igual a 0");
            throw new Exception();
        }
    }

    public double calcularMedia (){
        double soma = 0;
        for(int i=0; i<lista.size(); i++) {
            soma += lista.get(i);
        }

        return soma / lista.size();
    }



}
