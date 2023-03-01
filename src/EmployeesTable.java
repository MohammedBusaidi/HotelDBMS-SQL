import java.sql.*;

public class EmployeesTable {
	public static void createEmployeesTable() {
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

	            String sql = "CREATE TABLE Employees (\r\n"
	            		+ "  employee_id INTEGER PRIMARY KEY,\r\n"
	            		+ "  employee_type_id INTEGER,\r\n"
	            		+ "  room_id INTEGER,\r\n"
	            		+ "  created_date DATE NOT NULL,\r\n"
	            		+ "  updated_date DATE,\r\n"
	            		+ "  is_active BIT NOT NULL,\r\n"
	            		+ "  FOREIGN KEY (employee_type_id) REFERENCES Employee_Type(Employee_type_id),\r\n"
	            		+ "  FOREIGN KEY (room_id) REFERENCES Rooms(room_id)\r\n"
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

