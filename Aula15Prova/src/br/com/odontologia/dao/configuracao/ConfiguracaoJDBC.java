package br.com.odontologia.dao.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;


    //Construtor recebendo parametros
    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    //Construtor configurado
    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/clinica;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        this.nomeUsuario = "sa";
        this.senha = "";
    }

    //Método Conexão BD
    public Connection conectarComBancoDeDados() {
        Connection connection = null;


        try {
            connection = DriverManager.getConnection(jdbcDriver, nomeUsuario, senha);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
