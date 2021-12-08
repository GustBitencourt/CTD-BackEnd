package com.dh.medicamentos.Dao.impl;

import com.dh.medicamentos.Dao.ConfiguracaoJDBC;
import com.dh.medicamentos.Dao.IDao;
import com.dh.medicamentos.Model.Medicamento;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicamentoDaoH2 implements IDao<Medicamento> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public MedicamentoDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    //Interfaces

    //Salvar
    public Medicamento salvar(Medicamento medicamento) {
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
            "INSERT INTO medicamentos" +
            "(nome, laboratorio, quantidade, preco) " +
            "VALUES ('%s', '%s', '%s', '%s')",
            medicamento.getNome(),
            medicamento.getLaboratorio(),
            medicamento.getQuantidade(),
            medicamento.getPreco()
        );

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()) {
                medicamento.setId(keys.getInt(1));
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return medicamento;

    }

    //Buscar por ID
    public Medicamento buscar(Integer id) {

        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;

        String query = String.format(
                "SELECT id, nome, laboratorio, quantidade, preco " +
                "FROM medicamentos " +
                "WHERE id = '%s'", id);

        Medicamento medicamento = null;

        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            while(result.next()) {
                medicamento = new Medicamento(
                    result.getInt("id"),
                    result.getNString("nome"),
                    result.getString("laboratorio"),
                    result.getInt("quantidade"),
                    result.getDouble("preco")
                );
            }
            statement.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicamento;
    }


}
