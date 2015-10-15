/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmjsfapp.firstwebapplicationmaven;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author harri
 */
@Named(value = "user2")
@SessionScoped
public class User2 implements Serializable {

    @ManagedProperty(value="anonymous")
    private String name;
    private String password;
 
    private List<String> favoriteSports;
    private Map<String, String> spokenLanguages;    
    
    @Inject
    private Profession profession;
    
    /**
     * Creates a new instance of User2
     */
    public User2() {
    }
 
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
        
    public Profession getProfession() {
        return profession;
    }
 
    public void setProfession(Profession profession) {
        this.profession = profession;
    }         
    
}
