package java_oppilas_db;

import java.sql.*;

public class UpdateStudents {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DbYhteys.url, DbYhteys.user,
					DbYhteys.passwd);
			Statement stmt = conn.createStatement();
			int tulos = 0;
			
			String dropTable = "DROP TABLE oppilas";
			stmt.executeUpdate(dropTable); 
			String createTable = "CREATE TABLE oppilas (" +
					"Id INT(64) NOT NULL," +
					"Nimi VARCHAR(20)," +
					"Demopisteet INT(64)," +
					"Koepisteet INT(64))";
			stmt.executeUpdate(createTable); 
			
			String deleteSql = "DELETE FROM oppilas WHERE Nimi LIKE 'Kalle%'";
			stmt.executeUpdate(deleteSql);
			
			String insertBegin = "INSERT INTO oppilas(Id,Nimi,DemoPisteet,KoePisteet) "; 
			String sql = insertBegin + 
					"VALUES (15, 'Kalle Kinnari', 10, 20)";
			tulos += stmt.executeUpdate(sql);
			 
			sql = insertBegin + 
					"VALUES (16, 'Harri Mäenpää', 19, 21)";
			tulos += stmt.executeUpdate(sql);
			
			String updateBegin = "UPDATE oppilas SET DemoPisteet=15, KoePisteet=19 WHERE Id = 15";
			tulos += stmt.executeUpdate(updateBegin);
			stmt.close();
			conn.close();
			
			System.out.println("Päivitysten määrä " + tulos);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
