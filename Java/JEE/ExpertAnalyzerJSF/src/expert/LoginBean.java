package expert;

public class LoginBean {
     private String username;
     private String password;
     
     public void setPassword(String newPassword)
     {
    	 this.password = newPassword;
     }
     
     public String getPassword()
     {
    	 return this.password;
     }
	
     public void setUsername(String newUsername)
     {
    	 this.username = newUsername;
     }
     
     public String getUsername()
     {
    	 return this.username;
     }
     
}
