package MesaTrabalhoMenu;

public class Infantil extends Cardapio{
    private String brinquedo;
    private double valorBrinquedo;

    public Infantil(String tipo, double precoBase, String brinquedo, double valorBrinquedo) {
        super(tipo, precoBase);
        this.brinquedo = brinquedo;
        this.valorBrinquedo = valorBrinquedo;
    }

    @Override
    public void montar() {
        System.out.println("Produto com o brinde: " + brinquedo);
    }

    @Override
    public double precoVenda() {
        return getPrecoBase() + valorBrinquedo;
    }
}
