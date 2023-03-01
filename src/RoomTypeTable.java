import java.sql.*;

public class RoomTypeTable {
	 public static void createRoomTypeTable() {
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

		            String sql = "create table Room_Type (\r\n"
		            		+ "	room_type_id INTEGER PRIMARY KEY,\r\n"
		            		+ "	room_type_name VARCHAR(20) NOT NULL,\r\n"
		            		+ "	created_date DATE NOT NULL,\r\n"
		            		+ "	updated_date DATE,\r\n"
		            		+ "	is_Active BIT NOT NULL\r\n"
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
