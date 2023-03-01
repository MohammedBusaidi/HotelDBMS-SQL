import java.sql.*;

public class RoomsTable {
	 public static void createRoomsTable() {
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

		            String sql = "create table Rooms (\r\n"
		            		+ "	room_id INTEGER PRIMARY KEY,\r\n"
		            		+ "	room_type_id INTEGER,\r\n"
		            		+ "	FOREIGN KEY (room_type_id) REFERENCES Room_Type(room_type_id),\r\n"
		            		+ "	hotel_id INTEGER,\r\n"
		            		+ "	FOREIGN KEY (hotel_id) REFERENCES Hotels(hotel_id),\r\n"
		            		+ "	created_date DATE NOT NULL,\r\n"
		            		+ "	updated_date DATE,\r\n"
		            		+ "	is_Active BIT NOT NULL\r\n"
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
