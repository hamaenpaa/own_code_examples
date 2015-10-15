package itso.bank.example.db;
import java.sql.*;

/**
 * @author UELI
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class GetCustomerMain {
	private static final String DBCLASS = "COM.ibm.db2.jdbc.app.DB2Driver";
	private static final String URL = "jdbc:db2:BankDB";

	public GetCustomerMain() {	
		try {
			Class.forName(DBCLASS);
		} catch (Throwable ex) {}
	}

	private Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(URL);
		return con;
	}
	
	public static void main(String[] args) throws SQLException {
		String ssn = "111-11-1111";
		if (args != null && args.length > 0) ssn = args[0];
		
		GetCustomerMain custTest = new GetCustomerMain();
		
		// connect to database
		Connection con = custTest.getConnection();

		// prepare statement that calls stored procedure
		CallableStatement cs = con.prepareCall("{call ITSO.GetCustomer(?)} ");
		cs.setString(1, ssn);

		// execute
		ResultSet rs = cs.executeQuery();

		while (rs.next()) {
			// get the data from the row
			System.out.println("TITLE:       " + rs.getString("title"));
			System.out.println("FIRST NAME:  " + rs.getString("firstname"));
			System.out.println("LAST NAME:   " + rs.getString("lastname"));
			System.out.println("SSN:   " + rs.getString("ssn"));
		}
	}	
}
