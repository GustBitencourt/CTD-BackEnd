package SerieFlix;

public class Serie {
    private String nome;
    private String link;

    public Serie(String nome, String link) {
        this.nome = nome;
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
    }
}
