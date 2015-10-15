package fi.agileo;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class RowData {
	private HashMap<String,Object> columns;
	
	public RowData() {
		columns = new HashMap<String,Object>();
	}
	
	public void putColumn(String column, Object data) {
		columns.put(column, data);
	}
	
	public String getColumnAsString(String column) {
		return columns.get(column).toString();
	}
}
