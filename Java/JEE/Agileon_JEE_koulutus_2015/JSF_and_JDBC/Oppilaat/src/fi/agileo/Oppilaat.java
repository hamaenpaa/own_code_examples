package fi.agileo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

@SessionScoped
@ManagedBean
public class Oppilaat {
	// Resource injection from context.xml
	@Resource(name = "jdbc/jeemysql")
	private DataSource ds;	
	
	public List<Oppilas> getOppilaat() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<Oppilas> oppilaat = new ArrayList<Oppilas>();
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from oppilas");
			while (rs.next()) {
				oppilaat.add(new Oppilas(
						rs.getInt("Id"), rs.getString("nimi"), 
						rs.getInt("Koepisteet"), rs.getInt("Demopisteet")));
			}
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			try {
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
				if (conn != null) conn.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return oppilaat;
	}

	public List<Oppilas> getJarjestetytOppilaat() {
		List<Oppilas> oppilaat = getOppilaat();
		Collections.sort(oppilaat);
		return oppilaat;
	}
	
	public static Object getManagedBean(String beanName) {
	    FacesContext fc = FacesContext.getCurrentInstance();
	    Object bean;
	     
	    try {
	        ELContext elc = fc.getELContext();
	        bean = elc.getELResolver().getValue(elc, null,
	          beanName);
	    } catch (RuntimeException e) {
	        throw new FacesException(e.getMessage(), e);
	    }
	 
	    if (bean == null) {
	        throw new FacesException("bean not found.");
	    }
	    return bean;
	}	
	
	
	private void addOppilasToDb(Oppilas oppilas) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(
					"INSERT INTO oppilas (id,nimi,koepisteet,demopisteet) VALUES (?,?,?,?)");
			stmt.setInt(1, oppilas.getId());
			stmt.setString(2, oppilas.getNimi());
			stmt.setInt(3, oppilas.getKoepisteet());
			stmt.setInt(4, oppilas.getDemopisteet());
			stmt.execute();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public String lisaaUusi() {
		Oppilas oppilas = (Oppilas)getManagedBean("oppilas");
		addOppilasToDb(oppilas);
		return "index";
	}
}
