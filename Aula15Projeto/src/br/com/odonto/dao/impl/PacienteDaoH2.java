package br.com.odonto.dao.impl;

import br.com.odonto.dao.IDao;
import br.com.odonto.dao.configuracao.ConfiguracaoJDBC;
import br.com.odonto.model.Paciente;
import br.com.odonto.util.Util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class PacienteDaoH2 implements IDao<Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public PacienteDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        paciente.setEndereco(enderecoDaoH2.salvar(paciente.getEndereco()));

        String query = String.format(
                "INSERT INTO paciente (nome, sobrenome, rg, data_Cadastro, endereco_id) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s'",
                paciente.getNome(),
                paciente.getSobrenome(),
                paciente.getRg(),
                Util.dateToTimestamp(paciente.getDataCadastro()),
                paciente.getEndereco().getId()
        );
    }

    //BUscar



    //Excluir


    //Buscar Todos


    //CriarObjeto


}
