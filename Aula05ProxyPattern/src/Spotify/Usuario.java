package Spotify;

public class Usuario {

    private String nome;
    private String identificador;
    private String tipoUsario;

    public Usuario(String nome, String identificador, String tipoUsario) {
        this.nome = nome;
        this.identificador = identificador;
        this.tipoUsario = tipoUsario;
    }

    public Object[] infoUsuario(){
        Object[] informacao = new Object[2];
        informacao[0] = identificador;
        informacao[1] = tipoUsario;

        return informacao;
    }

}
