import java.sql.*;

public class EmployeeTypeTable {
	public static void createEmployeeTypeTable() {
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

	            String sql = "CREATE TABLE Employee_Type (\r\n"
	            		+ "  employee_type_id INTEGER PRIMARY KEY,\r\n"
	            		+ "  employee_type_name VARCHAR(255) NOT NULL,\r\n"
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

