package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlconnection {
public Connection dataBaseLink;
public Connection getConnection(){
    String databaseName ="schoolManag";
    String url = "jdbc:mysql://./"+databaseName+";integratedSecurity=true";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        dataBaseLink = DriverManager.getConnection(url);
        System.out.println("connection succeeded");

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("connection failed");
    }
return dataBaseLink;
}
/* try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=schoolManag";

        Connection conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement();
        ResultSet resultSet;

        resultSet = statement.executeQuery("SELECT * from student");
        String StId = resultSet.getString("stID");
        String Name = resultSet.getString("sName");
        String lastName = resultSet.getString("slastName");
        String BDay = resultSet.getString("BDay");
        String sclass = resultSet.getString("SClass");
        String email = resultSet.getString("email");
        System.out.println(StId);
        System.out.println(Name);
        System.out.println(lastName);
        System.out.println(BDay);
        System.out.println(sclass);
        System.out.println(email);
        conn.close();
    } catch (Exception e) {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());

    }*/
}
