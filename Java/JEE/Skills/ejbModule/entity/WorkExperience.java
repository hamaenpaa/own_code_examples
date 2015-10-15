package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkExperience {
   protected int id;
   protected int user_id;
   protected int company_id;
   protected int days;
   protected int beginyear;
   protected int endyear;
   protected int workingrole;
   
   public WorkExperience() {}
   
   @Id
   public int getId() { return this.id; }
   public void setId(int id) { this.id = id; }

   public int getUserId() { return this.user_id; }
   public void setUserId(int user_id) { this.user_id = user_id; }
   
   public int getCompanyId() { return this.company_id; }
   public void setCompanyId(int company_id) { this.company_id = company_id; }
   
   public int getDays() { return this.days; }
   public void setDays(int days) { this.days = days; }
   
   public int getBeginYear() { return this.beginyear; }
   public void setBeginYear(int beginyear) { this.beginyear = beginyear; }
   
   public int getEndYear() { return this.endyear; }
   public void setEndYear(int endyear) { this.endyear = endyear; }
   
   public int getWorkingRole() { return this.workingrole; }
   public void setWorkingRole(int workingrole) { this.workingrole = workingrole; }
}
