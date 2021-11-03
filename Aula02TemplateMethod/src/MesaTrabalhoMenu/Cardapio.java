package MesaTrabalhoMenu;

public abstract class Cardapio {
    private String tipo;
    private double precoBase;

    public Cardapio(String tipo, double precoBase) {
        this.tipo = tipo;
        this.precoBase = precoBase;
    }

    public abstract void montar();
    public abstract double precoVenda();

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
