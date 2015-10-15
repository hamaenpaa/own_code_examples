package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserSkillSource {
	protected int id;
	protected int user_id;
	protected int evaluator_user_id;
	protected int skill_source_id;
	protected int expert_level;
	protected float meaningfactor;
	protected int expert_level_calculated;

	public UserSkillSource() {}
	
	@Id
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
	
    public int getUserId() { return this.user_id; }
    public void setUserId(int user_id) { this.user_id = user_id; }
	
    public int getExpertLevel() { return this.expert_level; }
	public void setExpertLevel(int expert_level) { this.expert_level = expert_level; }
	
    public int getSkillSourceId() { return this.skill_source_id; }
	public void setSkillSourceId(int skill_source_id) { this.skill_source_id = skill_source_id; }

    public int getEvaluatorUserId() { return this.evaluator_user_id; }
    public void setEvaluatorUserId(int evaluator_user_id) { this.evaluator_user_id = evaluator_user_id; }
	
	public float getMeaningFactor() { return this.meaningfactor; }
	public void setMeaningFactor(int meaningfactor) { this.meaningfactor = meaningfactor; }
	
    public int getExpertLevelCalculated() { return this.expert_level_calculated; }
    public void setExpertLevelCalculated(int expert_level_calculated) { this.expert_level_calculated = expert_level_calculated; }
	
}
