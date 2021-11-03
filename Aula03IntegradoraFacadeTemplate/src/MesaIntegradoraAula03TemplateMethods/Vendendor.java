package MesaIntegradoraAula03TemplateMethods;

public abstract class Vendendor {

    public void mostrarCategoria() {
        int pontos = calcularPontos();
        if(pontos < 20) {
            System.out.println("Novato");
        } else if(pontos >= 20 && pontos <= 30) {
            System.out.println("Aprendiz");
        } else if(pontos > 30 && pontos <= 40) {
            System.out.println("Bom");
        } else if(pontos > 40) {
            System.out.println("Mestre");
        }
    }

    public abstract int calcularPontos();

    public abstract int vender();

}
