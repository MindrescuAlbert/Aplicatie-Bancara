package JDBC;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetUpDataUsingStatement {

    public void createTable(String numeTabel) {
        String createTableSql = "CREATE TABLE IF NOT EXISTS " + numeTabel +
                "(id int PRIMARY KEY AUTO_INCREMENT, tipTranzactie varchar(40), dataTranzactie varchar(40), suma double)";

        Connection connection = JDBC.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addTranzactie() {
        String insertTranzactieSql = "INSERT INTO Tranzactii(tipTranzactie, dataTranzactie, suma) VALUES ('Merge', 'Azi', 100)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertTranzactieSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getAllTranzactions() {
        String selectSql = "SELECT * FROM Tranzactii";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1));
                System.out.println("tipTranzactie: " + resultSet.getString(2));
                System.out.println("dataTranzactie: " + resultSet.getString(3));
                System.out.println("suma: " + resultSet.getDouble(4));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
