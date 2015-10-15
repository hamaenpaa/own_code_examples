package fi.agileo;

import java.util.*;
import java.sql.*;


public class Oppilaat {
	// Muista myös kopioida MySQL:n JDBC-ajuri Tomcatin lib/-hakemistoon
	// Tästä tulee muuten vain yhteysvirhe
	public Oppilaat() {
	}

	private Connection luoYhteys2() throws SQLException {
		Connection conn = null;

		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(DbYhteys.url, DbYhteys.user, DbYhteys.passwd);
			} catch (Exception e) {
				System.err.println("Error in Database connection: " + java.util.Arrays.toString(e.getStackTrace()));
			}
		}
		return conn;

	}

	// palautetaan tietokannasta lista Oppilas-olioita
	public List<Oppilas> getOppilaat() throws SQLException {
		Connection conn = luoYhteys2();
		PreparedStatement ps = conn.prepareStatement("select * from student");
		List<Oppilas> list = new ArrayList<>();

		try (ResultSet result = ps.executeQuery()) {
			while (result.next()) {
				Oppilas op = new Oppilas();
				op.setNimi(result.getString("nimi"));
				op.setDemopisteet(result.getInt("demo"));
				op.setKoepisteet(result.getInt("koe"));
				list.add(op);
			}
		}
		conn.close();
		System.out.println(list);
		return list;

	}

	public void lisaaOppilas(Oppilas uusi) throws SQLException {
		Connection conn = luoYhteys2();

		PreparedStatement stmt = conn.prepareStatement("INSERT INTO student (nimi,demo,koe) VALUES (?,?,?)");
		stmt.setString(1, uusi.getNimi());
		stmt.setInt(2, uusi.getDemopisteet());
		stmt.setInt(3, uusi.getKoepisteet());
		// stmt.executeUpdate(createTable);
		int muuttuneetRivit = stmt.executeUpdate();
		System.out.println("Tietokannassa muuttui " + muuttuneetRivit + " riviä.");
		stmt.close();
		conn.close();
	}
}
