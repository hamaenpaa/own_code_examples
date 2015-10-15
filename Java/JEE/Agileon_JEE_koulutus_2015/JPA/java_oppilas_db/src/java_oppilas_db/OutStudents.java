package java_oppilas_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutStudents {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DbYhteys.url, DbYhteys.user,
					DbYhteys.passwd);
			Statement stmt = conn.createStatement();
		
			ResultSet rs = stmt.executeQuery("select * from oppilas");
			while (rs.next()) {
				// hae vuorossa olevan rivin tiedot getType(KENTTA) metodilla
				int id = rs.getInt("Id");
				String nimi = rs.getString("nimi");
				int demoPisteet = rs.getInt("Demopisteet");
				int koePisteet = rs.getInt("Koepisteet");
				System.out.println("id " + id +  " nimi " + nimi + " " + 
						" demopisteet " + demoPisteet + " koepisteet " + koePisteet);
			}
			rs.close();
			conn.close();
		}
		catch (SQLException swe) {
			
		}
	}

}
