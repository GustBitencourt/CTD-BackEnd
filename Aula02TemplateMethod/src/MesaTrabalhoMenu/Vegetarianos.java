package MesaTrabalhoMenu;

public class Vegetarianos extends Cardapio{
    public Vegetarianos(String tipo, double precoBase) {
        super(tipo, precoBase);
    }

    @Override
    public void montar() {
        System.out.println("Embalagem especial para produtos vegetarianos");
    }

    @Override
    public double precoVenda() {
        return getPrecoBase() * 1.01;
    }


}
