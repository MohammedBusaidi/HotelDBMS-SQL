import java.sql.*;

public class HotelTable {
    public static void createHotelTable() {
    	String url = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=HotelDBMS;" +
                "encrypt=true;" +
                "trustServerCertificate=true";
    	
    	String user = "sa";
        String pass = "root";
        
        
		Connection con = null;
		    try {

	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	            DriverManager.registerDriver(driver);

	            con = DriverManager.getConnection(url, user, pass);

	            Statement st = con.createStatement();

	            String sql = "Create Table Hotels ("
	            		+ "	hotel_id INTEGER PRIMARY KEY,"
	            		+ "	hotel_name VARCHAR(20) NOT NULL,"
	            		+ "	hotel_location VARCHAR,"
	            		+ "	created_date DATE NOT NULL,"
	            		+ "	updated_date DATE,"
	            		+ "	is_Active BIT NOT NULL"
	            		+ ")";

	            Integer m = st.executeUpdate(sql);
	            if (m >= 1) {
	                System.out.println("created successfully : " + sql);
	            } else {
	                System.out.println("Creation failed");
	            }
	        } catch (Exception ex) {
	            System.err.println(ex);
	        }
    }
}
