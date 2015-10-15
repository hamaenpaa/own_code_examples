package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SkillCategory {
	protected int id;
	protected int parent_id;
	protected String name;
	
	public SkillCategory() {}
	   
	@Id
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }

	public int getParentId() { return this.parent_id; }
	public void setgetParentId(int parent_id) { this.parent_id = parent_id; }
	
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }	
}
