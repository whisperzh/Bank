package com.ood.Utils;
import com.ood.Accounts.AccountBean;
import com.ood.Enums.AccountEnum;
import com.ood.Enums.CurrencyEnum;
import com.ood.Loan.LoanBean;
import com.ood.Transactions.Transaction;
import com.ood.Transactions.TransactionBean;
import com.ood.Users.UserBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                bean.setSsn(rs.getString("uid"));
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
        String uid=bean.getSsn();
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
        String email= "\'"+bean.getSsn()+"\'";
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

    public AccountBean getAccountBean(String uid,String email){
        AccountBean bean=new AccountBean();
        bean.setUid(uid);
        bean.setEmail(email);
        uid="\'"+uid+"\'";
        email="\'"+email+"\'";
        String sql = "SELECT * FROM Account WHERE uid is "
                +uid+" AND email is "+email+";";
        try {
            rs=statement.executeQuery(sql);
            while (rs.next())
            {
                bean.setAid(rs.getString("aid"));
                bean.setAccountEnum(AccountEnum.StringtoType(rs.getString("type")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<AccountBean> getUsersAccounts(String uid){
        List<AccountBean> ans=new ArrayList();
        uid=strWrap(uid);
        String sql = "SELECT * FROM Account WHERE uid is "
                +uid+";";
        try {
            rs=statement.executeQuery(sql);
            while (rs.next())
            {
                AccountBean bean=new AccountBean();
                bean.setUid(rs.getString("uid"));
                bean.setAid(rs.getString("aid"));
                bean.setAccountEnum(AccountEnum.StringtoType(rs.getString("type")));
                bean.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public void insertAccountBean(AccountBean bean) {
        String uid="\'"+ bean.getUid()+"\'";
        String email= "\'"+bean.getEmail()+"\'";
        String aid= "\'"+bean.getAid()+"\'";
        String accountType="\'"+bean.getAccountEnum().toString()+"\'";

        String sql = "INSERT INTO Account" +
                " (aid," +
                "uid," +
                "type," +
                "email)\n" +
                "VALUES (" +
                aid +","+
                uid +","+
                accountType+","+
                email+
                ");";
        try {
            statement.execute(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<TransactionBean> getTransactionBean(String uid)
    {
        List<TransactionBean>  ans=new ArrayList<>();
        String sql="";
        try {
            rs=statement.executeQuery(sql);
            while (rs.next())
            {
                TransactionBean bean=new TransactionBean();
                bean.setTid(rs.getString("tid"));
                bean.setAmount(rs.getFloat("amount"));
                bean.setCurrencyEnum(CurrencyEnum.toType(rs.getString("currency")));
                bean.setTimeStamp(rs.getString("datetime"));
                bean.setFrom_uid(rs.getString("from_uid"));
                bean.setTo_uid(rs.getString("to_uid"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
    public void insertTransactionBean(TransactionBean bean){
        String tid=strWrap(bean.getTid());
        String from_uid=strWrap(bean.getFrom_uid());
        String to_uid=strWrap(bean.getTo_uid());
        float amount= bean.getAmount();
        String currencyEnum=strWrap(bean.getCurrencyEnum().toString());
        String timeStamp=strWrap(bean.getTimeStamp());

        String sql = "INSERT INTO Account" +
                " (tid," +
                "from_uid," +
                "to_uid," +
                "amount" +
                "currency"+
                "datetime"+
                ")\n" +
                "VALUES (" +
                tid +","+
                from_uid +","+
                to_uid+","+
                amount+","+
                currencyEnum+","+
                timeStamp+
                ");";
        try {
            statement.execute(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<LoanBean> getLoanBean(String uid){
        uid=strWrap(uid);
        List<LoanBean> ans=new ArrayList();
        String sql="SELECT * FROM Loan where uid is "+uid+" ;";
        try{
            rs=statement.executeQuery(sql);
            while (rs.next())
            {
                LoanBean bean=new LoanBean();
                bean.setLid(rs.getString("lid"));
                bean.setLid(rs.getString("uid"));
                bean.setCurrencyEnum(CurrencyEnum.toType(rs.getString("currency")));
                bean.setAmount(rs.getFloat("amount"));
                bean.setDate(rs.getString("date"));
                bean.setIs_clear(rs.getBoolean("is_clear"));
                bean.setClear_date(rs.getString("clear_date"));
                ans.add(bean);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public void insertLoanBean(LoanBean bean){
        String lid=strWrap(bean.getLid());
        String uid=strWrap(bean.getUid());
        float amount= bean.getAmount();
        String currencyEnum=strWrap(bean.getCurrencyEnum().toString());
        String date = strWrap(bean.getDate());
        String is_clear=bean.isIs_clear()?"1":"0";;

        String sql = "INSERT INTO Loan" +
                " (lid," +
                "uid," +
                "currency," +
                "amount," +
                "date,"+
                "is_clear"+
                ")" +
                "VALUES (" +
                lid +","+
                uid +","+
                currencyEnum+","+
                amount+","+
                date+","+
                is_clear+
                ");";
        try {
            statement.execute(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String strWrap(String str){
        return "\'"+str+"\'";
    }

}
