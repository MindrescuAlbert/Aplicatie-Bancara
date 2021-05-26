package Repository;

import JDBC.JDBC;
import com.company.Cont;

import java.sql.*;
import java.util.Optional;

public class ContRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Cont" +
                "(id int PRIMARY KEY AUTO_INCREMENT, numeTitular varchar(40), IBAN varchar(40), totalBaniCont double)";

        Connection connection = JDBC.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Prepared Statement
    public void insert(String numeTitular, String IBAN, double totalBaniCont)   {
        String insertContSql = "INSERT INTO Cont(numeTitular, IBAN, totalBaniCont) VALUES(?, ?, ?)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertContSql);
            preparedStatement.setString(1, numeTitular);
            preparedStatement.setString(2, IBAN);
            preparedStatement.setDouble(3, totalBaniCont);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insert(Cont cont)   {
        String insertContSql = "INSERT INTO Cont VALUES(null, ?, ?, ?)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertContSql);
            preparedStatement.setString(1, cont.getNumeTitular());
            preparedStatement.setString(2, cont.getIBAN());
            preparedStatement.setDouble(3, cont.getTotalBaniCont());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public Optional<Cont> getById(int id)   {
        String selectSql = "SELECT * FROM Cont c WHERE c.id = ?";
        Connection connection = JDBC.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCont(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Cont> mapToCont(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id = resultSet.getInt(1);
            String numeTitular = resultSet.getString(2);
            String IBAN = resultSet.getString(3);
            double totalBaniCont = resultSet.getDouble(4);
            return Optional.of(new Cont(id, numeTitular, IBAN, totalBaniCont));
        }
        return Optional.empty();
    }


    public void updateSuma(Double suma, int id) {
        String updateSumaSql = "UPDATE Cont SET totalBaniCont=? WHERE id=?";
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

    public void deleteCont(int id) {
        String deleteContSql = "DELETE FROM Cont WHERE id=?";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteContSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void getAllAccounts() {
        String selectSql = "SELECT * FROM Cont";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1));
                System.out.println("numeTitular: " + resultSet.getString(2));
                System.out.println("IBAN: " + resultSet.getString(3));
                System.out.println("totalBaniCont: " + resultSet.getDouble(4));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
