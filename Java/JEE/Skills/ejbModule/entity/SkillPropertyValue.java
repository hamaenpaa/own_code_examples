package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SkillPropertyValue {
	protected int id;
	protected int skill_id;
	protected int skill_source_id;
	protected int skill_property_id;
	protected int valuedatatype;
	protected int ivalue;
	protected String svalue;
	protected Date dtvalue;
	
	public SkillPropertyValue() {}
	
	@Id
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    
    public int getSkillId() { return this.skill_id; }
    public void setSkillId(int skill_id) { this.skill_id = skill_id; }
    
    public int getSkillSourceId() { return this.skill_source_id; }
    public void setSkillSourceId(int skill_source_id) { this.skill_source_id = skill_source_id; }
    
    public int getSkillPropertyId() { return this.skill_property_id; }
    public void setSkillPropertyId(int skill_property_id) { this.skill_property_id = skill_property_id; }
    
    public int getValueDataType() { return this.valuedatatype; }
    public void setValueDataType(int valuedatatype) { this.valuedatatype = valuedatatype; }
    
    public int getIntValue() { return this.ivalue; }
    public void setIntValue(int ivalue) { this.ivalue = ivalue; }
    
    public String getStringValue() { return this.svalue; }
    public void setStringValue(String svalue) { this.svalue = svalue; }
    
    public Date getDateValue() { return this.dtvalue; }
    public void setDateValue(Date dtvalue) { this.dtvalue = dtvalue; }
}
