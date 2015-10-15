package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SourceOfSkill {
    int id;
    int skill_id;
    int skill_source_id;
    
    public SourceOfSkill() {}
    
    @Id
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    
    public int getSkillId() { return this.skill_id; }
    public void setSkillId(int skill_id) { this.skill_id = skill_id; }

    public int getSkillSourceId() { return this.skill_source_id; }
    public void setSkillSourceId(int skill_source_id) { this.skill_source_id = skill_source_id; }
}
