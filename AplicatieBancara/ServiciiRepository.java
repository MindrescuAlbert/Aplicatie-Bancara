package Repository;

import JDBC.JDBC;
import com.company.Servicii;

import java.sql.*;
import java.util.Optional;

public class ServiciiRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Servicii" +
                "(id int PRIMARY KEY AUTO_INCREMENT, numePersoana varchar(40), dataCerere varchar(40))";

        Connection connection = JDBC.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Prepared Statement
    public void insert(String numePersoana, String dataCerere)   {
        String insertServiciuSql = "INSERT INTO Servicii(numePersoana, dataCerere) VALUES(?, ?)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertServiciuSql);
            preparedStatement.setString(1, numePersoana);
            preparedStatement.setString(2, dataCerere);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insert(Servicii Serviciu)   {
        String insertServiciuSql = "INSERT INTO Servicii VALUES(null, ?, ?)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertServiciuSql);
            preparedStatement.setString(1, Serviciu.getNumePersoana());
            preparedStatement.setString(2, Serviciu.getDataCerere());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public Optional<Servicii> getById(int id)   {
        String selectSql = "SELECT * FROM Servicii s WHERE s.id = ?";
        Connection connection = JDBC.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToServicii(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Servicii> mapToServicii(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id = resultSet.getInt(1);
            String numePersoana = resultSet.getString(2);
            String dataCerere = resultSet.getString(3);
            return Optional.of(new Servicii(id, numePersoana, dataCerere));
        }
        return Optional.empty();
    }


    public void updateNume(String nume, int id) {
        String updateNumeSql = "UPDATE Servicii SET nume=? WHERE id=?";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateNumeSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void deleteServiciu(int id) {
        String deleteServiciuSql = "DELETE FROM Servicii WHERE id=?";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteServiciuSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void getAllServices() {
        String selectSql = "SELECT * FROM Servicii";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1));
                System.out.println("NumePersoana: " + resultSet.getString(2));
                System.out.println("dataCerere: " + resultSet.getString(3));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
