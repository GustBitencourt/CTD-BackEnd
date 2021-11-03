package MesaTrabalhoFiguras;

public class Circulo extends Figura{
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * 3.14 * raio;
    }


}
