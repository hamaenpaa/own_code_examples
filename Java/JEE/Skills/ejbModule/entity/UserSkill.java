package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserSkill {
   protected int id;
   protected int user_id;
   protected int evaluator_user_id;
   protected int skill_id;
   protected int expert_level;
   protected int expert_lev_calc;
   protected int expert_lev_calc_indep_of_user;
   
   public UserSkill() {}
   
   @Id
   public int getId() { return this.id; }
   public void setId(int id) { this.id = id; }

   public int getUserId() { return this.user_id; }
   public void setUserId(int user_id) { this.user_id = user_id; }
   
   public int getEvaluatorUserId() { return this.evaluator_user_id; }
   public void setEvaluatorUserId(int evaluator_user_id) { this.evaluator_user_id = evaluator_user_id; }
   
   public int getSkillId() { return this.skill_id; }
   public void setSkillId(int skill_id) { this.skill_id = skill_id; }

   public int getExpertLevel() { return this.expert_level; }
   public void setExpertLevel(int expert_level) { this.expert_level = expert_level; }
   
   public int getExpertLevelCalc() { return this.expert_lev_calc; }
   public void setExpertLevelCalc(int expert_lev_calc) { this.expert_lev_calc = expert_lev_calc; }
   
   public int getExpertLevelCalcIndepUser() { return this.expert_lev_calc_indep_of_user; }
   public void setExpertLevelCalcIndepUser(int expert_lev_calc_indep_of_user) { this.expert_lev_calc_indep_of_user = expert_lev_calc_indep_of_user; }
}
