package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Course {
	protected int id;
	protected String name;
	protected Date beginDate;
	protected Date endDate;
	
	public Course() {}
	
	@Id
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id; }

	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	
	public Date getBeginDate() { return this.beginDate; }
	public void setBeginDate(Date beginDate) { this.beginDate = beginDate; }
	
	public Date getEndDate() { return this.endDate; }
	public void setEndDate(Date endDate) { this.endDate = endDate; }
	
}
