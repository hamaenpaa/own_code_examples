package systems.ossystems;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OsSystem implements Serializable {
	private static final long serialVersionUID = 3842644017736019861L;

	private String name;
	private String version;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "OsSystem [name=" + name + ", version=" + version + "]";
	}
}
