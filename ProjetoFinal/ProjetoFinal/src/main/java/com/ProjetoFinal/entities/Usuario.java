package com.ProjetoFinal.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String acesso;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Consulta> consultas = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, String acesso) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getAcesso() {
        return acesso;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }
}
