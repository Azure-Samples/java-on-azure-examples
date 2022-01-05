package examples.azure.postgresql.getcountry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetCountry {

    public static void main(String[] arguments) throws Exception {

        Connection connection = DriverManager.getConnection(arguments[0], arguments[1], arguments[2]);
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM countries WHERE abbreviation = ?");
        statement.setString(1, arguments[3]);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("ID: " + resultSet.getLong(1));
            System.out.println("Abbreviation: " + resultSet.getString(2));
            System.out.println("Short name: " + resultSet.getString(3));
            System.out.println("Long name: " + resultSet.getString(4));
        } else {
            System.out.println("Country " + arguments[3] + " not found, please issue a PR to add it :)");
        }
    }
}
