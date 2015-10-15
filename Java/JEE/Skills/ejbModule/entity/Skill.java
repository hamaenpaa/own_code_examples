package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Skill {
   protected int id;
   protected int parent_id;
   protected String name;
   protected String description;
   protected int expert_level;
   
   public Skill() {}
   
   @Id
   public int getId() { return this.id; }
   public void setId(int id) { this.id = id; }
   
   public int getParentId() { return this.parent_id; }
   public void setParentId(int parent_id) { this.parent_id = parent_id; }

   public int getExpertLevel() { return this.expert_level; }
   public void setExpertLevel(int expert_level) { this.expert_level = expert_level; }
   
   public String getName() { return this.name; }
   public void setName(String name) { this.name = name; }
   
   public String getDescription() { return this.description; }
   public void setDescription(String description) { this.description = description; }
   
   
   
   
}
