package org.example.jdbc;

import java.sql.*;

public class JdbcTest {
    private static void printStaff() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(
                   "Select st1.*, st2.name cName, st2.firstName cFirstName " +
                    "from staff st1 left join staff st2 on st1.chief = st2.id order by name");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name =  resultSet.getString("name");
                String firstName = resultSet.getString("firstName");
                String chiefName = resultSet.getString("cName");
                String cFirstName = resultSet.getString("cFirstName");
                String chief = chiefName == null ? "--" : chiefName + " " + cFirstName;
                System.out.format("%s %s; начальник: %s%n", name, firstName, chief);
            }
        }
    }
    public static void main(String[] args) throws SQLException {
        try {
            printStaff();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        JdbcUtils.getConnection().close();
    }
}
