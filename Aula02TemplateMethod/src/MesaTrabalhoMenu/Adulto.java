package MesaTrabalhoMenu;

public class Adulto extends Cardapio{

    public Adulto(String tipo, double precoBase) {
        super(tipo, precoBase);
    }

    @Override
    public void montar() {
        System.out.println("Combo Normal");
    }

    @Override
    public double precoVenda() {
        return getPrecoBase();
    }


}
