package Repository;

import JDBC.JDBC;
import com.company.Carduri;

import java.sql.*;
import java.util.Optional;

public class CarduriRepository {

    public void createTable() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS Carduri" +
                "(id int PRIMARY KEY AUTO_INCREMENT, numarCard varchar(40), numeDetinator varchar(40), CVV varchar(40), " +
                "dataExpirare varchar(40), id_cont int)";

        Connection connection = JDBC.getDatabaseConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Prepared Statement
    public void insert(String numarCard, String numeDetinator, String CVV, String dataExpirare, int id_cont)   {
        String insertCarduriSql = "INSERT INTO Carduri(numarCard, numeDetinator, CVV, dataExpirare, id_cont) VALUES(?, ?, ?, ?, ?)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertCarduriSql);
            preparedStatement.setString(1, numarCard);
            preparedStatement.setString(2, numeDetinator);
            preparedStatement.setString(3, CVV);
            preparedStatement.setString(4, dataExpirare);
            preparedStatement.setInt(5, id_cont);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void insert(Carduri carduri)   {
        String insertCarduriSql = "INSERT INTO Carduri VALUES(null, ?, ?, ?, ?, ?)";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertCarduriSql);
            preparedStatement.setString(1, carduri.getNumarCard());
            preparedStatement.setString(2, carduri.getNumeDetinator());
            preparedStatement.setString(3, carduri.getCVV());
            preparedStatement.setString(4, carduri.getDataExpirare());
            preparedStatement.setInt(5, carduri.getId_cont());
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public Optional<Carduri> getById(int id)   {
        String selectSql = "SELECT * FROM Carduri c WHERE c.id = ?";
        Connection connection = JDBC.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCarduri(resultSet);
        } catch (SQLException e)    {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<Carduri> mapToCarduri(ResultSet resultSet) throws SQLException  {
        if(resultSet.next())    {
            int id = resultSet.getInt(1);
            String numarCard = resultSet.getString(2);
            String numeDetinator = resultSet.getString(3);
            String CVV = resultSet.getString(4);
            String dataExpirare = resultSet.getString(5);
            int id_cont = resultSet.getInt(6);
            return Optional.of(new Carduri(id, numarCard, numeDetinator, CVV, dataExpirare, id_cont));
        }
        return Optional.empty();
    }


    public void updateData(String data, int id) {
        String updateDataSql = "UPDATE Carduri SET dataExpirare=? WHERE id=?";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateDataSql);
            preparedStatement.setString(1, data);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void deleteCard(int id) {
        String deleteCardSql = "DELETE FROM Carduri WHERE id=?";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteCardSql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e)    {
            e.printStackTrace();
        }
    }

    public void getAllCards() {
        String selectSql = "SELECT * FROM Carduri";
        Connection connection = JDBC.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while(resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1));
                System.out.println("numarCard: " + resultSet.getString(2));
                System.out.println("numeDetinator: " + resultSet.getString(3));
                System.out.println("CVV: " + resultSet.getString(4));
                System.out.println("dataExpirare: " + resultSet.getString(5));
                System.out.println("id_cont: " + resultSet.getInt(6));
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
