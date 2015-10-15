package entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity
public class WorkingRole {
	int id;
	String name;
	String description;
	  
	public WorkingRole() {}
	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
    public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
    public String getDescription() { return this.description; }
	public void setDescription(String description) { this.description = description; }
}
