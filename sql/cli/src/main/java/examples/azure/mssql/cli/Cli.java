package examples.azure.mssql.cli;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cli {

    private String url;
    private String username;
    private String password;
    private String sql;
    private Connection connection;
    
    public static void main(String[] arguments) throws Exception {
        Cli cli = new Cli();
        cli.parseArguments(arguments);
        cli.run();
    }

    public void parseArguments(String[] arguments) {
        for(int i=0; i<arguments.length; i++) {
            if (arguments[i].equals("--url")) {
                this.url = arguments[++i];
            } else if (arguments[i].equals("--username")) {
                this.username = arguments[++i];
            } else if (arguments[i].equals("--password")) {
                this.password = arguments[++i];
            } else if (arguments[i].equals("--sql")) {
                this.sql = arguments[++i];
            }
        }
    }

    public void run() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLServerDriver not found", e);
        }
        if (!url.startsWith("jdbc:")) {
            url = "jdbc:sqlserver://" + url;
        }
        this.connection = DriverManager.getConnection(url, username, password);

        if (sql != null) {
            executeSql(sql);
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
