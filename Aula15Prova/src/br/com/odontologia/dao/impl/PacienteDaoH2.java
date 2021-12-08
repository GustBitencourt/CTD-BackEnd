package br.com.odontologia.dao.impl;

import br.com.odontologia.dao.IDao;
import br.com.odontologia.dao.configuracao.ConfiguracaoJDBC;
import br.com.odontologia.model.Endereco;
import br.com.odontologia.model.Paciente;
import br.com.odontologia.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteDaoH2 implements IDao<Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC;
    private EnderecoDaoH2 enderecoDaoH2;

    public PacienteDaoH2(EnderecoDaoH2 enderecoDaoH2) {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDaoH2 = enderecoDaoH2;
    }


    //Método para Salvar Paciente
    @Override
    public Paciente salvar(Paciente paciente) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        paciente.setEndereco(enderecoDaoH2.salvar(paciente.getEndereco()));

        String querySalvar = String.format(
                "INSERT INTO pciente (nome, sobrenome, rg, data_cadastro, endereco_id) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s')",
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getRg(),
                Util.dateToTimestamp(paciente.getDataCadastro()),
                paciente.getEndereco().getId());

        try {
            statement = conexao.createStatement();
            statement.executeUpdate(querySalvar, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if(keys.next())
                paciente.setId(keys.getInt(1));
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    //Método para Buscar Paciente
    @Override
    public Optional<Paciente> buscar(Integer id) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String queryBuscar = String.format(
                "SELECT id, nome, sobrenome, rg, data_cadastro, endereco_id " +
                        "FROM paciente " +
                        "WHERE id = '%s'", id);

        Paciente paciente = null;

        try {
            statement = conexao.createStatement();
            ResultSet resultado =statement.executeQuery(queryBuscar);

            while (resultado.next()) {
                paciente = criarObjetoPaciente(resultado);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente != null ? Optional.of(paciente) : Optional.empty();
    }

    //Método para EXCLUIR Paciente
    @Override
    public void excluir(Integer id) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String queryExcluir = String.format(
            "DELETE FROM paciente WHERE id = '%s'", id);

        try {
            statement = conexao.createStatement();
            statement.executeUpdate(queryExcluir);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Método para BUSCAR TODOS os pacientes
    @Override
    public List<Paciente> buscarTodos() {

        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String queryBuscarTodos = "SELECT * FROM paciente";
        List<Paciente> pacientes = new ArrayList<>();

        try {
            statement = conexao.createStatement();
            ResultSet resultado = statement.executeQuery(queryBuscarTodos);
            while (resultado.next()) {
                pacientes.add(criarObjetoPaciente(resultado));
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    //CRIANDO OBJETO PACIENTE
    private Paciente criarObjetoPaciente(ResultSet resultado) throws SQLException {
        Integer idPaciente = resultado.getInt("id");
        String nome = resultado.getString("nome");
        String sobrenome = resultado.getString("sobrenome");
        String rg = resultado.getString("rg");
        Date dataCadastro = resultado.getDate("data_cadastro");
        Endereco endereco = enderecoDaoH2.buscar(
                resultado.getInt("endereco_id")).orElse(null);
        return new Paciente(idPaciente, nome, sobrenome, rg, dataCadastro, endereco);
    }
}
