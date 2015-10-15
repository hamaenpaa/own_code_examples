package java_oppilas_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateOneStudent {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DbYhteys.url, DbYhteys.user,
					DbYhteys.passwd);
			String sql = "select * from oppilas";
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			// mennään tulosjoukon ensimmäiseen alkioon
			rs.first();
			int koep = rs.getInt("Koepisteet");
			rs.updateInt("Koepisteet", koep + 1);
			rs.updateRow();
			rs.close();
			stmt.close();
			conn.close();
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
