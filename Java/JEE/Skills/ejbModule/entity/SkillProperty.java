package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SkillProperty {
   protected int id;
   protected int skill_id;
   protected String name;
   protected String description;
   
   public SkillProperty() {}
   
   @Id
   public int getId() { return this.id; }
   public void setId(int id) { this.id = id; }

   public int getSkillId() { return this.skill_id; }
   public void setSkillId(int skill_id) { this.skill_id = skill_id; }
   
   public String getName() { return this.name; }
   public void setName(String name) { this.name = name; }
 	
   public String getDescription() { return this.description; }
   public void setDescription(String description) { this.description = description; }
   
}
