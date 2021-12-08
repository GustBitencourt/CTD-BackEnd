package br.com.odontologia.model;

public class Dentista {

    private Integer id;
    private String numeroMatricula;
    private String nome;
    private String sobrenome;

    //Com ID
    public Dentista(Integer id, String numeroMatricula, String nome, String sobrenome) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    //Sem Id

    public Dentista(String numeroMatricula, String nome, String sobrenome) {
        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "id=" + id +
                ", numeroMatricula='" + numeroMatricula + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }
}
