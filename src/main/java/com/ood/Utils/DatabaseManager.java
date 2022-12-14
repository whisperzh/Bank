package com.ood.Utils;
import com.ood.Model.Accounts.AccountBean;
import com.ood.Enums.AccountEnum;
import com.ood.Enums.CurrencyEnum;
import com.ood.Model.Balance.BalanceBean;
import com.ood.Model.Loan.LoanBean;
import com.ood.Model.Stocks.StockBean;
import com.ood.Model.Stocks.UserStock;
import com.ood.Model.Transactions.TransactionBean;
import com.ood.Model.Users.UserBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Query collection of DB
 */
public class DatabaseManager {
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    private static DatabaseManager dbManager;
    public DatabaseManager() {
        //url="jdbc:sqlite:sample.db" "jdbc:sqlite:/Users/leo/Desktop/Boston University/CS611/Bank/src/main/resources/test"
        conn(Constants.URL);
    }

    public static DatabaseManager getInstance() {
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
        String username=strWrap(bean.getUserName());
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

    public AccountBean getAccountBean(String aid){
        AccountBean bean=new AccountBean();
        bean.setAid(aid);
        aid=strWrap(aid);
        String sql = "SELECT * FROM Account WHERE aid is "
                +aid+";";
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
        double amount= bean.getAmount();
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
        double amount= bean.getAmount();
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

    public StockBean getStock(String sid){
        StockBean bean=new StockBean();
        sid=strWrap(sid);
        String sql="SELECT * FROM Stock where sid is "+sid+" ;";
        try{
            rs=statement.executeQuery(sql);
            while (rs.next())
            {
                bean.setCompany(rs.getString("company"));
                bean.setPrice(rs.getDouble("price"));
                bean.setSid(rs.getString("sid"));
                bean.setLast_update_time(rs.getString("last_update_time"));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bean;
    }

    public List<StockBean> getStocks(){
        List<StockBean> beans=new ArrayList<>();
        String sql="SELECT * FROM Stock;";
        try {
            rs=statement.executeQuery(sql);
            while(rs.next())
            {
                StockBean bean=new StockBean(
                        rs.getString("sid"),
                        rs.getString("company"),
                        rs.getDouble("price"),
                        rs.getString("last_update_time")
                );
                beans.add(bean);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return beans;
    }

    public void updateStock(String sid,double price){
        sid=strWrap(sid);
        String datetime=strWrap(Utils.getDateTime());
        String pricestr=Double.toString(price);
        String sql="UPDATE Stock "+
                "SET price ="+
                pricestr+","+
                "last_update_time = "+
                datetime+" "+
                " WHERE "+
                " sid = " +
                sid +
                ";";
        try {
            statement.execute(sql);

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<UserBean> getAllUsers(){
        List<UserBean> user=new ArrayList();
        String sql="SELECT * from User";
        try {
            rs=statement.executeQuery(sql);
            while(rs.next())
            {
                UserBean userbean=new UserBean();
                userbean.setAdmin(rs.getBoolean("is_admin"));
                userbean.setSsn(rs.getString("uid"));
                userbean.setFirstName(rs.getString("first_name"));
                userbean.setUserName(rs.getString("username"));
                userbean.setLastName(rs.getString("last_name"));
                userbean.setBirthday(rs.getString("birthday"));
                user.add(userbean);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /**
     *
     * @param lid the id of certain loan
     */
    public void updateLoan(String lid,boolean isCleared){
        lid=strWrap(lid);
        int clearFlag = (isCleared == true) ? 1 : 0;
        String datetime=strWrap(Utils.getDateTime());
        String sql="UPDATE Loan "+
                "SET clear_date ="+
                datetime+","+
                "is_clear = "+
                clearFlag+" "+
                " WHERE "+
                " lid = " +
                lid +
                ";";
        try {
            statement.execute(sql);

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateBalance(String aid,double changedAmount){
        aid = strWrap(aid);
        double oldAmount = 0.0;
        double newAmount = 0.0;
        int isMoneyAdded = (changedAmount >= 0) ? 1 : 0;
        String sqlQueryAmount="SELECT amount FROM Balance WHERE aid is " +aid+ ";";
        try {
            rs=statement.executeQuery(sqlQueryAmount);
            oldAmount = rs.getDouble("amount");
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(isMoneyAdded == 1){
            newAmount = oldAmount + changedAmount;
        }
        else newAmount = oldAmount - changedAmount;
        String sql="UPDATE Balance "+
                "SET amount ="+
                newAmount+
                " WHERE "+
                " aid = " +
                aid +
                ";";
        try {
            statement.execute(sql);

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String strWrap(String str){
        return "\'"+str+"\'";
    }


    public UserBean getUserbean(String uid) {
        uid=strWrap(uid);
        String sql = "SELECT * FROM User WHERE uid is "+
                uid+";";
        try
        {
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

    public void deletAccount(String aid) {
    }

    public List<BalanceBean> getBalanceBean(String aid) {
        List<BalanceBean> ans=new ArrayList();
        aid=strWrap(aid);
        String sql="SELECT * FROM Balance WHERE aid is "+aid+";";
        try {
            rs=statement.executeQuery(sql);
            while(rs.next())
            {
                BalanceBean bean=new BalanceBean();
                bean.setAid(rs.getString("aid"));
                bean.setAmount(rs.getDouble("amount"));
                bean.setCurrencyEnum(CurrencyEnum.toType(rs.getString("currency")));
                ans.add(bean);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }

    public void insertUserStock(UserStock userStock) {
        String aid=strWrap(userStock.getAid());
        String sid=strWrap(userStock.getSid());
        String datetime=strWrap(userStock.getStock_buy_time());
        Double proportion=userStock.getProportion();
        String sql = "INSERT INTO UserStock" +
                " (aid," +
                "sid," +
                "proportion," +
                "buy_date)\n" +
                "VALUES (" +
                aid + "," +
                sid + "," +
                proportion + "," +
                datetime +
                ");";
        try {
            statement.execute(sql);

        } catch (SQLException ex) {
            System.exit(-1);
        }
    }

    public UserStock getSpecificUserStock(String aid, String sid){
        UserStock stock = new UserStock();
        String sql="SELECT * FROM UserStock WHERE aid is "
                +aid+" AND sid is "+sid+";";
        try {
            rs=statement.executeQuery(sql);
            while(rs.next())
            {
                stock.setAid(rs.getString("aid"));
                stock.setSid(rs.getString("sid"));
                stock.setProportion(rs.getDouble("proportion"));
                stock.setStock_buy_time(rs.getString("buy_date"));
                stock.setLast_update_time(rs.getString("last_updated"));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stock;
    }

    public List<UserStock> getUserStocks(String aid){
        List<UserStock> stocks=new ArrayList();
        String sql="SELECT * FROM UserStock WHERE aid is "
                +aid+";";
        try {
            rs=statement.executeQuery(sql);
            while(rs.next())
            {
                UserStock stock=new UserStock();
                stock.setAid(rs.getString("aid"));
                stock.setSid(rs.getString("sid"));
                stock.setProportion(rs.getDouble("proportion"));
                stock.setStock_buy_time(rs.getString("buy_date"));
                stock.setLast_update_time(rs.getString("last_updated"));
                stocks.add(stock);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stocks;
    }

    public List<UserStock> getAllUserStocks(){
        List<UserStock> stocks=new ArrayList();
        String sql="SELECT * FROM UserStock;";
        try {
            rs=statement.executeQuery(sql);
            while(rs.next())
            {
                UserStock stock=new UserStock();
                stock.setAid(rs.getString("aid"));
                stock.setSid(rs.getString("sid"));
                stock.setProportion(rs.getDouble("proportion"));
                stock.setStock_buy_time(rs.getString("buy_date"));
                stock.setLast_update_time(rs.getString("last_updated"));
                stocks.add(stock);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return stocks;
    }

    public void updateUserStock(String aid, String sid, Double proportion){
        UserStock stock = new UserStock();
        Double newProportion;
        Double oldProportion = 0.0;
        String sql="SELECT * FROM UserStock WHERE aid is "
                +aid+" AND sid is "+sid+";";
        int isProportionAdded = (proportion >= 0) ? 1 : 0;
        String currentDate=strWrap(Utils.getDateTime());
        try {
            rs = statement.executeQuery(sql);
            while(rs.next())
            {
                stock.setAid(rs.getString("aid"));
                stock.setSid(rs.getString("sid"));
                oldProportion = rs.getDouble("proportion");
                stock.setStock_buy_time(rs.getString("buy_date"));
                stock.setLast_update_time(rs.getString("last_updated"));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        if(isProportionAdded == 1){
            newProportion = oldProportion + proportion;
        }
        else newProportion = oldProportion - proportion;
        String sqlUpdate="UPDATE UserStock "+
                "SET proportion ="+
                newProportion+
                "last_updated ="+
                currentDate+
                " WHERE "+
                " aid = " +
                aid +
                " and sid = " +
                sid +
                ";";
        try {
            statement.execute(sqlUpdate);

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<UserBean> getAllUserByLoanDescend(){
        List<UserBean> ans=new ArrayList<>();
        String sql = "SELECT User.uid, User.username, User.first_name, User.last_name, User.birthday, User.is_admin, User.phone_number FROM User,Loan WHERE User.uid = Loan.uid and Loan.is_clear == 0 GROUP BY User.uid, User.username ORDER BY SUM(Loan.amount) DESC;";
        try {
            rs = statement.executeQuery(sql);
            while(rs.next())
            {
                UserBean userbean=new UserBean();
                userbean.setAdmin(rs.getBoolean("is_admin"));
                userbean.setSsn(rs.getString("uid"));
                userbean.setFirstName(rs.getString("first_name"));
                userbean.setLastName(rs.getString("last_name"));
                userbean.setUserName(rs.getString("username"));
                userbean.setBirthday(rs.getString("birthday"));
                ans.add(userbean);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ans;
    }
}
