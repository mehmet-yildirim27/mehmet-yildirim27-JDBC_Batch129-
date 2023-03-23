import java.sql.*;

public class Query04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "12345");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from ogrenciler");


        // If you have to get metadata of a table like total number of column,
        // column name, column type etc. , ResultSetMetaData interface is useful
        // because it provides methods to get metadata from the ResultSet object.

        ResultSetMetaData rmsd = rs.getMetaData();
        System.out.println("1. sutunun ismi: " + rmsd.getColumnName(1));
        System.out.println("2. sutunun ismi: " + rmsd.getColumnName(2));
        System.out.println("3. sutunun ismi: " + rmsd.getColumnName(3));
        System.out.println("4. sutunun ismi: " + rmsd.getColumnName(4));

        System.out.println("Tablo ismi: " + rmsd.getTableName(3));
        System.out.println(rmsd.getTableName(5));       // PSQLException: The column index is out of range: 5, number of columns: 4.

        System.out.println(rmsd.getColumnTypeName(1));

    }
}
