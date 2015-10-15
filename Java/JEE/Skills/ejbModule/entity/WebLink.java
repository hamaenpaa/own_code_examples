package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class WebLink {
	protected int id;
	protected String url;
	protected String name;
	protected String description;
	protected Date date;
	
	public WebLink() {}
	   
	@Id
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
    public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
    public String getDescription() { return this.description; }
	public void setDescription(String description) { this.description = description; }
	
    public Date getDate() { return this.date; }
	public void setDate(Date date) { this.date = date; }

    public String getUrl() { return this.url; }
	public void setUrl(String url) { this.url = url; }
	
	
	
}
