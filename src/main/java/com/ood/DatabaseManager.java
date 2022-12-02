package com.ood;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    public DatabaseManager(String url) {
        //url="jdbc:sqlite:sample.db"
        conn(url);
    }

    public void conn(String url){
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            rs = statement.executeQuery("select * from person");
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
    }

    private void createTable() {
        String sql = "CREATE TABLE contacts ("
                + "  id integer primary key,"
                + "  firstName VARCHAR,"
                + "  lastName VARCHAR,"
                + "  email VARCHAR,"
                + "  phoneNumber VARCHAR,"
                + "  address VARCHAR,"
                + "  webAddress VARCHAR,"
                + "  notes VARCHAR)";
        try {
            statement.execute(sql);
        } catch (SQLException ex) {
            System.exit(-1);
        }
    }
}
