package MesaTrabalho;

import java.sql.*;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS figuras; " +
            "CREATE TABLE figuras (id INT AUTO_INCREMENT PRIMARY KEY, tipo VARCHAR(30), cor VARCHAR(30))";

    private static final String sqlInsert = "INSERT INTO figuras (tipo, cor) " +
            "VALUES ('Circulo', 'Vermelho'), ('Quadrado', 'Azul'), ('Circulo', 'Amarelo'), ('Quadrado', 'verde'), ('Quadrado', 'Cinza')";

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""
            );
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert);

            ShowFiguras(connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection == null)
                return;

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void ShowFiguras(Connection connection) throws Exception {
        String sqlQuery = "SELECT * from figuras";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
    }
}
