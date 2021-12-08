package br.com.odontologia.dao.impl;

import br.com.odontologia.dao.IDao;
import br.com.odontologia.dao.configuracao.ConfiguracaoJDBC;
import br.com.odontologia.model.Dentista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DentistaDaoH2 implements IDao<Dentista> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public DentistaDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    // Método salvar
    @Override
    public Dentista salvar(Dentista dentista) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String querySalvar = String.format(
                "INSERT INTO dentista " +
                        "(numero_matricula, nome, sobrenome) " +
                        "VALUES ('%s', '%s', '%s')",
        dentista.getNumeroMatricula(), dentista.getNome(), dentista.getSobrenome());


        try {
            statement = conexao.createStatement();
            statement.executeUpdate(querySalvar, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                dentista.setId(keys.getInt(1));
            statement.close();
            conexao.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return dentista;
    }

    // Método buscar
    @Override
    public Optional<Dentista> buscar(Integer id) {

        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "SELECT id, numero_matricula, nome, sobrenome " +
                        "FROM dentista " +
                        "WHERE id = '%s'", id);
        Dentista dentista = null;
        try {
            statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(query);

            while (resultado.next()){
                dentista = criarObjetoDentista(resultado);
            }
            statement.close();
            conexao.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        // Aqui um IF reduzido
        return dentista != null ? Optional.of(dentista) : Optional.empty();
    }

    // Método excluir
    @Override
    public void excluir(Integer id) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "DELETE FROM dentista WHERE id = '%s'", id);
        try {
            statement = conexao.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método buscarTodos
    @Override
    public List<Dentista> buscarTodos() {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = "SELECT * FROM dentista";
        List<Dentista> dentistas = new ArrayList<>();
        try {
            statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                dentistas.add(criarObjetoDentista(result));
            }
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return dentistas;
    }

    //Objeto Dentista
    private Dentista criarObjetoDentista(ResultSet resultado) throws SQLException {
        Integer id = resultado.getInt("id");
        String numeroMatricula = resultado.getString("rua");
        String nome = resultado.getString("numero");
        String sobrenome = resultado.getString("bairro");
        return new Dentista(id, numeroMatricula, nome, sobrenome);
    }


}
