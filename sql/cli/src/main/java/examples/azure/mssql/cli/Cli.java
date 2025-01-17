package examples.azure.mssql.cli;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cli {

    private Connection connection;
    private String[] arguments;

    public Cli(String[] arguments) throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLServerDriver not found", e);
        }
        String url = arguments[0];
        if (!url.startsWith("jdbc:")) {
            url = "jdbc:sqlserver://" + url;
        }
        this.connection = DriverManager.getConnection(url, arguments[1], arguments[2]);
        this.arguments = arguments;
    }

    public static void main(String[] arguments) throws Exception {
        Cli cli = new Cli(arguments);
        cli.run();
    }

    public void run() throws Exception {
        if (arguments.length > 3) {
            executeSql(arguments[3]);
        } else {
            boolean interactive = true;
            if (interactive) {
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(System.in));
                boolean exit = false;
                do {
                    System.out.print(">> ");
                    String sql = reader.readLine();
                    if ("/exit".equalsIgnoreCase(sql.trim())) {
                        exit = true;
                        continue;
                    }
                    executeSql(sql);
                } while (!exit);
            }
        }
    }

    private void executeSql(String sql) {
        try {
            Statement statement = connection.createStatement();
            boolean hasResultSet = statement.execute(sql);
            if (hasResultSet) {
                ResultSet resultSet = statement.getResultSet();
                if (resultSet != null) {
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
                    }
                    System.out.println();
                    
                    boolean hasResults = false;
                    while(resultSet.next()) {
                        hasResults = true;
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                    if (!hasResults) {
                        System.out.println("no results");
                    }
                } else {
                    System.out.println("no results");
                }
            } else {
                int updateCount = statement.getUpdateCount();
                if (updateCount == -1) {
                    System.out.println("Statement executed successfully.");
                } else {
                    System.out.println("Statement executed successfully, " + updateCount + " rows affected.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing statement: " + e.getMessage());
        }
    }
}
