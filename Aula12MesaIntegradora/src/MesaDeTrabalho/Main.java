package MesaDeTrabalho;

import java.sql.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS funcionarios; " +
            "CREATE TABLE funcionarios (" +
            "id INT NOT NULL PRIMARY KEY, " +
            "primeironome VARCHAR(32) NOT NULL, " +
            "sobrenome VARCHAR(32) NOT NULL, " +
            "idade VARCHAR(32) NOT NULL, " +
            "cpf VARCHAR(11) NOT NULL);";

    private static final String sqlInsert = "INSERT INTO funcionarios " +
            "(id, primeironome, sobrenome, idade, cpf) " +
            "VALUES ( 1, 'Gustavo', 'Gama', 20, '1234'), " +
            "(2, 'João', 'Pedro', 30, '4321'), " +
            "(2, 'Alfredo', 'Macedo', 18, '2134')";

    private static final String sqlInsertCorreto = "INSERT INTO funcionarios " +
            "(id, primeironome, sobrenome, idade, cpf) " +
            "VALUES ( 1, 'Gustavo', 'Gama', 20, '1234'), " +
            "(2, 'João', 'Pedro', 30, '4321'), " +
            "(3, 'Alfredo', 'Macedo', 18, '2134')";

    private static final String sqlUpdate = "UPDATE funcionarios SET idade = 40 WHERE id = 3;";

    private static final String sqlDelete = "DELETE funcionarios WHERE id = 2;";

    private static final String sqlDelete2 = "DELETE funcionarios WHERE primeironome = 'Gustavo';";

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception{

        BasicConfigurator.configure();

        try(Connection connection = getConnection()) {
            Statement statement = connection.createStatement();

            try{
                statement.execute(sqlCreateTable);
                statement.execute(sqlInsert);
            }catch (Exception e) {
                logger.error("Id");
            }
            statement.execute(sqlInsertCorreto);

            statement.execute(sqlUpdate);
            logger.debug("As informações dos ids de funcionários foram atualizadas.");

            statement.execute(sqlDelete);
            logger.info("O funcionario de id numero 2 foi excluido.");

            statement.execute(sqlDelete2);
            logger.info("O funcionario Gustavo foi excluido.");

        }

    }

    public static Connection getConnection() throws Exception {
        String url = "jdbc:h2:tcp://localhost/~/test";
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(url, "sa", "");
    }

}
