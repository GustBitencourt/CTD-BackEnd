package ExercicioGuiado;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

    private String nome;
    private String sobrenome;
    LocalDate idade;
    private String email;

    public Pessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
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

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public String calcularNomeInteiro() {
        return this.nome + " " + this.sobrenome;
    }

    public boolean ehMaiorIdade() {
        return Period.between(this.idade, LocalDate.of(2021,10,25)).getYears() > 18;
    }
}
