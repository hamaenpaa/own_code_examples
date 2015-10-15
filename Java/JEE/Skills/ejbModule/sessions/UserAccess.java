package sessions;
import javax.ejb.Local;
import entity.User;

@Local
public interface UserAccess {
    public User login();    
}
