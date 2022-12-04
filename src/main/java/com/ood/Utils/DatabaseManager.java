package com.ood.Utils;
import com.ood.Users.UserBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    private static DatabaseManager dbManager;
    public DatabaseManager() {
        //url="jdbc:sqlite:sample.db" "jdbc:sqlite:/Users/leo/Desktop/Boston University/CS611/Bank/src/main/resources/test"
        conn(Constants.URL);
    }

    public static DatabaseManager getDbManager() {
        if(dbManager==null)
            dbManager=new DatabaseManager();
        return dbManager;
    }

    public void conn(String url){
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

//            statement.executeUpdate("drop table if exists person");
//            statement.executeUpdate("create table person (id integer, name string)");
//            statement.executeUpdate("insert into person values(1, 'leo')");
//            statement.executeUpdate("insert into person values(2, 'yui')");
//            rs = statement.executeQuery("select * from person");
//            while(rs.next())
//            {
//                // read the result set
//                System.out.println("name = " + rs.getString("name"));
//                System.out.println("id = " + rs.getInt("id"));
//            }
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
    public void creatTransactionDB(){

    }

    public UserBean getUserbean(String userName, String password) {
        userName="\'"+userName+"\'";
        password="\'"+password+"\'";
        String sql = "SELECT * FROM User WHERE username is "
                +userName+" AND password is "+password+";";
        try {
            rs=statement.executeQuery(sql);
            while (rs.next())
            {
                UserBean bean=new UserBean();
                bean.setAdmin(rs.getBoolean("is_admin"));
                bean.setEmail(rs.getString("uid"));
                bean.setFirstName(rs.getString("first_name"));
                bean.setUserName(rs.getString("username"));
                bean.setLastName(rs.getString("last_name"));
                bean.setBirthday(rs.getString("birthday"));
                return bean;
            }

        } catch (SQLException ex) {
            System.exit(-1);
        }
        return null;
    }


    public boolean hasUserBean(UserBean bean) {
        String uid=bean.getEmail();
        uid="\'"+uid+"\'";
        String sql = "SELECT * FROM User WHERE uid is "
                +uid+";";
        try {
            rs=statement.executeQuery(sql);
            while (rs.next())
            {
               return true;
            }

        } catch (SQLException ex) {
            System.exit(-1);
        }
        return false;
    }

    public void insertUserBean(UserBean bean) {
        String username="\'"+ bean.getUserName()+"\'";
        String email= "\'"+bean.getEmail()+"\'";
        String fname= "\'"+bean.getFirstName()+"\'";
        String lname= "\'"+bean.getLastName()+"\'";
        String password= "\'"+bean.getPassword()+"\'";
        String birthday= "\'"+bean.getBirthday()+"\'";
        String isadmin= bean.isAdmin()?"1":"0";

        String sql = "INSERT INTO User" +
                " (uid," +
                "username," +
                "password," +
                "first_name," +
                "last_name," +
                "birthday," +
                "is_admin)\n" +
                "VALUES (" +
                email +","+
                username +","+
                password+","+
                fname +","+
                lname +","+
                birthday +","+
                isadmin +
                ");";
        try {
            statement.execute(sql);

        } catch (SQLException ex) {
            System.exit(-1);
        }
    }
}
