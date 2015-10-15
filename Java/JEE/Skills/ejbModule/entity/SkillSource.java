package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SkillSource {
	protected int id;
	protected int category;
	protected float meaningfactor;
	
	public SkillSource() {}
	   
	@Id
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }
	
	public int getCategory() { return this.category; }
	public void setCategory(int category) { this.category = category; }
	
	public float getMeaningFactor() { return this.meaningfactor; }
	public void setMeaningFactor(int meaningfactor) { this.meaningfactor = meaningfactor; }
	
}
