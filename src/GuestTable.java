import java.sql.*;

public class GuestTable {
	public static void createGuestTable() {
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

	            String sql = "CREATE TABLE Guests (\r\n"
	            		+ "  guest_id INTEGER PRIMARY KEY,\r\n"
	            		+ "  guest_name VARCHAR(255) NOT NULL,\r\n"
	            		+ "  guest_phone VARCHAR(255) NOT NULL,\r\n"
	            		+ "  guest_accompanying_members INTEGER NOT NULL,\r\n"
	            		+ "  guest_payment_amount INTEGER NOT NULL,\r\n"
	            		+ "  room_id INTEGER,\r\n"
	            		+ "  hotel_id INTEGER,\r\n"
	            		+ "  created_date DATE NOT NULL,\r\n"
	            		+ "  updated_date DATE,\r\n"
	            		+ "  is_active BIT NOT NULL\r\n"
	            		+ ");";

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
