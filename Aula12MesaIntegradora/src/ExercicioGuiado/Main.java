package ExercicioGuiado;

import java.sql.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS usuarios; " + "CREATE TABLE usuarios (" +
            "id INT AUTO_INCREMENT PRIMARY KEY," +
            "primeiroNome VARCHAR(32) NOT NULL," +
            "sobrenome VARCHAR(32) NOT NULL," +
            "idade INT NOT NULL," +
            "altura DOUBLE NOT NULL," +
            "matriculado boolean NOT NULL)";

    private static final String sqlInsert = "INSERT INTO usuarios " +
            "(primeironome, sobrenome, idade, altura, matriculado) VALUES " +
            "('Jardel', 'Silva', 24, 1.23, true), ('Gustavo', 'Gama', 25, 1.79, true), ('Renner', 'Almeida', 31, 2.05, false)";

    private static final String sqlDelete = "DELETE FROM usuarios WHERE id = 1";

    //Declaração do logger
    private static final Logger logger = Logger.getLogger(Main.class);

    //Main
    public static void main(String[] args) throws Exception {

        //Configuração do Logging
        BasicConfigurator.configure();

        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert);
            statement.execute(sqlDelete);

            logger.info("Excluindo o usuario com o id 1");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection == null) {
                return;
            } else {
                connection.close();
            }
        }

    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }

}
