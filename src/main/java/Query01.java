import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
            There are 5 steps to connect any java application with the database using JDBC. These steps are as follows:
            Register the Driver class
            Create connection
            Create statement
            Execute queries
            Close connection
         */

        //1) Driver Tanımla
        //The forName() method of Class class is used to register the driver class. This method is used to dynamically load the driver class.
        Class.forName("org.postgresql.Driver");

        /*
            Note: Since JDBC 4.0, explicitly registering the driver is optional.
            We just need to put vender's Jar in the classpath,
            and then JDBC driver manager can detect and load the driver automatically.
         */

        //2) Database'e Bağlan
        //The getConnection() method of DriverManager class is used to establish connection with the database.
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "My22981453.");
        /*
            "jdbc:postgresql://localhost:5432/jdbc"==> jdbc is the API, postgresql is the database
                                                       localhost is the server name on which postgresql is running, we may also use IP address
                                                       5432 is the port number
                                                       jdbc, postgresql üzerinde islem yapmak istedigimiz DB'nin adi
            Username: The default username (für postgresql is "postgres", für Oracle is "system", für mysql is "root")
                      Bu isim degistirilebilir
            Password: It is the password given by the user at the time of installing the oracle database.
         */

        //3) Statement
        //The createStatement() method of Connection interface is used to create statement.
        // The object of statement is responsible to execute queries with the database.
        Statement st = con.createStatement();

        //4) ResultSet
        //The executeQuery() method of Statement interface is used to execute queries to the database.
        //This method returns the object of ResultSet that can be used to get all the records of a table.
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //5) Dataları Al
        while( veri.next()){
            System.out.println(
                    veri.getInt(1)
                            + veri.getString(2)
                            + veri.getString(3)
                            + veri.getString(4));
        }

        //Bağlantıları Kapatma
        //By closing connection object statement and ResultSet will be closed automatically.
        //The close() method of Connection interface is used to close the connection.
        /*
            Note: Since Java 7, JDBC has ability to use try-with-resources statement
            to automatically close resources of type Connection, ResultSet, and Statement.
         */
        con.close();
        st.close();
        veri.close();
    }
}