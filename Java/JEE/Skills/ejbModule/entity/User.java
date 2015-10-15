package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
   name="checklogin",
   query="SELECT User u WHERE u.username = :username AND u.password = :password"
)
public class User {
   protected int id;
   protected int access_level;
   protected String name;
   protected String password;
   protected String address;
   protected String email;
   protected String phonenumber;
   
   public User() {}
   
   @Id
   public int getId() { return this.id; }
   public void setId(int id) { this.id = id; }

   public int getAccessLevel() { return this.access_level; }
   public void setAccessLevel(int access_level) { this.access_level = access_level; }
   
   public String getName() { return this.name; }
   public void setName(String name) { this.name = name; }

   public String getPassword() { return this.password; }
   public void setPassword(String password) { this.password = password; }

   public String getAddress() { return this.address; }
   public void setAddress(String address) { this.address = address; }
   
   public String getEmail() { return this.email; }
   public void setEmail(String email) { this.email = email; }

   public String getPhoneNumber() { return this.phonenumber; }
   public void setPhoneNumber(String phonenumber) { this.phonenumber = phonenumber; }
}
