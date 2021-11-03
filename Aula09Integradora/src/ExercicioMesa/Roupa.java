package ExercicioMesa;

public class Roupa {
    private String tamanho;
    private String tipo;
    private boolean ehNova;
    private boolean importada;
    private int contador;

    public Roupa(String tamanho, String tipo, boolean ehNova, boolean importada) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        this.ehNova = ehNova;
        this.importada = importada;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEhNova() {
        return ehNova;
    }

    public void setEhNova(boolean ehNova) {
        this.ehNova = ehNova;
    }

    public boolean isImportada() {
        return importada;
    }

    public void setImportada(boolean importada) {
        this.importada = importada;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


}
