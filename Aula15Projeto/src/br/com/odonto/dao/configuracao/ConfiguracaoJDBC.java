package br.com.odonto.dao.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senhaUsuario;

    //Contrutor com parametros
    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senhaUsuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    //Construtor configurado
    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/clinica;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'CREATE.SQL'";
        this.nomeUsuario = "sa";
        this.senhaUsuario = "";
    }

    //Método Conexão Banco
    public Connection conectarComBancoDeDados() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senhaUsuario);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
