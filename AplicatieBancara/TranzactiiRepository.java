package Repository;

import JDBC.JDBC;
import com.company.Tranzactii;

import java.sql.*;
import java.util.Optional;

public class TranzactiiRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Tranzactii" +
                "(id int PRIMARY KEY AUTO_INCREMENT, tipTranzactie varchar(40), dataTranzactie varchar(40), suma double)";

        Connection connection = JDBC.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Prepared Statement
    public void insert(String tipTranzactie, String dataTranzactie, double suma)   {
        String insertTranzactieSql = "INSERT INTO Tranzactii(tipTranzactie, dataTranzactie, suma) VALUES(?, ?, ?)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertTranzactieSql);
            preparedStatement.setString(1, tipTranzactie);
            preparedStatement.setString(2, dataTranzactie);
            preparedStatement.setDouble(3, suma);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insert(Tranzactii Tranzactie)   {
        String insertTranzactieSql = "INSERT INTO Tranzactii VALUES(null, ?, ?, ?)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertTranzactieSql);
            preparedStatement.setString(1, Tranzactie.getTipTranzactie());
            preparedStatement.setString(2, Tranzactie.getDataTranzactie());
            preparedStatement.setDouble(3, Tranzactie.getSuma());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public Optional<Tranzactii> getById(int id)   {
        String selectSql = "SELECT * FROM Tranzactii t WHERE t.id = ?";
        Connection connection = JDBC.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToTranzactii(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Tranzactii> mapToTranzactii(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id = resultSet.getInt(1);
            String tipTranzactie = resultSet.getString(2);
            String dataTranzactie = resultSet.getString(3);
            double suma = resultSet.getDouble(4);
            return Optional.of(new Tranzactii(id, tipTranzactie, dataTranzactie, suma));
        }
        return Optional.empty();
    }


    public void updateSuma(Double suma, int id) {
        String updateSumaSql = "UPDATE Tranzactii SET suma=? WHERE id=?";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSumaSql);
            preparedStatement.setDouble(1, suma);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void deleteTranzactie(int id) {
        String deleteTranzactieSql = "DELETE FROM Tranzactii WHERE id=?";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteTranzactieSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
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
                System.out.println("In cont au ramas: " + resultSet.getDouble(4));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
