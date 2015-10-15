package fi.agileo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;

@SessionScoped
@ManagedBean
public class GenericSQL {
	@Resource(name = "jdbc/jeemysql")
	private DataSource ds;		
	
	private String SQL;
	private String[] columns;

	private List<RowData> rowDatas;
	
	public GenericSQL() {
		
	}
	
	public String getSQL() {
		return SQL;
	}
	
	public String[] getColumns() {
		return columns;
	}
	
	public List<RowData> getRowDatas() {
		return rowDatas;
	}
	
	public String executeSQL() {
		rowDatas = new ArrayList<RowData>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(this.SQL);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int iColumnCount = rsmd.getColumnCount();
			System.out.println("ColumnCount " + iColumnCount);
			columns = new String[iColumnCount];
			for (int i = 1; i <= columns.length; i++) {
				System.out.println("i " + i);
				columns[i - 1] = rsmd.getColumnName(i);
				System.out.println("Column name " + columns[i - 1]);
			}
			
			while (rs.next()) {
				RowData rowData = new RowData();
				for (int i = 1; i <= columns.length; i++) {
					System.out.println(columns[i - 1] + " -> " + rs.getObject(i));
					rowData.putColumn(columns[i - 1], rs.getObject(i));
				}
				rowDatas.add(rowData);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return "index";
	}
	
	public void setSQL(String sql) {
		this.SQL = sql;
	}
}
