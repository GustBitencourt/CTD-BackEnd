package br.com.odontologia.dao.impl;

import br.com.odontologia.dao.IDao;
import br.com.odontologia.dao.configuracao.ConfiguracaoJDBC;
import br.com.odontologia.model.Endereco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnderecoDaoH2 implements IDao<Endereco> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public EnderecoDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    // Método salvar
    @Override
    public Endereco salvar(Endereco endereco) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String querySalvar = String.format(
                "INSERT INTO endereco " +
                        "(rua, numero, bairro, cidade) " +
                        "VALUES ('%s', '%s', '%s', '%s')",
                endereco.getRua(), endereco.getNumero(),
                endereco.getBairro(), endereco.getCidade());

        try {
            statement = conexao.createStatement();
            statement.executeUpdate(querySalvar, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                endereco.setId(keys.getInt(1));
            statement.close();
            conexao.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    // Método buscar
    @Override
    public Optional<Endereco> buscar(Integer id) {

        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "SELECT id, rua, numero, cidade, bairro " +
                        "FROM endereco " +
                        "WHERE id = '%s'", id);
        Endereco endereco = null;
        try {
            statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(query);

            while (resultado.next()){
                endereco = criarObjetoEndereco(resultado);
            }
            statement.close();
            conexao.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        // Aqui um IF reduzido
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }


    // Método excluir
    @Override
    public void excluir(Integer id) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
                "DELETE FROM endereco WHERE id = '%s'", id);
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
    public List<Endereco> buscarTodos() {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = "SELECT * FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();
        try {
            statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                enderecos.add(criarObjetoEndereco(result));
            }
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return enderecos;
    }

    //Criar Objeto endereco
    private Endereco criarObjetoEndereco(ResultSet resultado) throws SQLException {
        Integer id = resultado.getInt("id");
        String rua = resultado.getString("rua");
        String numero = resultado.getString("numero");
        String bairro = resultado.getString("bairro");
        String cidade = resultado.getString("cidade");
        return new Endereco(id, rua, numero, bairro, cidade);
    }




}
