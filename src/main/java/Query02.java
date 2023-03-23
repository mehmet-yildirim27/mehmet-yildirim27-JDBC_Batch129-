import java.sql.*;

public class Query02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1) Driver Tanımla
        Class.forName("org.postgresql.Driver");

        //2) Database'e Bağlan



     /*
          getConnection(String url,String userName,String password) throws SQLException:
          is used to establish the connection with the specified url, username, and password.
          The SQLException is thrown when the corresponding Driver class of the given database is not registered with the DriverManager.
    */

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "My22981453.");

        /*
        DriverManager class
        The DriverManager class is the component of JDBC API and also a member of the java.sql package.
        The DriverManager class acts as an interface between users and drivers.
        It keeps track of the drivers that are available and handles establishing a connection between a database and the appropriate driver.
        It contains all the appropriate methods to register and deregister the database driver class and
        to create a connection between a Java application and the database.
        The DriverManager class maintains a list of Driver classes that have registered themselves by calling the method DriverManager.registerDriver().
        Note that before interacting with a Database, it is a mandatory process to register the driver; otherwise, an exception is thrown.
         */

        //3) Statement
        Statement st = con.createStatement();


        //Soru: Region id'si 1 olan "country name" değerlerini çağırın.

        String sql01= "select country_name from countries where region_id=1";

        //4) ResultSet
        ResultSet veri = st.executeQuery(sql01);

        while (veri.next()) {
            System.out.println(veri.getString(1));
        }

        //Soru: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql02 = "select country_id, country_name from countries where region_id>2";
        ResultSet veri02 = st.executeQuery(sql02);

        while (veri02.next()){

            System.out.println(veri02.getString("country_id") + veri02.getString("country_name"));
        }

        con.close();
        st.close();
        veri.close();
        veri02.close();

    }
}